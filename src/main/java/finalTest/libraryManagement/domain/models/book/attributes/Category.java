package finalTest.libraryManagement.domain.models.book.attributes;

import java.util.regex.Pattern;

import org.springframework.util.Assert;

public class Category {

    private final String category;

    public Category(String category) {
        Assert.notNull(category, "The book category cannot be null");
        Assert.isTrue(category.length() <= 20, "The Maximum book category size must be 20 characters");
        Assert.isTrue(Pattern.matches("^[A-z\\s]+(?<!\\s)$", category), "The book category cannot contain special characters");
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
}
