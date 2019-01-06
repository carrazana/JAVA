/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Enunciado;

/**
 *
 * @author cliente preferencial
 */
public class Tarjetas
{
    private int numeroDeSerie;
    private int numeroDeDNI;

    public Tarjetas() {
    }

    public Tarjetas(int numeroDeSerie, int numeroDeDNI) {
        this.numeroDeSerie = numeroDeSerie;
        this.numeroDeDNI = numeroDeDNI;
    }



    public int getNumeroDeDNI() {
        return numeroDeDNI;
    }

    public void setNumeroDeDNI(int numeroDeDNI) {
        this.numeroDeDNI = numeroDeDNI;
    }

    public int getNumeroDeSerie() {
        return numeroDeSerie;
    }

    public void setNumeroDeSerie(int numeroDeSerie) {
        this.numeroDeSerie = numeroDeSerie;
    }

    public void descontarViaje()
    {

    }



    @Override
    public String toString()
    {
        return "Numero de serie: " + numeroDeSerie + " Numero de DNI: " + numeroDeDNI;
    }


}
