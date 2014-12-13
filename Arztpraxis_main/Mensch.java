
/**
 * Abstract class Mensch - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Mensch extends Priorität
{
    private String name;
    
    public Mensch(int p)
    {
        super(p);
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
