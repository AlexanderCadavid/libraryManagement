package finalTest.libraryManagement.domain.models.book.attributes;

import java.util.regex.Pattern;

import org.springframework.util.Assert;

public class Author {

    private final String author;

    public Author(String author) {
        Assert.notNull(author, "The book author cannot be null");
        Assert.isTrue(author.length() <= 30, "The Maximum book author size must be 30 characters");
        Assert.isTrue(Pattern.matches("^[A-z\\s]+(?<!\\s)$", author), "The book author cannot contain special characters");
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }
}
