package top.book.controller;


import top.book.entity.Book;
import top.book.service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SampleServlet", urlPatterns = "/sample")
public class SampleServlet extends HttpServlet {
    BookService bookService = new BookService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Book book = new Book();
        List<Book> bookList = bookService.queryAll(book);
        request.setAttribute("books", bookList);
        request.getRequestDispatcher("/sample.ftl").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
