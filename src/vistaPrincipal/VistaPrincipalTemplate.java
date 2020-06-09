package vistaPrincipal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.ScrollPane;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import logica.Cliente;
import logica.Logica;

/**
 * VistaPrincipalTemplate
 */
public class VistaPrincipalTemplate extends JFrame{

    //Objetos graficos
    private JPanel pNorte, pCajero, pClienteA;
    private JLabel lTitulo, lMnsCajero, lClienteP, lCajero, lGrafica;
    private JButton bAddClientes;
    private ScrollPane scrollPCola;

    //Objetos decoradores
    private Font fuenteTitulo, fuentePrincipal;
    private Cursor cMano;
    private ImageIcon iAux, iAbrir, iCajero;
    private Color colorAzulClaro, colorAzulM, colorAzulF;

    //Objetos comunicacion
    private Logica log;
    private int x,y,in;

    public VistaPrincipalTemplate(Logica log){
        this.log = log;
        crearObjetosDecoradores();
        crearJPaneles();
        crearScrollPane();
        crearJButtons();
        crearJLabels();

        this.setSize(800, 500);
        this.setLocationRelativeTo(this);
        this.setTitle("Banco");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void crearObjetosDecoradores(){
        fuenteTitulo = new Font("Comic Sans MS", Font.BOLD, 20);
        fuentePrincipal = new Font("Comic Sans MS", Font.PLAIN, 16);
        iAbrir = new ImageIcon("resources/imagenes/abrirBanco.png");
        iCajero = new ImageIcon("resources/imagenes/asesor.png");
        cMano = new Cursor(Cursor.HAND_CURSOR);
        colorAzulClaro = new Color(72, 192, 249);
        colorAzulM = new Color(0, 122, 204);
        colorAzulF = new Color(17, 15, 151);
    }

    private void crearJPaneles(){
        pNorte = new JPanel(new FlowLayout());
        pNorte.setBackground(colorAzulM);
        this.add(pNorte,BorderLayout.NORTH);
        pCajero = new JPanel(new BorderLayout());
        //pCajero.setSize(300, 400);
        this.add(pCajero, BorderLayout.WEST);
    }

    private void crearJLabels(){
        lTitulo = new JLabel("Banco colombiano");
        lTitulo.setFont(fuenteTitulo);
        pNorte.add(lTitulo);

        JPanel pRCajero = new JPanel(new BorderLayout());
        lMnsCajero = new JLabel("Cajero");
        lMnsCajero.setSize(20, 10);
        lMnsCajero.setFont(fuentePrincipal);
        lMnsCajero.setHorizontalAlignment(SwingConstants.CENTER);
        pRCajero.add(lMnsCajero, BorderLayout.CENTER);
        lCajero = new JLabel();
        iAux = new ImageIcon(iCajero.getImage().getScaledInstance(80, 80, Image.SCALE_AREA_AVERAGING));
        lCajero.setIcon(iAux);        
        pRCajero.add(lCajero, BorderLayout.SOUTH);
        pCajero.add(pRCajero, BorderLayout.CENTER);
        lClienteP = new JLabel("asd");
        pClienteA = new JPanel();
        pClienteA.add(lClienteP);
        pCajero.add(pClienteA, BorderLayout.SOUTH);

        lGrafica = new JLabel(){
            public void paint(Graphics grph) {
                dibujaCola(grph);
            };
        };
        lGrafica.setBackground(colorAzulClaro);
        scrollPCola.add(lGrafica);
    }

    private void crearJButtons(){
        bAddClientes = new JButton();
        bAddClientes.setSize(5, 5);
        bAddClientes.setFocusable(false);
        bAddClientes.setBorder(null);
        bAddClientes.setContentAreaFilled(false);
        iAux = new ImageIcon(iAbrir.getImage().getScaledInstance(100, 100, Image.SCALE_AREA_AVERAGING));
        bAddClientes.setIcon(iAux);
        bAddClientes.setCursor(cMano);
        bAddClientes.addActionListener(log);
        bAddClientes.setBackground(Color.RED);
        pCajero.add(bAddClientes, BorderLayout.NORTH);
    }
    
    public void crearScrollPane(){
        scrollPCola = new ScrollPane(ScrollPane.SCROLLBARS_AS_NEEDED);
        this.add(scrollPCola, BorderLayout.CENTER);
    }

    private void dibujaCola(Graphics grph) {
        System.out.println("Dibuja cola");
        int anchura=log.getCola().size();
        if(anchura==0) return;
        grph.setColor(Color.WHITE);
        grph.clearRect(0, 0, x, y);
        y = 420;
        x = anchura*110;
        in = 0;
        grph.clearRect(0, 0, x, y);
        lGrafica.setPreferredSize(new Dimension(x, y));
        dibujaCliente(grph,log.getCola().get(in), 30, 180);
        scrollPCola.doLayout();
    }

    private int dibujaCliente(Graphics grph, Cliente cliente, int x, int y) {

        if (cliente == null)
            return 0;

        grph.setColor(colorAzulF);
        grph.fillRect(x, y, 100, 50);
        
            grph.setColor(Color.RED);
            grph.drawString(cliente.getNombre(), x + 20, y + 30);
            grph.drawString(cliente.getRecibos(), x + 20, y + 45);
            if (!log.getCola().isEmpty()) {
                in++;
                dibujaCliente(grph, log.getCola().get(in), x + 100, y);
            }
        
        return 1;
    }

    public JButton getbAddClientes() {
        return bAddClientes;
    }

    public JPanel getpClienteA() {
        return pClienteA;
    }

    public ScrollPane getScrollPCola() {
        return scrollPCola;
    }

    public JLabel getLGrafica(){
        return lGrafica;
    }

}