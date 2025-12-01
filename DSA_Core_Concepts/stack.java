package DSA_Core_Concepts;

import java.util.Stack;

public class stack{
public static void main(String args[]){
    Stack<Integer> stack = new Stack<>();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    System.out.println("Stack before push:"+ stack);

    // stack.pop(1);
    stack.pop();
    System.out.println("Stack after push:"+ stack);
}
}
