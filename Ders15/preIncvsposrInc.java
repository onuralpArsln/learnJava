public class preIncvsposrInc {

    public static void main(String[] args) {
        int[] myArr = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        int target = 1;

        myArr[target++] = 1000;

        System.out.println("first target is " + target);

        int target2 = 4;

        myArr[++target2] = 5000;

        System.out.println("second target is " + target2);

        for (int element : myArr) {
            System.out.println(element);
        }

        System.out.println("Post-increment");
        for (int i = 0; i < 5; i++) { // Post-increment
            System.out.println("i = " + i);
        }

        System.out.println("pre-increment");

        for (int i = 0; i < 5; ++i) { // pre-increment
            System.out.println("i = " + i);
        }

        int[] mySecondArr = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int returner = 3;

        System.out.println("post decrement");

        for (int i = 0; i < 3; i++) {
            System.out.println(mySecondArr[returner--]);

        }

        System.out.println("pre decrement");

        returner = 3;

        for (int i = 0; i < 3; i++) {
            System.out.println(mySecondArr[--returner]);

        }

    }

}

/*
 * 
 * post increment x++
 * x arttırılmadan önce bir kopyası oluşur
 * bu hafıza kaplar geçici değişken performansı
 * azaltır
 * 
 * 
 * pre increment ++x
 * kopya oluşmaz hafıza kaplamaz
 * 
 * ama performans farklı gözden çıkarılabilir
 * 
 */
