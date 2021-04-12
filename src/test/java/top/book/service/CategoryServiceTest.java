package top.book.service;

import junit.framework.TestCase;
import top.book.entity.Category;

public class CategoryServiceTest extends TestCase {

    public void testInsert() {

        int row = new CategoryService().insert(new Category("数据库"));
        System.out.println("更新多少行 = " + row);
    }
}