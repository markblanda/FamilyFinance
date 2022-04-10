package model;

public class TransactionCateogry {
    private final String categoryTitle;

    public TransactionCateogry(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    @Override
    public String toString() {
        return categoryTitle;
    }
}
