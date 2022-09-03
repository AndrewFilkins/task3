package ru.haulmont.application.controller;

import ru.haulmont.application.entity.Book;
import ru.haulmont.application.entity.ResponseBook;
import ru.haulmont.application.repository.BookRepository;
import ru.haulmont.application.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;
    private final BookRepository bookRepository;

    @Autowired
    public BookController(BookService bookService, BookRepository bookRepository) {
        this.bookService = bookService;
        this.bookRepository = bookRepository;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ResponseBook>> getAllBooks() {
        List<Book> bookList = bookService.getAllBooks();
        List<ResponseBook> responseBookList = new ArrayList<>();
        for (Book book : bookList) {
            responseBookList.add(new ResponseBook(book.getId(),book.getTitle(),book.getPublishYear(),book.getManufacturer()));
        }
        return new ResponseEntity<>(responseBookList, HttpStatus.OK);
    }

    @GetMapping("/create")
    public ResponseEntity<ResponseBook> createBook(@RequestParam String title, @RequestParam String publishYear, @Value("${manufacturer}") String manufacturer) {
        ResponseBook book = new ResponseBook();
        book.setTitle(title);
        book.setPublishYear(publishYear);
        book.setManufacturer(manufacturer);
        bookRepository.save(new Book(book.getTitle(), book.getPublishYear(), book.getManufacturer()));
        return new ResponseEntity<>(book, HttpStatus.OK);
    }
}
