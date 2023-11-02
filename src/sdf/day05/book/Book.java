package sdf.day05.book;

public class Book {
    private String title;
    private String publisher;

    public Book (String title, String publisher) {
        this.title = title;
        this.publisher = publisher;
    }

    public String getBookTitle() {
        return title;
    }

    public void setBookTitle(String bookTitle) {
        this.title = bookTitle;
    }

    public String getBookPublisher() {
        return publisher.toUpperCase();
    }

    public void setBookPublisher(String bookPublisher) {
        this.publisher = bookPublisher;
    }

}
