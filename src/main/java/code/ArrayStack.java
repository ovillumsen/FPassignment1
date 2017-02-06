/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

/**
 *
 * @author Oliver
 */
public class ArrayStack<T> {

    private T[] array;
    private int top = 0;

    @SuppressWarnings("unchecked")
    public ArrayStack(int num) {
        array = (T[]) new Object[num];
    }

    public void push(T o) {
        array[top] = o;
        top++;
    }

    public T pop() {
        top--;
        T o = array[top];
        array[top] = null;
        return o;
    }

    public boolean isEmpty() {
        return array[top - 1] == null;
    }

    public void print() {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                System.out.println(array[i]);
            }
        }
    }
}
