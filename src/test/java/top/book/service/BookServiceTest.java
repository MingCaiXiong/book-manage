package top.book.service;

import junit.framework.TestCase;
import top.book.entity.Book;

public class BookServiceTest extends TestCase {

    public void testQueryById() {
        Book book = new BookService().queryById(1);
        System.out.println(book);
    }

    public void testQueryVersion() {
        String version = new BookService().queryVersion();
        System.out.println("version = " + version);
    }
}