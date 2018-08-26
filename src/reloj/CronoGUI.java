package reloj;

import com.sun.corba.se.spi.orb.ParserImplTableBase;
import com.sun.xml.internal.ws.api.pipe.Fiber;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import static javafx.scene.input.KeyCode.F;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CronoGUI extends JFrame implements ActionListener {

    private JTextField second;
    private JTextField minute;
    private JTextField heure;
    private JLabel punto1;
    private JLabel punto2;
    private JButton avanzar;
    private JButton retroceder;
    private JButton pausar;
    private JButton ajustar;
    private JButton correr;
    private JButton reiniciar;
    private JPanel PanelText;
    private JPanel PanelB;
    private Font fuente;
    private Font fuentepunto;
    private Reloj mp3;
    private int contador;

    public CronoGUI() {
        contador = 0;
        PanelB = new JPanel();
        PanelB.setLayout(new GridLayout(1, 6));
        PanelB.setBackground(Color.black);
        PanelText = new JPanel();
        PanelText.setLayout(new GridLayout(1, 5));
        PanelText.setBackground(Color.black);
        second = new JTextField("0");
        second.setBackground(Color.black);
        second.setForeground(Color.white);
        second.setBorder(null);
        fuente = new Font("DS-digital", Font.PLAIN, 50);
        second.setFont(fuente);
        second.setHorizontalAlignment(SwingConstants.CENTER);
        minute = new JTextField("0");
        minute.setFont(fuente);
        minute.setBorder(null);
        minute.setHorizontalAlignment(SwingConstants.CENTER);
        minute.setBackground(Color.black);
        minute.setForeground(Color.white);
        heure = new JTextField("0");
        heure.setFont(fuente);
        heure.setBorder(null);
        heure.setHorizontalAlignment(SwingConstants.CENTER);
        heure.setBackground(Color.black);
        heure.setForeground(Color.white);
        punto1 = new JLabel(":");
        punto1.setFont(fuente);
        punto1.setForeground(Color.white);
        punto1.setHorizontalAlignment(SwingConstants.CENTER);
        punto2 = new JLabel(":");
        punto2.setFont(fuente);
        punto2.setForeground(Color.white);
        punto2.setHorizontalAlignment(SwingConstants.CENTER);
        avanzar = new JButton();
        avanzar.addActionListener(this);
        avanzar.setActionCommand("avanzar");
        avanzar.setIcon(new ImageIcon("F:/[FAT32]/[005B17]/avanzar.jpg"));
        avanzar.setBackground(Color.black);
        avanzar.setBorder(null);
        ajustar = new JButton();
        ajustar.addActionListener(this);
        ajustar.setActionCommand("ajustar");
        ajustar.setIcon(new ImageIcon("F:/[FAT32]/[005B17]/ajustar.png"));
        ajustar.setBackground(Color.black);
        ajustar.setBorder(null);
        retroceder = new JButton();
        retroceder.addActionListener(this);                        
        retroceder.setActionCommand("retroceder");
        retroceder.setIcon(new ImageIcon("F:/[FAT32]/[005B17]/retroceder.jpg"));
        retroceder.setBackground(Color.black);
        retroceder.setBorder(null);
        pausar = new JButton();
        pausar.addActionListener(this);
        pausar.setActionCommand("pausar");
        pausar.setIcon(new ImageIcon("F:/[FAT32]/[005B17]/pausar.jpg"));
        pausar.setBackground(Color.black);
        pausar.setBorder(null);
        correr = new JButton();
        correr.addActionListener(this);
        correr.setActionCommand("correr");
        correr.setIcon(new ImageIcon("F:/[FAT32]/[005B17]/correr.jpg"));
        correr.setBackground(Color.black);
        correr.setBorder(null);
        reiniciar = new JButton();
        reiniciar.addActionListener(this);
        reiniciar.setActionCommand("reiniciar");
        reiniciar.setIcon(new ImageIcon("F:/[FAT32]/[005B17]/reiniciar.jpg"));
        reiniciar.setBackground(Color.black);
        reiniciar.setBorder(null);
        mp3 = new Reloj();
        PanelB.add(retroceder);
        PanelB.add(avanzar);
        PanelB.add(correr);
        PanelB.add(pausar);
        PanelB.add(reiniciar);
        PanelB.add(ajustar);
        retroceder.setEnabled(false);
        correr.setEnabled(false);
        pausar.setEnabled(false);
        //ajustar.setEnabled(false);
        reiniciar.setEnabled(false);
        PanelText.add(heure);
        heure.setEnabled(false);
        minute.setEnabled(false);
        second.setEnabled(false);
        PanelText.add(punto1);
        PanelText.add(minute);
        PanelText.add(punto2);
        PanelText.add(second);
        this.getContentPane().setLayout(new BorderLayout(5, 5));
        this.getContentPane().add(PanelText, BorderLayout.NORTH);
        this.getContentPane().add(PanelB, BorderLayout.SOUTH);
        this.getContentPane().setBackground(Color.black);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("avanzar")) {
            if (heure.getText().equals("00") && minute.getText().equals("00") && second.getText().equals("00")) {
                retroceder.setEnabled(false);
            } else {
                retroceder.setEnabled(true);
            }
            avanzar.setEnabled(false);
            correr.setEnabled(true);
            pausar.setEnabled(true);
            ajustar.setEnabled(true);
            reiniciar.setEnabled(true);
        } else if (e.getActionCommand().equals("retroceder")) {
            avanzar.setEnabled(true);
            retroceder.setEnabled(false);
            correr.setEnabled(true);
            pausar.setEnabled(true);
            ajustar.setEnabled(true);
            reiniciar.setEnabled(true);
        }

        if (e.getActionCommand().equals("correr")) {
            correr.setEnabled(false);
            pausar.setEnabled(true);
            reiniciar.setEnabled(false);
            ajustar.setEnabled(false);
            if (avanzar.isEnabled()) {
                mp3.getH().setValor(Integer.parseInt(heure.getText()));
                mp3.getM().setValor(Integer.parseInt(minute.getText()));
                mp3.getS().setValor(Integer.parseInt(second.getText()));
                Retro(mp3);

            } else {
                mp3.getH().setValor(Integer.parseInt(heure.getText()));
                mp3.getM().setValor(Integer.parseInt(minute.getText()));
                mp3.getS().setValor(Integer.parseInt(second.getText()));
                Correr(mp3);
                retroceder.setEnabled(true);
//boolean equals = e.getActionCommand().equals("avanzar");
            }
        }

        if (e.getActionCommand().equals("pausar")) {
            Paus(mp3);
            correr.setEnabled(true);
            pausar.setEnabled(false);
            reiniciar.setEnabled(true);
            ajustar.setEnabled(true);
        }

        if (e.getActionCommand().equals("reiniciar")) {
            retroceder.setEnabled(true);
            avanzar.setEnabled(true);
            correr.setEnabled(false);
            pausar.setEnabled(false);
            ajustar.setEnabled(false);
            reiniciar.setEnabled(false);
            mp3.reiniciar();
            heure.setText(Integer.toString(mp3.getH().getValor()));
            minute.setText(Integer.toString(mp3.getM().getValor()));
            second.setText(Integer.toString(mp3.getS().getValor()));
        }

        if (e.getActionCommand().equals("ajustar")) {
            if (contador == 0) {
                heure.setEnabled(true);
                second.setEnabled(true);
                minute.setEnabled(true);
                retroceder.setEnabled(false);
                avanzar.setEnabled(false);
                correr.setEnabled(false);
                pausar.setEnabled(false);
                ajustar.setEnabled(true);
                reiniciar.setEnabled(false);
                contador++;
            } else {
                contador = 0;
                avanzar.setEnabled(true);
                correr.setEnabled(false);
                pausar.setEnabled(false);
                reiniciar.setEnabled(false);
                heure.setEnabled(false);
                second.setEnabled(false);
                minute.setEnabled(false);
                if (heure.getText().equals("0") & minute.getText().equals("0") & second.getText().equals("0")) {
                    retroceder.setEnabled(false);
                } else {
                    retroceder.setEnabled(true);
                }
                mp3.getH().setValor(Integer.parseInt(heure.getText()));
                mp3.getM().setValor(Integer.parseInt(minute.getText()));
                mp3.getS().setValor(Integer.parseInt(second.getText()));
            }

        }

    }

    //class Temporizador {
    public Timer t;

//        public void Temporizador() {
//            this.t = new Timer();
//        }
    public void Correr(Reloj cr) {
        this.t = new Timer();
        this.t.schedule(new tarea(mp3, 1), 0, 1000);
    }

    public void Paus(Reloj cr) {
        this.t.cancel();
        this.t.purge();
    }

    public void Retro(Reloj cr) {
        this.t = new Timer();
        this.t.schedule(new tarea(mp3, 2), 0, 1000);
    }

    class tarea extends TimerTask {

        Reloj mp3;
        int i;

        tarea(Reloj mp3, int i) {
            this.mp3 = mp3;
            this.i = i;
        }

        @Override
        public void run() {
            if (i == 1) {
                mp3.avanzar();
                heure.setText(Integer.toString(mp3.getH().getValor()));
                minute.setText(Integer.toString(mp3.getM().getValor()));
                second.setText(Integer.toString(mp3.getS().getValor()));
            } else if (i == 2) {
                mp3.retroceder();
                heure.setText(Integer.toString(mp3.getH().getValor()));
                minute.setText(Integer.toString(mp3.getM().getValor()));
                second.setText(Integer.toString(mp3.getS().getValor()));
                if (heure.getText().equals("0") && minute.getText().equals("0") && second.getText().equals("0")) {
                    Paus(mp3);
                }

            }
        }

    }
}
//}
