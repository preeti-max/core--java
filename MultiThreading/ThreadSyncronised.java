package MultiThreading;
import java.io.FileWriter;
import java.io.IOException;


class Shakespeare{
    synchronized void writeEpicStuff(String s){
        try{
            FileWriter fw = new FileWriter("playsync.txt",true);
            int n=s.length();
            for(int i=0;i<n;i++){
                fw.write(s.charAt(i));
            }
            fw.write("\n");
            fw.close();
            System.out.println("File written successfully by "+Thread.currentThread().getName());
            
        }
        catch(IOException e){
            System.out.println(e);
        }        
    }
}

class MyThread extends Thread {
    private String content;
    private Shakespeare shakespeare;
    MyThread(String content,Shakespeare shakespeare){
        this.content = content;
        this.shakespeare = shakespeare;
    }
    @Override
    public void run() {
        this.shakespeare.writeEpicStuff(this.content);
    }

}

public class ThreadSyncronised{
    public static void main(String[] args) throws InterruptedException {
        
        Shakespeare shakespeare = new Shakespeare();
        MyThread t1 = new MyThread("Et tu Brute!",shakespeare);
        MyThread t2 = new MyThread("Hamlet is a small village.",shakespeare);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        
        

        
    }
    
}
