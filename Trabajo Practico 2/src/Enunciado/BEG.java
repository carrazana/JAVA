/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Enunciado;

/**
 *
 * @author cliente preferencial
 */
public class BEG extends Tarjetas
{
    private int numeroDeViajes;

    public BEG()
    {
    }



    public BEG(int numeroDeSerie, int numeroDeDNI, int numeroDeViajes)
    {
        super(numeroDeSerie, numeroDeDNI);
        this.numeroDeViajes = numeroDeViajes;
    }



    public int getNumeroDeViajes() {
        return numeroDeViajes;
    }

    public void setNumeroDeViajes(int numeroDeViajes) {
        this.numeroDeViajes = numeroDeViajes;
    }

    @Override
    public void descontarViaje()
    {
        int num= getNumeroDeViajes();
        if(num>=1)
        {
            num--;
        }
        else
            System.out.println("No tiene viajes");
    }

    @Override
    public String toString() {
        return super.toString()+ " Numero de viajes: " + numeroDeViajes ;
    }



}
