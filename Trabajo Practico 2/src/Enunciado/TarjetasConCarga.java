/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Enunciado;

/**
 *
 * @author cliente preferencial
 */
public class TarjetasConCarga extends Tarjetas
{
    private int importe;

    public TarjetasConCarga() {
    }



    public TarjetasConCarga(int numeroDeSerie, int numeroDeDNI, int importe)
    {
        super(numeroDeSerie, numeroDeDNI);
        this.importe = importe;
    }



    public int getImporte() {
        return importe;
    }

    public void setImporte(int importe) {
        this.importe = importe;
    }


    @Override
    public void descontarViaje()
    {
        double imp=getImporte();
        if(imp>=3.20)
        {
            imp=imp-3.20;
        }
        else
            System.out.println("Se ha quedado sin credito");
    }

    @Override
    public String toString()
    {
        return super.toString() + " Importe: " + importe;
    }



}
