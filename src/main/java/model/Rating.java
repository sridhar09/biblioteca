package model;

public class Rating {
    private final int value;

    public Rating(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        if(value>0){
            return Integer.toString(value);
        }
        return "Unrated";
    }
}
