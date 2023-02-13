import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static List<LendingRegistry> registry = new ArrayList<>();

    public static void message() {
        System.out.println("1. Add Book To Index User");
        System.out.println("2. Show Books From Index User");
        System.out.println("3. Delete Book From Index User With Title");
        System.out.println("4. Show Books From User That have a passed date");
        System.out.println("5. Returns List With Expired Books For User");
        System.out.println("6. Returns List With Books Of Author For User");
        System.out.println("7. Print All Users With Expired Books");
        System.out.println("0. Exit program.");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        registry.add(new LendingRegistry(new Reader("Acho", "Burgas", "1287329873")));
        registry.add(new LendingRegistry(new Reader("Gosho", "Sofia", "1846473843")));

        registry.get(0).addBook(new Book(1, "Acho", "Princ", 23.57), 1,1,1999);
        registry.get(0).addBook(new Book(1, "Gosho", "Cherno", 34.67), 8,11,2024);

        while(true) {
            message();
            String input = sc.nextLine().trim();
            switch (input) {
                case "1":
                    System.out.print("Input User Index. After that input User Id, Author, Title, Price. After that enter Book Return Date: Day/Month/Year.");
                    registry.get(Integer.parseInt(sc.nextLine().trim())).addBook(new Book(Integer.parseInt(sc.nextLine().trim()), sc.nextLine().trim(), sc.nextLine().trim(), Double.parseDouble(sc.nextLine().trim())), Integer.parseInt(sc.nextLine().trim()),Integer.parseInt(sc.nextLine().trim()),Integer.parseInt(sc.nextLine().trim()));
                    break;
                case "2":
                    System.out.print("Input User Index: ");
                    registry.get(Integer.parseInt(sc.nextLine().trim())).printLentBooks();
                    break;
                case "3":
                    System.out.print("Input User Index and Book Title To Delete: ");
                    registry.get(Integer.parseInt(sc.nextLine().trim())).deleteBookByTitle(sc.nextLine().trim());
                    break;
                case "4":
                    System.out.println("Input User Index: ");
                    registry.get(Integer.parseInt(sc.nextLine().trim())).showBooksWithPassedReturnDate();
                    break;
                case "5":
                    System.out.println("Input User Index: ");
                    List<Book> books = registry.get(Integer.parseInt(sc.nextLine().trim())).returnListWithExpiredBooks();
                    System.out.println(books.toString());
                    break;
                case "6":
                    System.out.println("Input User Index and Author: ");
                    List<Book> books1 = registry.get(Integer.parseInt(sc.nextLine().trim())).returnListWithBooksOfAuthor(sc.nextLine().trim());
                    System.out.println(books1.toString());
                    break;
                case "7":
                    LendingRegistry.printAllUsersWithExpiredBooks();
                    break;
                case "0":
                    return;
            }
        }
    }
}
