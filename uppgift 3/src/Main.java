public class Main {
    static void main() {

        Person person1 = new Person("2005-12-25");
        Person person2 = new Person("2004-02-19");

        person1.setNamn("Noel");
        person2.setNamn("Elise");

        person1.setGatuadress("Östermalmsgatan 90");
        person1.setPostnummer("11459");
        person1.setPostort("Stockholm");

        person2.setGatuadress("Blomenhovsvägen 12");
        person2.setPostnummer("12345");
        person2.setPostort("Nyköping");

        System.out.println(person1.getNamn() + " bor på:");
        System.out.println(person1.getGatuadress());
        System.out.println(person1.getPostnummer() + " " + person1.getPostort());

        System.out.println();

        System.out.println(person2.getNamn() + " bor på:");
        System.out.println(person2.getGatuadress());
        System.out.println(person2.getPostnummer() + " " + person2.getPostort());

        person2.setGatuadress(person1.getGatuadress());
        person2.setPostnummer(person1.getPostnummer());
        person2.setPostort(person1.getPostort());

        System.out.println();

        System.out.println("Men nu flyttar " + person2.getNamn() + " hem till " + person1.getNamn() + "!!");

        System.out.println(person2.getNamn() + " bor nu på:");
        System.out.println(person2.getGatuadress());
        System.out.println(person2.getPostnummer() + person2.getPostort());

    }
}
