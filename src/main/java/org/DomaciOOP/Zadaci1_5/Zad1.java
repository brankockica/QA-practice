package org.DomaciOOP.Zadaci1_5;


import java.util.Arrays;

class Osoba {
    String ime;
    String prezime;
    int godine;
    public Osoba (String ime, String prezime, int godine){
        this.ime        = ime;
        this.prezime    = prezime;
        this.godine     = godine;
    }
}
class Student extends Osoba{
    String index;
    public Student(String ime, String prezime, int godine, String index){
        super(ime, prezime, godine);
        this.index = index;
    }
    @Override
    public String toString(){           //Hvala Silvija
        return "Student: " + ime + " " + prezime + " " + "Godine: " + godine + " " + "Broj indexa: " + index;
    }
}
class Profesor extends Osoba{
    String predmet;
    public Profesor(String ime, String prezime, int godine, String predmet) {
        super(ime, prezime, godine);
        this.predmet = predmet;
    }
    @Override
    public String toString(){           //Hvala Silvija
        return "Profesor: " + ime + " " + prezime + " " + "Godine: " + godine + " " + "Predmet: " + predmet;
    }
}
public class Zad1{
    public static void main(String[] args) {
        Osoba[] osobe = {                                                               //Hvala Silvija
                        new Student("Petar","Peric",22,"RA1669"),
                        new Student("Zivorad","Zikic",21, "FA801"),
                        new Student("Mitar", "Miric", 22, "RA1711"),
                        new Profesor("Miodrag", "Radic", 52, "Statika"),
                        new Profesor("Bratislav", "Loptica", 58, "Dinamika")
            };

        for (int i = 0; i < osobe.length; i++){     //Hvala Silvija
            System.out.println(osobe[i]);
        }

        /*Student pera    = new Student("Petar","Peric",22,"RA1669");
        Student zika    = new Student("Zivorad","Zikic",21, "FA801");
        Student mika    = new Student("Mitar", "Miric", 22, "RA1711");
        Profesor popa   = new Profesor("Miodrag", "Radic", 52, "Statika");
        Profesor braca  = new Profesor("Bratislav", "Loptica", 58, "Dinamika");

        String [] student1 = {pera.ime, pera.prezime, String.valueOf(pera.godine), pera.index};
        String [] student2 = {zika.ime, zika.prezime, String.valueOf(zika.godine), zika.index};
        String [] student3 = {mika.ime, mika.prezime, String.valueOf(mika.godine), mika.index};

        String [] profesor1 = {popa.ime, popa.prezime, String.valueOf(popa.godine), popa.predmet};
        String [] profesor2 = {braca.ime, braca.prezime, String.valueOf(braca.godine), braca.predmet};


        System.out.println("Student: " + Arrays.toString(student1));
        System.out.println("Student: " + Arrays.toString(student2));
        System.out.println("Student: " + Arrays.toString(student3));
        System.out.println("Profesor: " + Arrays.toString(profesor1));
        System.out.println("Profesor: " + Arrays.toString(profesor2));*/

        //System.out.println("Student: " + pera.ime + " " +pera.prezime+ "\n Starost: " +pera.godine + "\n Index: " +pera.index);
        //System.out.println("Profesor: " + braca.ime + " " +braca.prezime+ "\n Starost: " +braca.godine + "\n Predmet: " +braca.predmet);

    }
}