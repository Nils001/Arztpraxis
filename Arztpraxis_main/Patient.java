
public class Patient extends Mensch
{
    private Krankheit diagnose;
    private String krankheitsstatus;
    private boolean brauchRöntgen;

    public Patient()
    {
        super(1);
        diagnose = new Krankheit();

        this.setPriorität(diagnose.getPrioritaet());
        krankheitsstatus = null;
        brauchRöntgen = diagnose.getRöntgen();
    }

    public Krankheit getKrankheit()
    {
        return diagnose;

    }

    public void setKrankheitsstatus(String c)
    {
        krankheitsstatus = c;
    }
}
