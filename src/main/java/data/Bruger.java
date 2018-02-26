package data;

public class Bruger {
    private String brugernavnet;

    public Bruger() {
    }

    public Bruger(String brugernavnet, String name) {
        this.brugernavnet = brugernavnet;
    }

    public String getBrugernavnet() {
        return brugernavnet;
    }

    public void setBrugernavnet(String brugernavnet) {
        this.brugernavnet = brugernavnet;
    }

}
