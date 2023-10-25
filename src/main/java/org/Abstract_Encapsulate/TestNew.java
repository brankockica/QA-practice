package org.Abstract_Encapsulate;

import org.Protected.Ograniceno;

abstract class Racunanje{
    abstract int sumaNiza();
}
class Niz1 extends Racunanje{
    int a,b,c,d;
    private int e,f;

    public Niz1 (int a, int b, int c, int d, int e, int f){
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }
    public Niz1 ( int a, int b, int c){            //Overloadovanje sa istim brojem parametra u konstruktoru ne moze!
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public Niz1 (int e, int f){                 //Overloadovan konstruktor
        this.e = e;
        this.f = f;
    }
    public int getE(){              //geter
        return e;
    }
    public int getF(){              //geter
        return f;
    }
    public void setE(int e){        //seter
        this.e = e;
    }
    public void setf(int f){        //seter
        this.f = f;
    }

    @Override
    int sumaNiza(){
        int [] array = {a,b,c};
        int suma = 0;
        for (int i : array) {
            suma += i;
        } return suma;
    }

}
public class TestNew extends Ograniceno {
    public static void main(String[] args){

        Niz1 niz1 = new Niz1(5,4,10);
        Niz1 niz2 = new Niz1(13,3);

        niz2.setE(4);
        int [] arrayPrivate = {niz2.getE(), niz2.getF()};
        int sumaPrivate = 0;
        for (int i : arrayPrivate){
            sumaPrivate += i;
        }

        System.out.println(niz2.getE());
        System.out.println("Suma niz1 je: " + niz1.sumaNiza());
        System.out.println("Suma niza sa privatnim elementima je:" + sumaPrivate);

        int [] arrayProtected = {protVar1,2,4,protVar2};        //koristimo protected ?static? varijable u nizu
        int sumaProtected = 0;
        for (int i : arrayProtected){
            sumaProtected += i;
        }
        System.out.println("Suma niza sa protected elementima je:" + sumaProtected);

    }
}
