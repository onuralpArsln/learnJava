import devices.*;
import people.*;

public class main {
	public static void main(String[] args) {
		HumanBase testHuman = new HumanBase("test", 21);
		HumanPatient testPatient = new HumanPatient("patient", 31, "headache");

		Xray testDevice = new Xray();
		testDevice.imagine(testHuman);
		System.out.println(testHuman.diagnosis);

		testDevice.imagine(testPatient);
		System.out.println(testPatient.diagnosis);
	}

}
