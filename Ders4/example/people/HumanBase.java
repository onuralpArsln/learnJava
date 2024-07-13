package people;

public class HumanBase {

	public final String name;
	final int age;
	public String diagnosis;

	public HumanBase(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public int AgeGetter() {
		return this.age;
	}
}
