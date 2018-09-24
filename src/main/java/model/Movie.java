package model;

import static model.LibraryItemType.*;

public class Movie extends LibraryItem{
    private final Rating rating;

    public Movie(String title, String maker, int year, Rating rating) {
        super(title, maker, year , MOVIE);
        this.rating = rating;
    }

    @Override
    public String toString() {
        return super.title + " | " + super.maker + " | " + super.year + " | " + rating;
    }
}
