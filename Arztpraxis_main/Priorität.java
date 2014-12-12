
public abstract class Priorität
{
    private int priorität;    

    public Priorität(int p)
    {
        priorit�t = p;
    }

    public int gibPriorität()
    {
        return priorit�t;
    }

    public boolean isGreater (Priorit�t pObject)
    {
        return (priorit�t < pObject.priorit�t);
    }

    public boolean isLess (Priorit�t pObject)
    {
        return (priorit�t > pObject.priorit�t);
    }

    public boolean isEqual (Priorit�t pObject)
    {
        return (priorit�t == pObject.priorit�t);
    }
}