
public class Patient extends Mensch
{
    private Krankheit hilfe;
    private String krankheitsstatus;
    private String diagnose;
    private boolean brauchRöntgen;

    public Patient()
    {
        super(1);
        hilfe = new Krankheit();
        diagnose = hilfe.getDiagnose();
        priorität = hilfe.getPriorität();
        krankheitsstatus = null;
        brauchRöntgen = hilfe.getRöntgen();
    }

    public Krankheit getKrankheit()
    {
        return hilfe;

    }
    
    public String getDiagnose()
    {
        return diagnose;
    }
    
        public int getPriorität()
    {
        return priorität;
    }

    public void setKrankheitsstatus(String c)
    {
        krankheitsstatus = c;
    }

    public String getKrankheitsstatus()
    {
        return krankheitsstatus;
    }

}
