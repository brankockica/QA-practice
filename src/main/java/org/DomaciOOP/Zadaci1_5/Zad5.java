package org.DomaciOOP.Zadaci1_5;
class Kalkulator {

    public Kalkulator(){
        //prazno?
    }
    public double sabiranje(double broj1, double broj2){
        return broj1 + broj2;
    }
    public double oduzimanje(double broj1, double broj2){
        return broj1 - broj2;
    }
    public double mnozenje(double broj1, double broj2){
        return broj1 * broj2;
    }
    public double deljenje(double broj1, double broj2){
        return broj1 / broj2;
    }
    public double izracunaj (String operacija, double broj1, double broj2){
        if (operacija.equals("+")){
            return sabiranje(broj1, broj2);
        } else if (operacija.equals("-")){
            return oduzimanje(broj1, broj2);
        } else if (operacija.equals("*")){
            return mnozenje(broj1, broj2);
        } else if (operacija.equals("/")){
            return deljenje(broj1, broj2);
        }else return 0;

    }
}
public class Zad5 {

    public static void main(String[] args) {

        Kalkulator rezultat = new Kalkulator();

        double sabiranje = rezultat.sabiranje(10.5, 5.2);
        System.out.println("Rezultat sabiranja: " + sabiranje);
        double oduzimanje = rezultat.oduzimanje(10.5, 5.2);
        System.out.println("Rezultat oduzimanja: " + oduzimanje);
        double mnozenje = rezultat.mnozenje(80.5, -2.2);
        System.out.println("Rezultat mnozenja: " + mnozenje);
        double deljenje = rezultat.deljenje(-100.5, -5.2);
        System.out.println("Rezultat deljenja: " + deljenje);

        String plus      = "+";
        String minus     = "-";
        String puta      = "*";
        String podeljeno = "/";

        double operacija1 = rezultat.izracunaj(plus, 50, 30);
        System.out.println("Rezultat operacije: " + operacija1);
        double operacija2 = rezultat.izracunaj(podeljeno, 50, 30);
        System.out.println("Rezultat operacije: " + operacija2);
        double operacija3 = rezultat.izracunaj(minus, 50, 30);
        System.out.println("Rezultat operacije: " + operacija3);
        double operacija4 = rezultat.izracunaj(puta, 50, 30);
        System.out.println("Rezultat operacije: " + operacija4);

    }
}
