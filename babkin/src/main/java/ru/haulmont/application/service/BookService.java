package ru.haulmont.application.service;

import ru.haulmont.application.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();

    void createBook(Book book);
}
