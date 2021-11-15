package com.yl.service.impl;

import com.yl.dao.impl.BookDao;
import com.yl.dao.impl.BookDaoImpl;
import com.yl.pojo.Book;
import com.yl.pojo.Page;

import java.util.List;

/**
 * @author candk
 * @Description
 * @date 10/25/21 - 3:33 PM
 */
public class BookServiceImpl implements BookService {

    private BookDao bookDao = new BookDaoImpl();

    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {

        bookDao.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {

        bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }

    @Override
    public Page<Book> page(int pageNum, int pageSize) {

        Page<Book> page = new Page<>();

        page.setPageNum(pageNum);
        page.setPageSize(pageSize);

        Integer pageTotalCount = bookDao.queryForPageTotalCount();
        page.setPageSize(pageTotalCount);
        int pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0) {
            pageTotal++;
        }
        page.setPageTotal(pageTotal);

        if (pageNum < 1){
            pageNum = 1;
        }

        if (pageNum > pageTotal){
            pageNum = pageTotal;
        }

        int begin = (page.getPageNum() - 1) * pageSize;
        List<Book> items = bookDao.queryForPageItems(begin, pageSize);
        page.setItems(items);

        return page;
    }

    @Override
    public Page<Book> pageByPrice(int pageNum, int pageSize, int minPrice, int maxPrice) {
        Page<Book> page = new Page<>();

        page.setPageNum(pageNum);
        page.setPageSize(pageSize);

        Integer pageTotalCount = bookDao.queryForPageTotalCountByPrice(minPrice, maxPrice);

        page.setPageSize(pageTotalCount);
        int pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0) {
            pageTotal++;
        }
        page.setPageTotal(pageTotal);

        if (pageNum < 1){
            pageNum = 1;
        }

        if (pageNum > pageTotal){
            pageNum = pageTotal;
        }

        int begin = (page.getPageNum() - 1) * pageSize;
        List<Book> items = bookDao.queryForPageItemsByPrice(begin, pageSize, minPrice, maxPrice);
        page.setItems(items);

        return page;
    }

}
