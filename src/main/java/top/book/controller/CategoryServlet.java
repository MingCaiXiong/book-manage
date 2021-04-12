package top.book.controller;

import top.book.entity.Category;
import top.book.service.CategoryService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "CategoryServlet", value = "/category")
public class CategoryServlet extends HttpServlet {
    private CategoryService categoryService = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categories = null;
        Category category = new Category();

        String cname = null;
        cname = request.getParameter("cname");
        if (cname != null) {
            category.setCName(cname);
            categories = categoryService.queryAll(category);
        }else {
            categories = categoryService.queryAll(category);

        }

        categories.forEach(System.out::println);

        request.setAttribute("categories", categories);
        request.getRequestDispatcher("/category.ftl").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
