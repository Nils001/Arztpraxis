
public abstract class Raum
{
    private boolean besetzt;
    protected Patient patient;    

    public Raum()
    {
        patient = null;
    }
    
    public void hinzuf�gen(Patient a)
    {
        patient = a;
    }
    
    public void l�schen()
    {
        patient = null;
    }
    
    public boolean istBesetzt()
    {
        if (patient == null)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}
