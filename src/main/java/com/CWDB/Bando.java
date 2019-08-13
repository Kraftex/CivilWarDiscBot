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
    public static final Bando ALEJ = new Bando(ALEJANDRISTAS);
    public static final Bando PLUT = new Bando(PLUTOCRATAS);

    private int team;

    /**
     * Constructor.
     * Su mejor uso seria: new Bando (Bando.ALEJANDRISTAS)...
     * */
    public Bando ( int team )
    {
        this.team = team;
    }
    /*public int getTeam ( )
    {
        return team;
    }*/
    public boolean equals ( Object o )
    {
        if ( !(o instanceof Bando) )
            return false;
        Bando b = (Bando)o;
        return b.team == team;
    }
    public String toString ( )
    {
        if ( team == ALEJANDRISTAS )
            return "Alegandrista";
        else
            return "Plutocratas";
    }
}
