package com.ggs.exam.service;

import com.ggs.exam.pojo.Book;

import java.util.List;

/**
 *
 *  @author: Starbug
 *  @date: 2020-07-03 17:22
 */
public interface BookService {
    List<Book> getBookList();

    Book getEditBookInfo(String id);

    void insertBookInfo(Book book);

    void updateBookInfo(Book book);

    void deleteBookInfoById(String id);
}
