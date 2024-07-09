import devices.*;
import people.*;

public class main {
	public static void main(String[] args) {
		HumanBase testHuman = new HumanBase("test", 21);
		HumanPatient testPatient = new HumanPatient("patient", 31, "headache");

		// liskov subs
		// objects of a superclass should be replaceable
		// with objects of its subclasses
		// without affecting the correctness of the program.

		// human base ve human patient methodla düzgn çalışmalı

		Xray testDevice = new Xray();
		testDevice.imagine(testHuman);
		System.out.println(testHuman.diagnosis);

		testDevice.imagine(testPatient);
		System.out.println(testPatient.diagnosis);
	}

}
