package generics;

public class GenericFunctionExample {
    static <T> T genericFunction(Integer n, T param) {
        if (param instanceof Integer || param instanceof Double) {
            Integer res = n * Integer.parseInt(String.valueOf(param));
            return (T) res;
        } else if (param instanceof String) {
            return (T) "Can't perform multiplication";
        } else if (param instanceof Boolean)
            return (T) (Object) false;
        else
            return (T) "No output";

    }

    public static void main(String[] args) {
        System.out.println(genericFunction(44, 33));
    }
}