
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
    private Behandlungsraum behandlungszimmer[];
    private Queue ankunft;
    private Queue abgang;
    /**
     * Constructor for objects of class Rezeption
     */
    public Rezeption(int wartezimmera,int behandlungszimmera,int wartezimmerplätze)
    {
        ankunft = new Queue();
        abgang = new Queue();
        wartezimmer =new Wartezimmer[wartezimmera];
        behandlungszimmer = new Behandlungsraum[behandlungszimmera];
        for(int i = 0;i< wartezimmera;i++){

            wartezimmer[i] = new Wartezimmer(wartezimmerplätze);

        }
        for (int i = 0;i<behandlungszimmera;i++)
        {
            behandlungszimmer[i]= new Behandlungsraum();

        }
    }

    public void neuerPatient()
    {
        Patient a = new Patient();
        ankunft.enqueue(a);
        log = log + "Patient in Queue Ankunft hinzugefügt \n";
    }

    public void bewegeArzt(Raum a)
    {
        pArzt.setWo(a);
        log = log + "Arzt geht zu Raum" +a+"\n";
    }

    public void queueZuWartezimmer()
    {

        for(int i = 0;i<wartezimmer.length;i++){
            if (wartezimmer[i].platzFrei())
            {
                wartezimmer[i].hinzufügen((Mensch)ankunft.front());
                ankunft.dequeue();
                log = log + "Patient in Wartezimmer " + i+ "hinzugefügt\n";
                break;
            }
        }
    }

    public void wartezimmerZuBehandlungsraum()
    {
        for(int i=0;i<wartezimmer.length;i++)
        {
            if(wartezimmer[i].istBesetzt())
            {
                for(int o = 0;o<behandlungszimmer.length;i++)
                {
                    if(!behandlungszimmer[i].istBesetzt())
                    {
                        behandlungszimmer[i].hinzufügen((Patient)wartezimmer[i].gibErsten());
                        wartezimmer[i].löschen();

                    }

                }
            }
        }
    }

    public void behandlungeräumeLeeren()
    {
        for (int i = 0;i<behandlungszimmer.length;i++)
        {
            Patient a = behandlungszimmer[i].gibPatientUndLöschen();
            abgang.enqueue(a);
            if(a!=null)
            {
                log = log + "Patient  wurde aus Behandlungszimmer " +i+ "geholt und der abgang Queue hinzugefügt\n";
            }
        }
    }

    public void logAusgeben()
    {
        System.out.println(log);

    }
}
