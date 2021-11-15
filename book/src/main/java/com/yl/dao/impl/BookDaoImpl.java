package com.yl.dao.impl;

import com.yl.pojo.Book;

import java.util.List;

/**
 * @author candk
 * @Description
 * @date 10/22/21 - 4:29 PM
 */
public class BookDaoImpl extends BaseDao implements BookDao{


    @Override
    public int addBook(Book book) {

        String sql = "insert into t_book(name, author, price, sales, stock, img_path) values(?, ?, ?, ?, ?, ?)";

        return update(sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImgPath());
    }

    @Override
    public int deleteBookById(Integer id) {

        String sql = "delete from t_book where id = ?";

        return update(sql, id);
    }

    @Override
    public int updateBook(Book book) {

        String sql = "update t_book set name=?, author=?, price=?, sales=?, stock=?, img_path=? where id = ?";

        return update(sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImgPath(), book.getId());
    }

    @Override
    public Book queryBookById(Integer id) {

        String sql = "select id, name, author, price, sales, stock, img_path imgPath from t_book where id = ?";

        return (Book) queryForOne(Book.class, sql, id);
    }

    @Override
    public List<Book> queryBooks() {

        String sql = "select id, name, author, price, sales, stock, img_path imgPath from t_book";

        return queryForList(Book.class, sql);
    }

    @Override
    public Integer queryForPageTotalCount() {
        String sql = "select count(*) from t_book";
        Number count = (Number) queryForSingleValue(sql);

        return count.intValue();
    }

    @Override
    public List<Book> queryForPageItems(Integer begin, Integer pageSize) {
        String sql = "select id, name, author, price, sales, stock, img_path imgPath from t_book limit ?, ?";

        return queryForList(Book.class, sql, begin, pageSize);
    }

    @Override
    public Integer queryForPageTotalCountByPrice(int minPrice, int maxPrice) {
        String sql = "select count(*) from t_book where price between ? and ?";
        Number count = (Number) queryForSingleValue(sql, minPrice, maxPrice);

        return count.intValue();
    }

    @Override
    public List<Book> queryForPageItemsByPrice(int begin, int pageSize, int minPrice, int maxPrice) {
        String sql = "select id, name, author, price, sales, stock, img_path imgPath from t_book where price between ? and ? order by price limit ?, ?";

        return queryForList(Book.class, sql, minPrice, maxPrice, begin, pageSize);
    }

}
