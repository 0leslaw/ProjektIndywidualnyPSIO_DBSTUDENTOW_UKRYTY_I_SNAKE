package Main;

import GUI.RamkaStartowa;
import Kursy.Kurs;
import Ludzie.Osoba;
import Ludzie.Student_dzienny;
import Serializacja.Serializacja;
import Testy.Test_1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Main {


    public static void main(String[] args) throws IOException,ClassNotFoundException, InputMismatchException {


//        ArrayList<Osoba> o = new ArrayList<>();
//        o.add(new Student_dzienny());
//        ArrayList<Kurs> k = new ArrayList<>();
//        k.add(new Kurs(3));
////
//        Serializacja.zapisDowolnejArrayListy(o,"PlikOsob.ser");
//        Serializacja.zapisDowolnejArrayListy(k,"PlikKursow.ser");
//        Test_1.wykonajTest();
        RamkaStartowa.start();
//        Student_dzienny s = (Student_dzienny) java.Serializacja.odczyt("PlikOsob.ser").get(
//                java.Serializacja.odczyt("PlikOsob.ser").size()-1);
//        System.out.println(s.getLista_kursow());
    }


}
