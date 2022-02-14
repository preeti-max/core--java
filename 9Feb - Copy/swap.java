public class swap {
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

    public static void main(String[] args) {
        swap(5, 8);
    }
}