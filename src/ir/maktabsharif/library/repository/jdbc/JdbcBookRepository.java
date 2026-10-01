package ir.maktabsharif.library.repository.jdbc;

import ir.maktabsharif.library.entity.Book;
import ir.maktabsharif.library.repository.BookRepository;
import ir.maktabsharif.library.repository.DbConaction;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcBookRepository implements BookRepository {
    @Override
    public void save(Book book) {


        try {
            Connection connection = DbConaction.getConnection();
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO book( name , author) values( '" + book.getName() + "','" + book.getAuthor() + "')");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Book findById(int id) {
        try {
            Connection connection = DbConaction.getConnection();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("select * from  book where id=" + id);
            if (result.next()) {
                int bookId = result.getInt("id");
                String name = result.getString("name");
                String author = result.getString("author");
                Book book = new Book(bookId, name, author);
                return book;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(Book book) {

    }

    @Override
    public List<Book> findAll() {
        ArrayList<Book> books = new ArrayList<>();
        try {
            Connection connection = DbConaction.getConnection();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("select * from  book");
            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                String author = result.getString("author");
                Book book = new Book(id, name, author);
                books.add(book);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return books;
    }

}
