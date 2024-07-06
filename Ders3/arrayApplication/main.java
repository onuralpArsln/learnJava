
public class main {

    public static void main(String[] args) {
        // java arrayı belirlendikten sonra boyutu değişmezz
        String[] listing = { "Bu", "Bir", "String", "Arrayı" };

        // listeyi yazdırmak pythondaki gibi direkt olmaz
        System.out.println(listing);

        System.out.println("foreach: ");
        // bir döngü ile dönmen lazım
        for (String element : listing) {
            System.out.println(element);
        }

        // bir indis değerini değiştirmek mümkün
        listing[0] = "değiştim";
        System.out.println("listing[0]");
        System.out.println(listing[0]);
        System.out.println("listing[0]");

        System.out.println("for loop : ");
        for (int i = 0; i < listing.length; i++) {
            System.out.println(listing[i]);
        }

        String[] anotherlist = listing;
        System.out.println("referanslar");
        System.out.println(anotherlist);
        System.out.println(listing);

        anotherlist[0] = "referanstan değiştim";
        System.out.println("listing[0]");
        System.out.println(listing[0]);

        System.out.println("listing[0]");

        String[] onemorelist;
        onemorelist = listing;
        onemorelist[0] = "it is one more ";
        System.out.println("listing[0]");
        System.out.println(listing[0]);

    }

}
