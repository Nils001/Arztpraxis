import java.util.Random;
public class Patient extends Mensch
{

    private String krankheitsstatus;
    private String diagnose;
    private boolean brauchRoentgen;

    public Patient()
    {
        super(1);

        this.brauchRoentgen = false;
        Random r = new Random();     
        int a = r.nextInt(4);
        int b = r.nextInt(5);
        if (a == 0)
        {
            this.prioritaet = 1;
            switch(b)
            {       
                case 0:
                this.diagnose = "Bruch";
                this.brauchRoentgen = true;
                break;

                case 1:
                this.diagnose = "Ab";
                this.brauchRoentgen = true;
                break;

                case 2:
                this.diagnose = "Herzstillstand";
                break;

                case 3:
                this.diagnose = "Bewusstlos";
                break;               

                case 4:
                this.diagnose = "Schlaganfall";
                break;

                case 5:
                this.diagnose = "Atemstillstand";
                break;
            }
        }
        else if (a == 1)
        {
            this.prioritaet = 2;
            switch(b)
            {
                case 0:
                this.diagnose = "Platzwunde";
                break;

                case 1:
                this.diagnose = "Schirfwunde";
                break;

                case 2:
                this.diagnose = "Schnittwunde";
                break;

                case 3:
                this.diagnose = "Brandwunde";
                break;

                case 4:
                this.diagnose = "Quetschung";
                this.brauchRoentgen = true;
                break;

                case 5:
                this.diagnose = "Ausgekugelt";
                this.brauchRoentgen = true;
                break;
            }
        }
        else if (a == 2)
        {
            this.prioritaet = 3;
            switch(b)
            {
                case 0:
                this.diagnose = "Malaria";
                break;

                case 1:
                this.diagnose = "Ebola";
                break;

                case 2:
                this.diagnose = "Pest";
                break;

                case 3:
                this.diagnose = "Pocken";
                break;

                case 4:
                this.diagnose = "Gelbfieber";
                break;

                case 5:
                this.diagnose = "Cholera";
                break;
            }
        }
        else if (a == 3)
        {
            this.prioritaet = 4;
            switch(b)
            {
                case 0:
                this.diagnose = "AIDS";
                break;

                case 1:
                this.diagnose = "Down-Syndrom";
                break;

                case 2:
                this.diagnose = "Rheuma";
                break;

                case 3:
                this.diagnose = "Alzheimer";
                break;

                case 4:
                this.diagnose = "Parkinson";
                break;

                case 5:
                this.diagnose = "Epilepsie";
                break;
            }
        }
        else if (a == 4)
        {
            this.prioritaet = 5;
            switch(b)
            {
                case 0:
                this.diagnose = "Husten";
                break;

                case 1:
                this.diagnose = "Erkaeltung";
                break;

                case 2:
                this.diagnose = "Haarausfall";
                break;

                case 3:
                this.diagnose = "Schnupfen";
                break;

                case 4:
                this.diagnose = "Erektionsstoerungen";
                break;

                case 5:
                this.diagnose = "Migraene";
                break;                        
            }
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
