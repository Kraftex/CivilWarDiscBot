/**
 * DescriptionOfTheProgram.
 * Resolucion del problema 'Bando'.
 * 
 * @author Julian C. Giraldo
 * @since 22/06/2019
 * @version 1.0 22/06/2019
 * */

public class Bando // Posible clase sin sentido...
// Posible sustitucion en Zona poniendole los 'estaticos'
{
    public static final int ALEJANDRISTAS = 1;
    public static final int PLUTOCRATAS = 0;

    private int team;

    public Bando ( int team )
    {
        this.team = team;
    }
    public int getTeam ( )
    {
        return team;
    }
    public String toString ( )
    {
        if ( team == ALEJANDRISTAS )
            return "Alegandrista";
        else
            return "Plutocratas";
    }
}
