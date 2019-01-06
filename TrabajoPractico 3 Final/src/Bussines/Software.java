/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bussines;

/**
 *
 * @author Cordi Eugenio - Carrazana Pablo
 */
public class Software implements Comparable {

    private int codigo;
    private float importe;
    private String nombre;
    private int tipo;

    /**
     * Costructor con parametros Inicializa los atributos
     *
     * @param codigo
     * @param importe
     * @param nombre
     * @param tipo
     */
    public Software(int codigo, float importe, String nombre, int tipo) {
        this.codigo = codigo;
        this.importe = importe;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    /**
     * Accede al valor de el codigo
     *
     * @return el valor de Codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Modifica el valor de el codigo
     *
     * @param codigo nuevo valor de el codigo
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * Accede al valor de el importe
     *
     * @return el valor de el importe
     */
    public float getImporte() {
        return importe;
    }

    /**
     * Modifica el valor de el importe
     *
     * @param importe nuevo valor de el importe
     */
    public void setImporte(float importe) {
        this.importe = importe;
    }

    /**
     * Accede al valor de el NOmbre
     *
     * @return el valor de el nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Modifica el valor de el Nombre
     *
     * @param nombre nuevo valor de el nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Accede al valor de el tipo
     *
     * @return el valor de el tipo
     */
    public int getTipo() {
        return tipo;
    }

    /**
     * Modifica el valor de el tipo
     *
     * @param tipo nuevo valor de el tipo
     */
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    /**
     * Compara el objeto tomado por parametro con el atributo propio de Software
     *
     * @param x
     * @return un entero, cero o un negativo dependiendo si es menor, igual o
     * mayor  que el codigo del software tomado por parametro
     */
    public int compareTo(Object x) {
        Software so = (Software) x;
        return this.codigo - so.codigo;
    }

    /**
     * Crea una cadena simple de cada uno de los valores finales de los
     * atributos
     *
     * @return conversion a string de un Software
     */
    @Override
    public String toString() {
        return "Software: " + "codigo=" + codigo
                + ", importe=" + importe
                + ", nombre=" + nombre
                + ", tipo=" + tipo + '}';
    }
}
