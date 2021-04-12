package top.book.controller;

import top.book.entity.Category;
import top.book.service.CategoryService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "CategoryServlet", value = "/category/*")
public class CategoryServlet extends HttpServlet {
    private CategoryService categoryService = new CategoryService();

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

    private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/add_category.ftl").forward(request, response);

    }

    private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categories = null;
        Category category = new Category();
        List<Category> nav = categoryService.queryAll(category);

        String cname = null;
        cname = request.getParameter("cname");
        if (cname != null) {
            String finalCname = cname;
            categories = nav.stream().filter(p -> p.getCName().equals(finalCname)).collect(Collectors.toList());
        } else {
            categories = nav;
        }


        request.setAttribute("categories", categories);
        request.setAttribute("nav", nav);
        request.getRequestDispatcher("/category.ftl").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");
        if (categoryService.insert(new Category(name)) == 1) {
            this.list(request, response);
        }
    }
}
