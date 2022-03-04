package generics;

class Absolute<T extends Number> {
    T num;

    public Absolute(T num) {
        this.num = num;
    }

    public boolean isAbsolute(Absolute<T> obj) {
        if (Math.abs(num.intValue()) == Math.abs(obj.num.intValue())) {
            return true;

        }
        return false;
    }

}

public class AbsoluteDriver {
    public static void main(String[] args) {
        Absolute<Long> obj = new Absolute<>(4L);
        Absolute<Long> obj1 = new Absolute<>(-4L);
        System.out.println(obj.isAbsolute(obj1));

    }

}
