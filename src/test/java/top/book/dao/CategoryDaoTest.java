package top.book.dao;

import junit.framework.TestCase;
import top.book.entity.Category;
import top.book.utils.MyBatisUtils;

import java.util.List;

public class CategoryDaoTest extends TestCase {

    public void testQueryById() {
    }

    public void testQueryAllByLimit() {
    }

    public void testQueryAll() {
        MyBatisUtils.executeQuery(sqlSession -> {

            List<Category> categories = sqlSession.getMapper(CategoryDao.class).queryAll(new Category());
            categories.forEach(System.out::println);
            return null;
        });
    }

    public void testInsert() {
    }

    public void testUpdate() {
    }

    public void testDeleteById() {
    }
}