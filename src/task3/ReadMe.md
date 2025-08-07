# 📚 Mini Library Management System in Java

This is a simple Java console-based application that simulates a basic Library Management System. It allows you to:

- Add books and users
- Issue books to users
- Return books from users
- View the list of books and users

---

## 🚀 Features

- **Book Management**: Add and manage books with title, author, and issue status.
- **User Management**: Add users and track borrowed books.
- **Issue/Return System**: Users can borrow and return books with proper validation.
- **Console Output**: Easy-to-read console messages for actions and errors.

---

## 🛠️ Technologies Used

- Java (Standard Edition)
- Java Collections (ArrayList)

---

## 🧾 Classes Overview

### `Book`
Represents a book with:
- Title
- Author
- Issued status

### `User`
Represents a library user with:
- Name
- List of borrowed books

### `Library`
Main manager class that:
- Holds lists of books and users
- Allows issuing and returning books
- Finds books/users by name
- Prints the book/user list

### `Main`
Test driver with a sample demo of the library system.