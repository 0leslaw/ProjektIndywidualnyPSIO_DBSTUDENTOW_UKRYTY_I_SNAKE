package Kursy;

import java.io.Serializable;
import java.util.Random;

public class Kurs implements Serializable {
    private String nazwa;
    private int ECTs;
    private int semestr;
    private float ocenazkursu;


    public Kurs(String nazwa,int ECTs,int semestr){
        this.nazwa = nazwa;
        this.ECTs = ECTs;
        this.semestr = semestr;
    }
    public Kurs(int sem){
        Random random = new Random();
        String[] nazwy_kursow = {"Algebra" , "Analiza","Fizyka","OSK","PSiO","Logika dla informatyków","Wychowanie fizyczne"};
        nazwa = nazwy_kursow[random.nextInt(0, nazwy_kursow.length)];
        ECTs = random.nextInt(3,6);
        ocenazkursu = random.nextInt(2,6);
        int temp = random.nextInt(0,3);
        if(ocenazkursu<5){
            if(temp==0){
                ocenazkursu -= 0.5;
            }else if(temp ==2){
                ocenazkursu += 0.5;
            }
        }
        else{
            if(temp==0){
                ocenazkursu -= 0.5;
            }
        }
        this.semestr = sem;
    }


    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public int getECTs() {
        return ECTs;
    }

    public void setECTs(int ECTs) {
        this.ECTs = ECTs;
    }

    public int getSemestr() {
        return semestr;
    }

    public void setSemestr(int semestr) {
        this.semestr = semestr;
    }

    public float getOcenazkursu() {
        return ocenazkursu;
    }

    public void setOcenazkursu(float ocenazkursu) {
        this.ocenazkursu = ocenazkursu;
    }

    public String toString(){
        return "\n NAZWA: " +nazwa+"\n  |  SEMESTR: "+ semestr + "\n  |  ECTs: " + ECTs +"\n";
    }
}
