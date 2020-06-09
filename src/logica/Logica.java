package logica;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import vistaPrincipal.VistaPrincipalTemplate;

public class Logica implements ActionListener{

    private VistaPrincipalTemplate visPrin;
    private Queue<Cliente> cola;
    private List<Cliente> colaG;
    private int cliente;

    public Logica() {
        cola = new LinkedList<>();
        colaG = new LinkedList<>();
        visPrin = new VistaPrincipalTemplate(this);
    }

    private int generarRecibos(){
        int n = (int)Math.floor(Math.random()*20+1);
        System.out.println("Recibos: "+n);
        return n;
    }

    public void actionPerformed(ActionEvent e){
        for(int i=cliente; i<cliente+5; i++){
            Cliente c = new Cliente(generarRecibos());
            cola.add(c);
            colaG.add(c);
            visPrin.getLGrafica().repaint();
        }
    }

    public List<Cliente> getCola(){
        return colaG;
    }
}