
public class Rezeption
{
    private String log;
    private Arzt pArzt;
    private Wartezimmer wartezimmer[];
    private Behandlungsraum behandlungszimmer[];
    private Queue ankunft;
    private Queue abgang;

    public Rezeption(int wartezimmera,int behandlungszimmera,int wartezimmerplaetze)
    {
        ankunft = new Queue();
        abgang = new Queue();
        pArzt = new Arzt();
        pArzt.setWo(0);
        wartezimmer = new Wartezimmer[wartezimmera];
        behandlungszimmer = new Behandlungsraum[behandlungszimmera];

        for(int i = 0;i< wartezimmera;i++)
        {
            wartezimmer[i] = new Wartezimmer(wartezimmerplaetze);
        }

        for (int i = 0;i<behandlungszimmera;i++)
        {
            behandlungszimmer[i] = new Behandlungsraum();
        }
    }

    public void neuerPatient()
    {
        Patient a = new Patient();
        a.setKrankheitsstatus(null);
        ankunft.enqueue(a);
        log = log + "Patient "+a+" in Queue Ankunft hinzugefuegt  \n";
        
    }

    public void bewegeArzt()
    {
        int a = pArzt.getWo();
        log = log + "Arzt ist in Raum " +a+"\n";
        behandlungszimmer[a].setArzt(false);
        a++;
        if(a<behandlungszimmer.length)
        {
            behandlungszimmer[a].setArzt(true);
            pArzt.setWo(a);
            log = log + "Arzt ist jetz in Raum" +a+"\n";

        }
        else 
        {
            a=0;
            behandlungszimmer[a].setArzt(true);
            pArzt.setWo(a);
            log = log + "Arzt ist jetz in Raum" +a+"\n";
        }
    }

    public void queueZuWartezimmer()
    {
        if (!ankunft.isEmpty())
        {
            for(int i = 0; i < wartezimmer.length; i++)
            {
                if (wartezimmer[i].platzFrei())
                {
                    wartezimmer[i].hinzufuegen((Prioritaet)ankunft.front());
                    Patient a =(Patient) ankunft.front();
                    ankunft.dequeue();
                    log = log + "Patient"+a+" in Wartezimmer " + i+ " hinzugefuegt \n";
                    
                    break;
                }
            }
        }
        else
        {
            log = log + "Kann keine Patienten zum Wartezimmer hinzufügen, da die Ankunft Queue leer ist \n";
        }
    }

    public void wartezimmerZuBehandlungsraum()
    {
        boolean ab ;
        for(int i=0;i<wartezimmer.length;i++)
        {
            if(wartezimmer[i].istBesetzt())
            {

                Prioritaet a =  wartezimmer[i].gibErsten();
                log = log + "Patient "+a+" in Wartezimmer" +i+" gefunden \n";

                for(int h =0;h<behandlungszimmer.length;h++)
                {
                    if(!behandlungszimmer[h].istBesetzt()){
                        behandlungszimmer[h].hinzufuegen((Patient) a);
                        log = log + "Patient"+a+" wurde in Behandlungszimmer "+h+" hinzugefügt \n";
                        wartezimmer[i].loeschen();
                        return;
                    }
                    if (h == behandlungszimmer.length-1)
                    {
                        log = log + "Fehler beim hinzufügen des Partienten.\n Entweder kein Patient gefunden oder kein freies Behandlunsgzimmer.";
                        return;
                    }

                }

            }
        }
    }

    public void behandlungeraeumeLeeren()
    {
        for (int i = 0; i < behandlungszimmer.length; i++)
        {
            if ((behandlungszimmer[i].istBesetzt()))
            {
                Patient a = behandlungszimmer[i].getPatient();
                if(a.getKrankheitsstatus().equals("Behandelt"))
                {
                    behandlungszimmer[i].loeschen();
                    abgang.enqueue(a);
                    log = log + "Patient "+a+" wurde aus Behandlungszimmer " +i+ "geholt und der abgang Queue hinzugefuegt\n";
                    
                }
            }
        }
    }

    public void logAusgeben()
    {
        System.out.println(log);
    }

    /* public void simulation(int anzahl)
    {
    for(int a = 0; a < anzahl; a++)                             //funktioniert
    {
    neuerPatient();
    }

    while (!warteraumVoll() && !ankunft.isEmpty())              //funktioniert
    {
    queueZuWartezimmer();
    }

    for (int i = 0; i < wartezimmer.length; i++)
    {
    if (wartezimmer[i] != null)
    {
    wartezimmer[i].ausgabe();
    }
    }

    /*for(int b = 0; b < behandlungszimmer.length; b++)         //funktioniert
    {
    wartezimmerZuBehandlungsraum();
    }

    for (int c = 0; c < anzahl; c++)                            //fehler
    {
    bewegeArzt();
    behandlungszimmer[pArzt.getWo()].diagnostizieren();
    behandlungeraeumeLeeren();
    queueZuWartezimmer();
    wartezimmerZuBehandlungsraum();
    System.out.println();
    }*/
    //logAusgeben();*/
}

