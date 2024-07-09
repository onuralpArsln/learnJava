import devices.*;
import people.*;

public class main {
	public static void main(String[] args) {
		HumanBase testHuman = new HumanBase("test", 21);
		Xray testDevice = new Xray();
		testDevice.imagine(testHuman);
		System.out.println(testHuman.diagnosis);
	}

}
