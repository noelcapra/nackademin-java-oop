import java.util.ArrayList;

public class Main{
    static void main() {
        ArrayList<matratter>meny = new ArrayList<>();

        matratter ratt1 = new matratter("Ramen", 129, "Kött", 1250);
        matratter ratt2 = new matratter("hamburgare", 15, "kött", 450);
        matratter ratt3 = new matratter("palak paneer", 179, "vegansk", 650);

        meny.add(ratt1);
        meny.add(ratt2);
        meny.add(ratt3);

        System.out.println("Dagens Lunchmemy");
        System.out.println("-----------------");

        for (matratter matratt : meny) {
            System.out.println(matratt.namn);
            System.out.println(matratt.pris + " kr");
            System.out.println(matratt.typ);
            System.out.println(matratt.kalorier + " kalorier");
        }
    }
}
