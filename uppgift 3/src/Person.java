public class Person {

    private String fodelsedatum;
    private String namn;
    private String gatuadress;
    private String postnummer;
    private String postort;

    public Person(String fodelsedatum) {
        this.fodelsedatum = fodelsedatum;
    }

    public String getFodelsedatum() {
        return fodelsedatum;
    }

    public String getNamn() {
        return namn;
    }

    public void setNamn(String namn) {
        this.namn = namn;
    }

    public String getGatuadress() {
        return gatuadress;
    }

    public void setGatuadress(String gatuadress) {
        this.gatuadress = gatuadress;
    }

    public String getPostnummer() {
        return postnummer;
    }

    public void setPostnummer(String postnummer) {
        this.postnummer = postnummer;
    }

    public String getPostort() {
        return postort;
    }

    public void setPostort(String postort) {
        this.postort = postort;
    }
}