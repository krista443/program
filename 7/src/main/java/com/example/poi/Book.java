import java.util.Scanner;

public class Book {
    private final String title;
    private final String author;
    private final String genre;
    private final int pageCount;

    private Book(BookBuilder builder) {
        this.title = builder.title;
        this.author = builder.author;
        this.genre = builder.genre;
        this.pageCount = builder.pageCount;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public int getPageCount() {
        return pageCount;
    }

    public static class BookBuilder {
        private String title;
        private String author;
        private String genre;
        private int pageCount;

        public BookBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public BookBuilder setAuthor(String author) {
            this.author = author;
            return this;
        }

        public BookBuilder setGenre(String genre) {
            this.genre = genre;
            return this;
        }

        public BookBuilder setPageCount(int pageCount) {
            this.pageCount = pageCount;
            return this;
        }

        public Book build() {
            if (title == null || author == null || genre == null || pageCount <= 0) {
                throw new IllegalStateException("Не все свойства книги установлены.");
            }
            return new Book(this);
        }
    }
}
