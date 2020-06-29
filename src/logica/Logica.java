package logica;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.awt.Color;

import vistaPrincipal.VistaPrincipalTemplate;

public class Logica implements ActionListener {

    private VistaPrincipalTemplate visPrin;
    private Queue<Cliente> cola;
    private LinkedList<Cliente> colaG;
    private Cajero cajero;

    public Logica() {
        cola = new LinkedList<>();
        colaG = new LinkedList<>();
        visPrin = new VistaPrincipalTemplate(this);
        cajero = new Cajero("AtenderClientes", visPrin, this);
    }

    private int generarRecibos() {
        int n = (int) Math.floor(Math.random() * 20 + 1);
        return n;
    }

    private char generarNombres() {
        int n = (int) Math.floor(Math.random() * (90 - 64 + 1) + 64);
        return (char) n;
    }

    private Color generarColor() {
        Random rand = new Random();
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        Color c = new Color(r, g, b);
        return c;
    }

    public void actionPerformed(ActionEvent e) {
        int n = (int) Math.floor(Math.random() * 5 + 1);
        for (int i = 0; i < n; i++) {
            Cliente c = new Cliente(generarNombres(), generarRecibos(), generarColor());
            cola.add(c);
            //Auxiliar para dibujar
            colaG.add(c);
            visPrin.getLGrafica().repaint();
            visPrin.getLGrafica().updateUI();
        }
        if (!cajero.isAlive())
            cajero.start();
    }

    public List<Cliente> getColaG() {
        return colaG;
    }

    public Queue<Cliente> getCola() {
        return cola;
    }
}