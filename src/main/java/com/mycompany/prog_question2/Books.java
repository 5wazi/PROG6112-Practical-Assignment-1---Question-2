/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prog_question2;
import static com.mycompany.prog_question2.PROG_Question2.option;
import static com.mycompany.prog_question2.PROG_Question2.launch;

import java.util.Scanner;

/**
 *
 * @author samke
 */
public class Books {
    
    //Create data fields
    protected static String title;
    protected static String author;
    protected static String genre;
    protected static String cardID;
    protected static String isbn;
    
    public Books(String title, String author, String genre, String cardID) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.cardID = cardID;
    }

    public static String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public String getcardID() {
        return cardID;
    }
    
    //Declare Variable
    public static int launch;
    public static int COL = 5;
    public static int rows = 0;
    public static String searchTitle;
    public static String remove;
    public static String returnBook;
    public static String bookTitle;
    
    //Declare Array
    public static String[][] books = new String[100][COL];
    
    //Import Scanner Object
    public static Scanner kb = new Scanner(System.in);
    
    public static void addBook() {
        while (option == 1) {
            //Prompt the user and save input to the books array
            System.out.println("Enter book genre: ");
            genre = kb.next();
            books[rows][0] = genre;

            System.out.println("Enter book title: ");
            bookTitle = kb.next();
            books[rows][1] = bookTitle;

            System.out.println("Enter author: ");
            author = kb.next();
            books[rows][2] = author;

            System.out.println("Enter book ISBN: ");
            isbn = kb.next();
            books[rows][3] = isbn;
            
            //Call the calculateReturnDate method and store the result
            books[rows][4] = calculateReturnDate(); 

            //INCREMENTING THE ROW
            rows = rows + 1;

            System.out.println("""
                               ---------------------------------------------------
                               Book has been Borrowed
                               ---------------------------------------------------
                               Enter (1) to launch menu or any other key to exit
                               """);
            launch = kb.nextInt();
            break;
        }
    }
    
    public static void returnBook() {
    while (option == 2) {
        
        if (rows == 0) {
            System.out.println("""
                               ---------------------------------------------------
                               No Outstanding Books to Return");
                               ---------------------------------------------------
                               Enter (1) to launch menu or any other key to exit
                               """);
            launch = kb.nextInt();
            break;
        } else {
            System.out.println("Please enter book title to return: ");
            returnBook = kb.next();
            System.out.println("Are you sure you want to return book titled '" + returnBook + "'?. Enter (y) to confirm.");
            String remove = kb.next();
        
            if (remove.equals("y")) {
                for (int l = 0; l < rows; l++) {
                    if (books[l][1].equals(returnBook)){ // Compare with book title
                        // Shift all books after the returned book
                        for (int i = l; i < rows - 1; i++) {
                            books[i][0] = books[i+1][0];
                            books[i][1] = books[i+1][1];
                            books[i][2] = books[i+1][2];
                            books[i][3] = books[i+1][3];
                            books[i][4] = books[i+1][4];
                        }
                        rows = rows - 1; 
                        System.out.println("---------------------------------------------------");
                        System.out.println("Book titled '" + returnBook + "' was returned!");
                        System.out.println("---------------------------------------------------");
                        break;
                    }
                }
            } else {
                break;
            }
        System.out.println("Enter (1) to launch menu or any other key to exit");
        launch = kb.nextInt();
        break;
        }
        
    }
    }
    
    public static void searchBook() {
        while (option == 3) {
            
            if (rows == 0) {
            System.out.println("""
                               ---------------------------------------------------
                               No Outstanding Books to Search");
                               ---------------------------------------------------
                               Enter (1) to launch menu or any other key to exit
                               """);
            launch = kb.nextInt();
            break;
            } else {
                System.out.println("Please enter book title to search: ");
                searchTitle = kb.next();
                String found = "n";
            
                for (int i = 0; i < rows; i++) {
                    if (books[i][1].equals(searchTitle)) {
                        System.out.println("---------------------------------------------------");
                        System.out.println("BOOK GENRE: " + books[i][0]);
                        System.out.println("BOOK TITLE: " + books[i][1]);                 
                        System.out.println("AUTHOR: " + books[i][2]);
                        System.out.println("ISBN: " + books[i][3]);
                        System.out.println("RETURN DATE: " + books[i][4]);
                        System.out.println("---------------------------------------------------");
                        found = "y";
                        break;
                    }
                }
               
                if (found.equals("n")) {
                    System.out.println("---------------------------------------------------");
                    System.out.println("Book titled '" + searchTitle + "' was not found!");
                    System.out.println("---------------------------------------------------");
                }
                            
                System.out.println("Enter (1) to launch menu or any other key to exit");
                launch = kb.nextInt();
                break;
            }
            
        }
    }
    
    public static String calculateReturnDate() {
        java.time.LocalDate date = java.time.LocalDate.now();
        java.time.LocalDate returnDate = date.plusDays(14); // add 14 days to get the return date

        java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedReturnDate = returnDate.format(formatter);

        return formattedReturnDate;
    }
    
    public static void displayBooks() {
        
    while (option == 4) {
        if (rows == 0) {
            System.out.println("""
                               ---------------------------------------------------
                               No Outstanding books
                               ---------------------------------------------------
                               """);

        } else {
            for (int k = 1; k <= rows; k++) {
                System.out.println("BOOK " + k);
                System.out.println("---------------------------------------------------");
                System.out.println("GENRE: " + books[k-1][0]);
                System.out.println("TITLE: " + books[k-1][1]);
                System.out.println("AUTHOR: " + books[k-1][2]);
                System.out.println("ISBN: " + books[k-1][3]);
                System.out.println("RETURN DATE: " + books[k-1][4]); // corrected here
                System.out.println("---------------------------------------------------");
            }
        }
        
        System.out.println("Enter (1) to launch menu or any other key to exit");
        launch = kb.nextInt();
        break;
    }    
}
    
    public static void exit() {
        while (option == 5) {
            //End of Program statement
            System.out.println("*****THANK YOU FOR USING THE CITY LIBRARY*****");
            System.exit(0);
        }
    }
    
}
