package top.book.service;

import top.book.dao.BookDao;
import top.book.entity.Book;
import top.book.utils.MyBatisUtils;

public class BookService {
    public Book queryById(Integer id){
        return(Book) MyBatisUtils.executeQuery(sqlSession -> sqlSession.getMapper(BookDao.class).queryById(id));
    }

    public String queryVersion(){
      String version = (String) MyBatisUtils.executeQuery(sqlSession -> sqlSession.selectOne("sample.getMySqlVersion"));
      return version;
    }
}
