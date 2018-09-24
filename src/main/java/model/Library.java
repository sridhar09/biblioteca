package model;

import java.util.ArrayList;
import java.util.Collection;

public class Library {
    private Collection<LibraryItem> availableLibraryItems;
    private Collection<LibraryItem> checkedOutLibraryItems;
    public Library(Collection<LibraryItem> availableLibraryItems){
        this.availableLibraryItems = new ArrayList<>(availableLibraryItems);
        checkedOutLibraryItems = new ArrayList<>();
    }

    public Collection<String> getLibraryItemList(LibraryItemType itemType){
        Collection<String> bookTitleList = new ArrayList<>();
        for(LibraryItem libraryItem : availableLibraryItems){
            if(libraryItem.hasItemType(itemType)){
                bookTitleList.add(libraryItem.toString());
            }
        }
        return bookTitleList;
    }

    public boolean checkout(String bookTitle, LibraryItemType itemType){
        LibraryItem checkoutLibraryItem = null;
        for(LibraryItem libraryItem : availableLibraryItems){
            if(libraryItem.hasTitle(bookTitle) && libraryItem.hasItemType(itemType)){
                checkoutLibraryItem = libraryItem;
                break;
            }
        }
        if(availableLibraryItems.remove(checkoutLibraryItem)){
            checkedOutLibraryItems.add(checkoutLibraryItem);
            return true;
        }
        return false;
    }

    public boolean returnItem(String bookTitle, LibraryItemType itemType) {
        LibraryItem returnLibraryItem = null;
        for(LibraryItem libraryItem : checkedOutLibraryItems){
            if(libraryItem.hasTitle(bookTitle) && libraryItem.hasItemType(itemType)){
                returnLibraryItem = libraryItem;
                break;
            }
        }
        if(checkedOutLibraryItems.remove(returnLibraryItem)) {
            availableLibraryItems.add(returnLibraryItem);
            return true;
        }
        return false;
    }
}
