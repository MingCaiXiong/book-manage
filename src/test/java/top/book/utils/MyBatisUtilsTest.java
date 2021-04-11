package top.book.utils;

import junit.framework.TestCase;

public class MyBatisUtilsTest extends TestCase {

    public void testExecuteQuery() {
        String version = (String)MyBatisUtils.executeQuery(sqlSession -> (String) sqlSession.selectOne("sample.getMySqlVersion"));
        System.out.println("version = " + version);
    }
}