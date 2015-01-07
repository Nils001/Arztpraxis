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
        
        String vorname = "";
        String nachname = "";
        Random r = new Random();     
        int a = r.nextInt(10);
        int b = r.nextInt(10);

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
            vorname = "Emma ";
            break;
            case 6:
            vorname = "Mia ";
            break;
            case 7:
            vorname = "Hannah ";
            break;
            case 8:
            vorname = "Sofia ";
            break;
            case 9:
            vorname = "Emilia ";
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
