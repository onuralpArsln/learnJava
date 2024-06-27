public class HelloWorld {

	public static void main(String[] args) {
		System.out.println("Hello World");
		System.out.println(args.length);

		if (args.length > 3) {
			for (String elaman : args) {
				System.out.println(elaman);

			}
		} else if (args.length == 3) {
			System.out.println(args[1]);

		} else {
			System.out.println("bana biraz arg ver");
		}

		for (int i = 0; i < 15; i = i + 3) {
			System.out.println(i);
		}
	}

}
