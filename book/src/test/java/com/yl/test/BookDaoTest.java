package com.yl.test;

import com.yl.dao.impl.BookDao;
import com.yl.dao.impl.BookDaoImpl;
import com.yl.pojo.Book;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author candk
 * @Description
 * @date 10/22/21 - 4:43 PM
 */
class BookDaoTest {

    private BookDao bookDao = new BookDaoImpl();

    @Test
    void addBook() {
        bookDao.addBook(new Book(null, "Time History", "112312", new BigDecimal(1000.00), 11000, 100,null));
    }

    @Test
    void deleteBookById() {
        bookDao.deleteBookById(21);
    }

    @Test
    void updateBook() {
        bookDao.updateBook(new Book(21, "Simple Time History", "1121", new BigDecimal(1000.00), 11000, 100,null));
    }

    @Test
    void queryBookById() {
        Book book = bookDao.queryBookById(21);
        System.out.println(book);
    }

    @Test
    void queryBooks() {
        List<Book> books = bookDao.queryBooks();
        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Test
    void queryForPageTotalCount() {
        System.out.println(bookDao.queryForPageTotalCount());
    }

    @Test
    void queryForPageTotalCountByPrice() {
        System.out.println(bookDao.queryForPageTotalCountByPrice(10, 50));
    }

    @Test
    void queryForPageItemsByPrice() {
        List<Book> books = bookDao.queryForPageItemsByPrice(1, 6, 10, 50);
        for (Book book : books) {
            System.out.println(book);
        }
    }
}