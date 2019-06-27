/**
 * DescriptionOfTheProgram.
 * Resolucion del problema 'Mapa'.
 * 
 * @author Julian C. Giraldo
 * @since 22/06/2019
 * @version 1.0 22/06/2019
 * */

import java.util.ArrayList;

public class Mapa
{
    private ArrayList<ArrayList<Zona>> mapa;

    public Mapa ( )
    {
        int i = 0;
        int j = 0;
        mapa = new ArrayList<>( );
        while( i < 6 )
        {
            mapa.add( new ArrayList<Zona>( ) );
            while( j < 5 )
            {
                if ( i < 3 )
                    mapa.get(i).add( new Zona( (char)( i + 'a' ) + "" + j, new Bando( Bando.ALEJANDRISTAS ) ) );
                else
                    mapa.get(i).add( new Zona( (char)( i + 'a' ) + "" + j, new Bando( Bando.PLUTOCRATAS ) ) );
                j++;
            }
            i++;
            j = 0;
        }
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
}
