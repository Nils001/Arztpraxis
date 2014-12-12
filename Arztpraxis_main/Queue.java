
public class Queue
{
    private Node head, tail;

    private class Node
    {
        private Object content;
        private Node nextNode;

        public Node(Object pContent, Node pNext)
        { 
            content = pContent;
            nextNode = pNext;
        }

        public void setContent(Object pContent)
        { 
            content = pContent;
        }

        public Object content()
        {
            return content;
        }

        public void setNext(Node pNext)
        { 
            nextNode = pNext;
        }

        public Node next()
        {
            return nextNode;
        }
    }

    public Queue() 
    {
        head = null;
        tail = null;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void enqueue(Object pObject) 
    { 
        if (pObject != null){
            Node lNewNode = new Node(pObject, null);
            if (this.isEmpty()){
                head = lNewNode;
                tail = lNewNode;
            }
            else{
                tail.setNext(lNewNode);
                tail = lNewNode;
            }
        }  
    }

    public void dequeue() 
    {
        if (!this.isEmpty()){
            head = head.next();
        }
    }

    public Object front(){
        if (this.isEmpty())
        {
            return null;
        }
        else{
            return head.content();
        }
    }
}
