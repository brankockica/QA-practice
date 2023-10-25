package org.DomaciOOP.Zadaci1_5;
class BankovniRacun {
    private double stanjeNaRacunu;
    private String vlasnik;
    public BankovniRacun (double stanjeNaRacunu, String vlasnik) {
        this.stanjeNaRacunu = stanjeNaRacunu;
        this.vlasnik = vlasnik;
    }
    public double getStanjeNaracunu(){          //geter
        return stanjeNaRacunu;
        }
    public String getVlasnik(){                 //geter
        return vlasnik;
    }
    public void setStanjeNaracunu(double novoStanjeNaRacunu){            //seter
        stanjeNaRacunu = novoStanjeNaRacunu;
    }
    public void setVlasnik(String noviVlasnik){                   //seter
        vlasnik = noviVlasnik;
    }
    public void uplatiNovac(double iznos){
        if (iznos < 0){
            System.out.println("Uneli ste nedozvoljenu sumu");
        }else {
            setStanjeNaracunu(getStanjeNaracunu() + iznos);
            System.out.println("Uspesno ste uplatili: " + iznos);
            System.out.println("Na stanju trenutno imate: " + getStanjeNaracunu());
        }
    }
    public void podigniNovac(double iznos){
        if (iznos < 0){
            System.out.println("Uneli ste nedozvoljenu sumu");
        }
        else if (getStanjeNaracunu() < iznos){
            System.out.println("Nemate dovoljno sredstava na racunu");
            System.out.println("Na stanju trenutno imate: " + getStanjeNaracunu());
        }else {
            setStanjeNaracunu(getStanjeNaracunu() - iznos);
            System.out.println("Uspesno ste podigli: " + iznos);
            System.out.println("Na stanju trenutno imate: " + getStanjeNaracunu());
        }
    }
    public void prikazikorisnika(){
        System.out.println("\nVlasnik: " + vlasnik + "\nStanje na rucunu: " + stanjeNaRacunu);
    }

}
public class Zad2 {
    public static void main(String[] args) {
        BankovniRacun korisnik1 = new BankovniRacun(300.50,"Pera");
        BankovniRacun korisnik2 = new BankovniRacun(44.8,"Zika");
        BankovniRacun korisnik3 = new BankovniRacun(100.22,"Mika");

        korisnik1.prikazikorisnika();
        korisnik1.podigniNovac(100.35);
        korisnik1.podigniNovac(50.35);
        korisnik1.uplatiNovac(1013.80);

        korisnik2.prikazikorisnika();
        korisnik2.podigniNovac(50);
        korisnik2.podigniNovac(44.81);
        korisnik2.uplatiNovac(500.80);

        korisnik3.prikazikorisnika();
        korisnik3.podigniNovac(-30);
        korisnik3.podigniNovac(-0.000000000000000000000009);
        korisnik3.uplatiNovac(535.80);
    }
}
