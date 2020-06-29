package logica;

import vistaPrincipal.VistaPrincipalTemplate;

public class Cajero extends Thread {

    private VistaPrincipalTemplate visPrin;
    private Logica l;

    public Cajero(String name, VistaPrincipalTemplate visPrin, Logica log) {
        super(name);
        this.visPrin = visPrin;
        this.l = log;
    }

    private void atenderClientes(){
        while (!l.getCola().isEmpty()) {            
            Cliente c = l.getCola().poll();
            //Auxiliar para dibujar
            l.getColaG().remove(0);
            visPrin.getLGrafica().repaint();
            addCliente(c);
            if(c.getRecibos()>0){
                l.getCola().add(c);
                l.getColaG().add(c);
                visPrin.getLGrafica().repaint();
            }                      
        }
        visPrin.getpClienteA().setBackground(null); ;
        visPrin.getlClienteP().setText("Esperando");
        visPrin.getlRecibos().setText("Cliente");
    }

    public void run() {
        while (true) {
            atenderClientes();
        }
    }

	public void addCliente(Cliente c) {
        visPrin.getpClienteA().setBackground(c.getColor());
        visPrin.getlClienteP().setText("Cliente "+c.getNombre());
        int r = c.getRecibos();
        if (r >= 5) {
            c.setRecibos(r - 5);
            for (int i = 0; i < 5; i++) {
                try {
                    visPrin.getlRecibos().setText("Recibos: "+r);
                    visPrin.getlRecibos().repaint();
                    r--;
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else {
            c.setRecibos(0);
            int aux = r;
            for (int i = 0; i < aux; i++) {
                try {
                    visPrin.getlRecibos().setText("Recibos: "+r);
                    visPrin.getlRecibos().repaint();
                    r--;
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
	}
}