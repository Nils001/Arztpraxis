
/**
 * Write a description of class Behandlungsraum here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Behandlungsraum extends Raum
{
    private boolean hatArzt;

    public Behandlungsraum()
    {

    }

    private void mussR�ntgen()
    {
        a.brauchR�ntgen = true;
    }

    private void diagnoseStellen()
    {
        a.setDiagnose();
    }
}
