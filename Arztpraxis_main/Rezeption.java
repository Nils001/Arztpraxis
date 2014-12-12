
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
        log = log + "Patient in Queue Ankunft hinzugefügt  \n";
    }

    public void bewegeArzt()
    {

        int a = pArzt.getWo();
        int b=a;
        log = log + "Arzt ist in Zimmer " +a+"\n" ;
        behandlungszimmer[a].setArzt(false);
        a++;
        if (a == behandlungszimmer.length)
        {
            a=0;
        }

        if(behandlungszimmer[a].istBesetzt())
        {
            pArzt.setWo(a);
            behandlungszimmer[a].setArzt(true);
            behandlungszimmer[a].diagnostizieren();
            log = log + "Arzt geht von Zimmer " +b+" zu Zimmer " +a+ " und diagnostiziert " +behandlungszimmer[a].getpDiagnose().getDiagnose()+"\n"; 
        }
    }

    public void queueZuWartezimmer()
    {
        if (!ankunft.isEmpty()){
            for(int i = 0;i<wartezimmer.length;i++){
                if (wartezimmer[i].platzFrei())
                {
                    wartezimmer[i].hinzufügen((Mensch)ankunft.front());
                    ankunft.dequeue();
                    log = log + "Patient in Wartezimmer " + i+ " hinzugefügt\n";
                    break;
                }
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
                    if(!behandlungszimmer[o].istBesetzt())
                    {
                        behandlungszimmer[o].hinzufügen((Patient)wartezimmer[i].gibErsten());
                        wartezimmer[i].löschen();
                        log = log + "Patient  wurde aus Wartezimmer " +i+ " geholt und dem Behandlungsraum " +o+ " hinzugefügt\n";
                        break;
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

    public boolean istFertig()
    {
        boolean fertig = true;
        for(int i = 0;i<behandlungszimmer.length;i++)
        {
            if (behandlungszimmer[i].istBesetzt())
            {
                fertig = false;
                return fertig;
            }
        }
        return fertig;
    }
    
    public boolean warteraumVoll()
    {
        boolean voll = true;
        for(int i = 0;i<wartezimmer.length;i++)
        {
            if (wartezimmer[i].platzFrei())
            {
                voll = false;
                return voll;
            }
        }
        return voll;
    }

    public void simulation(int anzahl)
    {
        for(int i = 0;i<anzahl;i++)
        {
            this.neuerPatient();
            logAusgeben();
        }

        while (!warteraumVoll())
        {
            queueZuWartezimmer();
            wartezimmerZuBehandlungsraum();
            logAusgeben();
        }

        while(!istFertig())
        {
            this.bewegeArzt();
            behandlungszimmer[pArzt.getWo()].diagnostizieren();
            behandlungeräumeLeeren();
            this.queueZuWartezimmer();
            this.wartezimmerZuBehandlungsraum();
            logAusgeben();
        }
        logAusgeben();
    }
}
