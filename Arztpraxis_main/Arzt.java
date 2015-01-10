import java.io.Serializable;
/**
 * Write a description of class Arzt here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Arzt implements Serializable 
{
    private int woBinIch;
    
    public Arzt()
    {
        
    }
    
    public void setWo(int a)
    {
        woBinIch = a;
    }
    
    public int getWo()
    {
        return woBinIch;
    }
}
