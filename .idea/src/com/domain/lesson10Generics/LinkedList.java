package com.domain.lesson10Generics;

public class LinkedList<T> {
    private Node head;
    private Node last;

    public void remove(T elem){
        if (head == null) return;



    }

    public void add(T value){
        if (head == null) {
            head = new Node<>(value);
            last = head;
            return;
        }
        find(-1).next = new Node<>(value);
    }

    public T get (int ind){
        Node<T> result = find (ind);
        return result == null ? null : result.value;
    }


    private Node find(int ind){
        if (ind == 0 )return  head;

        int cnt = 0;
        Node node = head;
        while (node != null){
            if (cnt++ == ind) return node;
            if (ind < 0  && node.next == null) return node;
            node = node.next;

        }
        return  null;
    }

}

class Node <T>{
    T value;
    Node next;

    public Node(T value){
        this.value = value;

    }
}

