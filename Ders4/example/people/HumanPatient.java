package people;

public class HumanPatient extends HumanBase {

    String symptoms;

    public HumanPatient(String name, int age, String symptoms) {
        super(name, age);
        this.symptoms = symptoms;

    }

}
