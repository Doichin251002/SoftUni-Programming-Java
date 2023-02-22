package BookComparator;

import java.util.Comparator;

public class BookComparator implements Comparator<Book> {

    @Override
    public int compare(Book book1, Book book2) {
        int titleCompare = book1.getTitle().compareTo(book2.getTitle());
        if (titleCompare != 0) {
            return titleCompare;
        }
        return book1.getYear() - book2.getYear();
    }
}
