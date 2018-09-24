package model;

import java.util.ArrayList;
import java.util.Collection;

public class Library {
    private Collection<LibraryItem> availableLibraryItems;
    private Collection<LibraryItem> checkedOutLibraryItems;
    private Collection<User> users;
    private UserManager userManager;
    public Library(Collection<LibraryItem> availableLibraryItems, Collection<User> users){
        this.availableLibraryItems = new ArrayList<>(availableLibraryItems);
        checkedOutLibraryItems = new ArrayList<>();
        this.users = users;
        userManager = new UserManager(new ArrayList<>(users));
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

    public boolean checkout(String itemTitle, LibraryItemType itemType){
        LibraryItem checkoutLibraryItem = null;
        for(LibraryItem libraryItem : availableLibraryItems){
            if(libraryItem.hasTitle(itemTitle) && libraryItem.hasItemType(itemType)){
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

    public boolean returnItem(String itemTitle, LibraryItemType itemType) {
        LibraryItem returnLibraryItem = null;
        for(LibraryItem libraryItem : checkedOutLibraryItems){
            if(libraryItem.hasTitle(itemTitle) && libraryItem.hasItemType(itemType)){
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

    public boolean login(LoginCredential loginCredential){
        return userManager.login(loginCredential);
    }
}
