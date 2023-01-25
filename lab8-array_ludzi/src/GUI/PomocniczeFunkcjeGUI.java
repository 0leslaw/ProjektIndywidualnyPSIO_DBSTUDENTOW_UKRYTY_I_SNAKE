package GUI;

public class PomocniczeFunkcjeGUI {
    public static boolean czyjestSamint(String wpisanytekst, int granica_dol, int granica_gora){
        boolean czysamint = true;

        try{
            Integer wynink = Integer.parseInt(wpisanytekst);
        }
        catch (NumberFormatException ex){
            czysamint = false;
        }
        if(czysamint)
            if(!(Integer.parseInt(wpisanytekst) > granica_dol && Integer.parseInt(wpisanytekst) < granica_gora)) {
                czysamint = false;

            }
        return czysamint;
    }
    public static boolean czyjestSamString(String wpisanytekst){
        if ((wpisanytekst).matches("[a-zA-Z]+"))
            return true;
        else return false;
    }
    public static int dajIntaOdStringa(String wpisanytekst){
        return Integer.parseInt(wpisanytekst);
    }
}
