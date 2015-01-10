import java.io.Serializable; 
public abstract class Prioritaet implements Serializable 
{
    protected int prioritaet;    

    public Prioritaet(int p)
    {
        prioritaet = p;
    }

    public int gibPrioritaet()
    {
        return prioritaet;
    }

    public boolean isGreater (Prioritaet pObject)
    {
        return (prioritaet < pObject.prioritaet);
    }

    public boolean isLess (Prioritaet pObject)
    {
        return (prioritaet > pObject.prioritaet);
    }

    public boolean isEqual (Prioritaet pObject)
    {
        return (prioritaet == pObject.prioritaet);
    }

    public void setPrioritaet(int p)
    {
            prioritaet = p;
    }

}