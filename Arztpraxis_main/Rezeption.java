
public class Rezeption
{
    private String log ="";
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

    /* Der Arzt wird in das nächste Behandlungszimmer gebraucht in dem ein Patient auf die Behandlung wartet*/
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

    /*Der erste Patient wird aus der Queue in das erste freie Wartezimmer gebracht */
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

                    return;
                }
            }
        }
        else
        {
            log = log + "Kann keine Patienten zum Wartezimmer hinzufügen, da die Ankunft Queue leer ist \n";
        }
    }

    /*Der erste Patient im ersten Wartezimmer wird in den ersten freien Behandlungsraum gebracht*/
    public void wartezimmerZuBehandlungsraum()
    {

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

                        return;
                    }

                }
            }
        }
        log = log + "Fehler beim hinzufügen des Partienten.\n Entweder kein Patient gefunden oder kein freies Behandlunsgzimmer.";
    }

    /*Der erste Behandlungsraum der besetzt ist wird geleert falls der Patient bereits behandelt wurde*/
    public void behandlungeraumLeeren()
    {
        for (int i = 0; i < behandlungszimmer.length; i++)
        {
            if ((behandlungszimmer[i].istBesetzt()))
            {
                log = log + "Patient in Zimmer " +i+ " gefunden \n";
                Patient a = behandlungszimmer[i].getPatient();
                if(a.getKrankheitsstatus() == "Behandelt")
                {

                    behandlungszimmer[i].loeschen();
                    abgang.enqueue(a);
                    log = log + "Patient "+a+" wurde aus Behandlungszimmer " +i+ "geholt und der Abgang Queue hinzugefuegt\n";
                    return;
                }
                else
                {
                log = log + "Dieser Patient wurde noch nicht behandelt ! \n";
                }
            }
        }
    }

    /*In dem Raum, in welchen sich der Arzt befindet, wird der Patient behandelt */
    public void behandeln()
    {
        int a = pArzt.getWo();
        behandlungszimmer[a].diagnostizieren();
    }

    /*Der gesammte Log wird ausgegeben*/
    public String logAusgeben()
    {
        return log;
    }

    public String statusAusgabe()
    {
        String status = "";
        int i = 0;
        Patient a;
        status = status + "Arzt befindet sich in Zimmer" +pArzt.getWo()+"\n";
        status = status +"\n";
        status = status + "In der Ankunftsschlange befinden sich : \n ";
        while(!ankunft.isEmpty())
        {
            a =(Patient) ankunft.front();
            status = status + i +". "+ a +" \n";
            i++;
        }
        status = status +"\n";
        for(i = 0; i < behandlungszimmer.length; i++)
        {
            if(behandlungszimmer[i].istBesetzt())
            {   
                a = behandlungszimmer[i].getPatient();
                status = status + "Behandlungszimmer "+ i +" ist besetzt mit dem Patienten "+ a +" \n";
            }
            else
            {
                status = status + "Behandlungszimmer "+ i +" ist frei \n";
            }
            status = status +"\n";
        }
        for(i=0;i<wartezimmer.length;i++)
        {
            status = status + "Wartezimmer " + i+ " : \n";
            status = status + wartezimmer[i].ausgabe() + "\n";

        }
        status = status +"\n";
        i = 0;
        while(!abgang.isEmpty())
        {
            a =(Patient) abgang.front();
            status = status + i +". "+ a +" \n";
            i++;
        }
        return status;
    }

    /*false wenn keine Patienten in den Behandlungsräumen sind,
    true wenn mindestens ein Patient in einem Behandlungsraum ist.
     */
    public boolean behandlungsraumBesetzt()
    {

        for(int i = 0; i < behandlungszimmer.length; i++)
        {
            if(behandlungszimmer[i].istBesetzt())
            {
                return true;
            }
        }
        return false;
    }

    /*false wenn keine Patienten in den Warteräumen sind,
    true wenn mindestens ein Patient in einem Warteraum ist.
     */
    public boolean wartezimmerBesetzt()
    {

        for(int i = 0; i < wartezimmer.length; i++)
        {
            if(wartezimmer[i].istBesetzt())
            {
                return true;
            }
        }
        return false;
    }

    public boolean warteraumNichtVoll()
    {
        for(int i = 0; i < wartezimmer.length; i++)
        {
            if(wartezimmer[i].platzFrei())
            {
                return true;
            }
        }
        return false;
    }

    /*   public void simulation(int anzahl)
    {
    boolean a;
    for(int a = 0; a < anzahl; a++)                             //funktioniert
    {
    neuerPatient();
    }

    while (!warteraumNichtVoll() && !ankunft.isEmpty())              //funktioniert
    {
    queueZuWartezimmer();
    }
    if(!ankunft.isEmpty())
    {
    a=true;
    }
    while(!behandlungsraumBesetzt())
    {

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
    }
    //logAusgeben();*/
}

