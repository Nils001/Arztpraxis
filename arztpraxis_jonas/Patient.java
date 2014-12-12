
public class Patient extends Mensch
{
    private Krankheit diagnose;
    private String krankheitsstatus;
    private boolean brauchRöntgen;

    public Patient(int p)
    {
        super(p);
        diagnose = null;
        krankheitsstatus = null;
        brauchRöntgen = false;
    }

    public void setDiagnose (Krankheit a)
    {
        diagnose = a;
    }

    public void setBrauchRöntgen(boolean b)
    {
        brauchRöntgen = b;
    }

    public void setKrankheitsstatus(String c)
    {
        krankheitsstatus = c;
    }
}
