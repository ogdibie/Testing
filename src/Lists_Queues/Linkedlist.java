package Lists_Queues;

import sun.awt.image.ImageWatched;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by ogheneruona on 3/14/16.
 */
public class Linkedlist<T> implements Iterable<T> {
    private Node<T> head;
    private int size;

    public Linkedlist(){
        head = null;
        size = 0;
    }

    public boolean isEmpty(){
        return head == null ;
    }

    /**
     * Adds a Node at the beginning of the list
     * @param value
     */

    //case 1 : Empty list-- keeping track of the head Node
    // more than 1 element
    public void addFirst(T value){
        if(this.isEmpty()){
            head = new Node<>(value);
        }else{
            Node<T> newNode = new Node<>(value);
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    /**
     * returns the first element in the list
     * @return
     */
    public T getFirst(){
        if (head == null)
            throw new NoSuchElementException();
        return head.value;
    }

    /**
     * Removes the first element in the list and return it
     * throw out of bound exception if there is no element to remove
     * @return
     */
    public T removeFirst(){
        if (this.isEmpty()){
            throw new IndexOutOfBoundsException();
        }
        T value = head.value;
        head = head.next;
        size--;

        return value;
    }

    /**
     * Adds an element to the end of a list
     */
    public void addLast(T value){
        if(this.isEmpty()){
            addFirst(value);
        }
        else{
            Node<T> temp = head;
            while(temp.next !=null){
                temp = temp.next;
            }

            temp.next = new Node<T>(value);
        }

        size++;
    }

    /**
     * return mtoLast element
     * 1->2->3->4->5
     * 2 to last return 3
     */
    public T getMtolast(int m){
        //get the total number of element in the list
        Node<T> temp = head;
        int sizeoflist = 0;
        while (temp !=null){
            sizeoflist++;
            temp = temp.next;
        }

        int n = sizeoflist - m;

        temp = head;
        for (int i = 1; i< n; i++){
            temp = temp.next;
        }

        return temp.value;
    }

    /**
     * Removes duplates from a linkedlist
     * 1->2->3->5->2->3->1
     */
    public void removeduplicates(){
        Node<T> check = head;
        Node<T> cur;
        Node<T> prev;
        //loop through the rest and remove it if it already exist
        while (check !=null){
            prev = check;
            cur = check.next;
            while (cur !=null){
                if (check.value.equals(cur.value)){
                    prev.next = cur.next;
                    cur = cur.next;
                }
                else {
                    prev = cur;
                    cur = cur.next;
                }

            }

            check = check.next;
        }
    }


    /**
     * Gets the last element in the list
     * @return
     */
    public T getlast(){
        Node<T> temp = head;
        while (temp.next !=null){
            temp = temp.next;
        }

        return temp.value;
    }

    /**
     * removes all elements from the linkedlist
     */
    public void clear(){
        head = null;
    }

    /**
     *
      * @param value
     * @return true if value is contained in the linkedlist
     */
   public boolean contains(T value){

       for (T tmp : this){
           if(tmp.equals(value))
               return true;
       }
       return false;
   }

    /**
     *
     * @param pos
     * @return the data at pos
     */
    public  T get(int pos){
        if (head == null) throw new IndexOutOfBoundsException();

        Node<T> tmp = head;
        for (int i=0; i < pos && tmp!=null; i++){
            tmp = tmp.next;
        }

        if (tmp ==null)
            throw new IndexOutOfBoundsException();
        return tmp.value;
    }

    /**
     * String representation of the Linkedlist
     * @return
     */
    public String toString(){
        StringBuffer sb = new StringBuffer();
        for (T value : this){
            sb.append(" ");
            sb.append(value);
        }

        return sb.toString();
    }
    @Override
    public Iterator iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T>{
        private Node<T> nextNode;

        public LinkedListIterator(){
            nextNode = head;
        }
        @Override
        public boolean hasNext() {
            return nextNode !=null;
        }

        @Override
        public T next() {
            if(!hasNext()) throw new NoSuchElementException();
            T value = nextNode.value;
            nextNode = nextNode.next;

            return value;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private static class Node<T> {

        //fields
        T value;
        Node<T> next;

        public Node(T value){
            this.value = value;
            this.next = null;
        }
    }

    public static void main(String[] args){
        Linkedlist<Integer> integers = new Linkedlist<>();

        integers.addFirst(1);
        integers.addLast(2);
        integers.addLast(3);
        integers.addLast(4);
        integers.addLast(5);

        System.out.println(integers);

        System.out.println(integers.getMtolast(2));
    }
}
