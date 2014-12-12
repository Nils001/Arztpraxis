
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
        if (!istBesetzt())
        {
            patient = a;
        }
    }

    public Patient gibPatientUndLöschen()
    {
        if(this.istBesetzt()){
            Patient a = patient;
            patient = null;
            return a;
        }
        return null;
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
