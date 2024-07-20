package sourcePackage1;

public class Printer {

    public Flyer printFlyer(String note) {
        Flyer fly = new Flyer(note);
        return fly;
    }

    public Paper printPaper(String note, Paper paper) {
        paper.write(note, false);
        return paper;

    }

}
