
public abstract class Priorit�t
{
    private int priorit�t;    

    public Priorit�t(int p)
    {
        priorit�t = p;
    }

    public int gibPriorit�t()
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