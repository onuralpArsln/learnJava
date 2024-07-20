package sourcePackage1;

public class Paper {

    private String note = "";
    private boolean isErasable = true;

    // getter method
    public String getContent() {

        return this.note;
    }

    public void write(String note) {
        this.note += note;
    }

    void write(String note, boolean isInkErasable) {
        this.note += note;
        if (!isInkErasable) {
            this.isErasable = false;
        }
    }

    public boolean eraseContent() {
        if (isErasable) {
            this.note = "";
            return true;
        } else {
            return false;
        }

    }

}
