package com.perusahaan;

import java.util.*;

public class SinglyLinkedList<E> {
    private ListNode<E> firstNode;
    private ListNode<E> lastNode;
    private String name;

    public SinglyLinkedList() {
        this("linked list");
    }
    public SinglyLinkedList(String listName) {
        name = listName;
        firstNode = lastNode = null;
    }

    //input posisi data di bagian awal
    public void tambahDiAwal(E insertItem) {
        ListNode newNode = new ListNode(insertItem);

        if (isEmpty()) {
            firstNode = lastNode = new ListNode<E>(insertItem);
        } else {
            newNode.next = firstNode;
            firstNode = newNode;
        }
    }

    //input posisi data di bagian akhir
    public void tambahDiAkhir(E insertItem) {
        ListNode newNode = new ListNode(insertItem);
        if (isEmpty()) {
            firstNode = lastNode = new ListNode<E>(insertItem);
        } else {
            lastNode.next = newNode;
            lastNode = newNode;
        }
    }

    //Hapus data di bagian awal
    public E hapusDiAwal() throws NoSuchElementException {
        E removedItem = firstNode.data;
        if (isEmpty()){
            throw new NoSuchElementException(name + " is empty");
        }
        if(firstNode != null){
            ListNode temp = new ListNode(firstNode);
            firstNode = firstNode.next;
            temp = null;
        }
        return removedItem;
    }

    //Hapus data di bagian akhir
    public E hapusDiAkhir() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException(name + " is empty");
        }
        E removedItem = lastNode.data;

        if (firstNode == lastNode) {
            firstNode = lastNode = null;
        } else {
            ListNode<E> current = firstNode;
            while (current.next != lastNode) {
                current = current.next;
            }
            lastNode = current;
            current.next = null;
        }
        return removedItem;
    }

    private boolean isEmpty() {
        return firstNode == null;
    }
    public void print() {
        if (isEmpty()) {
            System.out.printf("Empty %s%n", name);
            return;
        }
        System.out.printf("The %s is: %n", name);
        ListNode<E> current = firstNode;
        while (current != null) {
            System.out.printf("%s ", current.data);
            current = current.next;
        }
        System.out.println();
    }
}

