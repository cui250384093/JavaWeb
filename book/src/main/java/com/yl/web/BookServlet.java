package com.yl.web; /**
 * @Description
 * @author candk
 * @version
 * @date 10/25/21 - 3:19 PM
 */

import com.yl.pojo.Book;
import com.yl.pojo.Page;
import com.yl.service.impl.BookService;
import com.yl.service.impl.BookServiceImpl;
import com.yl.util.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BookServlet extends BaseServlet {

    private BookService bookService = new BookServiceImpl();

    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int pageNum = WebUtils.parseInt(request.getParameter("pageNum"), 0) + 1;
        Book book = WebUtils.copyParamToBean(request.getParameterMap(), new Book());
        bookService.addBook(book);

        response.sendRedirect(request.getContextPath() + "/manager/bookServlet?action=page&pageNum=" + pageNum);
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        bookService.deleteBookById(Integer.parseInt(id));

        response.sendRedirect(request.getContextPath() + "/manager/bookServlet?action=page&pageNum=" + request.getParameter("pageNum"));
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Book book = WebUtils.copyParamToBean(request.getParameterMap(), new Book());
        bookService.updateBook(book);

        response.sendRedirect(request.getContextPath() + "/manager/bookServlet?action=page&pageNum=" + request.getParameter("pageNum"));
    }

    protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Book> books = bookService.queryBooks();
        request.setAttribute("books", books);
        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
    }

    protected void getBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Book book = bookService.queryBookById(id);
        request.setAttribute("book", book);

        request.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(request, response);
    }

    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int pageNum = WebUtils.parseInt(request.getParameter("pageNum"), 1);
        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        Page<Book> page = bookService.page(pageNum, pageSize);
        page.setUrl("manager/bookServlet?action=page");

        request.setAttribute("page", page);
        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
    }
}
