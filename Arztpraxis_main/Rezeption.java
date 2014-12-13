
public class Rezeption
{
    private String log;
    private Arzt pArzt;
    private Wartezimmer wartezimmer[];
    private Behandlungsraum behandlungszimmer[];
    private Queue ankunft;
    private Queue abgang;

    public Rezeption(int wartezimmera,int behandlungszimmera,int wartezimmerplätze)
    {
        ankunft = new Queue();
        abgang = new Queue();
        pArzt = new Arzt();
        pArzt.setWo(1);
        wartezimmer = new Wartezimmer[wartezimmera];
        behandlungszimmer = new Behandlungsraum[behandlungszimmera];

        for(int i = 0;i< wartezimmera;i++)
        {
            wartezimmer[i] = new Wartezimmer(wartezimmerplätze);
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
        //log = log + "Patient in Queue Ankunft hinzugefügt  \n";
        System.out.println("Patient in Queue Ankunft hinzugefügt");
    }

    public void bewegeArzt()
    {
        int a = pArzt.getWo();   
        int b = a;
        a++;
        //log = log + "Arzt ist in Zimmer " +a+"\n" ;
        System.out.println("Arzt ist in Zimmer " +b);
        behandlungszimmer[b].setArzt(false);

        while (a != b)
        {
            if (a == behandlungszimmer.length)
            {
                a = 0;
            }

            if(behandlungszimmer[a].istBesetzt())
            {
                pArzt.setWo(a);
                behandlungszimmer[a].setArzt(true);
                behandlungszimmer[a].diagnostizieren();
                //log = log + "Arzt geht von Zimmer " +b+" zu Zimmer " +a+ " und diagnostiziert " +behandlungszimmer[a].getpDiagnose().getDiagnose()+"\n"; 
                System.out.println("Arzt geht zu Zimmer " +a+ " und diagnostiziert " +behandlungszimmer[a].getpDiagnose().getDiagnose());
                break;
            }                       
            a++;            
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
                    wartezimmer[i].hinzufügen((Priorität)ankunft.front());
                    ankunft.dequeue();
                    //log = log + "Patient in Wartezimmer " + i+ " hinzugefügt\n";
                    System.out.println("Patient in Wartezimmer " +i+ " hinzugefügt");
                    break;
                }
            }
        }
    }

    public void wartezimmerZuBehandlungsraum()
    {
        /*for(int i=0;i<wartezimmer.length;i++)
        {
        if(wartezimmer[i].istBesetzt())
        {
        for(int o = 0;o<behandlungszimmer.length;i++)
        {
        if(!behandlungszimmer[o].istBesetzt())
        {
        behandlungszimmer[o].hinzufügen((Patient)wartezimmer[i].gibErsten());
        wartezimmer[i].löschen();
        //log = log + "Patient  wurde aus Wartezimmer " +i+ " geholt und dem Behandlungsraum " +o+ " hinzugefügt\n";
        System.out.println("Patient  wurde aus Wartezimmer " +i+ " geholt und dem Behandlungsraum " +o+ " hinzugefügt");
        break;
        }
        }
        }
        }*/

        int a = 0;
        int b = 1;
        while (a != b && a < wartezimmer.length)
        {
            b = a;
            if (wartezimmer[a].gibErsten() != null)
            {
                int c = 0;
                int d = 1;
                while (c != d && c < behandlungszimmer.length)
                {
                    d = c;
                    if (!behandlungszimmer[c].istBesetzt())
                    {
                        behandlungszimmer[c].hinzufügen((Patient)wartezimmer[a].gibErsten());
                        System.out.println("Patient  wurde aus Wartezimmer " +a+ " geholt und dem Behandlungsraum " +c+ " hinzugefügt");
                    }
                    else
                    {
                        c++;
                    }
                }
            }
            else
            {
                a++;
            }
        }
    }

    public void behandlungeräumeLeeren()
    {
        for (int i = 0; i < behandlungszimmer.length; i++)
        {
            if ((behandlungszimmer[i].istBesetzt()))
            {
                Patient a = behandlungszimmer[i].getPatient();
                if(a.getKrankheitsstatus().equals("Behandelt"))
                {
                    behandlungszimmer[i].löschen();
                    abgang.enqueue(a);
                    //log = log + "Patient  wurde aus Behandlungszimmer " +i+ "geholt und der abgang Queue hinzugefügt\n";
                    System.out.println("Patient  wurde aus Behandlungszimmer " +i+ " geholt und der abgang Queue hinzugefügt");
                }
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
        behandlungeräumeLeeren();
        queueZuWartezimmer();
        wartezimmerZuBehandlungsraum();
        System.out.println();
        }*/
        //logAusgeben();
    }
}
