package ir.maktabsharif.library;

import ir.maktabsharif.library.entity.Book;
import ir.maktabsharif.library.entity.Lond;
import ir.maktabsharif.library.entity.Member;
import ir.maktabsharif.library.repository.BookRepository;
import ir.maktabsharif.library.repository.inmemory.InMemoryBookRepository;
import ir.maktabsharif.library.repository.inmemory.InMemoryLondRepository;
import ir.maktabsharif.library.repository.inmemory.InMemoryMemberRepository;
import ir.maktabsharif.library.repository.jdbc.JdbcBookRepository;
import ir.maktabsharif.library.service.BookService;
import ir.maktabsharif.library.service.LondService;
import ir.maktabsharif.library.service.MemberService;

import java.util.List;

public class Main {
    public static void main() {

        InMemoryMemberRepository inMemoryMemberRepository =
                new InMemoryMemberRepository();

        InMemoryBookRepository inMemoryBookRepository =
                new InMemoryBookRepository();

        InMemoryLondRepository inMemoryLondRepository =
                new InMemoryLondRepository();
        JdbcBookRepository jdbcBookRepository = new JdbcBookRepository();

        MemberService serviceM =
                new MemberService(inMemoryMemberRepository);


        BookService serviceB =
                new BookService(jdbcBookRepository);

        LondService serviceL =
                new LondService(inMemoryLondRepository, inMemoryMemberRepository, inMemoryBookRepository);


        System.out.println("Members:");

        serviceM.addMember(
                "ali",
                "ali@gmail.com"
        );

        serviceM.addMember(
                "hassan",
                "hassan@gmail.com"
        );


        List<Member> members = serviceM.findAll();

        for (Member member : members) {
            System.out.println(
                    member.getId() + " "
                            + member.getName() + " "
                            + member.getEmail()
            );
        }


        System.out.println();
        System.out.println("Update member:");

        serviceM.updateMember(
                1,
                "ali update",
                "ali2@gmail.com"
        );

        members = serviceM.findAll();

        for (Member member : members) {
            System.out.println(
                    member.getId() + " "
                            + member.getName() + " "
                            + member.getEmail()
            );
        }


        System.out.println();
        System.out.println("Books:");

        serviceB.add(
                "Java",
                "James Gosling"
        );

        serviceB.add(
                "Clean Code",
                "Robert Martin"
        );

        List<Book> books = serviceB.findAll();

        for (Book book : books) {
            System.out.println(
                    book.getId() + " "
                            + book.getName() + " "
                            + book.getAuthor()
            );
        }


        System.out.println();
        System.out.println("Update book:");

        serviceB.update(
                1,
                "Java Programming",
                "James Gosling"
        );

        books = serviceB.findAll();

        for (Book book : books) {
            System.out.println(
                    book.getId() + " "
                            + book.getName() + " "
                            + book.getAuthor()
            );
        }


        System.out.println();
        System.out.println("Lend book:");

        Member member = serviceM.findAll().get(0);
        Book book = serviceB.findAll().get(0);

        serviceL.lendBook(
                member.getId(),
                book.getId()
        );

        System.out.println("book lent");


        System.out.println();
        System.out.println("Active loans:");

        List<Lond> londs = serviceL.findActiveLoans();

        for (Lond lond : londs) {
            System.out.println(
                    lond.getId() + " "
                            + lond.getMemberId().getName() + " "
                            + lond.getBookId().getName()
            );
        }


        System.out.println();
        System.out.println("Return book:");

        serviceL.returnBook(1);

        System.out.println("book returned");


        System.out.println();
        System.out.println("Active loans after return:");

        londs = serviceL.findActiveLoans();

        if (londs.isEmpty()) {
            System.out.println("no active loans");
        }

        for (Lond lond : londs) {
            System.out.println(
                    lond.getId() + " "
                            + lond.getMemberId().getName() + " "
                            + lond.getBookId().getName()
            );
        }


        System.out.println();
        System.out.println("Delete book:");

        serviceB.delete(2);

        books = serviceB.findAll();

        for (Book book1 : books) {
            System.out.println(
                    book1.getId() + " "
                            + book1.getName() + " "
                            + book1.getAuthor()
            );
        }


        System.out.println();
        System.out.println("Delete member:");

        serviceM.deleteMembers(2);

        members = serviceM.findAll();

        for (Member member1 : members) {
            System.out.println(
                    member1.getId() + " "
                            + member1.getName() + " "
                            + member1.getEmail()
            );
        }
    }
}