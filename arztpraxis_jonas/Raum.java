
public abstract class Raum
{
    private boolean besetzt;
    private Patient a;    

    public int Raum()
    {
        a = null;
    }
    
    public void hinzufügen(Patient b)
    {
        a = b;
    }
    
    public void löschen()
    {
        a = null;
    }
    
    public boolean istBesetzt()
    {
        if (a = null)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}
