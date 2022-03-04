package Collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Book {
    int id;
    String name;
    String author;
    String publisher;
    int quantity;

    public Book(int id, String name, String author, String publisher, int quantity) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.quantity = quantity;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((author == null) ? 0 : author.hashCode());
        result = prime * result + id;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
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
        Book other = (Book) obj;
        if (author == null) {
            if (other.author != null)
                return false;
        } else if (!author.equals(other.author))
            return false;
        if (id != other.id)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Book [author=" + author + ", id=" + id + ", name=" + name + ", publisher=" + publisher + ", quantity="
                + quantity + "]";
    }

}

public class BookDriver {

    public static void main(String[] args) {
        Book b1 = new Book(121, "Let us C", "Yashwant Kanetkar", "BPB", 8);
        Book b2 = new Book(233, "Operating System", "Galvin", "Wiley", 6);
        Book b3 = new Book(101, "Data Communications & Networking", "Forouzan", "Mc Graw Hill", 4);
        Book b4 = new Book(121, "Let us C", "Yashwant Kanetkar", "Mc Graw Hill", 11);
        List<Book> library = new ArrayList<>();
        Set<Book> set = new HashSet<>();

        library.add(b1);
        library.add(b2);
        library.add(b3);
        library.add(b4);
        for (int i = 0; i < library.size() - 1; i++) {
            Book a = library.get(i);
            for (int j = i + 1; j < library.size(); j++) {
                if (a.equals(library.get(j))) {
                    set.add(a);
                }

            }
        }
        System.out.println("NO of duplicates found: " + set.size());
        set.forEach(b -> System.out.println(
                "Duplicate books: +Book id: " + b.id + " Book name: " + b.name + " Book author:" + b.author));

        Book maxBook = null;

        ArrayList<Book> library2 = new ArrayList<>(library);
        library2.removeAll(set);
        int max = Integer.MIN_VALUE;
        for (Book b : library2) {

            if (b.quantity > max) {
                max = b.quantity;
                maxBook = b;

            }

        }
        System.out.println("Details of book with max quantity");
        System.out.println(maxBook);

    }

}
