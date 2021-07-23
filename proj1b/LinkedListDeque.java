
public class LinkedListDeque<T> implements Deque<T>{
    private class Node{
        private Node pre;
        private T item;
        private Node next;

        private Node(T x, Node p, Node n){
            pre = p;
            item = x;
            next = n;
        }

    }

    private Node sentinel;
    private int size;

    public LinkedListDeque(){
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.pre = sentinel;
    }

    public int size(){
        return size;

    }

    public void addFirst(T item){
        Node newNode = new Node(item, sentinel, sentinel.next);
        sentinel.next.pre = newNode;
        sentinel.next = newNode;
        size++;

    }

    public void addLast(T item){
        Node newNode = new Node(item, sentinel.pre, sentinel);
        sentinel.pre.next = newNode;
        sentinel.pre = newNode;
        size++;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void printDeque(){
        Node toPrint = sentinel.next;
        for (int i =0; i < size; i++){
            System.out.println(toPrint.item + " ");
            toPrint = toPrint.next;
        }
        System.out.println();
    }

    public T removeLast(){
        Node toRemove = sentinel.pre;
        sentinel.pre = toRemove.pre;
        toRemove.pre.next = sentinel;
        if (!isEmpty())
            size--;
        return toRemove.item;
    }
    @Override
    public T get(int index) {
        Node toGet = sentinel.next;
        for (int i = 0; i < index; i++) {
            toGet = toGet.next;
        }
        return toGet.item;
    }
    public T removeFirst(){
        Node toRemove = sentinel.next;
        toRemove.next.pre = sentinel;
        sentinel.next = toRemove.next;
        if (!isEmpty())
            size--;
        return toRemove.item;
    }
    private T getRecursive(int index, Node curr) {

        if (index == 0) {
            return curr.item;
        }
        return getRecursive(index - 1, curr.next);
    }

    public T getRecursive(int index) {
        return getRecursive(index, sentinel.next);
    }

}
