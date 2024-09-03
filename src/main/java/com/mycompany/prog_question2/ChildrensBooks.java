/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prog_question2;
import static com.mycompany.prog_question2.PROG_Question2.option;

/**
 *
 * @author samke
 */

enum Genres {
        ROMANCE, FANTASY, THRILLER, DRAMA, FICTION, NONFICTION, ADULT, CHILDREN
    }

public class ChildrensBooks extends Books{
        //Create Constructor
    public ChildrensBooks (String title, String author, String genre, String cardID) {
        super(title, author, genre, cardID); //Constructor of SuperClass
    }
    
    public static String allowed = "n";
    public static String genre;

    public static void addBook() {
        
        while (option == 1) {
            //While loop to loop while user inputs restricted genres
            while (allowed.equals("n")) {
                //Prompt the user and save input to the books array
                System.out.println("Enter book genre: ");
                genre = kb.next().toUpperCase();
                books[rows][0] = genre;
            
                Genres G = Genres.valueOf(genre);
            
                switch (G) {
                    case ROMANCE:
                    case ADULT:
                        System.out.println("The " + G + " genre is not allowed for children");
                        allowed = "n";
                        break;
                    default:
                        allowed = "y";
                        break;
                } 
            }

            //Prompt the user and save input to the books array
            System.out.println("Enter book title: ");
            bookTitle = kb.next();
            books[rows][1] = bookTitle;

            //Prompt the user and save input to the books array
            System.out.println("Enter author: ");
            author = kb.next();
            books[rows][2] = author;
            
            //Prompt the user and save input to the books array
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
    
}
