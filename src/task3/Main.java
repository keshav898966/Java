package task3;

import java.util.ArrayList;
import java.util.List;

class Book {
    private String title;
    private String author;
    private boolean isIssued;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    public String getTitle() {
        return title;
    }

    public boolean isIssued() {
        return isIssued;
    }

    public void issue() {
        isIssued = true;
    }

    public void returnBook() {
        isIssued = false;
    }

    @Override
    public String toString() {
        return title + " by " + author + (isIssued ? " (Issued)" : " (Available)");
    }
}

class User {
    private String name;
    private List<Book> borrowedBooks;

    public User(String name) {
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
        book.issue();
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
        book.returnBook();
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    @Override
    public String toString() {
        return name + " (Borrowed books: " + borrowedBooks.size() + ")";
    }
}

class Library {
    private List<Book> books;
    private List<User> users;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }

    public void addUser(User user) {
        users.add(user);
        System.out.println("User added: " + user.getName());
    }

    public void issueBook(String title, String userName) {
        Book book = findBook(title);
        User user = findUser(userName);

        if (book == null) {
            System.out.println("Book not found.");
        } else if (user == null) {
            System.out.println("User not found.");
        } else if (book.isIssued()) {
            System.out.println("Book already issued.");
        } else {
            user.borrowBook(book);
            System.out.println("Book issued: " + title + " to " + userName);
        }
    }

    public void returnBook(String title, String userName) {
        Book book = findBook(title);
        User user = findUser(userName);

        if (book == null || user == null) {
            System.out.println("Book or user not found.");
            return;
        }

        if (user.getBorrowedBooks().contains(book)) {
            user.returnBook(book);
            System.out.println("Book returned: " + title + " by " + userName);
        } else {
            System.out.println("This user didn't borrow the book.");
        }
    }

    public void listBooks() {
        System.out.println("Library Books:");
        for (Book book : books) {
            System.out.println("- " + book);
        }
    }

    public void listUsers() {
        System.out.println("Library Users:");
        for (User user : users) {
            System.out.println("- " + user);
        }
    }

    private Book findBook(String title) {
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                return b;
            }
        }
        return null;
    }

    private User findUser(String name) {
        for (User u : users) {
            if (u.getName().equalsIgnoreCase(name)) {
                return u;
            }
        }
        return null;
    }
}


public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        // Add some books
        library.addBook(new Book("1984", "George Orwell"));
        library.addBook(new Book("The Alchemist", "Paulo Coelho"));

        // Add users
        library.addUser(new User("Alice"));
        library.addUser(new User("Bob"));

        // Issue and return books
        library.issueBook("1984", "Alice");
        library.issueBook("The Alchemist", "Bob");
        library.issueBook("1984", "Bob"); // Already issued

        // Return book
        library.returnBook("1984", "Alice");
        library.issueBook("1984", "Bob");

        // List
        library.listBooks();
        library.listUsers();
    }
}
