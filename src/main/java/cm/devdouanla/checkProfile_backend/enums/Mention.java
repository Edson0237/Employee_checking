package cm.devdouanla.checkProfile_backend.enums;

public enum Mention {
    EXCELLENT(90, "EXCELLENT"),
    BIEN(75, "BIEN"),
    PASSABLE(60, "PASSABLE"),
    INSUFFISANT(0, "INSUFFISANT");

    private final int seuil;
    private final String label;

    Mention(int seuil, String label) {
        this.seuil = seuil;
        this.label = label;
    }

    public int getSeuil() {
        return seuil;
    }

    public String getLabel() {
        return label;
    }
}
