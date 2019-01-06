/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Enunciado;

/**
 *
 * @author cliente preferencial
 */
public class Principal
{
    private static GestorDeTarjetas t;
    private static BEG beg;
    private static TarjetasConCarga tC;

    public static void main(String[] args)
    {
        System.out.println("Cantidad de personas que suben al colectivo: ");
        int cant1= Consola.readInt();
        t = new GestorDeTarjetas(cant1);
       
        Tarjetas tar = null;
        Tarjetas tar1 = null;
        //BEG beg;
        //TarjetasConCarga tC;
        int tipo;
        int op, cant, cant2;
        boolean ver;
        Dibujante d=new Dibujante();
        
        do
        {
            System.out.println("1. Cargar tarjetas");
            System.out.println("2. Mostrar todo");
            System.out.println("3. Cantidad de tarjetas en el vector");
            System.out.println("4. Contiene tarjetas de un solo tipo? ");
            System.out.println("5. Tarjetas disponibles (Consola Grafica)");

            System.out.println("6. Salir");
            System.out.print("\t\tIngrese: ");
            op = Consola.readInt();
            switch(op)
            {
                case 1:
                        cargarTarjetas();
                        break;

                case 2:
                        System.out.println(t);
                        break;

                case 3:
                 
                        tC = new TarjetasConCarga();
                        cant = t.conteo(tC);
                        System.out.println("Cantidad de tarjetas con carga: " + cant);
                        
                        beg=new BEG();
                        cant2 = t.conteo(beg);
                        
                        System.out.println("Cantidad de boletos educativos gratuitos: " + cant2);
                     
                        
                        break;
                       
                case 4:
                        
                        do{
                        System.out.println("Ingrese 1 si es Tarjeta con carga o 2 si es Bono Educativo Gratuito: ");
                        tipo = Consola.readInt();
                        }while(tipo!=1 && tipo!=2);
                        if ( tipo == 1 ) tar = new TarjetasConCarga();
                        else tar=new BEG();
                        ver= t.verificacion(tar);

                        if(ver==true)
                            System.out.println("SI, son del mismo tipo");
                        else
                            System.out.println("NO, son diferentes");

                        break;

                case 5:
                        //tC= new TarjetasConCarga();
                        cant = t.conteo(tC);
                        System.out.println("Cantidad de tarjetas con carga: " + cant);

                        //beg=new BEG();
                        cant2 = t.conteo(beg);
                        
                        System.out.println("Cantidad de boletos educativos gratuitos: " + cant2);
                        //t.graficar(cant, cant2, tC, beg);
                        d.dibujar(t);
                        break;

                case 6: 
                    System.out.println("Chau chau");
                    break;
                default:
                    System.out.println("Error");
            }
        
        }while (op!=6);
        System.exit(0);

    }

    public static void cargarTarjetas()
    {
        int n = t.getCantidad();
        Tarjetas tar;
       //TarjetasConCarga tC;
       //BEG beg;
        int tipo;
        for(int i = 0; i < n; i++)
        {
            System.out.println("_____Tarjeta "+i+"_____");
            System.out.print("Numero de Serie: ");
            int numS = Consola.readInt();

            System.out.print("Numero de DNI: ");
            int numD = Consola.readInt();

            do{
                System.out.print("Ingrese 1 si es Tarjeta con carga o 2 si es Bono Educativo Gratuito: ");
                tipo = Consola.readInt();
            } while (tipo!=1 && tipo!=2);

            if ( tipo == 1 )
            {
                System.out.print("Importe: ");
                int imp = Consola.readInt();
                tC = new TarjetasConCarga(numS, numD, imp);
                t.setTarjetas(tC, i);
                
            }
            else
            {
                System.out.print("Numero de viajes: ");
                int numV = Consola.readInt();
                beg = new BEG(numS, numD, numV);
                t.setTarjetas(beg, i);
            }

            
        }
    }

    
}
