package sourcePackage1;

public class Paper {

    private String note;
    private boolean isErasable = true;

    public String getContent() {
        return this.note;
    }

    public void write(String note) {
        this.note += note;
    }

    public void write(String note, boolean isInkErasable) {
        this.note += note;
        if (!isInkErasable) {
            this.isErasable = false;
        }
    }

    public boolean erase() {
        if (isErasable) {
            this.note = "";
            return true;
        } else {
            return false;
        }

    }

}
