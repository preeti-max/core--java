public class Test2 {
    public static void square(int a) {
        System.out.println("The square of no is:" + (a * a));
    }

    public static void details(String name, String city, String hobby) {
        System.out.println("Name: " + name);
        System.out.println("City: " + city);
        System.out.println("Hobby: " + hobby);
    }

    public static void swap(int a, int b) {

        System.out.println("The value of a: " + a);
        System.out.println("The value of b: " + b);
        int c = a;
        a = b;
        b = c;
        System.out.println("After swapping");
        System.out.println("The value of a: " + a);
        System.out.println("The value of b: " + b);
    }

    public static void even_odd(int a) {
        if (a % 2 == 0) {
            System.out.println(" the number is even.");
        } else {
            System.out.println(" the number is odd.");
        }
    }

    public static void main(String args[]) {
        square(5);
        details("Preeti", "Gaya", "Reading novels");
        swap(2, 7);
        even_odd(6);

    }

}
