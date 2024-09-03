/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.prog_question2;

import java.util.Scanner;

/**
 *
 * @author samke
 */
public class PROG_Question2 {
    
    public static int option;
    public static int launch;
    

    public static void main(String[] args) {
        //Import scanner object
        Scanner kb = new Scanner(System.in);
        
        //Welcome Message
        System.out.println("WELCOME TO THE CITY LIBRARY MANAGEMENT SYSTEM");
        System.out.println("*****************************************************************");
        System.out.println("Please enter your library card ID number (start with the c or a): ");
        String cardID = kb.nextLine();
        
        
        System.out.println("Enter (1) to launch menue or any other key");
        launch = kb.nextInt();
        
        while (launch == 1){
            System.out.println("""
                           1. Add New Book
                           2. Return a Book
                           3. Search for a Book
                           4. Disaply Borrowed Books
                           5. Exit
                           """);
            option = kb.nextInt();
        
            //MENU OPTION 1
            while (option == 1) {
                if (cardID.startsWith("a")) {
                    Books.addBook();
                    break;
                } else {
                    ChildrensBooks.addBook();
                    break;
                }
            }
        
            //MENU OPTION 2
            Books.returnBook();
//            Books.returnBook(returnBook);
            
            //MENU OPTION 3
            Books.searchBook();
        
            //MENU OPTION 4
            Books.displayBooks();
        
            //MENU OPTION 5
            Books.exit();
        }
    }
}




/*
References
Prateek, S., 2024. How to Add Date in Arraylist Java. [Online] 
Available at: https://www.naukri.com/code360/library/how-to-add-date-in-arraylist-java
[Accessed 3 September 2024].
StackOverflow, 2022. Adding days to a date in Java [duplicate]. [Online] 
Available at: https://stackoverflow.com/questions/12087419/adding-days-to-a-date-in-java
[Accessed 3 September 2024].
StackOverflow, 2024. Junit Testing void 2D array. [Online] 
Available at: https://stackoverflow.com/questions/26188423/junit-testing-void-2d-array
[Accessed 3 September 2024].


*/