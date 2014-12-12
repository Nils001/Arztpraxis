
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
        if (istBesetzt())
        {
            patient.setKrankheitsstatus( pDiagnose.getDiagnose());
            
           
        }

    }
}
