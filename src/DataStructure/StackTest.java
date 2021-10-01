package DataStructure;

import java.util.ArrayList;

public class StackTest<T> {
    private ArrayList<T> stack = new ArrayList<T>();

    public void push(T item){
        stack.add(item);
    }

    public T pop(){
        if (stack.isEmpty()){
            return null;
        }
        return stack.remove(stack.size() -1);
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }

    public static void main(String[] args){
        StackTest<Integer> st = new StackTest<>();
        st.push(1);
        System.out.println(st.pop());
    }
}
