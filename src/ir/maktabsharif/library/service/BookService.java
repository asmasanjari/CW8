package ir.maktabsharif.library.service;

import ir.maktabsharif.library.entity.Book;
import ir.maktabsharif.library.repository.BookRepository;

import java.util.List;


public class BookService {
    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public void add(String name, String author) {
        var book = new Book(0, name, author);
        repository.save(book);
    }

    public void update(int id, String name, String author) {
        Book book = repository.findById(id);
        book.setName(name);
        book.setAuthor(author);
        repository.save(book);
    }

    public void delete(int id) {
        Book book = repository.findById(id);
        repository.delete(book);
    }

    public List<Book> findAll() {
        return repository.findAll();
    }
}
