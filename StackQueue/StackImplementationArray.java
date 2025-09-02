package Daily_DSA.StackQueue;

public class StackImplementationArray {
    int top = -1;
    int size = 10;
    int[] st = new int[size];


    /// printing the stack
    public void PrintStack(){
        for(int i = 0; i <= top; i++){
            System.out.print(st[i]+" ");
        }
        System.out.println();
    }

    /// push function
    public  void  push(int ele){
        if (top <= size){
            top+=1;
            st[top] = ele;
        }else{
            System.out.println("overflow of data");
        }
    }

    /// pop function
    public int pop(){
        if (top == -1){
            System.out.println("Stack does not have any element");
            return -1;
        }else{
            return st[top--];
        }
    }


    /// peek function
    public  int peek(){
        if (top == -1){
            System.out.println("stack does not have any element");
            return -1;
        }else{
            return st[top];
        }
    }


    ///  size of the stack
    public int Size(){
        return top+1;
    }
    public static void main(String[] args) {
        StackImplementationArray stack = new StackImplementationArray();
        stack.push(10);
        stack.push(5);
        stack.push(6);
        stack.push(15);
        stack.PrintStack();
        System.out.println("the pop element :- "+stack.pop());
        stack.PrintStack();
        stack.push(60);
        stack.PrintStack();
        System.out.println("the peeked element is :- "+stack.peek());
        stack.PrintStack();
    }
}
