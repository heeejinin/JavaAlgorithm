// 선형 자료구조 - 스택

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack);

        System.out.println(stack.pop());
        System.out.println(stack);

        System.out.println(stack.pop());
        System.out.println(stack);

        System.out.println(stack.peek()); // 3
        System.out.println(stack); // [1, 2, 3]

        System.out.println(stack.contains(1)); // true
        System.out.println(stack.size()); // 3
        System.out.println(stack.empty()); // false

        stack.clear();
        System.out.println(stack); //[]
        stack.pop(); //에러 발생 더 이상 꺼낼 데이터 x
    }

}
