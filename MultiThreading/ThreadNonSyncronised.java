
package MultiThreading;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Shakespeare2{
    void writeEpicStuff(String s){
        try{
            FileWriter fw2 = new FileWriter("playnonsync.txt",true);
            int n=s.length();
            for(int i=0;i<n;i++){
                fw2.write(s.charAt(i));
                
            }
            fw2.write("\n");
            fw2.close();
            System.out.println("File written successfully by "+Thread.currentThread().getName());
        }
        catch(IOException e){
            System.out.println(e);
        }
        
        
    }
}
class MyThread2 extends Thread {
    private String content;
    private Shakespeare2 shakespeare;
    MyThread2(String content,Shakespeare2 shakespeare){
        this.content = content;
        this.shakespeare = shakespeare;
    }
    @Override
    public void run() {
        this.shakespeare.writeEpicStuff(this.content);
    }

}
public class ThreadNonSyncronised{
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        Shakespeare2 shakespeare1 = new Shakespeare2();
        MyThread2 t3 = new MyThread2("Et tu Brute!",shakespeare1);
        MyThread2 t4 = new MyThread2("Hamlet is a small village.",shakespeare1);
        t3.start();
        t4.start();
        t3.join();
        t4.join();
        
        

        
    }
    
}
