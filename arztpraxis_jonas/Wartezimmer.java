
/**
 * @Norbert Gutsche 
 * @version 22.02.12
 */
public class Wartezimmer
{
    private List liste;
    private int plätze;
    private int sindBesetzt;

    public Wartezimmer(int a)
    {
        liste = new List();
        plätze = a;
        sindBesetzt = 0;
    }

    public void hinzufügen(Mensch a)
    {
        if (sindBesetzt < plätze)
        {
            if (liste.isEmpty())
            {
                liste.append(a);
                sindBesetzt = sindBesetzt + 1;
            }
            else
            {
                liste.toFirst();
                while (a.isLess((Prioritaet)liste.getObject()))
                {
                    if (liste.hasAccess())
                    {
                        liste.next();
                    }
                    else
                    {
                        liste.append(a);
                        sindBesetzt = sindBesetzt + 1;
                        break;
                    }
                }
                liste.insert(a);
            }
        }
    }

    public void löschen()
    {
        liste.toFirst();
        liste.remove();
        sindBesetzt = sindBesetzt - 1;
    }

    public void gibErsten()
    {
        liste.toFirst();
        Prioritaet object = (Prioritaet)liste.getObject();
        return object;
    }

    public boolean platzFrei()
    {
        if (sindBesetzt < plätze)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

}
