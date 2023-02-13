public class Reader {
    private String name;
    private String address;
    private String IGN;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIGN() {
        return IGN;
    }

    public void setIGN(String IGN) {
        this.IGN = IGN;
    }

    public Reader() {}

    public Reader(String name, String address, String IGN) {
        this.name = name;
        this.address = address;
        this.IGN = IGN;
    }

    public void print() {
        System.out.println(name + ": " + IGN + " " + address);
    }
}
