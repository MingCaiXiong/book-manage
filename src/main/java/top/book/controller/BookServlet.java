package top.book.controller;

import top.book.entity.Book;
import top.book.entity.Category;
import top.book.service.BookService;
import top.book.service.CategoryService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "BookServlet", value = "/book/*")
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
            create(request, response);
        }

    }

    private void create(HttpServletRequest request, HttpServletResponse response) {

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

    }
}
