package ir.maktabsharif.library.repository;

import ir.maktabsharif.library.entity.Book;

import java.sql.SQLException;
import java.util.List;

public interface BookRepository {
    void save(Book book) ;

    Book findById(int id);

    void delete(Book book);

    List<Book> findAll();
}
