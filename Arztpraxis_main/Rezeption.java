
/**
 * Write a description of class Rezeption here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rezeption
{
    private String log;
    private Arzt pArzt;
    private Wartezimmer wartezimmer[];
    /**
     * Constructor for objects of class Rezeption
     */
    public Rezeption(int wartezimmera,int behandlungszimmer,int wartezimmerplätze)
    {
        wartezimmer =new Wartezimmer[wartezimmera];
        for(int i = 0;i< wartezimmera;i++){

            wartezimmer[i] = new Wartezimmer(wartezimmerplätze);

        }

    }

    public void neuerPatient()
    {
        Patient a = new Patient();
        for(int i = 0;i<wartezimmer.length;i++){
            if (wartezimmer[i].platzFrei())
            {
                wartezimmer[i].hinzufügen(a);
                log = log + "Neuer Patient in Wartezimmer " + i+ "hinzugefügt";
                break;
            }
        }

    }

    public void bewegeArzt(Raum a)
    {
        pArzt.setWo(a);

    }
}
