
public class Combo {

}

class Child extends Parent implements IParent {

    public Child(String name) {
        super(name);
    }

    @Override
    public void getAddress() {
        System.out.print(" Child class overrides the Parent class getAddress()");
    }

    @Override
    public void getMobileNumber() {
        System.out.print(" Child class overrides the Parent class getMobileNumber()");
    }

    @Override
    public void getAge() {
        // To change body of implemented methods use File | Settings | File Templates.
    }
}

interface IParent {

    static String surname = "Doe";

    void getName();

    void getAddress();

    void getMobileNumber();
}

abstract class Parent {

    String name;

    public abstract void getAge();

    public Parent(String name) {
        this.name = name;
    }

    public void getName() {
        System.out.print("the parent name " + this.name);
    }
}