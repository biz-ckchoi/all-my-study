package chapter06.builder;

import org.junit.Assert;
import org.junit.Test;

public class LibraryBookTest {

    @Test
    public void fictionLibraryBook() {
        final LibraryBook.Builder builder = new LibraryBook.Builder();
        final LibraryBook book = builder.withBookName("War and Peace").build();

        Assert.assertEquals(BookType.FICTION, book.getBookType());
    }

}
