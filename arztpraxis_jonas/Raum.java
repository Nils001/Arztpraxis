
public abstract class Raum
{
    private boolean besetzt;
    protected Patient patient;    

    public Raum()
    {
        patient = null;
    }
    
    public void hinzufügen(Patient a)
    {
        patient = a;
    }
    
    public void löschen()
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
