// anythin between {}  of method is considered scope of this method

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;

public class learn{
    // use command  javac filename.java to compile 
    // use command  java filename execute 
    // void is a method that turns no type 
    // method is a function that part of object
    // main is the name of our method 

  // this line needed for constructor to use learning source ass field
  // youcan thnik this like c++ header, you need to declare variablesof learn here since your constructor cant assing values to object since 
  //  your class needs to have this variables before new  instance to be created 
  String learningSource;
  int timeWorked;
 

    // constructor has public + name (same with classs)
  public learn(String Source ){
    // this is a constructor , shares same name with class
    // write here some instructions to create instance 
    System.out.println(" this is constructing a learn ");
    // constructordaki source paraametresi oluşturlan objenin learningSourceuna atılır 
    learningSource = Source;
  }
  public learn(String Source, int Hours ){
    // Constructors can be overloaded you can have diffrent constrıctors used by the args you put in
    System.out.println("this is second constructor");
    this.learningSource = Source;
    timeWorked= Hours;
  }


    // method 
    // advertise method
  public void advertise() {
		System.out.println("Learning From " + learningSource + "!");
    System.out.println("work more learnd more !");}

  // static method can be called from other files(classes)
  public  static void  callAway() {
System.out.println("i called from awayyyy since i am static");
  }

    public static void main(String[] args){
      // string args allows arguments in terminal to be taken just like python 
      //this is how you print
       System.out.println("Hello Alp!");
       Second(); // this runs the method bottom
      
       // this creates a instance of learn named Java
       learn Java = new learn("CodeAcademy");
       // `System.out.println(Java.learningSource);` is printing the value of the `learningSource`
       // variable of the `Java` instance of the `learn` class. The value of `learningSource` is set to
       // "CodeAcademy" in the constructor of the `learn` class.
       System.out.println(Java.learningSource);

       learn pyqt = new learn("YouTube", 23);
       System.out.println(pyqt.timeWorked);
     
       // you need objects to call methods 
       pyqt.advertise();
       Java.advertise();
      

      // it makes you wait until a command is given
      // this is just declartion no effect 
       Scanner input= new Scanner(System.in);

       System.out.println("was yo name ");
       String userInput = input.next(); // this gets nex string input 
       System.out.printf("salam %s! nabersin", userInput);


       // if not closed it will leak
       input.close();


    }


    public static void WriteFiles() throws IOException{
      FileWriter output = new FileWriter("input.txt");
      String wordsOfWisdom = " asa ";
      output.write(wordsOfWisdom);

      // close or will be leak
      
      output.close();



    }
    

    // read and write files
    // adding throws excepton is integral part t this work
    public static void  ReadFiles() throws IOException{

      String path = "./input.txt";
      FileReader reader = new FileReader(path);
      int counter = 0;
      while ((counter = reader.read()) != -1) {    
        System.out.print((char)counter);    
      } 

      // must close your object or else you wont able  to reach that file since it locks
      reader.close();

      // .read() method reads one cchar at a time 
      /*
       * while (reader.ready()) {
  System.out.print((char) reader.read());
}
       * 
       */
    }

  
    public static void Second() {
      String name = "James Gosling";
      int yearCreated = 1995;
      System.out.println(name);
      char Single = 'a';
      //chars use singlequote marks

    }

    public static void Quotes(){
      // how to print " ?
      String Hello = "  \"   Hello  \" ";
      // with backslash you can print " so string will yield "Hello"
      // this called escape sequence 
      String backslash = "this is how you print a single backslash \\ ";
      // first backslash allows second to be registered as escape sequence
      final int numberFive= 5 ;
      // final means it cant be changed


      System.out.println("Good \n Game");
      /*
       *  this will yield :
       *  Good
       * Game
       */

    }





}

// constructor wtihout parameters 

 class Tree {
  // Creating a default constructor
  public Tree() {
    System.out.println("Tree is created");
  }

  public  void treegen(String args[]) {
    Tree t = new Tree();  // Calling a default constructor
  }
}

// Output: Tree is created
