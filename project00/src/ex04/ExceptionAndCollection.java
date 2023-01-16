package ex04;

import java.util.*;

public class ExceptionAndCollection {

    static void insertBook(ArrayList<String> bookList, Scanner bookScanner) {
        do {
            System.out.println("Enter the book name");
            bookList.add(bookScanner.nextLine());
            System.out.println("Do you want to add more books? (y or any key)");
        } while (bookScanner.nextLine().equals("y"));
    }

    static void insertBook(HashMap<String, Integer> bookMap, Scanner bookScanner) {
        do {
            System.out.println("Enter the book name");
            String bookName = bookScanner.nextLine();
            if (bookMap.containsKey(bookName)) {
                System.out.println("Book already exists");
                continue ;
            }
            while (true) {
                try {
                    System.out.println("Enter the book price");
                    bookMap.put(bookName, Integer.parseInt(bookScanner.nextLine()));
                    break ;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid price");
                }
            }
            System.out.println("Do you want to add more books? (y or any key)");
        } while (bookScanner.nextLine().equalsIgnoreCase("y"));
    }

    static void findBook(ArrayList<String> bookList, Scanner bookScanner) {
        do {
            System.out.println("Enter the book name to search");
            String bookName = bookScanner.nextLine();
            if (bookList.contains(bookName)) {
                System.out.println("Book is exist");
            } else {
                System.out.println("Book not found");
            }
            System.out.println("Do you want to search more books? (y or any key)");
        } while (bookScanner.nextLine().equalsIgnoreCase("y"));
    }

    static void findBook(HashMap<String, Integer> bookMap, Scanner bookScanner) {
        do {
            System.out.println("Enter the book name to search");
            String bookName = bookScanner.nextLine();
            if (bookMap.containsKey(bookName)) {
                System.out.println("Book is exist and the price is " + bookMap.get(bookName));
            } else {
                System.out.println("Book not found");
            }
            System.out.println("Do you want to search more books? (y or any key)");
        } while (bookScanner.nextLine().equalsIgnoreCase("y"));
    }

    static void deleteBook(ArrayList<String> bookList, Scanner bookScanner) {
        do {
            System.out.println("Enter the book name to delete");
            String bookName = bookScanner.nextLine();
            if (bookList.contains(bookName)) {
                bookList.remove(bookName);
                System.out.println("Book is deleted");
            } else {
                System.out.println("Book not found");
            }
            System.out.println("Do you want to delete more books? (y or any key)");
        } while (bookScanner.nextLine().equalsIgnoreCase("y"));
    }

    static void deleteBook(HashMap<String, Integer> bookMap, Scanner bookScanner) {
        do {
            System.out.println("Enter the book name to delete");
            String bookName = bookScanner.nextLine();
            if (bookMap.containsKey(bookName)) {
                bookMap.remove(bookName);
                System.out.println("Book is deleted");
            } else {
                System.out.println("Book not found");
            }
            System.out.println("Do you want to delete more books? (y or any key)");
        } while (bookScanner.nextLine().equalsIgnoreCase("y"));
    }

    static void selectList(ArrayList<String> bookList, Scanner bookScanner) {
        int choice = 4;
        do {
            System.out.println("Enter your choice \n1. Insert book \n2. Find book \n3. Delete book \n4. Exit");
            try {
                choice = Integer.parseInt(bookScanner.nextLine());
                switch (choice) {
                    case 1 -> insertBook(bookList, bookScanner);
                    case 2 -> findBook(bookList, bookScanner);
                    case 3 -> deleteBook(bookList, bookScanner);
                    case 4 -> {}
                    default -> throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice");
            }
        } while (choice != 4);
    }

    static void selectMap(HashMap<String, Integer> bookMap, Scanner bookScanner) {
        int choice = 4;
        do {
            System.out.println("Enter your choice \n1. Insert book \n2. Find book \n3. Delete book \n4. Exit");
            try {
                choice = Integer.parseInt(bookScanner.nextLine());
                switch (choice) {
                    case 1 -> insertBook(bookMap, bookScanner);
                    case 2 -> findBook(bookMap, bookScanner);
                    case 3 -> deleteBook(bookMap, bookScanner);
                    case 4 -> {}
                    default -> throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice");
            }
        } while (choice != 4);
    }

    public static void main(String[] args) {
        Scanner bookScanner = new Scanner(System.in);
        ArrayList<String> bookList = new ArrayList<>();
        HashMap<String, Integer> bookMap = new HashMap<>();
        int choice = 3;
        do {
            System.out.println("Enter your choice \n1. Book Array \n2. Book Map \n3. Exit");
            try {
                choice = Integer.parseInt(bookScanner.nextLine());
                switch (choice) {
                    case 1 -> selectList(bookList, bookScanner);
                    case 2 -> selectMap(bookMap, bookScanner);
                    case 3 -> {}
                    default -> throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number");
            }
        } while (choice != 3);
        bookList.forEach(s -> System.out.println("Book name: " + s));
        bookMap.forEach((s, p) -> System.out.println("Book Name: " + s + ", Price: " + p));
    }
}