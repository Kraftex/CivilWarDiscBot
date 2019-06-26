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
            return new Zona( "", new Bando(-1) );
    }
    public Zona getZone ( int i, int j )
    {
        if ( 0 <= i && i < 6 && 0 <= j && j < 5 )
            return mapa.get(i).get(j);
        else
            return new Zona( "", new Bando(-1) );
    }
    public String toString ( )
    {
        int i = 0, j = 0;
        Zona result = new Zona( "", new Bando(-1) );
        while( i < mapa.size( ) )
        {
            while( j < mapa.get(i).size( ) )
            {
                result = getZone( i , j );
                System.out.println(result);
                j++;
            }
            j = 0;
            i++;
        }
        return "";
    }
    public void putBattleLevels ( int levels, int i, int j  )
    {
        putBattleLevels ( levels, getZone(i, j) );
    }
    public void putBattleLevels ( int levels, Zona where )
    {
        getZone(where).setBattleLevels(levels);
    }
}
