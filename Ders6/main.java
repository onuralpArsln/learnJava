
public class main {
    public static void main(String[] args) {

        Tas tas1 = new Tas("pilav");
        Tas tas2 = new Tas("salata");
        Tas tas3 = new Tas("et");
        Tas tas4 = new Tas("puding");

        SeferTasi sefer = new SeferTasi();

        SeferTasi.name();

        sefer.append(tas1);
        // System.out.println(sefer.firstTas.yemek);
        sefer.append(tas2);
        // System.out.println(sefer.firstTas.nextTas.yemek);
        sefer.append(tas3);
        sefer.append(tas4);
        System.out.println(sefer.indexTas(8).yemek);

        // tastan bir class extend aldım

        newTas tas5 = new newTas("kebap");

        sefer.append(tas5);
        System.out.println(sefer.indexTas(4).yemek);

    }

}

class SeferTasi {
    Tas firstTas = null;
    int tasSayisi = 0;

    public void append(Tas tas) {
        if (this.firstTas == null) {
            this.firstTas = tas;
        } else {
            Tas temp = this.firstTas;
            while (temp.nextTas != null) {
                temp = temp.nextTas;
            }
            temp.nextTas = tas;
        }
        this.tasSayisi += 1;
    }

    public Tas indexTas(int index) {

        if (this.tasSayisi > index) {
            Tas temp = this.firstTas;
            for (int i = 0; i < index; i++) {
                temp = temp.nextTas;
            }
            return temp;
        } else {
            System.out.println("index out of reach");
            return this.firstTas;
        }

    }

    public static void name() {
        System.out.println("Stanley Sefer Tası");
    }

}

class Tas {
    String yemek;
    Tas nextTas = null;

    public Tas(String temp) {
        this.yemek = temp;
    }
}

// tastan extendlenen bir class
class newTas extends Tas {
    int val;

    public newTas(String temp) {
        super(temp);
    }

}