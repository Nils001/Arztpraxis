
public class Prioritaetenschlange
{
    private List liste;
    public Prioritaetenschlange()
    {
        liste = new List();

    }

    public void hinzufuegen(Prioritaet a)
    {
        
        
            if (liste.isEmpty())
            {
                liste.append(a);
                
            }
            else
            {
                liste.toFirst();
                while (liste.hasAccess())
                {
                    Prioritaet p = (Prioritaet)liste.getObject();
                    if (a.isGreater(p))
                    {
                        liste.insert(a);
                        
                        break;
                    }
                    else
                    {
                        liste.next();
                        if(!liste.hasAccess())
                        {
                            liste.append(a);
                            
                        }
                    }
                }

            
        }
    }
    public boolean isEmpty()
    {
    return liste.isEmpty();
    }
    
     public Prioritaet gibErsten()
    {
        liste.toFirst();
        Prioritaet object = (Prioritaet)liste.getObject();
        return object;
    }
}
