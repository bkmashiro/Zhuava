public class SingleStack<AnyType> {
    private Node<AnyType> head;

    SingleStack(){
        head = new Node<AnyType>(null, null);
    }

    void push(AnyType x){
        Node<AnyType> p = new Node<AnyType>(x, head.next);
        head.next = p;
    }
    AnyType top() {
        if(head.next == null) {
            return null;
        }
        else {
            return head.next.data;
        }

    }
    AnyType pop() {
        if(head.next == null) {
            return null;
        }
        else {
            AnyType temp = head.next.data;
            head.next = head.next.next;
            return temp;
        }
    }
    public void printStack() {
        Node<AnyType> p = head;
        System.out.println("The elements in stack are:");
        while(p.next != null) {
            System.out.println(p.next.data);
            p = p.next;
        }
    }
    boolean isEmpty(){
        return head.next==null;
    }
    private class Node<AnyType>{
        AnyType data;
        Node<AnyType> next;
        Node(){
            this(null, null);
        }
        Node(AnyType x){
            this(x, null);
        }
        Node(AnyType x, Node<AnyType> p){
            data = x;
            next = p;
        }
    }
}
