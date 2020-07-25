package com.ggs.exam.service.impl;

import com.ggs.exam.mapper.BookMapper;
import com.ggs.exam.pojo.Book;
import com.ggs.exam.pojo.BookExample;
import com.ggs.exam.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 *  @author: Starbug
 *  @date: 2020-07-03 17:22
 */
@Transactional(propagation = Propagation.REQUIRED,readOnly = true)
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Book> getBookList() {
        return bookMapper.selectByExample(new BookExample());
    }

    @Override
    public Book getEditBookInfo(String id) {
        BookExample bookExample = new BookExample();
        bookExample.createCriteria().andIdEqualTo(id);
        List<Book> books = bookMapper.selectByExample(bookExample);
        if (books.size() > 0) {
            return books.get(0);
        } else {
            return null;
        }
    }

    @Transactional(propagation = Propagation.REQUIRED,readOnly = false)
    @Override
    public void insertBookInfo(Book book) {
        bookMapper.insert(book);
    }

    @Transactional(propagation = Propagation.REQUIRED,readOnly = false)
    @Override
    public void updateBookInfo(Book book) {
        BookExample bookExample = new BookExample();
        bookExample.createCriteria().andIdEqualTo(book.getId());
        bookMapper.updateByExampleSelective(book, bookExample);
    }

    @Transactional(propagation = Propagation.REQUIRED,readOnly = false)
    @Override
    public void deleteBookInfoById(String id) {
        BookExample bookExample = new BookExample();
        bookExample.createCriteria().andIdEqualTo(id);
        bookMapper.deleteByExample(bookExample);
    }
}
