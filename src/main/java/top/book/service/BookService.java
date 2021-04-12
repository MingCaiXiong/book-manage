package top.book.service;

import top.book.dao.BookDao;
import top.book.entity.Book;
import top.book.utils.MyBatisUtils;

import java.util.List;

public class BookService {
    public Book queryById(Integer id){
        return(Book) MyBatisUtils.executeQuery(sqlSession -> sqlSession.getMapper(BookDao.class).queryById(id));
    }

    public String queryVersion(){
      String version = (String) MyBatisUtils.executeQuery(sqlSession -> sqlSession.selectOne("sample.getMySqlVersion"));
      return version;
    }
    /**
     * 通过实体作为筛选条件查询
     *
     * @param book 实例对象
     * @return 对象列表
     */
    public List<Book> queryAll(Book book){
        return (List<Book>) MyBatisUtils.executeUpdate(sqlSession -> sqlSession.getMapper(BookDao.class).queryAll(book));
    }

    public int insert(Book book) {
        return (int) MyBatisUtils.executeUpdate(sqlSession -> sqlSession.getMapper(BookDao.class).insert(book));
    }

    public List<Book> selectOneToMany(Integer cId){
       return (List<Book>)MyBatisUtils.executeQuery(sqlSession -> sqlSession.getMapper(BookDao.class).selectOneToMany(cId));
    }


}
