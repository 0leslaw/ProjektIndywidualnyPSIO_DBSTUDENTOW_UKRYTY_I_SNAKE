package Testy;

import Funkcje_dla_osob.Tworzenie_osob;
import Funkcje_dla_osob.Wyswietlanie_osob;
import Kursy.Kurs;

import Ludzie.*;
import Serializacja.Serializacja;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test_1 {

    public static void wykonajTest() throws IOException, ClassNotFoundException {
        ArrayList<Osoba> lista_osob =new ArrayList<>();
        //2-------------------------------------------------------------

        dodajLosoweOsoby(lista_osob,40);
        lista_osob.add(new Student_zaoczny("IST", 1, "Olek", 19, "Woźniak", 392222,0,0));


        //3 a-------------------------------------------------------------
        dodajKomentarz("Wyświetlenie kompletnych informacji na temat wszystkich pracowników" +
                " i studentów\n","3 a");

        Serializacja.wypiszOsobyZlisty(lista_osob);


        //3 b-------------------------------------------------------------
        dodajKomentarz("Wyszukanie konkretnej osoby / zboru osób poprzez nazwisko i " +
               "wyświetlenie kompletu informacji\n","3 b");

        ArrayList<String> listawyszukiwanychnazwisk = new ArrayList<>();
        listawyszukiwanychnazwisk.add("Lewandowski");
        listawyszukiwanychnazwisk.add("Żyła");
        Wyswietlanie_osob.wyswInfoOPodNazw(listawyszukiwanychnazwisk, lista_osob);

        //3 c-------------------------------------------------------------
        dodajKomentarz(". Wyszukanie studenta po numerze indeksu i wyświetlenie kompletu " +
                "informacji dotyczących tego studenta\n","3 c");

        Wyswietlanie_osob.wyszSpoNrInd(392222, lista_osob);
        System.out.println("co stanie się w przypadku podania nieistniejącego numeru indeksu: ");
        Wyswietlanie_osob.wyszSpoNrInd(0, lista_osob);


        //3 d-------------------------------------------------------------
        dodajKomentarz("Wyszukanie pracowników uczelni o wartości dorobku powyżej zadanej wartości T\n","3 d");

        Wyswietlanie_osob.wyszPodUstalonegoT(lista_osob,50);


        //3 e-------------------------------------------------------------
        dodajKomentarz("Wyszukanie pracownika administracyjnego po zajmowanym stanowisku pracy.\n","3 e");

        Wyswietlanie_osob.wyszPracAdmPoStanow("Księgowy", lista_osob);

        //4---------------------------------------------------------------
        dodajKomentarz("Przygotuj możliwość komunikacji z użytkownikiem – tj. wpisywanie \n" +
                "konkretnych osób z poziomu konsoli (przy wykorzystaniu obiektu typu Scanner\n" +
                "dla standardowego wejścia System.in )\n","4 ");


        lista_osob.add(Tworzenie_osob.funkcjaTworzOsobe());

        lista_osob.add(new Pracownik_uczelni_naukowo_dydaktyczny("Maciek",50,"Mbappe",
                "Wykładowca Algebry",14000,60));
        lista_osob.add(new Student_dzienny("IST",3,"Błażej",23,"Kowal",202020,0,0));


        //5---------------------------------------------------------------
        System.out.println("\n\n          ++++++++++=======5=======++++++++++\n");
        System.out.println("Zaimplementuj możliwość zapisu i odczytu całej bazy wpisanych osób do / z \n" +
                "pliku (poprzez serializację całej ArrayListy)\n");
        Serializacja.zapis(lista_osob,"PlikOsob.ser");
        ArrayList<Osoba> odczytane = Serializacja.odczyt("PlikOsob.ser");

        System.out.println("\n\ntotesyt\n\n"+odczytane.get(odczytane.size()-1)+"kuniec tesytu");
        Serializacja.wypiszOsobyZlisty(odczytane);

        //-----------------------------------------------------------------

        System.out.println("\n\n-------------------------------------------------\n" +
                "==========================================\n");


//        Student_dzienny student_dzienny = new Student_dzienny();
//        System.out.println(student_dzienny);
//        student_dzienny.przyznanieStypendium();
//        System.out.println(student_dzienny);
//
//        Pracownik_uczelni pracownik_uczelni = new Pracownik_uczelni();
//        System.out.println(pracownik_uczelni);
//        pracownik_uczelni.przydzielPlace();
//        System.out.println(pracownik_uczelni);

        for(int i =0;i<20;i++)
            Serializacja.dopiszDoDowolnejArraylistyTypuTYLKOT(new Kurs(2),"PlikKursow.ser");
    }
    public static void dodajKomentarz(String tekst,String podzadanie){
        System.out.println("\n\n       ***   "+podzadanie+"   ***");
        System.out.println("\n" + tekst);

    }
    public static void dodajLosoweOsoby(List<Osoba> lista_osob,int razy4iloscosob){

        for (int i = 0; i < razy4iloscosob; i++) {
            lista_osob.add(new Student_dzienny());
            lista_osob.add(new Student_zaoczny());
            lista_osob.add(new Pracownik_uczelni());
            lista_osob.add(new Pracownik_uczelni_naukowo_dydaktyczny());
        }
    }

}
