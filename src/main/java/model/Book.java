package model;

import static model.LibraryItemType.BOOK;

public class Book extends LibraryItem{

    public Book(String title, String maker, int year) {
        super(title, maker, year , BOOK);
    }

    @Override
    public String toString() {
        return super.title + " | " + super.maker + " | " + super.year;
    }
}
