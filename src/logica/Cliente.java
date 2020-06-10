package logica;

import java.awt.Color;

public class Cliente {
    private char nombre;
    private int recibos;
    private Color c;

    public Cliente(char n, int r, Color c){
        this.recibos = r;
        this.nombre = n;
        this.c = c;
    }

    public char getNombre(){
        return nombre;
    }

    public int getRecibos(){
        return recibos;
    }
    public void setRecibos(int r){
        recibos=r;
    }

    public Color getColor(){
        return c;
    }
}