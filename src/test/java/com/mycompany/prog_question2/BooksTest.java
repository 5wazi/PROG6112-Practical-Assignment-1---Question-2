/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.prog_question2;

import static com.mycompany.prog_question2.Books.calculateReturnDate;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author samke
 */
public class BooksTest {
    
    public BooksTest() {
    }

    @Test
    public void testAddBook() {
//    String[][] genre = {{"Fiction", "To Kill a Mockingbird", "Harper Lee", "2024-09-17"}};
    String[][] Book = {{"Fiction", "To kill a Mockingbird", "Harper Lee", calculateReturnDate()}};

    Books.addBook();

    assertEquals(Book, Books.books[0][0]);
    assertEquals(Book, Books.books[0][1]);
    assertEquals(Book, Books.books[0][2]);
    assertEquals(Book, Books.books[0][3]);
    assertEquals(Book, Books.books[0][4]);
    }
    
    
    
    @Test
    public void testReturnBook() {
        String[][] books = {{"Fiction", "To Kill a Mockingbird", "Harper Lee", "9780061120084", calculateReturnDate()}};
        Books.rows = 1;
        Books.books = books;

        Books.returnBook();

        assertEquals(0, Books.rows);
        assertNotNull(Books.books);
        assertEquals(0, Books.books.length);
    }
    
    
    @Test
    public void testSearchBook() {
    
    }
    
    

    @Test
    public void testCalculateReturnDate() {
        String expectedReturnDate = java.time.LocalDate.now().plusDays(14).format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String actualReturnDate = Books.calculateReturnDate();

        assertEquals(expectedReturnDate, actualReturnDate);
    }

    @Test
    public void testDisplayBooks() {
        
    }

    @Test
    public void testExit() {
        
    }
    
}
