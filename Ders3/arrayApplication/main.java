
public class main {

    public static void main(String[] args) {
        // java arrayı belirlendikten sonra boyutu değişmezz
        String[] listing = { "Bu", "Bir", "String", "Arrayı" };

        // listeyi yazdırmak pythondaki gibi direkt olmaz
        System.out.println(listing);

        // bir döngü ile dönmen lazım
        for (String string : listing) {
            System.out.println(string);
        }

        // bir indis değerini değiştirmek mümkün
        listing[0] = "değiştim";
        System.out.println(listing[0]);

    }

}
