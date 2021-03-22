package logic;

public class Book {
    int id;
    String title;
    String author;
    String notes;

    public Book(int id, String title, String author, String notes) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.notes = notes;
    }

    public Book(String title, String author, String notes) {
        this.title = title;
        this.author = author;
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}
