public class newClass {

    // as you can see i can reach learn class from other file with out any incllude since we have in the same dirs
    public static void main(String[] args){
        learn classes = new learn("other class", 01);
        System.out.println(classes.learningSource);
        // since this is a static meyhod i can call it from other file without requiring and object
        learn.callAway();
        // advertise is not a static method uses information from object that is called on so i need an object to o call it
        classes.advertise();

    }
}
