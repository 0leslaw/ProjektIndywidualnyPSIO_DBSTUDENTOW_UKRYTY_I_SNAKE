package Snek;

public class Punkt {
    private int x;
    private int y;
    private int skala;
    public Punkt(int x,int y,int skala){
        this.x=x;
        this.y=y;
        this.skala=skala;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    public void incY() {
        this.y = y +skala;
    }
    public void decY() {
        this.y = y -skala;
    }
    public void incX() {
        this.x = x +skala;
    }
    public void decX() {
        this.x = x -skala;
    }

    public int getSkala() {
        return skala;
    }

    public void setSkala(int skala) {
        this.skala = skala;
    }
    public String toString(){
        return "x: "+x+" y: "+y+" skala: "+skala;
    }
}
