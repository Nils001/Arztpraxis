import java.util.Random;
/**
 * Abstract class Mensch - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Mensch extends Prioritaet
{
    protected String name;

    public Mensch(int p)
    {
        super(p);

        //Patient bekommt einen von 400 verschiedenen Namen
        String vorname = "";
        String nachname = "";
        Random r = new Random();     
        int a = r.nextInt(20);
        int b = r.nextInt(20);

        switch(a)
        {
            case 0:
            vorname = "Ben ";
            break;
            case 1:
            vorname = "Luis ";
            break;
            case 2:
            vorname = "Paul ";
            break;
            case 3:
            vorname = "Lukas ";
            break;
            case 4:
            vorname = "Jonas ";
            break;
            case 5:
            vorname = "Leon ";
            break;
            case 6:
            vorname = "Finn ";
            break;
            case 7:
            vorname = "Tim ";
            break;
            case 8:
            vorname = "Felix ";
            break;
            case 9:
            vorname = "Max ";
            break;
            //////////////////////////////////////////////////////////////
            case 10:
            vorname = "Anna ";
            break;
            case 11:
            vorname = "Lena ";
            break;
            case 12:
            vorname = "Lea ";
            break;
            case 13:
            vorname = "Emilie ";
            break;
            case 14:
            vorname = "Maria ";
            break;
            case 15:
            vorname = "Emma ";
            break;
            case 16:
            vorname = "Lara ";
            break;
            case 17:
            vorname = "Hannah ";
            break;
            case 18:
            vorname = "Sofia ";
            break;
            case 19:
            vorname = "Lina ";
            break;
        }

        switch(b)
        {
            case 0:
            nachname = "Müller";
            break;
            case 1:
            nachname = "Schmidt";
            break;
            case 2:
            nachname = "Schneider";
            break;
            case 3:
            nachname = "Fischer";
            break;
            case 4:
            nachname = "Weber";
            break;
            case 5:
            nachname = "Meyer";
            break;
            case 6:
            nachname = "Wagner";
            break;
            case 7:
            nachname = "Becker";
            break;
            case 8:
            nachname = "Schulz";
            break;
            case 9:
            nachname = "Hoffmann";
            break;
            case 10:
            nachname = "Schäfer";
            break;
            case 11:
            nachname = "Koch";
            break;
            case 12:
            nachname = "Bauer";
            break;
            case 13:
            nachname = "Richter";
            break;
            case 14:
            nachname = "Klein";
            break;
            case 15:
            nachname = "Schröder";
            break;
            case 16:
            nachname = "Neumann";
            break;
            case 17:
            nachname = "Zimmermann";
            break;
            case 18:
            nachname = "Krüger";
            break;
            case 19:
            nachname = "Hartmann";
            break;
        }

        name = vorname + nachname;
    }

    public void setName(String pName)
    {
        name = pName;
    }

    public String getName()
    {
        return name;
    }
}
