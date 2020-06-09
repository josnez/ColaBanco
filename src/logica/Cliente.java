package logica;

public class Cliente {
    private String nombre;
    private int recibos;

    public Cliente(int r){
        this.recibos = r;
    }

    public String getString(){
        return "Cliente: "+nombre+"\nRecibos: "+recibos;
    }
    
}