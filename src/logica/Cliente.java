package logica;

public class Cliente {
    private String nombre;
    private int recibos;

    public Cliente(int r){
        this.recibos = r;
    }

    public String getNombre(){
        return "Cliente: "+nombre;
    }

    public String getRecibos(){
        return "Recibos: "+recibos;
    }
}