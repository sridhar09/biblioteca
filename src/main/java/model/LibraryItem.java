package model;

public class LibraryItem {
    protected final String title;
    protected final String maker;
    protected final int year;
    protected final LibraryItemType itemType;

    protected LibraryItem(String title, String maker, int year, LibraryItemType itemType) {
        this.title = title;
        this.maker = maker;
        this.year = year;
        this.itemType = itemType;
    }

    boolean hasTitle(String title){
        return this.title.equals(title);
    }

    boolean isOfItemType(LibraryItemType itemType){
        return this.itemType==itemType;
    }
}
