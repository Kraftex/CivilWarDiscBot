import java.util.Date;
public class Timer
{
    private long start;

    /**
     * Constructor que inicializa en comienzo del reloj con el tiempo actual en milisegundos.
     * */
    public Timer ( )
    {
        start = System.currentTimeMillis( );
    }

    /**
     * Vuelve a inicializar el reloj.
     * */
    public void restart ( )
    {
        start = System.currentTimeMillis( );
    }

    /**
     * Si han pasado las <h> horas devuelve true.
     * Uso:
     *      Timer t = new Timer( );
     *      while(true)
     *      {
     *          if ( t.isElaspeTimeHours(1) )
     *          {
     *              //Stuff...
     *              t.restart( );
     *          }
     *      }
     * */
    public boolean isElaspeTimeHours ( int h )
    {
        return h <= getElaspeTime( )/(3600*1000);
    }
    /**
     * Si han pasado los <m> minutos devuelve true.
     * */
    public boolean isElaspeTimeMinutes ( int m )
    {
        return m <= getElaspeTime( )/(60*1000);
    }
    /**
     * Si han pasado los <s> segundos devuelve true.
     * */
    public boolean isElaspeTimeSeconds ( int s )
    {
        return s <= getElaspeTime( )/(1000);
    }
    /**
     * Si han pasado <hours>:<minutes>:<seconds> devuelve true.
     * Si <minutes> o <seconds> es mayor o igual que 60, se
     *  transformaran respectivamente en horas y minutos.
     * */
    public boolean isElaspeTime ( int hours, int minutes, int seconds )
    {
        if ( 59 < seconds )
        {
            minutes += seconds / 60;
            seconds = seconds % 60;
        }
        if ( 59 < minutes )
        {
            hours += minutes / 60;
            minutes = minutes % 60;
        }
        return isElaspeTimeHours(hours)
            && isElaspeTimeMinutes(minites)
            && isElaspeTimeSeconds(seconds);
    }
    /**
     * Devuelve en milisegundos la diferencia entre el comienzo o reinicio del reloj
     *  hasta que se ejecuta este metodo.
     * */
    public long getElaspeTime ( )
    {
        return actualTime( ) - start;
    }
    /**
     * Devuelve el tiempo actual en milisegundos.
     * */
    public static long actualTime ( )
    {
        return System.currentTimeMillis( );
    }
    /**
     * Devuelve la hora actual.
     * */
    @SuppressWarnings("deprecation")
    public String toString ( )
    {
        Date that = new Date(start);
        return that.getHours( ) + ":" + that.getMinutes( ) + ":" + that.getSeconds( );
    }
}
