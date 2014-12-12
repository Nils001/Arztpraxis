
/**
 * @Norbert Gutsche 
 * @version 22.02.12
 */
public class Wartezimmer
{
    private List liste;
    private int pl�tze;
    private int sindBesetzt;

    public Wartezimmer(int a)
    {
        liste = new List();
        pl�tze = a;
        sindBesetzt = 0;
    }

    public void hinzuf�gen(Mensch a)
    {
        if (sindBesetzt < pl�tze)
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

    public void l�schen()
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
        if (sindBesetzt < pl�tze)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

}
