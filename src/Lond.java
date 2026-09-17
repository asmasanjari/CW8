public class Lond {
    private int id;
    private Member memberId;
    private Book bookId;

    public Lond(int id, Member memberId, Book bookId) {
        this.id = id;
        this.memberId = memberId;
        this.bookId = bookId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Member getMemberId() {
        return memberId;
    }

    public void setMemberId(Member memberId) {
        this.memberId = memberId;
    }

    public Book getBookId() {
        return bookId;
    }

    public void setBookId(Book bookId) {
        this.bookId = bookId;
    }


}
