package ru.haulmont.application.repository;

import ru.haulmont.application.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, UUID> {
}
