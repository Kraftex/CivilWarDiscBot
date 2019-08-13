/**
 * DescriptionOfTheProgram.
 * Resolucion del problema 'Zona'.
 * 
 * @author Julian C. Giraldo
 * @since 22/06/2019
 * @version 1.0 22/06/2019
 * */

/**
 * No se que comentar.
 * */

public class Zona
{
    public static Zona NULL = new Zona( "", new Bando(-1) );
    private Bando team;
    private String position;
    private int battleLevels;

    public Zona ( String position, Bando team )
    {
        this.position = position;
        this.team = team;
        battleLevels = 0;
    }
    public Zona ( String position, Bando team, int bL ) // Constructor sin sentido...
    {
        this.position = position;
        this.team = team;
        battleLevels = bL;
    }

    public void setBattleLevels ( int n )
    {
        battleLevels = n;
    }
    public int getBattleLevels ( )
    {
        return battleLevels;
    }
    public String getPosition ( )
    {
        return position;
    }
    public void setBando ( Bando b )
    {
        team = b;
    }
    public Bando getBando ( )
    {
        return team;
    }
    public void showBattleLevels ( )
    {
        // IDK... System.out.println( position + ": " + battleLevels );
    }
    public String toString ( )
    {
        if ( position.equals("") )
            return "(): null[]";
        else
            return "("+position+"): "+team+"["+battleLevels+"]";
    }
}
