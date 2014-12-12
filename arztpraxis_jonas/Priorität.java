
public abstract class Priorität
{
    private int priorität;    

    public Priorität(int p)
    {
        priorität = p;
    }

    public int gibPriorität()
    {
        return priorität;
    }

    public boolean isGreater (Priorität pObject)
    {
        return (priorität < pObject.priorität);
    }

    public boolean isLess (Priorität pObject)
    {
        return (priorität > pObject.priorität);
    }

    public boolean isEqual (Priorität pObject)
    {
        return (priorität == pObject.priorität);
    }
}