
interface MyWrapper {
    void printType();
}

class MyInteger implements MyWrapper {

    @Override
    public void printType() {
        System.out.println("Integer type");

    }

}

class MyDouble implements MyWrapper {

    @Override
    public void printType() {
        System.out.println("Double type");

    }

}

class MyCharacter implements MyWrapper {

    @Override
    public void printType() {
        System.out.println("Character type");

    }

}

class MyBoolean implements MyWrapper {

    @Override
    public void printType() {
        System.out.println("Boolean type");

    }

}

class MyWrapperFactory {
    public static MyWrapper getMyWrapperInstance(String s) {
        if (s == null || s.isEmpty())
            return null;
        if (s.matches("-?\\d+")) {
            return new MyInteger();

        }
        if (s.matches("-?\\d+(\\.\\d+)?"))
            return new MyDouble();
        if (s.matches("[a-zA-Z]"))
            return new MyCharacter();
        if (s.equals("true") || s.equals("false"))
            return new MyBoolean();
        else
            throw new IllegalArgumentException("Invalid input");

    }
}

public class FactoryMethodDemo {
    public static void main(String[] args) {

        MyWrapperFactory.getMyWrapperInstance("-1234").printType();
        MyWrapperFactory.getMyWrapperInstance("890000.34").printType();
        MyWrapperFactory.getMyWrapperInstance("true").printType();
        MyWrapperFactory.getMyWrapperInstance("c").printType();
        MyWrapperFactory.getMyWrapperInstance("@").printType();

    }

}
