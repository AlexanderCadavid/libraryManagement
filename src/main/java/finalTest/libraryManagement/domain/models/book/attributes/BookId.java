package finalTest.libraryManagement.domain.models.book.attributes;

import static org.springframework.util.Assert.notNull;

public class BookId {

    private final Integer bookId;

    public BookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getBookId() {
        return bookId;
    }
}
