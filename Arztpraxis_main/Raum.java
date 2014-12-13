
public abstract class Raum
{
    private boolean besetzt;
    protected Patient patient;    

    public Raum()
    {
        patient = null;
    }

    public void hinzufuegen(Patient a)
    {
        if (!istBesetzt())
        {
            patient = a;
        }
    }

    public void loeschen()
    {
            patient = null;
    }
    
    public Patient getPatient()
    {
        return patient;
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
