package sourcePackage1;

public class Flyer {

    final public String note;

    // sadece aynı pakettekiler ulaşır
    protected Flyer(String note) {
        this.note = note;
    }
}
