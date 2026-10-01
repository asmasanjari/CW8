package ir.maktabsharif.library.service;

import ir.maktabsharif.library.entity.Member;
import ir.maktabsharif.library.exception.LibraryFullException;
import ir.maktabsharif.library.exception.RegisterException;
import ir.maktabsharif.library.repository.MemberRepository;
import ir.maktabsharif.library.repository.jdbc.JdbcMembersRepository;

import java.util.List;

public class MemberService {
    private final MemberRepository memberRepository;
    int size=100;
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;

    }

    public void register(String name, String email) throws IllegalArgumentException {
        if (name == null) {
            throw new IllegalArgumentException("name can not be null");
//            System.out.println("name can not be null");
//            return;
        }
        if (email == null) {
            throw new IllegalArgumentException("email can not be null");
        }
        if (memberRepository.count() >=100){
            throw new LibraryFullException("library is full");
        }
        Member m1 = new Member(10, name, email);
        memberRepository.save(m1);
    }

    public void deleteMembers(int id) {
        Member m1 = memberRepository.findById(id);
        ;
        memberRepository.delete(m1);
    }

    public void updateMember(int id, String name, String email) {
        Member m1 = memberRepository.findById(id);
        m1.setName(name);
        m1.setEmail(email);
        memberRepository.save(m1);
    }

    public List<Member> findAll() {
        return memberRepository.findAll();
    }


}
