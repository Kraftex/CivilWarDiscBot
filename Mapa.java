/**
 * DescriptionOfTheProgram.
 * Resolucion del problema 'Mapa'.
 * 
 * @author Julian C. Giraldo
 * @since 22/06/2019
 * @version 1.0 22/06/2019
 * */

import java.io.File;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class Mapa
{
    public static final Color COLOR_ALEJ = new Color( 255, 203, 141, 190 );
    public static final Color COLOR_PLUT = new Color( 167, 248, 230, 190 );
    private ArrayList<ArrayList<Zona>> mapa;
    private BufferedImage orgMap; // Original Map
    private BufferedImage paintMap; // Map with colors
    //private Graphics2D drawing;

    public Mapa ( )//String nameFile )
    {
        //photoMap = ImageIO.read( new File(nameFile) );
        int i = 0;
        int j = 0;
        mapa = new ArrayList<>( );
        while( i < 6 )
        {
            mapa.add( new ArrayList<Zona>( ) );
            while( j < 5 )
            {
                if ( i < 3 )
                    mapa.get(i).add( new Zona( (char)( i + 'a' ) + "" + (j+1), new Bando( Bando.ALEJANDRISTAS ) ) );
                else
                    mapa.get(i).add( new Zona( (char)( i + 'a' ) + "" + (j+1), new Bando( Bando.PLUTOCRATAS ) ) );
                j++;
            }
            i++;
            j = 0;
        }
    }
    public Mapa ( String nameFile )
    {
        this( );
        try {
            paintMap = ImageIO.read( new File(nameFile) );
        }
        catch( Exception e )
        {
            System.out.println("Not found: "+nameFile);
        }
    }
    public void setBando ( int i, int j, Bando team )
    {
        getZone(i, j).setBando(team);
    }
    public Zona getZone ( Zona zone )
    {
        boolean find = false;
        int i = 0, j = 0;
        Zona result = new Zona( "", new Bando(-1) );
        while( i < mapa.size( ) && !find )
        {
            while( j < mapa.get(i).size( ) && !find )
            {
                if ( (result = getZone( i , j )).getPosition( ).equals( zone.getPosition( ) ) )
                {
                    find = true;
                    //System.out.println(result);
                    //result = 
                }
                //System.out.println(result);
                j++;
            }
            j = 0;
            i++;
        }
        if (find)
            return result;
        else
            return Zona.NULL;
    }
    /**
     * x in [0, 4]
     * y in [0, 5]
     * */
    public Zona getZone ( int x, int y )
    {
        if ( 0 <= y && y < 6 && 0 <= x && x < 5 )
            return mapa.get(y).get(x);
        else
            return Zona.NULL;
    }
    public String toString ( )
    {
        int i = 0, j = 0;
        String result = "";
        //Zona result = new Zona( "", new Bando(-1) );
        while( j < mapa.size( ) )
        {
            while( i < mapa.get(i).size( ) )
            {
                result += getZone( i , j ) + " - ";
                //System.out.println(result);
                i++;
            }
            result += "\n";
            i = 0;
            j++;
        }
        return result;
    }
    public void putBattleLevels ( int levels, int x, int y  )
    {
        putBattleLevels ( levels, getZone( x, y ) );
    }
    public void putBattleLevels ( int levels, Zona where )
    {
        getZone(where).setBattleLevels(levels);
    }
    
    
    public void setPhotoMap ( BufferedImage image )
    {
        paintMap = image;
    }
    /*public void setZoneColor ( Color color, Zone where )
    {
        setZoneColor(color, where.getPosition( ).charAt(0)-'a', where.getPosition( ).charAt(1)-'0' );
    }
    public void setZoneColor ( Color color, int i, int j )
    {
        
    }*/
    public void setZoneColor ( Graphics2D draw, Color color, int x, int y, double xLZone, double yLZone )
    {
        draw.setColor(color);
        draw.fill(new Rectangle2D.Double(x*xLZone, y*yLZone, xLZone, yLZone) );
        draw.setColor(Color.BLACK);
    }
    public void setMapColor ( Graphics2D draw, double xLZone, double yLZone )
    {
        int i = 0, j = 0;
        while( j < 6 )
        {
            while( i < 5 )
            {
                //setZoneColor();
                if ( getZone(i, j).getBando( ).equals(Bando.ALEJ) )
                    setZoneColor(draw, COLOR_ALEJ, i, j, xLZone, yLZone);
                else
                    setZoneColor(draw, COLOR_PLUT, i, j, xLZone, yLZone);
                i++;
            }
            i = 0;
            j++;
        }
    }
    @SuppressWarnings("deprecation")
    public static void main ( String[] args )
    {
        JFrame frame = new JFrame("Mapa Visual");
        Mapa map = new Mapa("img/mapa.png");
        int width = map.paintMap.getWidth();
        int height = map.paintMap.getHeight();
        double ratio =  (height+0.0)/width;
        int widthScale = 1000;
        int heightScale = (int)(1000*ratio);
        double xLZone = widthScale/5;
        double yLZone = heightScale/6;
        BufferedImage newMap = new BufferedImage(1000, (int)Math.round(1000*ratio), BufferedImage.TYPE_INT_ARGB);
        Graphics2D drawing = newMap.createGraphics( );
        
        drawing.setColor(Color.BLACK);
        drawing.setStroke( new BasicStroke( 1.2f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND ) );
        drawing.drawImage(map.paintMap, 0, 0, 1000, (int)Math.round(1000*ratio), null);
        //drawing.fillRect(0, 0, widthScale/3, heightScale/2);
        map.setMapColor(drawing, xLZone, yLZone);
        for( int i = 0; i < 6-1; i++ )// y
        {
            //newMap.getGraphics( ).drawLine( 0, (int)(yLZone + yLZone*i), width, (int)(yLZone + yLZone*i) );
            drawing.draw( new Line2D.Double( 0, yLZone + yLZone*i, width, yLZone + yLZone*i ) );
        }
        for ( int j = 0; j < 5-1; j++ )// x
        {
            drawing.drawLine( (int)(xLZone+xLZone*j), 0, (int)(xLZone+xLZone*j), height );
        }
        /*map.setZoneColor(drawing, COLOR_PLUT, 0, 0, xLZone, yLZone);
        map.setZoneColor(drawing, COLOR_PLUT, 0, 5, xLZone, yLZone);
        map.setZoneColor(drawing, COLOR_PLUT, 4, 5, xLZone, yLZone);
        map.setZoneColor(drawing, COLOR_PLUT, 3, 3, xLZone, yLZone);*/
        //map.setBando(4, 5, Bando.ALEJ);
        //map.setMapColor(drawing, xLZone, yLZone);
        JLabel image = new JLabel( new ImageIcon(newMap) );
        frame.setSize( 1000, (int)Math.round(1000*ratio)+30 );
        frame.getContentPane( ).add(image);
        frame.show( );
        //map.photoMap.getHeight();
    }
}
