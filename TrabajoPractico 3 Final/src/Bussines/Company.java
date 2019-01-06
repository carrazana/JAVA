/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bussines;

/**
 *
 * @author Cordi Eugenio-Carrazana Pablo
 */
import java.awt.*;

import trabajopractico3.SimpleList;
import trabajopractico3.GraphicsConsole;

public class Company {

    SimpleList l;
    Software s[];

    /**
     * Constructor Default
     */
    public Company() {
        Software s[] = new Software[5];
    }

    /**
     * Crea el vector de Software
     *
     * @param n tamaño del arreglo del tipo Software
     */
    public Company(int n) {
        s = new Software[n];
    }

    /**
     * Modifica cada uno de los companentes dentro del vector tomando como
     * parametro un indice y un Software
     *
     * @param i indice en e cual efectuara la modificacion
     * @param sf el nuevo valor de un software
     */
    public void setSoftware(int i, Software sf) {
        if (s == null) {
            return;
        }
        try {
            s[i] = sf;
        } catch (ArrayIndexOutOfBoundsException e) {
            e.getMessage();
        }
    }

    /**
     * Accede al valor de el del arreglo en la posicion i que se toma por
     * parametro
     *
     * @param i
     * @return el Software que esta en la posicion i
     */
    public Software getSoftware(int i) {

        try {
            return s[i];
        } catch (NullPointerException e) {
            e.getMessage();
            return null;
        }

    }

    /**
     * Accede a la dimencion del arreglo
     *
     * @return s.length valor de el arreglo
     */
    public int length() {
        return s.length;
    }

    /**
     * Crea una lista de acuerdo si los Software tiene un importe mayor a un
     * costo tomado como parametro
     *
     */
    public void CrearLista(float f) {
        if (s != null) {
            l = new SimpleList();
            for (int i = 0; i < s.length; i++) {
                try {
                    if (s[i].getImporte() > f) {
                        l.addInOrder(s[i]);
                    }
                } catch (NullPointerException q) {
                    q.getMessage();
                }
            }
        }

    }

    /**
     * Accede al temaño de la lista
     *
     * @return el tamaño si la lista no esta vacia o -1 en caso contrario
     */
    public int size() {
        if (!l.isEmpty()) {
            return l.size();
        }
        return -1;
    }

    /**
     * Convierte el contenido de la lista en String
     *
     * @return sb.toString el contenido de la lista en formato String
     */
    public String ListaImpresa() {
        StringBuffer sb = new StringBuffer();
        sb.append("Lista: \n");
        for (int i = 0; i < l.size(); i++) {
            Software soft = (Software) l.get(i);

            sb.append(soft + "\n");
        }
        return sb.toString();
    }

    /**
     * Convierte el contenido del arreglo a string mostrando la cantidad de
     * Software's por tipo que se encuentran dentro de la lista
     *
     * @return e.toString la conversion a string de el arreglo
     */
    public String getcantidadPorTipo() {
        int contar[] = new int[10];
        StringBuilder o = new StringBuilder();
        try {
            for (int i = 0; i < l.size(); i++) {

                Software so = (Software) l.get(i);
                contar[so.getTipo()]++;

            }

            o.append("Cantidad de software por tipo");
            for (int i = 0; i < contar.length; i++) {
                o.append("\nTipo: " + i + " Cantidad: " + contar[i]);

            }
        } catch (NullPointerException c) {
            c.getMessage();
        }
        return o.toString();
    }

    /**
     * Invoca el metodo getCantidadPorTipo para pasarle por parametro el arreglo
     * con los valores definitivos al metodo GraficoBarras quien realiza el
     * grafico
     *
     * @return la grafica
     */
    public void GraficarPorTiposBarra() {
        int barra[] = new int[10];
        for (int i = 0; i < l.size(); i++) {
            try {
                Software soft = (Software) l.get(i);
                barra[soft.getTipo()]++;

            } catch (Exception q) {
                q.getMessage();
            }

        }
        GraficoBarras(barra);

    }

    /**
     * Invoca el metodo getCantidadPorTipo para pasarle por parametro el arreglo
     * con los valores definitivos al metodo GraficoCircular quien realiza el
     * grafico
     *
     * @return la grafica
     */
    public void GraficarPorTipoCircular() {
        int circ[] = new int[10];
        for (int i = 0; i < l.size(); i++) {
            try {
                Software soft = (Software) l.get(i);
                circ[soft.getTipo()]++;

            } catch (Exception q) {
                q.getMessage();
            }

        }
        GraficoCircular(circ);

    }

    /**
     * Busca el objeto x en la lista, y en caso de encontrarlo, lo remueve del
     * lugar donde lo encontró y lo reubica al principio de la lista
     *
     * @param x
     * @return retorna true si la operación tuvo éxito, y false en caso
     * contrario.
     */
    public boolean move(Software x) {
        if (!l.isEmpty()) {

            if (l.moveToFront(x)) {
                l.toString();
                return true;
            }

        }

        return false;
    }

    /**
     * Mediante la consola grafica tomando por parametro un arreglo de conteo y
     * con esos valores realiza los graficos correspondiente a cada uno de los
     * tipos en el cargados
     *
     * @param conteo
     * @return un grafico en consola grafica tipo grafico de barras
     */
    public void GraficoBarras(int conteo[]) {
        int n = conteo.length;
// máxima altura en pixels que se permitirá a cada barra...
        int hmax = 200;
        int piso = hmax + 50; // fila donde aparecerán dibujadas TODAS las barras
        int texto = piso + 50; // fila donde comenzarán a desplegarse los mensajes de texto aclaratorios
        int ancho = 30; // ancho de todas las barras a dibujar
        int col = 50; // columna izquierda de la primera barra
        int gap = 50; // separación entre barras
// vector para almacenar las alturas de las barras...
        int h[] = new int[10];
// calculamos las alturas, en proporción al conteo de cada área...
        int suma = 0;
        for (int i = 0; i < n; i++) {
            suma += conteo[i];
        }
        for (int i = 0; i < n; i++) {
            h[i] = (int) (hmax * conteo[i] / suma);
        }
// y ahora, a graficar...
        GraphicsConsole c = GraphicsConsole.getInstance();
        c.setBounds(250, 50, 8 * (ancho + gap), 550);
        c.setVisible(true);
        c.setLocation(0, 0);
        c.setSize(1000, 700);
        c.clear();
// título principal del gráfico
        c.setFont(new Font("TimesRoman", Font.BOLD, 24));
        c.setColor(Color.blue);
        c.drawString("Cantidad de Sistemas de cada tipo", 50, 35);
// un vector con los colores disponibles para las 7 barras
        Color cs[] = {Color.red, Color.green, Color.yellow, Color.blue, Color.orange, Color.magenta, Color.cyan, Color.gray, Color.pink, Color.darkGray};
// despliegue del gráfico, barra por barra
        for (int i = 0; i < n; i++) {
            int alto = h[i]; // altura de la barra que se está dibujando
            int fil = piso - alto; // fila superior de la barra que se está dibujando
// seleccionamos el color i para la barra que se está por dibujar
            c.setColor(cs[i]);
// dibujamos la barra
            c.fillRect(col, fil, ancho, alto);
// fuente para los mensajes aclaratorios
            c.setFont(new Font("Arial", Font.BOLD, 12));
// mensaje de texto aclaratorio para esa barra
            c.drawString("Cantidad de proyectos tipo " + i + ": " + conteo[i], 50, texto);
// fila para la línea de texto del próximo mensaje
            FontMetrics fm = c.getFontMetrics();
            texto += fm.getDescent() + fm.getAscent() + 10;
// ajustamos la columna izquierda para la próxima barra
            col += (ancho + gap);
        }
    }

    /**
     * Mediante la consola grafica tomando por parametro un arreglo de conteo y
     * con esos valores realiza los graficos correspondiente a cada uno de los
     * tipos en el cargados
     *
     * @param conteo
     * @return un grafico en consola grafica tipo grafico circular
     */
    public String GraficoCircular(int conteo[]) {
        GraphicsConsole gc = GraphicsConsole.getInstance();
        gc.setBounds(250, 50, 8 * 200, 550);
        gc.setVisible(true);
        gc.setLocation(0, 0);
        gc.setSize(1000, 700);

        gc.clear();
        int texto = 200;
        gc.setColor(Color.getHSBColor(00, 06, 66));
        String aux = "";
        gc.setFont(new Font("TimesRoman", Font.BOLD, 24));
        gc.setColor(Color.blue);
        gc.drawString("Cantidad de Sistemas de cada tipo", 50, 35);
        for (int i = 0; i < conteo.length; i++) {
            aux += "tipo " + i + ":" + conteo[i] + "\n";
        }
        //grafico
        float angComienzo = 0;
        int total = 0;
        Color colores[] = {Color.red, Color.green, Color.yellow, Color.blue, Color.orange, Color.magenta, Color.cyan, Color.gray, Color.pink, Color.darkGray};
        for (int i = 0; i < conteo.length; i++) {
            total += conteo[i];
        }
        gc.setColor(Color.WHITE);
        gc.fillRect(20, 20, 100, 100);
        if (total != 0) {
            for (int i = 0; i < conteo.length; i++) {
                float c = ((float) conteo[i]) * 360 / total;
                float angFin = angComienzo + c;

                gc.setColor(colores[i]);
                if (i == conteo.length) {
                    c = 360 - angComienzo;
                }
                gc.fillArc(320, 90, 500, 500, (int) angComienzo, (int) c);
                angComienzo += c;
                gc.setFont(new Font("Arial", Font.BOLD, 12));

                // mensaje de texto aclaratorio para esa barra
                gc.drawString("Cantidad de proyectos tipo " + i + ": " + conteo[i], 50, texto);

                // fila para la línea de texto del próximo mensaje
                FontMetrics fm = gc.getFontMetrics();
                texto += fm.getDescent() + fm.getAscent() + 10;
            }
        } else {
            gc.setColor(Color.black);
            gc.drawString("no hay sistemas", 30, 70);
        }
        return aux;
    }

    /**
     * Verifica que se haya generado la Lista
     *
     * @return true si se genero la lista y false en caso contrario
     */
    public boolean ValidacionDeAcceso() {
        try {
            for (int i = 0; i < l.size(); i++) {
                Software si = (Software) l.get(i);
                if (si != null) {
                    return true;
                }
            }
        } catch (NullPointerException e) {
            e.getMessage();
        }
        return false;
    }

    /**
     * Convierte el contenido del arreglo a string mostrando todos los software
     *
     * @return s.toString el arreglo convertido a string
     */
    public String toString() {
        StringBuffer r = new StringBuffer();
        r.append("[");

        for (int i = 0; i < length(); i++) {
            try {

                if (i < length() - 1) {
                    if (s[i] == null) {
                        StringBuilder x = new StringBuilder();

                        x.append("No se encontraron Software cargados");
                        return x.toString();
                    }
                    r.append("\n"+s[i].toString());
                } else {
                    r.append("\n" + s[i].toString() + "]");
                }
            } catch (ArrayIndexOutOfBoundsException ed) {
                ed.getMessage();
            }
        }

        return r.toString();

    }
    public void setVisible(){
GraphicsConsole gc = GraphicsConsole.getInstance();
    
        gc.setVisible(false);
       
       
    }
}
