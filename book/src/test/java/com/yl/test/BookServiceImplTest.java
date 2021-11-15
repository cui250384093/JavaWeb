package com.yl.test;

import com.yl.pojo.Book;
import com.yl.service.impl.BookService;
import com.yl.service.impl.BookServiceImpl;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

/**
 * @author candk
 * @Description
 * @date 10/25/21 - 3:58 PM
 */
class BookServiceImplTest {

    BookService bookService = new BookServiceImpl();

    @Test
    void addBook() {
        bookService.addBook(new Book(null, "Gone with the wind", "Lily", new BigDecimal("200.0"), 2000, 20000, null));

    }

    @Test
    void deleteBookById() {
        bookService.deleteBookById(23);
    }

    @Test
    void updateBook() {
        bookService.updateBook(new Book(22, "Simple Time History", "111", new BigDecimal(1000.00), 11000, 100,null));
    }

    @Test
    void queryBookById() {
        Book book = bookService.queryBookById(21);
        System.out.println(book);
    }

    @Test
    void queryBooks() {
        for (Book book : bookService.queryBooks()) {
            System.out.println(book);
        }
    }
}