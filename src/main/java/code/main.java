/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

import java.util.Scanner;

/**
 *
 * @author Oliver
 */
@SuppressWarnings("unchecked")
public class main {

    private static ArrayStack stack;

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String[] arggs;
        while (true) {
            String str = scn.nextLine();
            arggs = str.split(" ");
            if(stack == null){
            stack = new ArrayStack(1000);
            }
            run(0, arggs);
            stack.print();
        }
    }

    public static void run(int index, String[] array) {
        if (index >= array.length) {
            return;
        }
        if (isNumeric(array[index])) {
            stack.push(Integer.parseInt(array[index]));
            run(index + 1, array);
        } else {
            operators(array[index]);
            run(index + 1, array);
        }
    }

    public static void operators(String str) {
        int numOne;
        int numTwo;
        switch (str) {
            case "+":
                numOne = (int) stack.pop();
                numTwo = (int) stack.pop();
                stack.push(numOne + numTwo);
                break;
            case "-":
                numOne = (int) stack.pop();
                numTwo = (int) stack.pop();
                stack.push(numOne - numTwo);
                break;
            case "*":
                numOne = (int) stack.pop();
                numTwo = (int) stack.pop();
                stack.push(numOne * numTwo);
                break;
            case "/":
                numOne = (int) stack.pop();
                numTwo = (int) stack.pop();
                stack.push(numOne / numTwo);
                break;
        }
    }

    public static boolean isNumeric(String str) {
        try {
            int i = Integer.parseInt(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

}
