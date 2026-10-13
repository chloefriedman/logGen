public class Node<T>
{
    T data;
    Node<T> next;
    public Node(T data)
    {
        this.data = data;
        this.next = null;
    }

    public void setLink(Node other)
    {
        next = other;
    }

    public Node<T> getNext(){
        return next;
    }

    public T getData()
    {
        return data;
    }

    public String toString(){
        return "" + data;
    }

    public void printAll()
    {
        Node<T> temp = this;
        while(temp != null)
        {
            System.out.println(temp.getData());
            temp = temp.getNext();
        }
    }
}
