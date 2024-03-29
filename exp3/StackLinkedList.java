public class StackLinkedList<T> {
    private Node<T> top = new Node<T>();

    public T pop() {
        T res = top.item;
        if(!top.end())
            top = top.next;
        return res;
    }

    public void push(T item){
        top = new Node<T>(item, top);
    }

    public T peek(){
        return top.item;
    }

    public void empty(){
        top = new Node<T>();
    }

    public boolean isEmpty(){
        return top.next==null;
    }

    private static class Node<U> {
        U item;
        Node<U> next;
        Node() {item = null; next = null;}
        Node(U item, Node<U> next){
            this.item = item;
            this.next = next;
        }
        boolean end() {
            return item == null && next == null;
        }
    }
}
