import java.util.Random;
public class Patient extends Mensch
{
    private String krankheitsstatus;
    private String diagnose;

    public Patient()
    {
        super(1);

        Random r = new Random();     
        int a = r.nextInt(6);
        int b = r.nextInt(5);
        if (a == 0)
        {
            this.prioritaet = 1;
            switch(b)
            {       
                case 0:
                this.diagnose = "hat einen Bruch";                
                break;

                case 1:
                this.diagnose = "hat etwas verloren";               
                break;

                case 2:
                this.diagnose = "hatte einen Herzstillstand";
                break;

                case 3:
                this.diagnose = "war Bewusstlos";
                break;               

                case 4:
                this.diagnose = "hatte einen Schlaganfall";
                break;

                case 5:
                this.diagnose = "hatte einen Atemstillstand";
                break;
            }
        }
        else if (a == 1)
        {
            this.prioritaet = 2;
            switch(b)
            {
                case 0:
                this.diagnose = "hatte eine Platzwunde";
                break;

                case 1:
                this.diagnose = "hatte eine Schirfwunde";
                break;

                case 2:
                this.diagnose = "hatte eine Schnittwunde";
                break;

                case 3:
                this.diagnose = "hatte eine Brandwunde";
                break;

                case 4:
                this.diagnose = "hatte eine Quetschung";
                break;

                case 5:
                this.diagnose = "hatte etwas Ausgekugelt";
                break;
            }
        }
        else if (a == 2)
        {
            this.prioritaet = 3;
            switch(b)
            {
                case 0:
                this.diagnose = "hatte Malaria";
                break;

                case 1:
                this.diagnose = "hatte Ebola";
                break;

                case 2:
                this.diagnose = "hatte die Pest";
                break;

                case 3:
                this.diagnose = "hatte Pocken";
                break;

                case 4:
                this.diagnose = "hatte Gelbfieber";
                break;

                case 5:
                this.diagnose = "hatte Cholera";
                break;
            }
        }
        else if (a == 3)
        {
            this.prioritaet = 4;
            switch(b)
            {
                case 0:
                this.diagnose = "hat AIDS";
                break;

                case 1:
                this.diagnose = "hat das Down-Syndrom";
                break;

                case 2:
                this.diagnose = "hat Rheuma";
                break;

                case 3:
                this.diagnose = "hat Alzheimer";
                break;

                case 4:
                this.diagnose = "hat Parkinson";
                break;

                case 5:
                this.diagnose = "hat Epilepsie";
                break;
            }
        }
        else if (a == 4)
        {
            this.prioritaet = 5;
            switch(b)
            {
                case 0:
                this.diagnose = "hat Husten";
                break;

                case 1:
                this.diagnose = "hat eine Erkaeltung";
                break;

                case 2:
                this.diagnose = "hat Haarausfall";
                break;

                case 3:
                this.diagnose = "hat Schnupfen";
                break;

                case 4:
                this.diagnose = "hat Erektionsstoerungen";
                break;

                case 5:
                this.diagnose = "hatte Migraene";
                break;                        
            }
        }
        else if (a == 5)
        {
            this.prioritaet = 6;
            this.diagnose = "kam zur Regeluntersuchung";
        }
        else if (a == 6)
        {
            this.prioritaet = 7;
            this.diagnose = "kam zu einer Sprechstunde";
        }
    }

    public String toString()
    {
        return name + " @ Priorität " + prioritaet;
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
