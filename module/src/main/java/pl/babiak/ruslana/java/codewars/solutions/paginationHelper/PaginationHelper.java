package pl.babiak.ruslana.java.codewars.solutions.paginationHelper;

import java.util.List;

public class PaginationHelper<I> {
    private int size = 0;
    private int items = 0;

    /**
     * The constructor takes in an array of items and a integer indicating how many
     * items fit within a single page
     */
    public PaginationHelper(List<I> collection, int itemsPerPage) {
        this.size = collection.size();
        this.items = itemsPerPage;
    }

    /**
     * returns the number of items within the entire collection
     */
    public int itemCount() {
        return size;
    }

    /**
     * returns the number of pages
     */
    public int pageCount() {
        int count = 0;
        if (size == items) {
            return 1;
        } else {
            count = size / items;
            if (size % items == 0 || items == 1) {
                return count;
            } else {
                return count + 1;
            }
        }
    }

    /**
     * returns the number of items on the current page. page_index is zero based.
     * this method should return -1 for pageIndex values that are out of range
     */
    public int pageItemCount(int pageIndex) {
        int pages = pageCount();

        if (pageIndex >= pages || pageIndex < 0) {
            return -1;
        }
        if (pages - 1 == pageIndex) {
            return size % items == 0 ? items : size % items;
        }
        return items;
    }

    /**
     * determines what page an item is on. Zero based indexes
     * this method should return -1 for itemIndex values that are out of range
     */
    public int pageIndex(int itemIndex) {
        if (itemIndex < 0 || itemIndex >= size) {
            return -1;
        }
        return itemIndex / items;
    }
}