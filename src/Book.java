public class Book {
    private int id;
    private int idGen = 1;
    private String title;
    private String author;
    private int year;
    private boolean available;

    public Book() {
        this.id = idGen++;
        this.available = true;
    }

    public Book(String title, String author, int year) {
        this();
        setAuthor(author);
        setTitle(title);
        setYear(year);
    }

    public void markAsBorrowed() {
        this.available = false;
    }

    public void markAsReturned() {
        this.available = true;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setTitle(String title) {
        if(title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setAuthor(String author) {
        if(author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setYear(int year) {
        if(year <= 1500 || year >= 2025) {
            throw new IllegalArgumentException();
        }
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isAvailable() {
        return available;
    }

    @Override
    public String toString() {
        return "id = " + id + "\n" +
                "author = " + author + "\n" +
                "title = " + title + "\n" +
                "year = " + year + "\n" +
                "isavailable = " + available;
    }
}
