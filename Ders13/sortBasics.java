public class sortBasics {

	public static void main(String[] args) {
		int[] arr = { 30, 4 };
		// bunu nasıl sıralarsın?
		sortTwo(arr);
		// sıralma mantığı 3 elemanla nasıl olmalı?
		int[] arr2 = { 30, 4, 23 };
	}

	public static int[] sortTwo(int[] arr) {
		int[] temparr = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

		return temparr;
	}

}
