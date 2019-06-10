package com.tie.algo.linkedlist;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.LocatorEx;

import java.util.Scanner;

public class LRUBaseLinkedList<T> {

    /**
     * 链表容量
     */
    private Integer capacity;

    /**
     * 链表长度
     */
    private int length;

    /**
     * 头结点
     */
    private SNode<T> headNode;

    /**
     * 默认容量
     */
    public static final int DEFAULT_CAPACITY = 10;

    public LRUBaseLinkedList() {
        this.headNode = new SNode<>();
        this.capacity = DEFAULT_CAPACITY;
        this.length = 0;
    }

    public LRUBaseLinkedList(Integer capacity) {
        this.headNode = new SNode<>();
        this.capacity = capacity;
        this.length = 0;
    }

    public void add(T data) {
        SNode preNode = getPreNode(data);
        if (preNode != null) {
            deleteElemOptim(preNode);
            insertAtBegin(data);
        }else {
            if (length >= this.capacity) {
                //删除尾结点
                deleteElemAtEnd();
            }
            insertAtBegin(data);
        }
    }

    /**
     * 在列首插入元素
     * @param data
     */
    public void insertAtBegin(T data) {
        SNode next = headNode.getNext();
        headNode.setNext(new SNode(data,next));
        length++;
    }

    /**
     * 删除preNode结点下一个元素
     * @param preNode
     */
    private void deleteElemOptim(SNode preNode) {
        SNode temp = preNode.getNext();
        preNode.setNext(temp.getNext());
        temp = null;
        length--;
    }

    /**
     * 删除尾结点
     */
    private void deleteElemAtEnd() {
        SNode ptr = headNode;
        //空链表
        if (ptr.getNext() == null) {
            return;
        }

        //倒数第二个结点
        while ((ptr.getNext().getNext() != null)) {
            ptr = ptr.getNext();
        }

        SNode tmp = ptr.getNext();
        ptr.setNext(null);
        tmp = null;
        length --;
    }

    /**
     * 获取查找元素的上一个节点
     * @param node
     * @return
     */
    public SNode getPreNode(T node) {
        SNode preNode = headNode;
        while (preNode.getNext() != null) {
            if (node.equals(preNode.getNext().getElement())) {
                return preNode;
            }
            preNode = preNode.getNext();
        }
        return null;
    }

    private void printAll() {
        SNode node = headNode.getNext();
        while (node != null) {
            System.out.println(node.getElement() + ",");
            node = node.getNext();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LRUBaseLinkedList<Object> list = new LRUBaseLinkedList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            list.add(scanner.next());
            list.printAll();
        }
    }
}
