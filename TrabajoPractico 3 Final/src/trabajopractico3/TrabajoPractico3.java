/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajopractico3;

/**
 *
 * @author Eugenio Cordi- Pablo Carrazana
 *
 */
import Bussines.Company;
import Bussines.Software;
import javax.swing.*;

public class TrabajoPractico3 {

    
    static Company c = new Company();
    static int op = 0, n, cod, cod1, c2, tipo, tipo1, tipo2;
    static Software s;
    static SimpleList l;
    static float costo, costo1, costo2, valor;
    static String nom, nom1, nom2;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        do {

            String ser = JOptionPane.showInputDialog(null, "¿Cuantos Productos?:", "Ingreso", JOptionPane.QUESTION_MESSAGE);
            try {
                if (ser != null) {
                    n = Integer.parseInt(ser);
                }
            } catch (Throwable w) {
                w.getMessage();
                JOptionPane.showMessageDialog(null, "Caracter Invalido Ingrese un Número\n", "Error", JOptionPane.PLAIN_MESSAGE, new ImageIcon("src/Imagenes/w.png"));
                op=0;
            }
        } while (n <= 0);

        c = new Company(n);
        do {
            String o = JOptionPane.showInputDialog(null,
                    "\n1: Cargar datos de los sistemas\n"
                    + "2:Crear un listado de los sistemas\n"
                    + "3:Ver cantidad de sistemas por tipo \n"
                    + "4:Ver la puesta en escena del método moveToFront\n"
                    + "5:Mostrar la cantidad de sistemas gráficamente\n"
                    + "6:Ver todos los datos cargados\n"
                    + "7:Salir\n" + "Ingrese una opción:", "Sus opciones son: ", JOptionPane.PLAIN_MESSAGE);
            try {
                if (o != null) {
                    op = Integer.parseInt(o);
                }
            } catch (Throwable m) {
                   JOptionPane.showMessageDialog(null, "Caracter Invalido Ingrese un Número\n", "Error", JOptionPane.PLAIN_MESSAGE, new ImageIcon("src/Imagenes/w.png"));
                   op=-1;
                   m.getMessage();
            }
            switch (op) {
                case 1:
                    JOptionPane.showMessageDialog(null, "Cargar los Datos\n", "Inicia la Carga de Datos", JOptionPane.PLAIN_MESSAGE, new ImageIcon("src/Imagenes/addData.png"));
                    cargar();
                    JOptionPane.showMessageDialog(null, "Se cargaron correctamente los datos\n", "Fin carga de datos", JOptionPane.PLAIN_MESSAGE, new ImageIcon("src/Imagenes/ok.png"));
                    break;
                case 2:

                    if (c.getSoftware(0) == null) {
                        JOptionPane.showMessageDialog(null, "   No se ha podido generar el listado\n" + " "
                                + " Usted sera redireccionado al Menú", "Error", JOptionPane.PLAIN_MESSAGE, new ImageIcon("src/Imagenes/errorlist.png"));

                        break;

                    }
                    try {
                        String no = JOptionPane.showInputDialog(null, "Ingrese un costo para generar la lista: ", "Buscador", JOptionPane.PLAIN_MESSAGE);
                        if (no != null) {
                            valor = Float.parseFloat(no);
                        }
                    } catch (Exception z) {
                           JOptionPane.showMessageDialog(null, "Caracter Invalido Vuelva a Intentarlo\n", "Error", JOptionPane.PLAIN_MESSAGE, new ImageIcon("src/Imagenes/w.png"));
                        op=0;
                           z.getMessage();
                    }
                    c.CrearLista(valor);
                    if(c.size()>0){
                    JOptionPane.showMessageDialog(null,c.ListaImpresa(), "El Listado se Genero con Éxito", JOptionPane.PLAIN_MESSAGE, new ImageIcon("src/Imagenes/listadook.png"));
                    }else{
                    JOptionPane.showMessageDialog(null, "No hay Softwar´s mayores a ese costo ", "Resultado", JOptionPane.WARNING_MESSAGE);     
                    }
                    break;

                case 3:

                    if (!c.ValidacionDeAcceso()) {
                        JOptionPane.showMessageDialog(null, "Imposible mostrar cantidades por tipos, cargue los datos o genere el listado\n" + " "
                                + "                             Usted sera redireccionado al Menú", "Error", JOptionPane.PLAIN_MESSAGE, new ImageIcon("src/Imagenes/errorlist.png"));

                        break;

                    }
                   
                    JOptionPane.showMessageDialog(null, c.getcantidadPorTipo(), "Listado", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/Imagenes/listado.png"));

                    break;
                case 4:

                    if (!c.ValidacionDeAcceso()) {
                        JOptionPane.showMessageDialog(null, "               El metodo solo es aplicable a una lista cargada.\n Realice la carga de los datos y genere la lista luego vuelva a intentarlo\n"
                                + "                       Usted sera redireccionado al Menú", "Error", JOptionPane.PLAIN_MESSAGE, new ImageIcon("src/Imagenes/error.png"));

                        break;

                    }
                     
                    JOptionPane.showMessageDialog(null, "Buscador","Search",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/Imagenes/search.png"));
                    String f = JOptionPane.showInputDialog(null, "Ingrese el código del Software: ", "Buscador", JOptionPane.PLAIN_MESSAGE);
                    try {
                        if (f != null) {
                            cod1 = Integer.parseInt(f);
                        }
                    } catch (Throwable d) {
                           JOptionPane.showMessageDialog(null, "Caracter Invalido Vuelva a Intentarlo\n", "Error", JOptionPane.PLAIN_MESSAGE, new ImageIcon("src/Imagenes/w.png"));
                        op=0;
                           d.getMessage();
                    }
                    Software r = new Software(cod1, costo2, nom2, tipo2);
                    if(c.size()==1){
                        JOptionPane.showMessageDialog(null, "Es el unico nodo no se pudo reubicar", "No se puede mover", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/Imagenes/estop.png"));
                    }else{
                    if (c.move(r)) {
                        JOptionPane.showMessageDialog(null, "Se reubico satisfactoriamente el Software en la\n" + c.ListaImpresa(), "Resultado", JOptionPane.PLAIN_MESSAGE, new ImageIcon("src/Imagenes/ok.png"));
                    } else {

                        JOptionPane.showMessageDialog(null, "Lo sentimos el Software no ha sido encontrado ", "Resultado", JOptionPane.WARNING_MESSAGE);


                    }
                    }
                    break;

                case 5:

                    if (!c.ValidacionDeAcceso()) {
                        JOptionPane.showMessageDialog(null, " No se detectaron datos cargados\nUsted sera redireccionado al Menú", "Error", JOptionPane.ERROR_MESSAGE, new ImageIcon("src/Imagenes/error.png"));
                        break;

                    }
                    int var = 0;
                    String g = JOptionPane.showInputDialog(null,
                            "\n1-Gráfico de barras"
                            + "\n2-Gráfico Circular "
                            + "\n3-Cerrar Consola grafica"
                            + "\nIngrese una opcion para abrir grafico:", "Estilos de Graficos", JOptionPane.PLAIN_MESSAGE);
                    try{
                    if (g != null) {
                        var = Integer.parseInt(g);
                    }
                    }catch(Exception x){
                    
                        x.getMessage();
                    JOptionPane.showMessageDialog(null, "Caracter Invalido Vuelva a intentarlo\n", "Error", JOptionPane.PLAIN_MESSAGE, new ImageIcon("src/Imagenes/w.png"));
                    op=0;
                    break;
                    }
                    switch (var) {
                        case 1:
                            c.GraficarPorTiposBarra();

                            break;

                        case 2:
                            c.GraficarPorTipoCircular();
                            break;
                        case 3:
                            c.setVisible();
                            break;
                    }
                    break;
                case 6:

                    if (c.getSoftware(0) == null) {
                        JOptionPane.showMessageDialog(null, "       No se ha cargado ningún dato\n"
                                + "   Usted sera redireccionado al Menú", "Error", JOptionPane.PLAIN_MESSAGE, new ImageIcon("src/Imagenes/error.png"));
                        break;

                    }
                    JOptionPane.showMessageDialog(null,"Los datos ingresados son:\n"+ c.toString(),"Datos",JOptionPane.DEFAULT_OPTION,new ImageIcon("src/Imagenes/array.png"));
                    break;
                case 7:
                    int opcion = JOptionPane.showOptionDialog(null, "El Proceso esta a punto finalizar.\n           ¿Qué hacer?", "ADVERTENCIA!", JOptionPane.OK_OPTION,JOptionPane.INFORMATION_MESSAGE,  new ImageIcon("src/Imagenes/estop.png"), new String[]{"Salir", "Cancelar"}, null);
                    if (opcion == 0) {
                        JOptionPane.showMessageDialog(null, "Hasta Pronto", "Saliendo del Sistema", JOptionPane.DEFAULT_OPTION, new ImageIcon("src/Imagenes/adios.png"));
                        System.exit(0);
                    } else {
                        op = 0;
                        break;
                    }
                    break;
                case 8:
                    JOptionPane.showMessageDialog(null, "SUS OPCIONES ESTAN ENTRE 1 Y 7\n\t", "ERROR", JOptionPane.ERROR_MESSAGE);
                    break;

                default:
                    break;
            }
        } while (op != 7);
    }

    public static void cargar() {


        for (int i = 0; i < c.length(); i++) {
            try {
                String no = JOptionPane.showInputDialog(null, "Ingrese El nombre del Software: ", "Ingreso ", JOptionPane.PLAIN_MESSAGE);
                if (no != null) {
                    nom = no;
                }
            } catch (Exception w) {
                  
                  w.getMessage();
                  
            }
            String x = JOptionPane.showInputDialog(null, "Ingrese el código del Software ", "Ingreso ", JOptionPane.PLAIN_MESSAGE);
            try {
                if (x != null) {
                    cod = Integer.parseInt(x);
                }
            } catch (Throwable d) {
                  JOptionPane.showMessageDialog(null, "Caracter Invalido Se cargara un Valor por defecto", "Error", JOptionPane.PLAIN_MESSAGE, new ImageIcon("src/Imagenes/w.png"));
                  
                  d.getMessage();
            cod=1;
            }

            String im = JOptionPane.showInputDialog(null, "Ingrese el importe del Software: ", "Ingreso ", JOptionPane.PLAIN_MESSAGE);
            try {
                if (im != null) {
                    costo = Float.parseFloat(im);
                }
            } catch (Throwable e) {
         JOptionPane.showMessageDialog(null, "Caracter Invalido Se cargara un Valor por defecto\n", "Error", JOptionPane.PLAIN_MESSAGE, new ImageIcon("src/Imagenes/w.png"));
                e.getMessage();
            costo=0.1f;
            }

            do {
                String t = JOptionPane.showInputDialog(null, "Ingrese el tipo de Software (0-9): ", "Ingreso ", JOptionPane.PLAIN_MESSAGE);
                try {
                    if (t != null) {
                        tipo = Integer.parseInt(t);
                    }
                } catch (Throwable f) {
   JOptionPane.showMessageDialog(null, "Caracter Invalido Se cargara un Valor por defecto\n", "Error", JOptionPane.PLAIN_MESSAGE, new ImageIcon("src/Imagenes/w.png"));
                    f.getMessage();
               
                }
            } while (tipo < 0 || tipo > 10);


            s = new Software(cod, costo, nom, tipo);
            c.setSoftware(i, s);

        }
    }
}