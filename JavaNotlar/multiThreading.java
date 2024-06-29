
// by extending Threads you can start usingmulti threading 

public class multiThreading extends Thread {

private String message ;
public int myval;

//constructor
public multiThreading (String message) {
    this.message = message;
}
    
// method that takes too long time 
public void spreadWord() throws InterruptedException{
    int x = 0;
    while(x < 100){
        this.myval = x ;
    System.out.println(this.myval);
    System.out.println(this.message);
    x = x+1;
    Thread.sleep((long) (3.0));
   
    }
}

// multiThread için bu override lazım
@Override
public void run(){   
try {
    spreadWord();
} catch (InterruptedException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
} }


    public static void main(String[] args ){
        multiThreading m1 = new multiThreading("ben m1");
        multiThreading m2 = new multiThreading("ben m2");
        m1.start();
        m2.start();
        System.out.println("sa");

        }
}
