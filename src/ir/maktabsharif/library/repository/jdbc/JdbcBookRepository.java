package ir.maktabsharif.library.repository.jdbc;

import ir.maktabsharif.library.entity.Book;
import ir.maktabsharif.library.repository.BookRepository;
import ir.maktabsharif.library.repository.DbConaction;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

public class JdbcBookRepository implements BookRepository {
    @Override
    public void save(Book book) {
        Connection connection = DbConaction.getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO book( name , author) values( '" + book.getName() + "','" + book.getAuthor() + "')");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public Book findById(int id) {
        return null;
    }

    @Override
    public void delete(Book book) {

    }

    @Override
    public List<Book> findAll() {
        return null;
    }
}
