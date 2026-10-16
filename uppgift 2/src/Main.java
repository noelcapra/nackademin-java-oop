public class Main {
    static void main() {

        Student student = new Student(
                "Noel",
                "Capra",
                "Nackademin",
                20

        );

        System.out.println("Förnamn " + student.getFornamn());
        System.out.println("Efternamn " + student.getEfternamn());
        System.out.println("Skola " + student.getSkola());
        System.out.println("Ålder " + student.getAlder());
    }
}
