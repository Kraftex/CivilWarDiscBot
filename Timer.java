import java.util.Date;
public class Timer
{
    private long start;

    public Timer ( )
    {
        start = System.currentTimeMillis( );
    }

    public void restart ( )
    {
        start = System.currentTimeMillis( );
    }

    public boolean isElaspeTimeHours ( int h )
    {
        return h <= getElaspeTime( )/(3600*1000);
    }
    public boolean isElaspeTimeMinites ( int m )
    {
        return m <= getElaspeTime( )/(60*1000);
    }
    public boolean isElaspeTimeSeconds ( int s )
    {
        return s <= getElaspeTime( )/(1000);
    }
    public boolean isElaspeTime ( int hours, int minites, int seconds )
    {
        return isElaspeTimeHours(hours)
            && isElaspeTimeMinites(minites)
            && isElaspeTimeSeconds(seconds);
    }
    public long getElaspeTime ( )
    {
        return actualTime( ) - start;
    }
    public long actualTime ( )
    {
        return System.currentTimeMillis( );
    }
    @SuppressWarnings("deprecation")
    public String toString ( )
    {
        Date that = new Date(start);
        return that.getHours( ) + ":" + that.getMinutes( ) + ":" + that.getSeconds( );
    }
}
