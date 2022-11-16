package test6;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        supplement6_2();
    }

    private static void supplement6_1() throws Exception {
        Map bracket = new HashMap<Character, Character>();
        bracket.put(')', '(');
        bracket.put('}', '{');
        bracket.put(']', '[');

        Scanner sc = new Scanner(System.in);

        System.out.println("输入一个java语句");
        String s = sc.next();
        sc.close();
        boolean flag = true;
        Stack stack = new Stack(s.length());
        char[] c = new char[s.length()];
        c = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (bracket.containsValue(c[i])) {
                stack.Push(c[i]);
            } else if (bracket.containsKey(c[i])) {
                if (bracket.get(c[i]) == stack.Peak()) {
                    stack.Pop();
                } else {
                    flag = false;
                    break;
                }
            }
        }

        if (flag) {
            System.out.println("括号合法");
        } else {
            System.out.println("括号不合法");
        }
    }

    private static void supplement6_2() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入第一个大数");
        String st1 = sc.next();
        System.out.println("输入第二个大数");
        String st2 = sc.next();

        char[] ch1 = st1.toCharArray();
        char[] ch2 = st2.toCharArray();

        Stack s1 = new Stack(ch1.length);
        Stack s2 = new Stack(ch2.length);

        Stack result = new Stack((ch1.length > ch2.length) ? ch1.length : ch2.length + 1);
        int flag = 0;
        // for(int i = 0; i <
        // ((stack1.Length()>stack2.Length())?stack2.Length():stack1.Length()); i++) {

        // }
        for (int i = 0; i < ch1.length; i++) {
            s1.Push(Character.getNumericValue(ch1[i]));
        }
        for (int i = 0; i < ch2.length; i++) {
            s2.Push(Character.getNumericValue(ch2[i]));
        }

        while (!(s1.isEmpty() && s2.isEmpty())) {
            int a, b;
            if(s1.isEmpty()) {
                a =(int) s2.Pop();
                b = 0;
            } else if(s2.isEmpty()) {
                a = (int) s1.Pop();
                b = 0;
            } else {
                a = (int) s1.Pop();
                b = (int) s2.Pop();
            }
            int n = a + b + flag;
            flag = (n > 10) ? 1 : 0;
            result.Push(n - flag * 10);
        }

        while (!result.isEmpty()) {
            System.out.print(result.Pop());
        }
    }
}
// TODO: 分隔符匹配
// TODO: 大数相加
