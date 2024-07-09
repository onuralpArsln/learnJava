package people;

public class HumanPatient extends HumanBase {

    String semptoms;

    public HumanPatient(String name, int age, String semptomps) {
        super(name, age);
        this.semptoms = semptomps;

    }

}
