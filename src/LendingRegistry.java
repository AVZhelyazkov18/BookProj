import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LendingRegistry {
    private List<Book> lentBooks;
    private List<LocalDate> dates;
    private Reader reader;

    public LendingRegistry(Reader reader) {
        this.reader = reader;
        this.lentBooks = new ArrayList<>();
        this.dates = new ArrayList<>();
    }

    public LendingRegistry() {}

    public void addBook(Book book, int day, int month, int year) {
        lentBooks.add(book);
        dates.add(LocalDate.of(year, month, day));
        System.out.println("Successfully added book.");
    }

    public void printLentBooks() {
        System.out.println("All Books:");
        for (Book book: lentBooks) {
            book.print();
        }
    }

    public void deleteBookByTitle(String title) {
        for (int i = 0; i < lentBooks.size(); i++) {
            if (lentBooks.get(i).getTitle().equalsIgnoreCase(title)) {
                lentBooks.remove(i);
                dates.remove(i);
                System.out.println("Successfully deleted book with title: " + title + ".");
                return;
            }
        }
        System.out.println("Could not find a book with title: " + title);
    }

    public void showBooksWithPassedReturnDate() {
        for (int i = 0; i < dates.size(); i++) {
            if(dates.get(i).isBefore(LocalDate.now())) {
                lentBooks.get(i).print();
            }
        }
    }

    public List<Book> returnListWithExpiredBooks() {
        List<Book> booksToReturn = new ArrayList<>();
        for (int i = 0; i < dates.size(); i++) {
            if(dates.get(i).isBefore(LocalDate.now())) {
                booksToReturn.add(lentBooks.get(i));
            }
        }
        return booksToReturn;
    }

    public List<Book> returnListWithBooksOfAuthor(String Author) {
        List<Book> booksToReturn = new ArrayList<>();
        for (int i = 0; i < lentBooks.size(); i++) {
            if(lentBooks.get(i).getAuthor().equalsIgnoreCase(Author)) {
                booksToReturn.add(lentBooks.get(i));
            }
        }
        return booksToReturn;
    }

    public static void printAllUsersWithExpiredBooks() {
        for (LendingRegistry register: Main.registry) {
            for (LocalDate date: register.dates) {
                if (date.isBefore(LocalDate.now())) {
                    register.reader.print();
                    break;
                }
            }
        }
    }
}
