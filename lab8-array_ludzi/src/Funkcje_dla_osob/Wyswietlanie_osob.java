package Funkcje_dla_osob;

import Ludzie.Pracownik_uczelni_naukowo_dydaktyczny;
import Ludzie.Osoba;
import Ludzie.Pracownik_uczelni;
import Ludzie.Student;

import java.util.List;

public class Wyswietlanie_osob {

    public static void wyswInfoOPodNazw(List<String> lista_nazwisk, List<Osoba> lista_osob){

        int i = 0;
        while(i<lista_nazwisk.size()){
            System.out.println("--------------------------------------------");
            System.out.println("Wyniki wyszukiwania po nazwisku " + lista_nazwisk.get(i)+": ");
            for(int j=0;j< lista_osob.size();j++){
                if ((lista_osob.get(j)).getNazwisko() == lista_nazwisk.get(i)){
                    System.out.println((lista_osob.get(j)).toString());
                }
            }
            i++;
        }

    }

    public static void wyszSpoNrInd(int nr_ind,List<Osoba> lista_osob){
        System.out.println("--------------------------------------------\n" +
                "Wyniki wyszukiwania po numerze indeksu: "+nr_ind);

        boolean czyjest = false;
        for(int i=0;i< lista_osob.size();i++)
            if(lista_osob.get(i) instanceof Student && ((Student) lista_osob.get(i)).getNr_ind() == nr_ind) {
                System.out.println((lista_osob.get(i)).toString());
                czyjest = true;
            }
        if(czyjest==false)
            System.out.println("\nNie znaleziono Studenta o podanym numerze indeksu\n");
    }

    public static void wyszPodUstalonegoT(List<Osoba> lista_osob,int min){


        System.out.println("--------------------------------------------\n" +"Pracownicy naukowo-dydaktyczni o " +
                "dorobku większym niż: "+min+"\n");
        System.out.printf("%-32s %s\n","Imię i nazwisko","dorobek");
        int j = 1;
        for(int i=0;i< lista_osob.size();i++)
            if(lista_osob.get(i) instanceof Pracownik_uczelni_naukowo_dydaktyczny &&
                    ((Pracownik_uczelni_naukowo_dydaktyczny) lista_osob.get(i)).getWartosc_dorobku() >= min) {


                System.out.printf("%-32s %s\n",j+". "+lista_osob.get(i).getImie()+" "+lista_osob.get(i).getNazwisko() ,
                        ((Pracownik_uczelni_naukowo_dydaktyczny) lista_osob.get(i)).getWartosc_dorobku());
                j++;
            }
        System.out.println("--------------------------------------------\n");
    }
    public static void wyszPracAdmPoStanow(String nazwastanowiska,List<Osoba> lista_osob){

        System.out.println("Pracownicy administracyjni na stanowisku " + nazwastanowiska + ": ");
        for(int i=0;i<lista_osob.size();i++)
            if(lista_osob.get(i) instanceof Pracownik_uczelni && ((Pracownik_uczelni) lista_osob.get(i)).getPraca() ==
                    nazwastanowiska)
            {
                System.out.printf("%-32s %s\n",lista_osob.get(i).getImie() +" "+lista_osob.get(i).getNazwisko(), "");
            }
        System.out.println("--------------------------------------------\n");

    }

}
