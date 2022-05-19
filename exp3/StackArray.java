public class StackArray {
    final int INIT_CAP = 32;
    int[] s;
    int stack_top=-1;
    int capacity;
    private void setCapacity(int cap){
        s = new int[cap];
        capacity=cap;
    }
    public StackArray(){
        setCapacity(INIT_CAP);
    }
    public StackArray(int capacity){
        setCapacity(capacity);
    }
    public void push(int v){
        if(!isFull()){
            s[++stack_top]=v;
        }else throw new IndexOutOfBoundsException();
    }
    public int pop(){
        if(!isEmpty()){
            return s[stack_top--];
        }else throw new IndexOutOfBoundsException();
    }
    public int peek(){
        return s[stack_top];
    }
    public boolean isEmpty(){
        return stack_top==-1;
    }
    public boolean isFull(){
        return stack_top==capacity-1;
    }
    public void empty(){
        stack_top=-1;
    }
}