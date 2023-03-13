package finalTest.libraryManagement.domain.models.book.attributes;

import java.util.regex.Pattern;

import org.springframework.util.Assert;

public class BookName {

    private final String bookName;

    public BookName(String bookName) {
        Assert.notNull(bookName, "The book name cannot be null");
        Assert.isTrue(bookName.length() <= 50, "The Maximum book name size must be 50 characters");
        Assert.isTrue(Pattern.matches("^[A-z\\s]+(?<!\\s)$", bookName), "The book name cannot contain special characters");
        this.bookName = bookName;
    }

    public String getBookName() {
        return bookName;
    }
}
