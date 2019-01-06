/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Enunciado;
import java.awt.*;
/**
 *
 * @author cliente preferencial
 */
public class GestorDeTarjetas
{
    private Tarjetas v[];
    private TarjetasConCarga tC;
    private BEG beg;


    public GestorDeTarjetas()
    {
        v= new Tarjetas[2];
    }

    public GestorDeTarjetas(int n)
    {
        if(n<=0) n=2;
        v= new Tarjetas[n];
    }

    public int getCantidad()
    {
        return v.length;
    }

    public Tarjetas getTarjetas( int i )
    {
        Tarjetas x = null;
        if ( i >= 0  && i < v.length ) x = v[i];
        return x;
    }

    public void setTarjetas(Tarjetas t, int i)
    {
        if (t != null && i >= 0  && i < v.length) v[i] = t;
    }

    public int conteo ( Tarjetas tar )
    {
        int c = 0;
        if ( tar != null )
        {
            for ( int i = 0; i < v.length; i++)
            {
                if ( tar.getClass() == v[i].getClass() ) c++;


            }
        }
        return c;
    }

    public boolean verificacion ( Tarjetas tar )
    {
        boolean c = true;
        if ( tar != null )
        {
            for ( int i = 0; i < v.length; i++)
            {
                if ( tar.getClass() != v[i].getClass()) c=false;


            }
        }
        return c;
    }



    public void graficar( int conteo, int conteo1, TarjetasConCarga tC, BEG bg)
    {
       int n[]= new int[2];
       n[0]=conteo;
       
       n[1]=conteo1;


        // máxima altura en pixels que se permitirá a cada barra...
        int altura=90;

        int piso = altura + 50;  // fila donde aparecerán dibujadas TODAS las barras
        int texto = piso + 50;  // fila donde comenzarán a desplegarse los mensajes de texto aclaratorios
        int ancho = 150;  // ancho de todas las barras a dibujar
        int col = 50;    // columna izquierda de la primera barra
        int gap = 50;    // separación entre barras
        int gap1=50;

        // vector para almacenar las alturas de las barras...
        

        // calculamos las alturas, en proporción al conteo de cada área...
      

        // y ahora, a graficar...
        GraphicsConsole c = GraphicsConsole.getInstance();
        c.setBounds( 250, 50, 8 * (ancho + gap), 550);
        c.setVisible( true );
        c.clear();


        // título principal del gráfico
        c.setFont( new Font( "TimesRoman", Font.BOLD, 24 ) );
        c.setColor( Color.blue );
        c.drawString("Cantidad de Tarjetas de cada tipo", 50, 35 );

        // un vector con los colores disponibles para las 7 barras
        Color cs[] = { Color.CYAN};
        Color cs1[] = { Color.BLUE};

        // despliegue del gráfico, barra por barra
        
        
        for( int i = 0; i < n[0]; i++ )
        {
            tC= new TarjetasConCarga();
            int alto = altura; // altura de la barra que se está dibujando
            int fil = piso - alto;  // fila superior de la barra que se está dibujando

            // seleccionamos el color i para la barra que se está por dibujar
            c.setColor( Color.CYAN );

            // dibujamos la barra
            c.fillRect( col, fil, ancho, alto );
/*
            // fuente para los mensajes aclaratorios
            c.setFont( new Font( "Arial", Font.BOLD, 12 ) );

            // mensaje de texto aclaratorio para esa barra
            c.drawString( "Cantidad de Tarjetas tipo " + i + ": " + conteo, 50, texto );

            // fila para la línea de texto del próximo mensaje
            FontMetrics fm = c.getFontMetrics();
            texto += fm.getDescent() + fm.getAscent() + 10;
 * 
 */

            // ajustamos la columna izquierda para la próxima barra
            //col += ( ancho + gap );
            //if(t instanceof TarjetasConCarga)
            //{
            
            c.setFont( new Font( "Arial", Font.BOLD, 12 ) );

            // mensaje de texto aclaratorio para esa barra
           c.drawString( "Dni " + ": " + tC.getNumeroDeDNI(), 50, texto );
           FontMetrics fm = c.getFontMetrics();
            texto += fm.getDescent() + fm.getAscent() + 10;

           c.drawString( "Serie " + ": " + tC.getNumeroDeSerie(), 50, texto );
           fm = c.getFontMetrics();
            texto += fm.getDescent() + fm.getAscent() + 10;

           c.drawString( "Importe " + ": " + tC.getImporte(), 50, texto );
           fm = c.getFontMetrics();
            texto += fm.getDescent() + fm.getAscent() + 10;


          
            // fila para la línea de texto del próximo mensaje
           
            //c.drawString( "Serie " + ": " + t.getNumeroDeSerie(), 50, texto );
            //}
        }
        // fuente para los mensajes aclaratorios
            c.setFont( new Font( "Arial", Font.BOLD, 12 ) );

            // mensaje de texto aclaratorio para esa barra
            c.drawString( "Cantidad de Tarjetas BEG " + ": " + conteo, 200, texto );

            // fila para la línea de texto del próximo mensaje
            FontMetrics fm = c.getFontMetrics();
            texto += fm.getDescent() + fm.getAscent() + 10;

        for( int i = 0; i < n[1]; i++ )
        {
        
            int alto = altura; // altura de la barra que se está dibujando
            int fil = piso - alto;  // fila superior de la barra que se está dibujando

            // seleccionamos el color i para la barra que se está por dibujar
            c.setColor( Color.BLUE );

            // dibujamos la barra
            c.fillRect( col, fil, ancho, alto );

            // fuente para los mensajes aclaratorios
            /*
            c.setFont( new Font( "Arial", Font.BOLD, 12 ) );

            // mensaje de texto aclaratorio para esa barra
            c.drawString( "Cantidad de Tarjetas tipo " + i + ": " + conteo1, 50, texto );

            // fila para la línea de texto del próximo mensaje
            fm = c.getFontMetrics();
            texto += fm.getDescent() + fm.getAscent() + 10;
             *
             */

            // ajustamos la columna izquierda para la próxima barra
            //col += ( ancho + gap );
            piso+= (altura + gap1);
        }
            // fuente para los mensajes aclaratorios
            c.setFont( new Font( "Arial", Font.BOLD, 12 ) );

            // mensaje de texto aclaratorio para esa barra
            c.drawString( "Cantidad de Tarjetas con Carga " + ": " + conteo1, 200, texto );

            // fila para la línea de texto del próximo mensaje
            fm = c.getFontMetrics();
            texto += fm.getDescent() + fm.getAscent() + 10;
    }
    
    @Override
    public String toString()
    {
         String r = "\nTarjetas:\n\t";
         
        for (int i = 0; i < v.length; i++)
        {
            if ( v[i] != null ) r += i+") " +( v[i].toString() + "\n\t" );
            
        }
        return r;
    }
}
