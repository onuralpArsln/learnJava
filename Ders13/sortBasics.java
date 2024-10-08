public class sortBasics {

	public static void main(String[] args) {
		int[] arr = { 30, 4 };
		int[] arr3 = { 5, 7 };
		// bunu nasıl sıralarsın?
		// sortTwo(arr);
		// sortTwo(arr3);
		// sıralma mantığı 3 elemanla nasıl olmalı?
		int[] arr2 = { 0, 1, 2, 3, 4, 5 };
		int[] arr22 = { 2310, 231, 4312, 323, 234, 52 };
		sortMore(arr22);
	}

	public static void sortTwo(int[] arr) {
		if (arr[0] > arr[1]) {
			int temp = arr[0];
			arr[0] = arr[1];
			arr[1] = temp;
		}
		System.out.println(arr[0]);
		System.out.println(arr[1]);
	}

	public static int[] compareMore(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {

				System.out.println(" " + arr[i] + "vs" + arr[j]);

			}

			System.out.println("---------");
		}

		return arr;
	}

	public static int[] sortMore(int[] arr) {
		int temp;

		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

		return arr;
	}

}
