package ir.maktabsharif.library.repository.inmemory;

import ir.maktabsharif.library.entity.Book;
import ir.maktabsharif.library.repository.BookRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryBookRepository implements BookRepository {
    private final Map<Integer, Book> books = new HashMap<>();

    @Override
    public void save(Book book) {
        if (book.getId() == 0)
            book.setId(books.size() + 1);

        books.put(book.getId(), book);
    }

    @Override
    public Book findById(int id) {
        return books.get(id);
    }

    @Override
    public void delete(Book book) {
        books.remove(book.getId());
    }

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(books.values());
    }
}
