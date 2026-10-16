import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// klassen för kvittot, sparar all text och totalen
public class Kvitto {
    String text = "";
    double total = 0;
    int kvittoNr = 0;

    // lägger till en rad på kvittot
    public void addRow(Produkt p, int antal){
        // om kvittot är tomt så är det första varan, då skrivs toppen ut först
        if(text.equals("")){
            kvittoNr++;
            String datum = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            text += "         STEFANS SUPERSHOP\n";
            text += "----------------------------------------\n";
            text += "Kvittonummer: " + kvittoNr + "  Datum: " + datum + "\n";
            text += "----------------------------------------\n";
        }

        double summa = p.getPrice() * antal; // pris gånger antal
        total = total + summa;
        text += p.getName() + "   " + antal + " * " + p.getPrice() + " = " + summa + "\n";
    }

    // skriver ut totalen o tack för köpet
    public void pay(){
        text += "----------------------------------------\n";
        text += "Total: " + total + "\n";
        text += "TACK FÖR DITT KÖP!\n";
    }

    // tömmer kvittot till nästa kund, kvittoNr ska inte nollställas
    public void clear(){
        text = "";
        total = 0;
    }

    public String getText(){
        return text;
    }

    public double getTotal(){
        return total;
    }
}
