package Daily_DSA.StackQueue;

public class QueueImplementationArray {
    int size = 10, start = -1, end = -1;
    int[] queue = new int[size];
    int CurrSize = 0;

    ///  push function
    public void push(int ele){
        if (CurrSize == size) {
            System.out.println("you can not push, it is full");
            return;
        }
        if (CurrSize == 0){
            start = 0;
            end = 0;
        }else {
            end = (end+1)%size;
        }
        queue[end] = ele;
        CurrSize++;
    }



    /// pop operation in Queue
    public int pop(){
        if (CurrSize == 0){
            System.out.println("stack is empty , you can not pop");
            return -1;
        }
        int el = queue[start];
        if (CurrSize == 1){
            start = end = -1;
        }else{
            start = (size+1)%size;
        }
        CurrSize -=1;
        return el;
    }



    ///  peek operation
    public int peek(){
        if (CurrSize == 0){
            System.out.println("you don't have element");
            return -1;
        }
        return queue[start];
    }


    ///  size
    public int Size(){
        return CurrSize;
    }
    public static void main(String[] args) {
        QueueImplementationArray Q = new QueueImplementationArray();
        Q.push(56);
    }
}
