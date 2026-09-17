package ir.maktabsharif.library.repository.inmemory;

import ir.maktabsharif.library.entity.Lond;
import ir.maktabsharif.library.repository.LondRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryLondRepository implements LondRepository {

    private final Map<Integer, Lond> londs = new HashMap<>();

    private int id = 1;

    @Override
    public void save(Lond lond) {

        if (lond.getId() == 0) {
            lond.setId(id++);
        }

        londs.put(lond.getId(), lond);
    }

    @Override
    public Lond findById(int id) {
        return londs.get(id);
    }

    @Override
    public List<Lond> findAll() {
        return new ArrayList<>(londs.values());
    }

    @Override
    public void returnBook(int id) {

        Lond lond = londs.get(id);

        if (lond != null) {
            lond.setReturnDate(java.time.LocalDateTime.now());
        }
    }
}