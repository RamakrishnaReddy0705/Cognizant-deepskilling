class Book {
    int bookId;
    String title;
    String author;

    Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }
}

public class LibraryManagement {

    static Book linearSearch(Book[] books, String title) {

        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title))
                return book;
        }
        return null;
    }

    static Book binarySearch(Book[] books, String title) {

        int low = 0;
        int high = books.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            int cmp = books[mid].title.compareToIgnoreCase(title);

            if (cmp == 0)
                return books[mid];
            else if (cmp < 0)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return null;
    }
}