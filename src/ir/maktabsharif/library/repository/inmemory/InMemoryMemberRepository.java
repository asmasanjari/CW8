package ir.maktabsharif.library.repository.inmemory;

import ir.maktabsharif.library.entity.Member;
import ir.maktabsharif.library.repository.MemberRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryMemberRepository implements MemberRepository {
    private final Map<Integer, Member> members = new HashMap();
    private int idd = 0;

    @Override
    public void save(Member member) {
        member.setId(idd);
        members.put(idd, member);
        idd++;

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
