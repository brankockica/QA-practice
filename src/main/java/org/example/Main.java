package org.example;

import java.text.DecimalFormat;

public class Main {
    /*public static void main(String[] args) {

        String name         = "Branislav";
        String ageString    = "30";
        int height          = 197;
        int ageInt          = Integer.parseInt(ageString);

        boolean isItLarger  = ageInt > height;

        if(isItLarger == true)
            System.out.println("Broj ageInt je veci od height");
        else
            System.out.println("Broj ageInt je manji od height");

        double  pi1         = Math.PI;
        float   pi2         = (float)Math.PI;                               // Math.PI je po sebi double
        DecimalFormat df    = new DecimalFormat("###.####");

        System.out.println("Broj pi sa 4 decimale je " + df.format(pi2));
        System.out.printf("Broj pi sa 5 decimale je %.5f %n", (pi1));
        System.out.printf("Broj pi sa 6 decimale je %.6f %n", (pi1));       // printf formatira " + " u operaciju?, mora " , "
        System.out.printf("Broj pi sa 7 decimale je %.7f %n", (pi2));       // Automatski mu radi roundUp ?
        System.out.println("Cao bao " + name);

        }*/

    public static void main(String[] args) {

        int[] singleArray   = {0,2,4,7,8,13,61,32,83,-14,-13};
        int[][] multiArray  = {{3,2,6,1,14,-5,31,7},{61,-5,2,3,4,5,32,-2,0}};

        int parSize     = 0;
        int neparSize   = 0;

        for (int k : singleArray) {         //Intelij preporuka za bolji/kraci for loop?
            if (k % 2 == 0 && k != 0)
                parSize++;
            else if (k != 0)                // Koristim != 0 kako bi se otarasio nule
                neparSize++;
        }

        int[] parni     = new int[parSize];
        int[] neparni   = new int[neparSize];
        int x = 0; int y = 0;
        for (int i = 0; i < singleArray.length; i++){         //obrati paznju na uslov i < singleArray.length da ne bi izgubio neki broj iz Arraya
            if (singleArray[i] % 2 == 0 && singleArray[i] != 0)
                parni[x++] = singleArray[i];
            else if (singleArray[i] != 0)                     // Koristim != 0 kako bi se otarasio nule
                neparni[y++] = singleArray[i];
        }
        for (int i = 0; i < parni.length; i++){
            System.out.println("Parni brojevi singleArraya su " + parni[i]);  //Kako isprintati sve clanove u jednoj liniji?
        }
        for (int i = 0; i < neparni.length; i++){
            System.out.println("Neparni brojevi singleArraya su " + neparni[i]);
        }



        String[] imena          = {"Pera","Zika","Mika","Srle","Prle"};
        String[] prezimena      = {"Peric","Zikic","Mikic","Srkic","Prkic"};
        String[] zanimanje      = {"Lekar","Pekar","Apotekar","Kolar","Stolar"};
        String[][] imePreZime   = {imena, prezimena, zanimanje};                                   //isto je kao i imePreZime1, nepotrebno indexiranje
        String[][] imePreZime1  = { {imena[0],imena[1],imena[2],imena[3],imena[4]},
                                    {prezimena[0],prezimena[1],prezimena[2],prezimena[3],prezimena[4]}
                                    };
        int i = 0;
        while (i < imePreZime.length-1){        //Zasto ovde mora -1 za sve i < 3?
            int j = 0;
            while (j < imePreZime[i].length){
                if (imePreZime[i][j].endsWith("a")) {
                    System.out.println("Dobar dan, " + imePreZime[i][j].replace("a", "o")
                                            + " " + imePreZime[i+1][j].concat("u"));  //moglo je i samo + " u " na kraju
                }else {System.out.println("Dobar dan, " + imePreZime[i][j] + " " + imePreZime[i+1][j].concat("u"));
                }                             // kako se oterasiti [i + 1] ??? IPAK NE TREBA! line 73 treba dodati -1 nakon .length (izbacivalo je Index 3 out of bounds)
                j++;

            }
            i++;                              //umesto break; pisemo i++; Ako ne zamenimo, kaze da while ne pravi loop !!!

        }

        System.out.println("Cao " + imena[4]);
        System.out.println("Dobar dan " + imePreZime[0][2].replace("a","o")
                                + " "   + imePreZime1[1][2].concat("u"));
        System.out.println("Dobar dan "+ imePreZime1[0][1] + " " +imePreZime[1][1]);


        }
    }
