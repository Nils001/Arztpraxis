import java.io.*;

public class ObjektLesen 
{
    public Rezeption lesen(String ort) 
    {
        try 
        {
            Rezeption t;
            FileInputStream fileIn = new FileInputStream(ort);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            t = (Rezeption)in.readObject();
            return t;
        }
        catch (IOException e) 
        {
            System.out.println("Error: "+e.getMessage());
            return null;
        }
        catch (ClassNotFoundException e) 
        {
            System.out.println("Error: "+e.getMessage());
            return null;
        }
    }
}
