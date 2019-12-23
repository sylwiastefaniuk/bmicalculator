package pl.kodu.akademia.model;

public enum Sex {
    Mężczyzna ("Men"),
    Kobieta ("Woman");

    String value;
    Sex(String value) {
        this.value = value;
    }
}
