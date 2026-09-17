package ir.maktabsharif.library;

import ir.maktabsharif.library.entity.Member;
import ir.maktabsharif.library.repository.inmemory.InMemoryBookRepository;
import ir.maktabsharif.library.repository.inmemory.InMemoryMemberRepository;
import ir.maktabsharif.library.service.MemberService;

import java.util.List;

public class Main {
    public static void main() {
        InMemoryMemberRepository inMemoryMemberRepository = new InMemoryMemberRepository();
        InMemoryBookRepository inMemoryBookRepository = new InMemoryBookRepository();

        MemberService serviceM = new MemberService(inMemoryMemberRepository);

        serviceM.addMember(
                "ali", "ali@gamil.com"
        ); serviceM.addMember(
                "hassan", "hasani@gamil.com"
        );
        List<Member> members = serviceM.findAll();
        for (Member member: members){
            System.out.println(member.getId()+" "+member.getName()+" " +member.getEmail());
        }
    }
}
