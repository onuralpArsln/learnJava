// Runnable interface is btter than threading 
// you dont need to extend to thread, you only extend to one class so dont waste it on thread since runnable interface is similiar
// runnable eats less memoryy 
// runnableis interface not a class 
// only has a basic run method 
// lambada syntax makes it more rewadableeeeeeee 
// you dont need to override runnnnnnn


public class runner implements Runnable {

    public String objName;
    public int objCounter;
    public int counter = 0;



    // constructor
    public runner( String name, int count ){
        this.objCounter = count;
        this.objName = name;
}

    //method 

    public void superHardCalculation(){

        while(100 > counter ) {
            this.counter = this.counter +1;
            this.objCounter = this.objCounter *2 ;
            System.out.println(this.objName);
            System.out.println(this.objCounter);
            System.out.println("--------");
            
        }
    }

    // what to do while thread runs
    public void run(){

// code to execute when thread is run
    this.superHardCalculation();
// goes here

}

public static void main(String[] args){

runner rc = new runner("first", 12);
runner cr = new runner("second", 11);

Thread t = new Thread(rc);
Thread y = new Thread(cr);

y.start();
t.start(); }
    
}
