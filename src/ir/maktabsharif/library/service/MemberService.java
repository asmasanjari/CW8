package ir.maktabsharif.library.service;

import ir.maktabsharif.library.entity.Member;
import ir.maktabsharif.library.repository.MemberRepository;

import java.util.List;

public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;

    }

    public void addMember(String name, String email) {
        Member m1 = new Member(0, name, email);
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
