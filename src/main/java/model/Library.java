package model;

import java.util.ArrayList;
import java.util.Collection;

public class Library {
    private Collection<Book> availableBooks;
    private Collection<Book> checkedOutBooks;
    public Library(Collection<Book> availableBooks){
        this.availableBooks = new ArrayList<>(availableBooks);
    }

    public Collection<String> getBookList(){
        Collection<String> bookTitleList = new ArrayList<>();
        for(Book book : availableBooks){
            bookTitleList.add(book.toString());
        }
        return bookTitleList;
    }

    public boolean checkout(String bookTitle){
        Book checkoutBook = null;
        for(Book book : availableBooks){
            if(book.getTitle().equals(bookTitle)){
                checkoutBook = book;
                break;
            }
        }
        if(availableBooks.remove(checkoutBook)){
            return true;
        }
        return false;
    }
}
