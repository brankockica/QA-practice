package org.example;

public class Zadaci {

    public static void main(String[] args) {

        /*System.out.println("Zadatak 1");
        int [] niz1 = {1, 2, 3, 4, 5, 13, 23, 55, 17, 22, 8};
        int trazeniBroj = 6;
        int j= 0;

        for (int i= 0; i < niz1.length; i++) {
            if (trazeniBroj == niz1[i]){
                System.out.println("Trazeni broj je pronadjen u nizu, i njegov index je " + i);
            }else
                j++;
        }
        if (j == niz1.length){
            System.out.println("Trazni broj nije pronadjen u nizu");
            System.out.println("_________________________________");
        }*/                                                         //Zbunio si me Veljo, ne moze ovako ja mislim :D

        System.out.println("Zadatak 1");
        int [] niz1 = {1, 2, 3, 4, 5, 13, 23, 55, 17, 22, 8};
        int trazeniBroj = 22;

        for (int i= 0; i < niz1.length; i++) {
            if (trazeniBroj == niz1[i]){
                System.out.println("Trazeni broj je pronadjen u nizu, i njegov index je " + i);
                break;
            }else if (trazeniBroj != niz1[i] && i == niz1.length-1) {
                System.out.println("Trazni broj nije pronadjen u nizu");
            }
        }


        System.out.println("\n" + "Zadatak 2" + "\n");
        int [] niz2= {1,2,3,4,5,6,7,8};
        int [] niz3= {6,5,4,3,2,1};
        int [] niz4= {2,1,4,7,31,32,30};

        /*for (int i = 0; i < niz2.length-1; i++){
            if (niz2[i] < niz2[i+1] && i == niz2.length-2){
                System.out.println("Niz je sortiran u rastucem trendu");
                break;
            }else if (niz2[i] > niz2[i+1] && i == niz2.length-2){
                System.out.println("Niz je sortiran u opadajucem trendu");
                break;
            }else if (i == niz2.length-2){
                System.out.println("Niz nije sortiran");
                break;                                                      //NE moze ovako valjda
            }*/

        int asc = 0;
        int desc = 0;
        for (int i = 0; i < niz2.length-1; i++) {
            if (niz2[i] < niz2[i + 1]) {
                asc++;
            } else if (niz2[i] > niz2[i + 1]){
                desc++;
            }
        if (asc == niz2.length-1){
            System.out.println("Niz je sortiran u rastucem trendu");
        }else if (desc == niz2.length-1){
            System.out.println("Niz je sortiran u opadajucem trendu");
        }else if (i == niz2.length-2) {
            System.out.println("Niz nije sortiran");
        }
        }

        System.out.println("\n" + "Zadatak 3, 4, 5" + "\n");

        int [] fibo = new int [10];
        fibo [0] = 0;
        fibo [1] = 1;                       //Moramo da zadamo prva dva broja, da bi nastavili niz
        for (int i = 2; i < fibo.length; i++){
            fibo [i] = fibo[i - 1] + fibo[i -2];
        }
        System.out.print("Prvih 10 brojeva fibonacijevog niza su: ");
        for (int i = 0; i < fibo.length; i++) {
            System.out.print(fibo[i] + ", ");
        }System.out.println("\n");

        int suma = 0;
        for (int i = 0; i < fibo.length; i++){
            suma = suma +fibo[i];
        }
        System.out.println("Suma prvih 10 brojeva fibonacijevog niza je: " + suma);
        double aritmetickaSredina = (double) suma / fibo.length;
        System.out.println("Aritmeticka sredina prvih 10 brojeva fibonacijevog niza je: "+ aritmetickaSredina);
    }
}
