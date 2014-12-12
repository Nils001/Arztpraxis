
import java.util.Random;
public class Krankheit
{
    private String diagnose;
    private int priorität;
<<<<<<< HEAD
    private boolean brauchRöntgen;
=======
>>>>>>> origin/master
    private Random r;
    private int a;
    private int b;

    public Krankheit()
    {
        this.brauchRöntgen = false;
        r = new Random();     
        a = r.nextInt(4);
        b = r.nextInt(5);
        if (a == 0)
        {
<<<<<<< HEAD
            this.priorität = 1;
            switch(b)
            {
                case 0:
                this.diagnose = "Bruch";
                this.brauchRöntgen = true;
                break;

                case 1:
                this.diagnose = "Ab";
                this.brauchRöntgen = true;
                break;

                case 2:
                this.diagnose = "Herzstillstand";
                break;

                case 3:
                this.diagnose = "Bewusstlos";
                break;
=======
            case 0: 
            this.diagnose = "";
            this.priorität =1 ;

            break;
            case 1: kartenwert = "bauer";
            break;
            case 2: kartenwert = "dame";
            break;
            case 3: kartenwert = "koenig";
            break;
            case 4: kartenwert = "2";
            break;
            case 5: kartenwert = "3";
            break;
            case 6: kartenwert = "4";
            break;
            case 7: kartenwert = "5";
            break;
            case 8: kartenwert = "6";
            break;
            case 9: kartenwert = "7";
            break;
            case 10: kartenwert = "8";
            break;
            case 11: kartenwert = "9";
            break;
            case 12: kartenwert = "10";
            break;                 
            case 0: kartenwert = "ass";
            break;
            case 1: kartenwert = "bauer";
            break;
            case 2: kartenwert = "dame";
            break;
            case 3: kartenwert = "koenig";
            break;
            case 4: kartenwert = "2";
            break;
            case 5: kartenwert = "3";
            break;
            case 6: kartenwert = "4";
            break;
            case 7: kartenwert = "5";
            break;
            case 8: kartenwert = "6";
            break;
            case 9: kartenwert = "7";
            break;
            case 10: kartenwert = "8";
            break;
            case 11: kartenwert = "9";
            break;
            case 12: kartenwert = "10";
            break;                 
>>>>>>> origin/master

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
            this.priorität = 2;
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
                this.brauchRöntgen = true;
                break;

                case 5:
                this.diagnose = "Ausgekugelt";
                this.brauchRöntgen = true;
                break;
            }
        }
        else if (a == 2)
        {
            this.priorität = 3;
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

<<<<<<< HEAD
                case 4:
                this.diagnose = "Gelbfieber";
                break;
=======
    public String gibDiagnose()
    {
        return diagnose;
    }

    public int gibPriorität ()
    {
        return priorität;

    }
>>>>>>> origin/master

                case 5:
                this.diagnose = "Cholera";
                break;
            }
        }
        else if (a == 3)
        {
            this.priorität = 4;
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
            this.priorität = 5;
            switch(b)
            {
                case 0:
                this.diagnose = "Husten";
                break;

                case 1:
                this.diagnose = "Erkältung";
                break;

                case 2:
                this.diagnose = "Haarausfall";
                break;

                case 3:
                this.diagnose = "Schnupfen";
                break;

                case 4:
                this.diagnose = "Erektionsstörungen";
                break;

                case 5:
                this.diagnose = "Migräne";
                break;
            }
        }
    }
}

