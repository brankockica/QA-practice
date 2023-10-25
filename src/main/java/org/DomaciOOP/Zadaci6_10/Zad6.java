package org.DomaciOOP.Zadaci6_10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

abstract class Kupi{
    abstract void dodajProizvod(Proizvod proizvod);     //sta ce nam ovo
    abstract double totalCena();
    abstract void stanjeKorpe();
}
class Proizvod {
    private String naziv;
    private double cena;
    private int kolicina;
    private double popust;
    public Proizvod(String naziv, double cena, double popust, int kolicina){
        this.naziv = naziv;
        this.cena = cena;
        this.popust = popust;
        this.kolicina = kolicina;
    }
    public Proizvod(String naziv, int kolicina){        //Da li nam trebao overload za kolicinu?
        this.naziv = naziv;
        this.kolicina = kolicina;
    }
    public String getNaziv() {  //geter
        return naziv;
    }
    public double getCena() {   //geter
        return cena;
    }
    public int getKolicina() {  //geter
        return kolicina;
    }
    public double getPopust() {  //geter
        return popust;
    }
    public void setPopust(double noviPopust){   //seter
        this.popust = noviPopust;
    }
    public void setNaziv(String noviNaziv) {    //seter
        this.naziv = noviNaziv;
    }
    public void setCena(double novaCena) {      //seter
        this.cena = novaCena;
    }
    public void setKolicina(int novaKolicina) { //seter
        this.kolicina = novaKolicina;
    }
    @Override
    public String toString() {
        return naziv + " " + cena + "rsd, " + "Popust od "+ popust+"%" +" - x" + kolicina;
    }
}
class Korpa extends Kupi {
    private static final int MAXproizvodi = 70;
    private Proizvod [] artikli = new Proizvod[MAXproizvodi];
    private int brojArtikla = 0;

    @Override
    void dodajProizvod(Proizvod proizvod){
        if (brojArtikla < MAXproizvodi){
            artikli[brojArtikla]= proizvod;
            brojArtikla ++;
        }else System.out.println("Korpa je puna");
    }
    @Override
    double totalCena(){
        double total = 0;
        for (int i=0; i <brojArtikla; i++) {
            double snizeno = artikli[i].getCena() - (artikli[i].getCena()*(artikli[i].getPopust() / 100));
            total += snizeno * artikli[i].getKolicina();
        }return total;
    }
    @Override
    void stanjeKorpe(){
        System.out.println("Korpa: \n");
        for (int i= 0; i < brojArtikla; i++){
            System.out.println(artikli[i]);
        }
        System.out.println("Ukupno: " + totalCena() + " dinara");
    }


}
public class Zad6 {
    public static void main(String[] args) {
        Korpa korpa = new Korpa ();
        Proizvod [] proizvod = {
                new Proizvod("Krastavac", 50,11.50, 10),
                new Proizvod("Paradajz", 180,0, 8),
                new Proizvod("Krompir", 100,0, 30),
                new Proizvod("Paprike", 50,9, 10),
        };
        korpa.dodajProizvod(proizvod[0]);           //Kako bre da izaberemo uz proizvod i kolicinu!!!!
        korpa.dodajProizvod(proizvod[1]);
        korpa.dodajProizvod(proizvod[2]);
        korpa.stanjeKorpe();

    }
}
