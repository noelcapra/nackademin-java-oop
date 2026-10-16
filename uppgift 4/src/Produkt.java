// en produkt i kassan, har namn och pris
public class Produkt {
    private String name;
    private double price;

    public Produkt(String name, double price){
        this.name = name;
        this.price = price;
    }

    // getters så man kan hämta namn o pris från andra klasser
    public String getName(){

        return name;
    }
    public double getPrice(){

        return price;
    }
}
