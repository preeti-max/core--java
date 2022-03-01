package MultiThreading;

class Thread1 extends Thread{
    @Override
    public void run() {
        for(int i=1;i<=10;i++){
            System.out.println("5 * "+i+" = "+5*i);
        }
        System.out.println("T1 terminating");
    

    }

}
class Thread2 implements Runnable{

    @Override
    public void run() {
       String[] country={"India","Australia","Ukraine","Japan","Korea"};
        for(String s:country){
            System.out.println(s);
        }
        System.out.println("t2 terminating");
        
    }
    
}

public class ThreadDriver {
    public static void main(String[] args) {
        String name="Preeti";
        String location="Mumbai";
        String hobby="Reading";
        Thread1 t1= new Thread1();
        Thread2 t=new Thread2();
        Thread t2=new Thread(t);

        System.out.println("Main thread running");
        t1.start();
        t2.start();
        System.out.println("Name :"+name);
        System.out.println("Location :"+location);
        System.out.println("Hobby :"+hobby);
        System.out.println("Main terminating");


        
    }
    
}
