package Enunciado;

import java.awt.Color;
import java.awt.Font;

public class Dibujante
{
    
    public static GraphicsConsole gc;    

    public Dibujante()
    {
        gc= GraphicsConsole.getInstance();
    }
    
    public static void dibujar(GestorDeTarjetas Gestor) //REVISAR
    {
        
        gc.setLocation(50,50);
        gc.setSize(600,600);
        int y=20;
        int x=30;
        int x2=30;
        int x3=55;
        int x4=55;
        int posTx=25;
        int posTy=75;
        int posTy2=75;
        gc.setColor(Color.blue);
        Font f= new Font ("Arial", Font.BOLD, 11);
        gc.setFont(f);
        gc.drawString("Tarjetas", 350, 15);
        
        
          
        for(int i=0; i<Gestor.getCantidad();i++)
        {
            if(Gestor.getTarjetas(i) instanceof TarjetasConCarga)
            {
                gc.setColor(Color.blue);
                gc.fillRect(y,x, 275,75);
                gc.setColor(Color.white);
                gc.drawString("Tarjeta Red Bus ", 120, x3);
                gc.drawString("" +Gestor.getTarjetas(i), posTx, posTy);
                posTy= posTy+95;
                x= x+95;
                x3= x3+95;
            }
        }
        
        
        for(int i=0; i<Gestor.getCantidad();i++)
        {
            if(Gestor.getTarjetas(i) instanceof BEG)
            {
                gc.setColor(Color.orange);
                gc.fillRect(y+295,x2, 250,75);
                gc.setColor(Color.black);
                gc.drawString("Tarjeta Beg", 365, x4);
                gc.drawString("" +Gestor.getTarjetas(i), posTx+295, posTy2);
                posTy2= posTy2+95;
                x2= x2+95;
                x4= x4+95;
            }
        }
        gc.setVisible(true);
    }
}
