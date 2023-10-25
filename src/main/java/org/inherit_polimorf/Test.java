package org.inherit_polimorf;

import java.util.Arrays;

class Varijable {

    int [] a, b, c, d;

    public Varijable(int [] a ,int [] b, int [] c ,int [] d){
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    public Varijable(int [] a ,int [] b, int [] c) {       //Overloadovanje konstruktora?
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public Varijable(int [] a ,int [] b) {                 //Overloadovanje konstruktora?
        this.a = a;
        this.b = b;
    }
    public Varijable(int [] a) {                           //Overloadovanje konstruktora?
        this.a = a;
    }

    public int getSum(){
        int suma = 0;
        for (int j : this.a) {
            suma += j;
        }
        return suma;
    }
}
class Child extends Varijable{
    int [] e;
    public Child(int[] a, int[] b, int[] e) {
        super(a,b);
        this.e = e;
    }
    public Child(int[] a, int[] e) {                //Overloadovanje konstruktora?
        super(a);
        this.e = e;
    }
    public void prikazi() {
        System.out.println("Koriscene varijable su: " +
                            "a" + Arrays.toString(a) + " " + "b" + Arrays.toString(b) +" " + "e" + Arrays.toString(e));
    }
    @Override
    public int getSum(){
        int suma = 0;
        for (int j : this.e) {
            suma += j;
        }
        return suma;
    }

    public double  getAritSredina(){     //kako da napravimo da uzima neki prozivoljni Parametar? a ne striktno "e"
        int suma = 0;
        for (int j : this.e) {              // jel mora ovde da se koristi   this.
            suma += j;
        } return (double) suma / this.e.length;

    }
}
public class Test {
    public static void main(String[] args){
        int [] e = {1,2,4,5,6};
        int [] a = {3,2,1};
        Varijable niz1 = new Varijable (a);
        Child niz = new Child (a,e);

        int test2   = niz1.getSum();
        int test1   = niz.getSum();
        double test = niz.getAritSredina();
        System.out.println("Suma niz1 je " + test2);
        System.out.println("Suma niz je " + test1);
        System.out.println("Aritmeticka sredina je " + test);

        niz.prikazi();

    }
}
