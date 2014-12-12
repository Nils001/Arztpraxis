
public class Behandlungsraum extends Raum
{
    private boolean hatArzt;
    private Krankheit pDiagnose;

    public Behandlungsraum()
    {

    }

    private void mussRöntgen()
    {
        patient.setBrauchRöntgen(true);
    }

    private void diagnoseStellen()
    {
        patient.setDiagnose(pDiagnose);
    }
}
