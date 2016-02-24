
public class Behandlungsraum extends Raum
{
    private boolean hatArzt;
    private String pDiagnose;

    public Behandlungsraum()
    {

    }

    public void hinzufügen(Patient a)
    {
        if (!istBesetzt())
        {
            patient = a;
            pDiagnose = a.getDiagnose();
        }
    }

    public void diagnostizieren()
    {
        if (istBesetzt()&& hatArzt)
        {
            patient.setKrankheitsstatus("Behandelt");
        }
    }

    public void setArzt(boolean a)
    {
        hatArzt = a;
    }

    public String getpDiagnose()
    {
        return pDiagnose;
    }
}
