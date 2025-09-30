package com.buse.library;
import java.util.Scanner;
import com.buse.library.repo.BookRepository;
import com.buse.library.model.Book;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        BookRepository repo = new BookRepository();
        boolean running = true;

        while (running) {
            System.out.println("--- Library Manager ---");
            System.out.println("1) Add Book");
            System.out.println("2) List Books");
            System.out.println("3) Borrow Book");
            System.out.println("4) Return Book");
            System.out.println("0) Exit");
            System.out.print("Choose: ");
            String choice = sc.nextLine().trim();

            switch (choice) {
                case "1":
                    System.out.print("Book title: ");
                    String title = sc.nextLine();
                    System.out.print("Author: ");
                    String author = sc.nextLine();
                    Book newBook = repo.addBook(title, author);
                    System.out.println("Added: " + newBook);
                    break;

                case "2":
                    if(repo.listBooks().isEmpty()){
                        System.out.println("There are no books in the library");
                    } else{
                        System.out.println("--- Books ---");
                        for(Book b:repo.listBooks()){
                            System.out.println(b);
                        }
                    }
                    break;

                case "3":
                    System.out.print("Enter book id to borrow: ");
                    int borrowId = Integer.parseInt(sc.nextLine());
                    if(repo.borrowBook(borrowId)){
                        System.out.println("Book borrowed successfully!");
                    } else {
                        System.out.println("Book not available or not found.");
                    }
                    break;

                case "4":
                    System.out.print("Enter book id to return: ");
                    int returnId = Integer.parseInt(sc.nextLine());
                    if(repo.returnBook(returnId)){
                        System.out.println("Book returned successfully!");
                    } else {
                        System.out.println("Book not found or already in library.");
                    }
                    break;

                case "0":
                    running = false;
                    System.out.println("Bye!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again");
            }
        }
    }
}
