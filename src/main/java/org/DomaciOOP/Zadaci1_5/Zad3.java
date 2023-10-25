package org.DomaciOOP.Zadaci1_5;
abstract class Nastavnik{
    String ime;
    String prezime;
    String predmet;
    public Nastavnik(String ime, String prezime, String predmet){
        this.ime = ime;
        this.prezime = prezime;
        this.predmet = predmet;
    }
    abstract void predstaviSe();
}
class Asistent extends Nastavnik{
    int godine;
    public Asistent(String ime, String prezime, String predmet, int godine){
        super(ime,prezime,predmet);
        this.godine = godine;
    }
    @Override
    void predstaviSe(){
        System.out.println("Zanimanje: Asistent" +
                            "\nIme: " + ime +
                            "\nPrezime: " + prezime +
                            "\nPredmet: " + predmet +
                            "\nGodine: " + godine +"\n");
    }
}
class ElProfesor extends Nastavnik{
    int radniStaz;
    public ElProfesor(String ime, String prezime, String predmet, int radniStaz){
        super(ime,prezime,predmet);
        this.radniStaz = radniStaz;
    }
    @Override
    void predstaviSe() {
        System.out.println("Zanimanje: Profesor" +
                            "\nIme: " + ime +
                            "\nPrezime: " + prezime +
                            "\nPredmet: " + predmet +
                            "\nRadni staz: " + radniStaz +"\n");
    }
}
public class Zad3 {
    public static void main(String[] args) {
        Asistent asistent1 = new Asistent("Radoje", "Radic", "Mehanika", 30);
        Asistent asistent2 = new Asistent("Stanoje", "Stanic", "Fundiranje", 29);
        Asistent asistent3 = new Asistent("Miloje", "Milic", "Materijali", 32);
        ElProfesor profesor1 = new ElProfesor("Dragoje", "Dragic", "Mehanika", 22);
        ElProfesor profesor2 = new ElProfesor("Vukoje", "Vukic", "Fundiranje", 40);

        asistent1.predstaviSe();
        asistent2.predstaviSe();
        asistent3.predstaviSe();
        profesor1.predstaviSe();
        profesor2.predstaviSe();

    }
}
