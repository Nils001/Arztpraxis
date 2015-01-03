
public class Wartezimmer
{
    private List liste;
    private int plaetze;
    private int sindBesetzt;

    public Wartezimmer(int a)
    {
        liste = new List();
        plaetze = a;
        sindBesetzt = 0;
    }

    public void hinzufuegen(Prioritaet a)
    {
        if (sindBesetzt < plaetze)
        {
            if (liste.isEmpty())
            {
                liste.append(a);
                sindBesetzt = sindBesetzt + 1;
            }
            else
            {
                liste.toFirst();
                while (liste.hasAccess())
                {
                    Prioritaet p = (Prioritaet)liste.getObject();
                    if (a.isLess(p))
                    {
                        liste.insert(a);
                        sindBesetzt = sindBesetzt + 1;
                        break;
                    }
                    else
                    {
                        liste.next();
                        if(!liste.hasAccess())
                        {
                            liste.append(a);
                            sindBesetzt = sindBesetzt + 1;
                        }
                    }
                }

            }
        }
    }

    public void loeschen()
    {
        if (!liste.isEmpty())
        {
            liste.toFirst();
            liste.remove();
            sindBesetzt = sindBesetzt - 1;
        }
    }

    public Prioritaet gibErsten()
    {
        liste.toFirst();
        Prioritaet object = (Prioritaet)liste.getObject();
        return object;
    }

    public boolean istBesetzt()

    {
        if(sindBesetzt != 0)
        {
            return true;
        }
        else {
            return false; 
        }

    }

    public void ausgabe()
    {
        if (!liste.isEmpty())
        {
            liste.toFirst();
            while (liste.hasAccess())
            {
                String krankheit = ((Patient)liste.getObject()).getDiagnose();

                int i = ((Patient)liste.getObject()).getPrioritaet();
                Integer meinInteger = new Integer(i);
                String prioritaet = meinInteger.toString(); 

                System.out.println(prioritaet+ " " +krankheit);

                liste.next();
            }
        }
    }

    public boolean platzFrei()
    {
        if (sindBesetzt < plaetze)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
