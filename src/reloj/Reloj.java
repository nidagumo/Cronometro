package reloj;

import java.awt.GraphicsEnvironment;
import java.util.Arrays;
import java.util.Scanner;
import sun.applet.Main;

public class Reloj {

    public Segundo getS() {
        return s;
    }

    public void setS(Segundo s) {
        this.s = s;
    }

    public Minuto getM() {
        return m;
    }

    public void setM(Minuto m) {
        this.m = m;
    }

    public Hora getH() {
        return h;
    }

    public void setH(Hora h) {
        this.h = h;
    }

    public void avanzar() {
        s.avanzar();
        if (s.getValor() == 0) {
            m.avanzar();
            if (m.getValor() == 0) {
                h.avanzar();
            }
        }
    }

    public void retroceder() {
        s.retroceder();
        if (s.getValor() == s.getLimite() - 1) {
            m.retroceder();
            if (m.getValor() == m.getLimite() - 1) {
                h.retroceder();
            }
        }
    }

    public void reiniciar() {
        s.reiniciar();
        m.reiniciar();
        h.reiniciar();
    }

    public void ajustar(int se, int mi, int ho) {
        s.setValor(se);
        m.setValor(mi);
        h.setValor(ho);
    }

    public static void main(String[] args) {
        new CronoGUI();
        System.out.println("avanzar");
        //String[] fontNames=GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        //System.out.println(Arrays.toString(fontNames));
    }
    private Segundo s = new Segundo();

    private Minuto m = new Minuto();

    private Hora h = new Hora();

}
