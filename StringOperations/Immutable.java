package StringOperations;
final class Task{
    private int a;
    private int b;
    public Task(int a, int b) {
        this.a = a;
        this.b = b;
    }
    public int getA() {
        return a;
    }
    public void setA(int a) {
        this.a = a;
    }
    public int getB() {
        return b;
    }
    public void setB(int b) {
        this.b = b;
    }

}


public class Immutable {
    public static void main(String[] args) {
        Task t1= new Task(1,2);
        System.out.println(t1.getA());
        
    }
    
}
