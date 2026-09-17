package ir.maktabsharif.library.repository;

import ir.maktabsharif.library.entity.Lond;

import java.util.List;

public interface LondRepository {
    void save(Lond lond);

    Lond findById(int id);

    List<Lond> findAll();

    void returnBook(int id);
}
