
public class Patient extends Mensch
{
    private Krankheit hilfe;
    private String krankheitsstatus;
    private String diagnose;
    private boolean brauchRoentgen;

    public Patient()
    {
        super(1);
        hilfe = new Krankheit();
        diagnose = hilfe.getDiagnose();
        prioritaet = hilfe.getPrioritaet();
        krankheitsstatus = null;
        brauchRoentgen = hilfe.getRoentgen();
    }

    public Krankheit getKrankheit()
    {
        return hilfe;

    }
    
    public String getDiagnose()
    {
        return diagnose;
    }
    
        public int getPrioritaet()
    {
        return prioritaet;
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
