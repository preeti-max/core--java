package StreamAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Book1 implements Comparable<Book1> {
    int id;
    String name;
    String author;
    String publisher;
    int quantity;

    public Book1(int id, String name, String author, String publisher, int quantity) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Book1 other = (Book1) obj;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public int compareTo(Book1 o) {
        return this.id - o.getId();
    }

    @Override
    public String toString() {
        return "Book1 [author=" + author + ", id=" + id + ", name=" + name + ", publisher=" + publisher + ", quantity="
                + quantity + "]";
    }

}

public class BookMarket {
    public static void main(String[] args) {
        Book1 b1 = new Book1(121, "Let us C", "Yashwant Kanetkar", "BPB", 8);
        Book1 b2 = new Book1(233, "Operating System", "Galvin", "Wiley", 6);
        Book1 b3 = new Book1(101, "Data Communications & Networking", "Forouzan", "Mc Graw Hill", 4);
        Book1 b4 = new Book1(121, "Let us C", "Yashwant Kanetkar", "Mc Graw Hill", 11);

        List<Book1> books = new ArrayList<>();
        books.add(b1);
        books.add(b2);
        books.add(b3);
        books.add(b4);
        books.stream().forEach(System.out::println);

        Set<Book1> set = books.stream().collect(Collectors.toSet());

        set.forEach(System.out::println);

        List<Book1> sortedBook1List = books.stream().sorted().collect(Collectors.toList());
        System.out.println("After sorting");
        sortedBook1List.forEach(System.out::println);

        System.out.println("After  doubling quantity");
        books.stream().map(q -> {
            q.quantity = q.quantity * 2;
            return q;
        }).collect(Collectors.toList()).forEach(System.out::println);

        System.out.println("Elements with quantity > 10");
        books.stream().filter(q -> q.quantity > 10)
                .collect(Collectors.toList()).forEach(System.out::println);

        int sold = books.stream().filter(i -> i.id < 200).map(x -> x.quantity).reduce(0, (ans, i) -> ans + i);
        System.out.println("Quantity of books with id < 200: " + sold);
    }
}