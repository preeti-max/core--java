class Addfunction{
    int add(int a,int b){
        return a+b;
    }
    int add(int a,int b,int c){
        return a+b+c;
    }
    int add(int a,int b,int c,int d){
        return a+b+c+d;
    }

}

public class Calculator {
    public static void main(String[] args) {
        Addfunction s1= new Addfunction();
        String s="The sum is: ";
        System.out.println(s+s1.add(2,8));
        System.out.println(s+s1.add(2,4,5));
        System.out.println(s+s1.add(2,4,8));
        System.out.println(s+s1.add(2,4,1,6));
    }
    
}

