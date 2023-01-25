package Serializacja;

import Ludzie.Osoba;
import Ludzie.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Serializacja {

    public static ArrayList<Osoba> odczyt(String nazwaPl)throws IOException,ClassNotFoundException{
        ObjectInputStream pl2=null;
        ArrayList<Osoba> lista_osob = null;
        try{
            pl2=new ObjectInputStream(new FileInputStream(nazwaPl));
            lista_osob=(ArrayList<Osoba>) pl2.readObject();



        } catch (EOFException ex) {
            System.out.println("Koniec pliku");
        }

        finally{
            if(pl2!=null)
                pl2.close();
        }
        usuwaNulle(lista_osob);
        return lista_osob;
    }

    public static void wypiszOsobyZlisty(ArrayList<Osoba> lista_osob){
        if(lista_osob!=null)
        for(int i=0;i<lista_osob.size();i++)
            if(lista_osob.get(i)!=null)
                System.out.println(lista_osob.get(i).toString());
    }

    public static void zapis(ArrayList<Osoba> lista_osob,String nazwapliku)throws IOException{
        ObjectOutputStream pl=null;
        try{
            pl=new ObjectOutputStream(new FileOutputStream(nazwapliku));
            pl.writeObject(lista_osob);
            pl.flush();
        }
        finally{
            if(pl!=null)
                pl.close();
        }
    }
    public static void dopisz(Osoba o, String nazwapliku) throws IOException, ClassNotFoundException {
        ArrayList<Osoba> lista = odczyt(nazwapliku);
        lista.add(o);
        zapis(lista, nazwapliku);
    }
    public static ArrayList<Osoba> usuwaNulle(ArrayList<Osoba> lista_osob){
        boolean usunieto = false;
        if(!lista_osob.isEmpty())
        for(int i =0; i<lista_osob.size(); i++){
            do{
            if(lista_osob.get(i) == null) {
                lista_osob.remove(i);
                usunieto = true;
            }else usunieto = false;
            }while (usunieto);
        }
        return lista_osob;
    }
    public static int dajNowyIndeks(String nazwapliku) throws IOException, ClassNotFoundException {
        ArrayList<Osoba> lista_osob = odczyt("PlikOsob.ser");
        ArrayList<Integer> nrind = new ArrayList<>();
        int temp = (new Random()).nextInt(100000,1000000);
        for (Osoba osoba : lista_osob) {
            if(osoba instanceof Student){
                nrind.add(((Student) osoba).getNr_ind());
            }
        }
        if(!nrind.isEmpty()) {
            boolean niezr = true;
            while (niezr) {
                niezr = false;
                for (Integer integer : nrind) {
                    if (temp == integer) {
                        temp = (new Random()).nextInt(100000, 1000000);
                        niezr = true;
                    }
                }
            }
        }
        return (int)temp;
    }
    public static <T> ArrayList<T> odczytDowolnejArrayListy(String nazwapliku) throws IOException, ClassNotFoundException {
        ObjectInputStream pl2=null;
        ArrayList<T> lista_T = null;
        try{
            pl2=new ObjectInputStream(new FileInputStream(nazwapliku));
            lista_T=(ArrayList<T>) pl2.readObject();

        } catch (EOFException ex) {
//            System.out.println("Koniec pliku");
        }

        finally{
            if(pl2!=null)
                pl2.close();
        }
        return lista_T;
    }

    public static <T> void zapisDowolnejArrayListy(ArrayList<T> lista_T, String nazwapliku)throws IOException {
        ObjectOutputStream pl=null;
        try{
            pl=new ObjectOutputStream(new FileOutputStream(nazwapliku));
            pl.writeObject(lista_T);
            pl.flush();
        }
        finally{
            if(pl!=null)
                pl.close();
        }
    }
    public static <T> void dopiszDoDowolnejArraylistyTypuTYLKOT(T o, String nazwapliku) throws IOException, ClassNotFoundException{
        ArrayList<T> lista = (ArrayList<T>) odczytDowolnejArrayListy(nazwapliku);
        lista.add(o);
        zapisDowolnejArrayListy(lista,nazwapliku);
    }
}
