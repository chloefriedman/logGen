
/**
 * This LinkedLog object represents a Log ADT implemented as
 * a LinkedList using the EnhancedLogInterface.
 * 
 * @author 
 * @version 
 */
public class LinkedLog<T> implements EnhancedLogInterface<T>
{
    private LLNode<T> log;
    private String name;
    private int size;

    public LinkedLog(String name)
    {
        this.name = name;
        size = 0;
        log = null;
    }
    
    // returns the name of this StringLog
    public String getName()
    {
        return name;
    }

    // returns the logical size of this StringLog
    public int size()
    {
        return size;
    }
    
    // returns true if this list contains no elements
    public boolean isEmpty()
    {
        return(size == 0);
    }
    
    // returns true if this list is completely full
    public boolean isFull()
    {
        return false;
    }

    // appends the specified element to the end of this list
    public void add(T element)
    {
        LLNode<T> toAdd = new LLNode<>(element);
        if(log == null)
        {
            log = new LLNode<T>(element);;
        }
        
        else
        {
            LLNode<T> temp = log;
            while(temp.getLink() != null)
            {
             temp = temp.getLink();
            }
            temp.setLink(toAdd);
        }
        size++;
    }
  
    // returns the element at the specified position in this list
    public T get(int index)
    {
        if(index > size || index < 0)
        {
            throw new IndexOutOfBoundsException("Index not in range");
        }
        else
        {
            int current = 0;
            LLNode<T> temp = log;
            while(current != index)
            {
                temp = temp.getLink();
                current++;
            }
            return temp.getInfo();
        }
        
    }
    
    // returns the index of the first occurance of the specified element
    // in this list, or -1 if this list does not contain the element
    public int indexOf(T element)
    {
        if(size == 0)
        {
            return -1;
        }
        else
        {
            int index = 0;
            LLNode<T> temp = log;
            while(index < size)
            {
                if(temp.getInfo() == element)
                {
                    return index;
                }
                else
                {
                    index ++;
                    temp = temp.getLink();
                }
            }
        }
        return -1;
    }
    
    // returns true if this list contains the specified element
    public boolean contains(T element)
    {
        if(indexOf(element) == -1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
    // returns a formatted string representation of this StringLog
    public String toString()
    {
        String result = "Log: " + name + "\n";
        LLNode<T> curNode = log;
        int count = 0;
    
        while (curNode != null)
        {
            count++;
            result += count + ". " + curNode.getInfo() + "\n";
            curNode = curNode.getLink();
        }
    return result;
    }
    
    // replaces the element at the specified position in this list
    // with the specified element
    public T set(int index, T element)
    {
        if(index >= size || index < 0)
        {
            throw new IndexOutOfBoundsException("Index is not in bound of list");
        }
        else if(log == null)
        {
            throw new NullPointerException("List is not initialized");
        }
        else
        {
            LLNode<T> temp = log;
            for(int i = 0; i < index; i++)
            {
                temp = temp.getLink();
            }
            T a = temp.getInfo();
            temp.setInfo(element);
            return a;
        }
    }
    
    // inserts the specified element at the specified position in this list
    public void add(int index, T element)
    {   
        if(index > size || index < 0)
        {
            throw new IndexOutOfBoundsException("Index to add is not valid");
        }
        else if(index == 0)
        {
            LLNode<T> toAdd = new LLNode<T>(element);
            toAdd.setLink(log);
            log = toAdd;
        }
        else if (index == size)
        {
            LLNode<T> temp = log;
            for(int i = 0; i < size; i++)
            {
                temp = temp.getLink();
            }
            LLNode<T> toAdd = new LLNode<T>(element);
            temp.setLink(element);
        }
        else
        {
            LLNode<T> temp = log;
            for(int i = 0; i < index-1; i++)
            {
                temp = temp.getLink();
            }
            LLNode<T> toAdd = new LLNode<T>(element);
            element.setLink(temp.getLink());
            temp.setLink(toAdd);
        }
    }
    
    // removes the element at the specified position in this list
    public T remove(int index)
    {
        if(index >= size || index < 0)
        {
            throw new IndexOutOfBoundsException("Index to add is not valid");
        }
        else if(size == 0)
        {
            throw new NullPointerException("No elements in list");
        }
        else if(index == 0)
        {
            if(size == 1)
            {
                LLNode<T> toRemove = log;
                log = null;
                return toRemove;
            }
            else
            {
                LLNode<T> toRemove = log;
                LLNode<T> second = log.getLink();
                log.setLink(null);
                log = second;
                return toRemove;
            }
            size--;
        }
        else if(index = size - 1)
        {
            LLNode<T> temp = log;
            for(int i = 0; i < size - 2; i++)
            {
                temp = temp.getLink();
            }
            LLNode<T> toRemove = temp.getLink();
            temp.setLink(null);
            size--;
            return toRemove;
        }
        else
        {
            LLNode<T> temp = log;
            for(int i = 0; i < index - 1; i++) //one before index to remove
            {
                temp = temp.getLink();
            }
            LLNode<T> toRemove = temp.getLink();
            temp.setLink(toRemove.getLink());
            toRemove.setLink(null);
            size--;
            return toRemove;
        }
    }
    
    // removes the first occurance of the specified element from this
    // list, if it is present
    public boolean remove(T element)
    {
        int index = indexOf(element);
        if(index == -1)
        {
            return false;
        }
        else
        {
            remove(index);
            return true;
        }
    }
        
    // removes all of the elements from this list
    public void clear()
    {
        log = null;
    }
}
