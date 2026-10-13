public class LearningLinks
{
    public static void main(String[] args) {
        Node one = new Node(20);
       // System.out.println(one);

       // Node two = new Node(30);
        one.setLink(new Node(30));

      //  System.out.println(one.next);

      //  Node three = new Node(40);
        one.getNext().setLink(new Node(40));

      //  System.out.println(one.getNext().getNext());

        Node temp = one;
        while(temp != null)
        {
            System.out.println(temp.getData());
            temp = temp.getNext();
        }
        temp = one;
        while(temp.getNext()!=null)
        {
            temp = temp.getNext();
        }
        temp.setLink(new Node(50));

        Node newFirst = new Node(10);
        newFirst.setLink(one);

        temp = one;
        while(temp.getNext().getNext() != null)
        {
            temp = temp.getNext();
        }
        temp.setLink(null);
        System.out.println();
        newFirst.printAll();
    }
}
