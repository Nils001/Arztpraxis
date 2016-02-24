import java.io.Serializable;

public class Rezeption implements Serializable 
{
    private String log = "";
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
        log = log + a + " ist an der Praxis angekommen.  \n";
    }

    /* Der Arzt wird in das nächste Behandlungszimmer gebraucht in dem ein Patient auf die Behandlung wartet*/
    public void bewegeArzt()
    {
        int a = pArzt.getWo();
        behandlungszimmer[a].setArzt(false);
        a++;

        if(a < behandlungszimmer.length)
        {
            behandlungszimmer[a].setArzt(true);
            pArzt.setWo(a);
            log = log + "Arzt geht in Raum " +a+ ". \n";
        }
        else 
        {
            a=0;
            behandlungszimmer[a].setArzt(true);
            pArzt.setWo(a);
            log = log + "Arzt geht in Raum " +a+ ". \n";
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
                    log = log + a + " setzt sich ins Wartezimmer " +i+ " \n";
                    return;
                }
            }
        }
        else
        {
            log = log + "Kann keine Patienten zum Wartezimmer hinzufügen, da die Ankunfts Queue leer ist \n";
        }
    }

    /*Der erste Patient im ersten Wartezimmer wird in den ersten freien Behandlungsraum gebracht*/
    public void wartezimmerZuBehandlungsraum()
    {
        Prioritaetenschlange a = new Prioritaetenschlange();

        for(int i = 0; i < wartezimmer.length; i++)
        {
            if(wartezimmer[i].istBesetzt())
            {
                Prioritaet b =  wartezimmer[i].gibErsten();
                a.hinzufuegen(b);
                //log = log + "Patient "+a+" in Wartezimmer" +i+" gefunden \n";

            }
        }
        if(!a.isEmpty())
        {
            Patient b = (Patient) a.gibErsten();
            for(int h = 0; h < behandlungszimmer.length; h++)
            {
                if(!behandlungszimmer[h].istBesetzt())
                {
                    behandlungszimmer[h].hinzufuegen((Patient) b);
                    log = log + b + " wurde Behandlungszimmer "+h+" zugewiesen. \n";
                    for(int i = 0; i < wartezimmer.length; i++)
                    {
                        Patient ab = (Patient) wartezimmer[i].gibErsten();
                        if(b.equals(ab))
                        {
                            wartezimmer[i].loeschen();
                            return;

                        }

                    }

                }
                if (h == behandlungszimmer.length - 1)
                {
                    return;
                }
            }
        }
        else
        {
            log = log + "Fehler beim hinzufügen des Partienten. \n";
            log = log + "Alle Wartezimmer sind leer! \n";
        }
    }

    /*Der erste Behandlungsraum der besetzt ist wird geleert falls der Patient bereits behandelt wurde*/
    public void behandlungeraumLeeren()
    {
        for (int i = 0; i < behandlungszimmer.length; i++)
        {
            if ((behandlungszimmer[i].istBesetzt()))
            {
                //log = log + "Patient in Zimmer " +i+ " gefunden \n";
                Patient a = behandlungszimmer[i].getPatient();
                if(a.getKrankheitsstatus() == "Behandelt")
                {
                    behandlungszimmer[i].loeschen();
                    abgang.enqueue(a);
                    log = log + a + " hat die Praxis verlassen. \n";
                    return;
                }
                else
                {
                    log = log + "Dieser Patient wurde noch nicht behandelt! \n";
                }
            }
        }
    }

    /*In dem Raum, in welchen sich der Arzt befindet, wird der Patient behandelt */
    public void behandeln()
    {
        if(behandlungszimmer[pArzt.getWo()].istBesetzt())
        {
            int a = pArzt.getWo();
            Patient c = behandlungszimmer[a].getPatient();

            behandlungszimmer[a].diagnostizieren();
            String b = behandlungszimmer[a].getpDiagnose();            
            log = log + c + " in Behandlungszimmer "+a+ " wurde behandelt. \n";
            log = log + "Der Patient " +c.getDiagnose()+ ". \n";

            behandlungszimmer[a].loeschen();
            abgang.enqueue(c);
            log = log + c + " hat die Praxis verlassen. \n";
            log = log + "\n";
        }
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
        status = status + "Arzt befindet sich in Zimmer" +pArzt.getWo()+ " \n";
        status = status + "\n";
        status = status + "In der Ankunftsschlange befinden sich: \n ";
        Queue hilfe = new Queue();
        while(!ankunft.isEmpty())
        {
            a =(Patient) ankunft.front();
            status = status + i + ". " +a+ " \n";
            i++;
            hilfe.enqueue(ankunft.front());
            ankunft.dequeue();
        }
        while(!hilfe.isEmpty())
        {
            ankunft.enqueue(hilfe.front());
            hilfe.dequeue();

        }
        status = status + "\n";
        for(i = 0; i < behandlungszimmer.length; i++)
        {
            if(behandlungszimmer[i].istBesetzt())
            {   
                a = behandlungszimmer[i].getPatient();
                status = status + "Behandlungszimmer " +i+ " ist besetzt mit dem Patienten " +a+ ". \n";
            }
            else
            {
                status = status + "Behandlungszimmer " +i+ " ist leer. \n";
            }
            status = status + "\n";
        }
        for(i=0;i<wartezimmer.length;i++)
        {
            status = status + "Wartezimmer " +i+ ": \n";
            status = status + wartezimmer[i].ausgabe() + "\n";

        }
        status = status + "\n";
        i = 0;
        while(!abgang.isEmpty())
        {
            a =(Patient) abgang.front();
            status = status + i + ". " +a+ " \n";
            i++;
            hilfe.enqueue(abgang.front());
            abgang.dequeue();
        }
        while(!hilfe.isEmpty())
        {
            abgang.enqueue(hilfe.front());
            hilfe.dequeue();

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

    //true wenn min ein behandlungsraum leer ist
    public boolean behandlungsraumLeer()
    {
        for(int i = 0; i < behandlungszimmer.length; i++)
        {
            if(!behandlungszimmer[i].istBesetzt())
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

    public String[] simulation(int anzahl)
    {
        log = log + "-----------------------------------Simulation---------------------------------- \n";
        log = log + "\n";
        
        for(int a = 0; a < anzahl; a++)                             //erzeugt Patienten                          
        {
            neuerPatient();
        }
        log = log + "\n";

        while (warteraumNichtVoll() && !ankunft.isEmpty())          //Ankunft zu Wartezimmer      
        {
            queueZuWartezimmer();   
        }
        log = log + "\n";

        for(int b = 0; b < behandlungszimmer.length; b++)           //wartezimmer zu behandlungsraum
        {
            if (wartezimmerBesetzt())
            {
                wartezimmerZuBehandlungsraum();
            }
        }
        log = log + "\n";

        while (wartezimmerBesetzt() || behandlungsraumBesetzt() || !ankunft.isEmpty())
        {
            bewegeArzt();
            behandeln();
            if (behandlungsraumLeer() && wartezimmerBesetzt())
            {
                wartezimmerZuBehandlungsraum();
                log = log + "\n";
            }
            if (warteraumNichtVoll() && !ankunft.isEmpty())
            {
                queueZuWartezimmer();
                log = log + "\n";
            }
        }

        return new String[]{ log, statusAusgabe() };
    }
}

