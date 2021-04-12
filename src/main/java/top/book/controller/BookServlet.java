package top.book.controller;

import top.book.entity.Book;
import top.book.entity.Category;
import top.book.service.BookService;
import top.book.service.CategoryService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "BookServlet", value = "/book/*")
@MultipartConfig //表示当前servlet可以处理multipart请求
public class BookServlet extends HttpServlet {
    CategoryService categoryService = new CategoryService();
    BookService bookService = new BookService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = String.valueOf(request.getRequestURL());
        String methodName = url.substring(url.lastIndexOf("/") + 1);
        if (methodName.equals("list")) {
            list(request, response);
        }
        if (methodName.equals("create")) {
            create(request, response, "Hello,Admin!");
        }

    }

    private void create(HttpServletRequest request, HttpServletResponse response, String message) throws ServletException, IOException {

        request.setAttribute("error", message);
        request.setAttribute("nav", categoryService.queryAll(new Category()));
        request.getRequestDispatcher("/add_book.ftl").forward(request, response);

    }

    private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String strCid = null;
        try {
            strCid = request.getParameter("cid");
        } catch (Exception e) {

        }
        List<Book> bookList = null;
        if (strCid != null) {
            int cid = Integer.parseInt(strCid);

            bookList = bookService.selectOneToMany(cid);
        } else {
            bookList = bookService.selectOneToMany(null);
        }

        List<Category> nav = categoryService.queryAll(new Category());
        request.setAttribute("nav", nav);
        request.setAttribute("books", bookList);
        request.getRequestDispatcher("/book.ftl").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        int writeRow = 0;
        String folder = "/upload";
        String imageUrl = null;

        //获取服务器存放上传文件的路径
        String imageSavePath = null;
        try {
            imageSavePath = this.getServletContext().getRealPath(folder);
        } catch (Exception e) {
            e.printStackTrace();
            this.create(request, response, "图片为必填项!!");
            return;
        }
        Part filePart = request.getPart("smallImg"); // Retrieves <input type="file" name="file">
        //getSubmittedFileName 获取上传文件的名称，这是servlet3.1中加入的方法
        String imageName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.

        String file = UUID.randomUUID() + "_" + imageName;
        try {
            filePart.write(imageSavePath + "/" + file);

            imageUrl = folder + "/" + file;
            //out/artifacts/book_admin_Web_exploded/upload/4a66349b-64cc-4091-aa8a-6de7110960b4_Java.jpg


            try {
                String name = request.getParameter("name");
                int categoryId = Integer.parseInt(request.getParameter("categoryId"));
                int level = Integer.parseInt(request.getParameter("level"));
                double price = Double.parseDouble(request.getParameter("price"));

                Book book = new Book();
                book.setName(name);
                book.setCId(categoryId);
                book.setScore(level);
                book.setPrice(price);
                book.setPoster(imageUrl);
                book.setCreateTime(new Date());
                book.setUpdateTime(new Date());

                writeRow = bookService.insert(book);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                this.create(request, response, "所有选项都要填写!!");
                return;
            }
        } catch (IOException e) {
            e.printStackTrace();
            this.create(request, response, "图片上传失败!!,请选择正常图片 大小不超过5K!!");
            return;
        }
        if (writeRow == 1) {
            response.sendRedirect("/book/list");
        }

    }
}
