package Funkcje_dla_osob;

import Kursy.Kurs;

import Ludzie.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Tworzenie_osob {

    public static Osoba funkcjaTworzOsobe() throws InputMismatchException {

        Scanner scanner= new Scanner(System.in);

        System.out.println("Wybierz jaką osobę chcesz dodać: \n 1 - Student\n2 - " +
                "Pracownik naukowo - dydaktyczny\n3 - Pracownik uczelni administracyjny\n"+
                "0 - zakończ\n");
        int wybor = -1;
        String imie = " ";
        int wiek = 0;
        String nazwisko = " ";
        String kierunek = " ";
        int semsestr = 0;
        int nr_indeksu = 0;
        String praca = " ";
        int zarobki_pm = 0;
        int wart_dorobku = 0;
        int wybor2 = 0;
        int ECTS = 0;
        String nazwakursu=" ";
        int semestr_kursu=0;
        boolean error;
        do{
            error = false;
            try
            {
                wybor = scanner.nextInt();
            }
            catch (InputMismatchException e)
            {
                System.out.println("Podano niepoprawne dane");
                error = true;
                scanner.nextLine();
            }

        } while(wybor > 3 || wybor < 0 || error);
        if(wybor == 0){}

        if(wybor == 1) {
            try {
                System.out.print("\n\nWpisz imię: ");
                imie = scanner.next();

                System.out.print("\n\nWpisz wiek: ");
                wiek = scanner.nextInt();

                System.out.print("\n\nWpisz nazwisko: ");
                nazwisko = scanner.next();

                System.out.print("\n\nWpisz kierunek: ");

                kierunek = scanner.next();


                System.out.print("\n\nWpisz semestr: ");
                semsestr = scanner.nextInt();


                System.out.print("\n\nWpisz numer indeksu: ");
                nr_indeksu = scanner.nextInt();
            }catch (InputMismatchException E){
                System.out.println("Podano nieprawidłowe dane");

            }


            Student studroboczy = new Student_dzienny(kierunek, semsestr, imie, wiek, nazwisko, nr_indeksu,0,0);
            do {
                System.out.println("Dodaj kurs - 1\nZakończ program - 2");
                do {
                    try {
                        wybor2 = 0;
                        wybor2 = scanner.nextInt();
                    }catch (InputMismatchException W){}

                } while (wybor2 > 2 || wybor2 < 1);

                if (wybor2 == 2)
                    return studroboczy;
                else if (wybor2 == 1) {
                    try {
                        System.out.print("\n\nWpisz imię: ");
                        imie = scanner.next();

                        System.out.print("\n\nWpisz wiek: ");
                        wiek = scanner.nextInt();

                        System.out.print("\n\nWpisz nazwisko: ");
                        nazwisko = scanner.next();

                        System.out.println("Wpisz nazwe: ");
                        nazwakursu = scanner.next();

                        System.out.println("Wpisz ECTs: ");
                        ECTS = scanner.nextInt();

                        System.out.println("Wpisz semestr: ");
                        semestr_kursu = scanner.nextInt();


                        studroboczy.setLista_kursow(new Kurs(nazwakursu, ECTS, semestr_kursu));
                    }catch (InputMismatchException O){
                        System.out.println("Podano nieprawidłowe dane");
                    }
                }
            }while(wybor2 ==1);
            return studroboczy;
        }


        else if(wybor == 2){
            try{
                System.out.print("\n\nWpisz imię: ");
                imie = scanner.next();

                System.out.print("\n\nWpisz wiek: ");
                wiek = scanner.nextInt();

                System.out.print("\n\nWpisz nazwisko: ");
                nazwisko = scanner.next();

                System.out.print("\n\nWpisz prace: ");
                praca = scanner.next();

                System.out.print("\n\nWpisz zarobki na miesiąc: ");
                zarobki_pm = scanner.nextInt();

                System.out.print("\n\nWpisz wartość dorobku: ");
                wart_dorobku = scanner.nextInt();
            }catch (InputMismatchException e) {
                System.out.println("Podano nieprawidłowe dane");

            }
            return new Pracownik_uczelni_naukowo_dydaktyczny(imie,wiek,nazwisko,praca,zarobki_pm,wart_dorobku);
        }
        else if (wybor == 3){
            try{
                System.out.print("\n\nWpisz imię: ");
                imie = scanner.next();

                System.out.print("\n\nWpisz wiek: ");
                wiek = scanner.nextInt();

                System.out.print("\n\nWpisz nazwisko: ");
                nazwisko = scanner.next();

                System.out.print("\n\nWpisz prace: ");
                praca = scanner.next();

                System.out.print("\n\nWpisz zarobki na miesiąc: ");
                zarobki_pm = scanner.nextInt();

            }
            catch (InputMismatchException e) {
                System.out.println("Podano nieprawidłowe dane");

            }
            return new Pracownik_uczelni(imie,wiek,nazwisko,praca,zarobki_pm);
        }else return null;

    }
}
