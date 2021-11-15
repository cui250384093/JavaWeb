package com.yl.dao.impl;

import com.yl.pojo.Book;

import java.util.List;

/**
 * @author candk
 * @Description
 * @date 10/22/21 - 4:26 PM
 */
public interface BookDao {

    public int addBook(Book book);

    public int deleteBookById(Integer id);

    public int updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();

    public Integer queryForPageTotalCount();

    public List<Book> queryForPageItems(Integer begin, Integer pageSize);

    Integer queryForPageTotalCountByPrice(int minPrice, int maxPrice);

    List<Book> queryForPageItemsByPrice(int begin, int pageSize, int minPrice, int maxPrice);
}
