import java.util.Random;
/**
 * Write a description of class Krankheit here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Krankheit
{
    // instance variables - replace the example below with your own
    private String diagnose;
    private int priorität;
    private Random r;
    private int a;
    /**
     * Constructor for objects of class Krankheit
     */
    public Krankheit()
    {
        r = new Random();     
        a = r.nextInt(30);
        switch(a)
        {
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

        }
    }

    public String gibDiagnose()
    {
        return diagnose;
    }

    public int gibPriorität ()
    {
        return priorität;

    }

}
