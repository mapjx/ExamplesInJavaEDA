/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolBinarioGraficoBasicoGUI;

import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Maximo Paute
 */
public class Interfaz extends JPanel {

    private ArbolBinarioGraficoBasicoGUI arbol;
    public static final int d = 30;
    public static final int r = d / 2;
    public static final int a = 50;

    public ArbolBinarioGraficoBasicoGUI setArbol(ArbolBinarioGraficoBasicoGUI arbol) {
        this.arbol = arbol;
        repaint();
        return this.arbol;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        pintar(g, getWidth() / 2, 30, arbol.getRaiz());
    }

    private void pintar(Graphics g, int x, int y, Nodo n) {
        if (n == null) {
        } else {
            int extra = n.completos(n) * (a / 2);
            g.drawOval(x, y, d, d);
            g.drawString(Integer.toString(n.dato), x + 10, y + 20);
            if (n.izq != null) {
                g.drawLine(x, y + r, x - a - extra + r, y + a);
            }
            if (n.der != null) {
                g.drawLine(x + (2 * r), y + r, x + a + extra + r, y + a);
            }
            pintar(g, x - a - extra, y + a, n.izq);
            pintar(g, x + a + extra, y + a, n.der);
        }

    }

}
