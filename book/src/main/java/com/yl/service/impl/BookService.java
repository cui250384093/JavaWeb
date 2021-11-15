package com.yl.service.impl;

import com.yl.pojo.Book;
import com.yl.pojo.Page;

import java.util.List;

/**
 * @author candk
 * @Description
 * @date 10/25/21 - 3:31 PM
 */
public interface BookService {

    public void addBook(Book book);

    public void deleteBookById(Integer id);

    public void updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();

    public Page<Book> page(int pageNum, int pageSize);

    public Page<Book> pageByPrice(int pageNum, int pageSize, int minPrice, int maxPrice);
}
