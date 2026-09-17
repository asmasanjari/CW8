package ir.maktabsharif.library.repository.inmemory;

import ir.maktabsharif.library.entity.Member;
import ir.maktabsharif.library.repository.MemberRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryMemberRepository implements MemberRepository {
    private final Map<Integer, Member> members = new HashMap();


    private int idd = 1;

    @Override
    public void save(Member member) {

        if (member.getId() == 0) {
            member.setId(idd);
            idd++;
        }

        members.put(member.getId(), member);
    }

    public void delete(Member member) {
        members.remove(member.getId());
    }

    @Override
    public Member findById(int id) {
        return members.get(id);
    }


    @Override
    public List<Member> findAll() {
        return new ArrayList<>(members.values());
    }
}
