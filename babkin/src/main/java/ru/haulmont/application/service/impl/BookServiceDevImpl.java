package ru.haulmont.application.service.impl;

import ru.haulmont.application.entity.Book;
import ru.haulmont.application.repository.BookRepository;
import ru.haulmont.application.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bookServiceDev")
@Profile("dev")
public class BookServiceDevImpl implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceDevImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        Book book = new Book("War and Peace", "1867", "-");
        bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public void createBook(Book book) {
        bookRepository.save(book);
    }
}
