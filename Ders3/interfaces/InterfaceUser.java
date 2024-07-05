import Ders3.extendExample.Teacher;

public class InterfaceUser {
    public static void main(String[] args) {
        Teacher mahmut = new Teacher();
        mahmut.assignHomework();
    }
}

// Interface tanımları
interface Teaching {
    void teachTopic();

    void assignHomework();
}

interface Authority {
    void slinceClass();
}

class Teacher implements Teaching {
    public Teacher() {
        System.out.println("öğretmeye hazırım");
    }

    @Override
    public void teachTopic() {
        System.out.println("calculus türev falan ");
    }

    @Override
    public void assignHomework() {
        System.out.println(" 4 milyon soru çözün");

    }
}