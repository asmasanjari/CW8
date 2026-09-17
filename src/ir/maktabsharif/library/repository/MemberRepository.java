package ir.maktabsharif.library.repository;

import ir.maktabsharif.library.entity.Book;
import ir.maktabsharif.library.entity.Member;

import java.util.List;

public interface MemberRepository {
    void save(Member member);

    void delete(Member member);

    Member findById(int id);

    List<Member> findAll();
}
