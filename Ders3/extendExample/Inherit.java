
public class Inherit {

    public static void main(String[] args) {

        TeacherBase mahmut = new TeacherBase("mahmut", "california ilkokulu");
        System.out.println(mahmut.represent());
        HsTeacher mehmet = new HsTeacher("mehmet", "florida fen lisesi", "fizik");
        System.out.println(mehmet.represent());
        mehmet.tellAge();
        mehmet.tellAge(360);

    }

}

class TeacherBase {
    String name;
    String currentSchool;

    public TeacherBase(String name, String school) {
        this.name = name;
        this.currentSchool = school;
    }

    public String represent() {
        return "My names is " + this.name + " and i am a teacher at " + this.currentSchool;
    }

    public void tellAge() {
        System.out.println("480 aylığım");
    }

    public void tellAge(int age) {
        System.out.println(age + " aylığım");
    }
}

class HsTeacher extends TeacherBase {

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