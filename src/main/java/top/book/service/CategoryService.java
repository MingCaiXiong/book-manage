package top.book.service;

import top.book.dao.CategoryDao;
import top.book.entity.Category;
import top.book.utils.MyBatisUtils;

import java.util.List;

public class CategoryService {

    public List<Category> queryAll( Category category){
       return  ( List<Category> ) MyBatisUtils.executeQuery(sqlSession -> sqlSession.getMapper(CategoryDao.class).queryAll(category));
    }

}
