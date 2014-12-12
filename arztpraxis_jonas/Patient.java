
public class Patient extends Mensch
{
    private Krankheit diagnose;
    private String krankheitsstatus;
    private boolean brauchR�ntgen;

    public Patient(int p)
    {
        super(p);
        diagnose = null;
        krankheitsstatus = null;
        brauchR�ntgen = false;
    }

    public void setDiagnose (Krankheit a)
    {
        diagnose = a;
    }

    public void setBrauchR�ntgen(boolean b)
    {
        brauchR�ntgen = b;
    }

    public void setKrankheitsstatus(String c)
    {
        krankheitsstatus = c;
    }
}
