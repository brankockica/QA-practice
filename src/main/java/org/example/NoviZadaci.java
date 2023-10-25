package org.example;

import java.util.regex.*;
import java.util.Scanner;

public class NoviZadaci {
    public static void main(String[] args) {
        System.out.println("Zadatak RPG" + "\n");

        boolean  vitezspava        = true;
        boolean strelacspava       = false;
        boolean zatvorenikspava    = false;
        boolean zivoradSkuce       = true;
        System.out.println("Stanje ucesnika je: "+"\n"+"Vitez spava: "+vitezspava+"\n"
                                                    + "Strelac spava: "+strelacspava+"\n"
                                                    + "Zatvorenik spava: "+zatvorenikspava+"\n"
                                                    + "Zivorad je s kuce: "+zivoradSkuce);

        for (int i = 0; i < 5; i++) {
            if (vitezspava == true && i == 0) {
                System.out.println("Brzi napad je moguc.");
            } else if ((vitezspava == false || strelacspava == false || zatvorenikspava == false) && i==1) {
                System.out.println("Spijuniranje je moguce, barem je jedna osoba budna.");
            } else if ((zatvorenikspava == false && strelacspava == true) && i==2) {
                System.out.println("Signalizacija je moguca.");
            } else if (((zivoradSkuce == true && strelacspava == true)
                    || (zivoradSkuce == false && zatvorenikspava == false && vitezspava == true && strelacspava == true))
                    && i==3) {
                System.out.println("Zivorad moze da spasi zatvorenika.");
            } else if (i==4) {
                System.out.println("Ostale radnje, pod ovim uslovima, nisu moguce."+ "\n");          // HELP ME
            }
        }

        System.out.println("Zadatak 7" + "\n");

        Scanner input       = new Scanner(System.in);
        System.out.println("Dobar dan, sta zelite? ");
        String proizvod     = input.nextLine();
        System.out.println("Treba mi " + proizvod);
        String [] inventar  = {"Kupus", "Paradajz", "Krastavac", "PAPRIKE"};


        for (int i = 0; i < inventar.length; i++){
            if (proizvod.equals(inventar[i])){
                System.out.println("Naravno, izvolite. Dovidjenja!");
                break;
            } else if (proizvod != inventar[i] && i== inventar.length-1) {
                System.out.println("Zao nam je, trenutno nemamo " + proizvod);
            }
        }

        System.out.println("Zadatak 8" + "\n");

        Scanner input1       = new Scanner(System.in);
        String regex =    "^(?=.*[0-9])"
                        + "(?=.*[a-z])(?=.*[A-Z])"
                        + "(?=.*[@#$%^&+=])"
                        + "(?=\\S+$).{8,20}$";

        Pattern req         = Pattern.compile(regex);
        System.out.println("Vas novi pasword je? ");
        String pasword      = input1.nextLine();


        for (int i=0; i < 5; i++){
            Matcher m = req.matcher(pasword);                //unete su varijable unutar loop-a, Resena stvar!
            boolean validPasword = m.matches();
            if (validPasword == false){
                System.out.println("Molimo vas pokusajte ponovo");
                System.out.println("Vas novi pasword je? ");
                pasword = input.nextLine();                 //nije mogao da proveri promenjen pasword van scope-a loopa, valjda

            } else if (validPasword == true){
                System.out.println("Vas pasword je pravilno unesen");
                break;
            }
        }

        System.out.println("Zadatak 9" + "\n");

        String izraz    = "3+4*2";
        int rezultat    = 0;
        String [] byPluses = izraz.split("\\+");        //splituje string izraz i prebacuje u array {"3", "4*2"}

        for (String multipl : byPluses) {                     //prebacuje array byPluses u String multipl ?
            String[] byMultipl = multipl.split("\\*");  //splituje string multipl i prebacuje u array byMultipl
            int multiplResult = 1;                            // za svaku iteraciju pravi int variablu
            for (String operand : byMultipl) {                //prebacuje array byMultipl u String operand ?
                multiplResult *= Integer.parseInt(operand);   //za svaku iteraciju int variablu mnozi sa pretvorenim Stringom operand??
            }
            rezultat += multiplResult;                        //NIJE mi jasno kako dobijamo tacan rezultat
        }
        System.out.println("Rezultat izraza je: " + rezultat);


        System.out.println("Zadatak 10" + "\n");

        int [] niz          = {10, 2, 3, 4, 5, 13, 23, 55, 17, 22, 8, 5};

        Scanner input2       = new Scanner(System.in);
        System.out.println("Unesite broj koji zelite da pronadjete.");
        String unos  = input2.nextLine();
        int trazeniBroj = Integer.parseInt(unos);

        for (int i= 0; i < niz.length; i++) {
            if (trazeniBroj == niz[i]){
                System.out.println("Trazeni broj je pronadjen u nizu, i njegov index je " + i);
            }else if (trazeniBroj != niz[i] && i == niz.length-1) {
                System.out.println("Trazni broj nije pronadjen u nizu");
            }
        }


    }
}
