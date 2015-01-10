import java.io.Serializable;
public class List implements Serializable 

{ 
    private Node first, tail, current;

    private class Node implements Serializable 
    { 
        private Object contentObj;
        private Node nextNode;

        public Node(Object pContent) 
        { 
            contentObj = pContent;
            nextNode = null;
        }

        public void setContent(Object pContent) 
        { 
            contentObj = pContent; 
        }

        public Object content() 
        { 
            return contentObj; 
        }

        public void setNext(Node pNext) 
        { 
            nextNode = pNext; 
        }

        public Node getNext() 
        { 
            return nextNode; 
        }

    } 

    public List() 
    {
        tail = new Node(null); 
        first = tail;
        tail.setNext(tail);
        current=first;
    }

    public boolean isEmpty() 
    { 
        return first == tail; 
    }

    public boolean hasAccess() 
    { 
        return (!this.isEmpty()) && (current != tail);
    }

    public void next() 
    { 
        if (this.hasAccess())
        {
            current = current.getNext();
        }
    }

    public void toFirst() 
    {
        if (!this.isEmpty())  
        {
            current = first; 
        }
    }

    public void toLast() 
    {
        if (!this.isEmpty())  
        {
            current = tail.getNext(); 
        }
    }

    public Object getObject() 
    {   
        if (this.hasAccess())
        {
            return current.content();
        }
        else 
        {
            return null;
        }
    }

    public void setObject(Object pObject) 
    { 
        if (pObject != null && this.hasAccess())
        {
            current.setContent(pObject); 
        }
    }

    public void append(Object pObject) 
    { 
        if (pObject != null) 
        {  
            Node lNewNode,lPos0;
            lPos0 = current;
            lNewNode = new Node(pObject);
            lNewNode.setNext(tail);
            if (this.isEmpty())
            {
                first = lNewNode;
            }
            else 
            {  
                Node lPrevious = tail.getNext();
                lPrevious.setNext(lNewNode);
            }  
            tail.setNext(lNewNode);
            current = lPos0;
        }
    }  

    public void insert(Object pObject) 
    {
        if (pObject != null) 
        {
            Node lNewNode,lFront,lPos;
            if (this.isEmpty())
            {
                this.append(pObject);
            }
            else if (this.hasAccess() ) 
            {
                lPos = current;
                lNewNode = new Node(pObject);
                lNewNode.setNext(current);
                if (lPos == first )
                {
                    first = lNewNode;
                }
                else 
                {
                    this.toFirst();
                    lFront = current;
                    while (this.hasAccess() & !(current == lPos)) 
                    {
                        lFront = current;
                        this.next();
                    }
                    lFront.setNext(lNewNode);  
                }          
                current=lPos;
            }
        }
    }

    public void concat(List pList) 
    {
        Node lCurrent1, lCurrent2, lPos0;

        if (pList != null && !pList.isEmpty()) 
        {
            if (this.isEmpty()) 
            {
                first = pList.first;
                tail = pList.tail;
                current = tail;
            }
            else 
            {
                lPos0 = current;
                current = tail.getNext();
                lCurrent1 = current;
                pList.toFirst();
                current = pList.current;
                lCurrent2 = pList.current;
                lCurrent1.setNext(lCurrent2);
                if (lPos0 != tail)
                {
                    current = lPos0;
                }
                else
                {
                    current = pList.tail;
                }
                tail = pList.tail;
            }

            pList.tail = new Node(null); 
            pList.first = pList.tail;
            pList.tail.setNext(tail);
            pList.current = pList.tail;
        }
    }

    public void remove() 
    { 
        Node lPos, lFront;

        if (this.hasAccess() ) 
        {
            if (current == first ) 
            {
                first = current.getNext();
                if (current.getNext() == tail)
                {
                    tail.setNext(first);
                }
                current = first;  
            }
            else 
            {
                lPos = current;
                this.toFirst();
                lFront = current;
                while (this.hasAccess() && !(current == lPos)) 
                {
                    lFront = current;
                    this.next();
                }
                lFront.setNext(lPos.getNext());
                current = lFront.getNext();
                if (current == tail)
                {
                    tail.setNext(lFront);
                }
            }  
        }
    }  
}
