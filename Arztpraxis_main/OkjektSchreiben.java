import java.io.*;

public class OkjektSchreiben {

    public void schreiben(Rezeption t,String ort) {
        ort = ort+ "Rezeption.dat";
        try {
            FileOutputStream fileOut = new FileOutputStream("Rezeptio.dat");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(t);
            out.close();
        }
        catch (IOException e) {
            System.out.println("Error: "+e.getMessage());
        }
    }
}
