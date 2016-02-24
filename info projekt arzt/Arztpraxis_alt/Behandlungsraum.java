
public class Behandlungsraum extends Raum
{
    private boolean hatArzt;
    private Krankheit pDiagnose;

    public Behandlungsraum()
    {

    }

    public void hinzufügen(Patient a)
    {
        if (!istBesetzt())
        {
            patient = a;
            pDiagnose =  a.getKrankheit();
        }
    }

    public void diagnostizieren()
    {
        if (istBesetzt()&& hatArzt)
        {
            patient.setKrankheitsstatus("Behandelt");
            System.out.println("Der patient hat " +patient.getKrankheit().getDiagnose()+ ".");
        }
    }

    public void setArzt(boolean a)
    {
        hatArzt = a;
    }

    public Krankheit getpDiagnose()
    {
        return pDiagnose;
    }
}
