package ir.maktabsharif.library.service;

import ir.maktabsharif.library.entity.Book;
import ir.maktabsharif.library.entity.Lond;
import ir.maktabsharif.library.entity.Member;
import ir.maktabsharif.library.repository.LondRepository;

import java.time.LocalDateTime;
import java.util.List;

public class LondService {

    private final LondRepository repository;

    public LondService(LondRepository repository) {
        this.repository = repository;
    }

    public void lendBook(Member member, Book book) {

        Lond lond = new Lond(
                0,
                member,
                book,
                LocalDateTime.now()
        );

        repository.save(lond);
    }

    public void returnBook(int id) {
        repository.returnBook(id);
    }

    public List<Lond> findAll() {
        return repository.findAll();
    }

    public Lond findById(int id) {
        return repository.findById(id);
    }

    public List<Lond> findActiveLoans() {

        List<Lond> activeLoans = new java.util.ArrayList<>();

        for (Lond lond : repository.findAll()) {

            if (lond.getReturnDate() == null) {
                activeLoans.add(lond);
            }
        }

        return activeLoans;
    }
}