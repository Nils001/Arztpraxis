
public abstract class Raum
{
    private boolean besetzt;
    private Patient a;    

    public int Raum()
    {
        a = null;
    }
    
    public void hinzuf�gen(Patient b)
    {
        a = b;
    }
    
    public void l�schen()
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
