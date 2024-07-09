
public class InterfaceUser {
    public static void main(String[] args) {
        Teacher mahmut = new Teacher();
        mahmut.assignHomework();
    }
}

// Interface tanımları
interface ITeaching {
    void teachTopic();

    void assignHomework();
}

interface IAuthority {
    void silenceClass();
}

class Teacher implements ITeaching, IAuthority {
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

    @Override
    public void silenceClass() {
        System.out.println("sınıf sus");
    }
}