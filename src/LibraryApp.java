import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;



public class LibraryApp {
    List<Book> books = new ArrayList<>();
    Scanner input = new Scanner(System.in);
    public void run(){
        int userChoice;
        do {
            System.out.println(
                    "Welcome to Library App!\n" +
                            "1. Print all books\n" +
                            "2. Add new book\n" +
                            "3. Search books by title\n" +
                            "4. Borrow a book\n" +
                            "5. Return a book\n" +
                            "6. Delete a book by id\n" +
                            "7. Quit"

            );
            System.out.print("Enter number to choose: ");
            userChoice = input.nextInt();
            input.nextLine();

            switch (userChoice) {
                case 1:
                    printAllBooks();
                    break;

                case 2:
                    addNewBook();
                    break;

                case 3:
                    searchBooksByTitle();
                    break;

                case 4:
                    borrowBook();
                    break;

                case 5:
                    returnBook();
                    break;

                case 6:
                    deleteBookById();
                    break;

                case 7:
                    quit();
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while(userChoice != 7);
    }

    private void printAllBooks(){
        if(books.isEmpty()){
            System.out.println("No books in the library.");
            return;
        }
        for(Book x : books){
            System.out.println(x);
        }
    }

    private void addNewBook(){
        System.out.print("Enter title: ");
        String title = input.nextLine();

        System.out.print("Enter author: ");
        String author = input.nextLine();

        System.out.print("Enter year: ");
        int year = input.nextInt();
        input.nextLine();

        Book kniga = new Book(title, author, year);
        books.add(kniga);
        System.out.println("Book added into library");
    }

    private void searchBooksByTitle() {
        System.out.print("Enter title: ");
        String title = input.nextLine().toLowerCase();
        boolean isfound = false;

        for(Book x : books){
            if(x.getTitle().toLowerCase().contains(title)){
                System.out.println(x);
                isfound = true;
            }
        }
        if(!isfound) {
            System.out.println("There is no book named:" + title);
        }
    }

    private void borrowBook() {
        System.out.print("Enter book id: ");
        int id = input.nextInt();
        input.nextLine();

        Book book = findBookById(id);

        if (book == null) {
            System.out.println("There is no book with this id.");
        } else if (book.isAvailable()) {
            System.out.println("Book been borrowed");
            book.markAsBorrowed();
        } else {
            System.out.println("Book is already borrowed.");
        }
    }
    private void returnBook() {
        System.out.print("Enter book id: ");
        int id = input.nextInt();
        input.nextLine();

        Book book = findBookById(id);

        if (book == null) {
            System.out.println("There is no book with this id.");
        } else if (!book.isAvailable()) {
            System.out.println("Book been returned");
            book.markAsReturned();
        } else {
            System.out.println("Book is already available.");
        }
    }

    private void deleteBookById() {
        System.out.print("Enter book id: ");
        int id = input.nextInt();
        input.nextLine();
        Book book = findBookById(id);

        if (book == null) {
            System.out.println("There is no book with this id.");
        } else {
            books.remove(book);
            System.out.println("Book been deleted");
        }
    }

    private void quit(){
        System.out.println("application exited");
    }

    private Book findBookById(int id) {
        for (Book x : books) {
            if (x.getId() == id) {
                return x;
            }
        }
        return null;
    }
}

