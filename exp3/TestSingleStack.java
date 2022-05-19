public class TestSingleStack {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SingleStack<Integer> ss = new SingleStack<Integer>();
        Integer[] a = {1,2,3};
        for (Integer integer : a) {
            ss.push(integer);
        }
        ss.printStack();
        System.out.println("The top element in stack is: "+ss.top());
        System.out.println("The popped elements in stack are: ");
        while (!ss.isEmpty()){
            System.out.printf("%d ",ss.pop());
        }
        System.out.println();
    }

}
