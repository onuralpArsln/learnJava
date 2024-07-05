
public class Inherit {

    public static void main(String[] args) {

        Teacher mahmut = new Teacher("mahmut", "california ilkokulu");
        System.out.println(mahmut.represent());
        HsTeacher mehmet = new HsTeacher("mehmet", "florida fen lisesi", "fizik");
        System.out.println(mehmet.represent());

    }

}

class Teacher {
    String name;
    String currentSchool;

    public Teacher(String name, String school) {
        this.name = name;
        this.currentSchool = school;
    }

    public String represent() {
        return "My names is " + this.name + " and i am a teacher at " + this.currentSchool;
    }
}

class HsTeacher extends Teacher {

    String topic;

    public HsTeacher(String name, String school, String topic) {
        super(name, school);
        this.topic = topic;
    }

    @Override
    public String represent() {
        return "My names is " + this.name + " and i am a " + this.topic + " teacher at " + this.currentSchool;
    }
}