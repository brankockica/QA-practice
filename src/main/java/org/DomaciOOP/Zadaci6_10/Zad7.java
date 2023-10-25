package org.DomaciOOP.Zadaci6_10;

import java.sql.SQLOutput;
import java.text.DecimalFormat;

class Oblik{
    double stranicaB;
    double stranicaA;
    double poluprecnik;
    double stranicaC;

    public Oblik (double stranicaA, double stranicaB,double stranicaC){
        this.stranicaA = stranicaA;
        this.stranicaB = stranicaB;
        this.stranicaC = stranicaC;
    }
    public Oblik (double stranicaA, double stranicaB){
        this.stranicaA = stranicaA;
        this.stranicaB = stranicaB;
    }
    public Oblik (double poluprecnik){
        this.poluprecnik = poluprecnik;
    }
    double obim(){
        return 0;
    }
    double povrsina(){
        return 0;
    }
    public double decimala = Math.pow(10, 4);
    static double najveciObim(Oblik... oblici) {   //Varargs mindblow. Mozemo da ubacimo bilo koji broj argumenta, u mom slucaju array instanci Oblik-a
        double najveci = 0;
        for (Oblik oblik : oblici) {        //Za svaki oblik(tj. element arraya ili instanca?) u klasi Oblik, uzimajuci array oblici
            double obim = oblik.obim();
            if (obim > najveci) {
                najveci = obim;             //recursion?
            }
        }return najveci;
    }
}
class Pravougaonik extends Oblik{
    public Pravougaonik (double stranicaA, double stranicaB){
        super(stranicaB,stranicaB);
    }
    @Override
    double obim(){
        return 2*(stranicaA + stranicaB);
    }
    @Override
    double povrsina(){
        return stranicaA * stranicaB;
    }
    @Override
    public String toString(){
        return "Obim pravougaonika je:" + Math.round(obim() * decimala) / decimala +
                "\nPovrsina pravougaonika je:" + Math.round(povrsina() * decimala) / decimala;
    }
}
class Krug extends Oblik{
    public Krug(double poluprecnik){
        super(poluprecnik);
    }

    @Override
    double obim(){
        return 2*poluprecnik*Math.PI;
    }
    @Override
    double povrsina(){
        return Math.pow(poluprecnik, 2)*Math.PI;
    }
    @Override
    public String toString(){
        return "Obim kruga je: " + Math.round(obim() * decimala) / decimala + "\nPovrsina kruga je: " +
                Math.round(povrsina() * decimala) / decimala;
    }
}
class Trougao extends Oblik{
    public Trougao(double stranicaA, double stranicaB,double stranicaC){
        super(stranicaA,stranicaB,stranicaC);
    }
    @Override
    double obim(){
        return stranicaA+stranicaB+stranicaC;
    }
    @Override
    double povrsina(){
        double s = obim() / 2;
        return  Math.sqrt(s *(s - stranicaA)*(s - stranicaB)*(s - stranicaC));
    }
    @Override
    public String toString(){
        return "Obim trougla je:" + Math.round(obim() * decimala) / decimala +
                "\nPovrsina trougla je:" + Math.round(povrsina() * decimala) / decimala;
    }
}
public class Zad7 {
    public static void main(String[] args) {
        Oblik [] oblici = {
                new Pravougaonik(13.5,8.2),
                new Krug(8.3),
                new Trougao(8.3, 9.6,12.9)
        };

        double najveci = Oblik.najveciObim(oblici);     //zato sto je metoda static, pozivamo je na celu klasu?

        for (Oblik oblik : oblici) {
            System.out.println(oblik);
        }
        //System.out.println(oblici[0]);
        //System.out.println(oblici[1]);
        //System.out.println(oblici[2]);
        System.out.println("Najveci obim je: " + Math.round(najveci * 10000.0) / 10000.0);      //decimala varijabla ne moze da se pozove ovde, zasto?

    }

}
