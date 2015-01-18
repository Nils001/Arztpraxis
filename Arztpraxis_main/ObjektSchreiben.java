import java.io.*;

public class ObjektSchreiben 
{
    public void schreiben(Rezeption t,String ort) 
    {
        ort = ort+ "\\Rezeption.rez";
        System.out.println(ort);
        try 
        {
            FileOutputStream fileOut = new FileOutputStream(ort);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(t);
            out.close();
        }
        catch (IOException e) 
        {
            System.out.println("Error: "+e.getMessage());
        }
    }
}
