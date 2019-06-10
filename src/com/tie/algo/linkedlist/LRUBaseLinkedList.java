package com.tie.algo.linkedlist;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.LocatorEx;

import java.util.Scanner;

public class LRUBaseLinkedList<T> {

    /**
     * ��������
     */
    private Integer capacity;

    /**
     * ������
     */
    private int length;

    /**
     * ͷ���
     */
    private SNode<T> headNode;

    /**
     * Ĭ������
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
                //ɾ��β���
                deleteElemAtEnd();
            }
            insertAtBegin(data);
        }
    }

    /**
     * �����ײ���Ԫ��
     * @param data
     */
    public void insertAtBegin(T data) {
        SNode next = headNode.getNext();
        headNode.setNext(new SNode(data,next));
        length++;
    }

    /**
     * ɾ��preNode�����һ��Ԫ��
     * @param preNode
     */
    private void deleteElemOptim(SNode preNode) {
        SNode temp = preNode.getNext();
        preNode.setNext(temp.getNext());
        temp = null;
        length--;
    }

    /**
     * ɾ��β���
     */
    private void deleteElemAtEnd() {
        SNode ptr = headNode;
        //������
        if (ptr.getNext() == null) {
            return;
        }

        //�����ڶ������
        while ((ptr.getNext().getNext() != null)) {
            ptr = ptr.getNext();
        }

        SNode tmp = ptr.getNext();
        ptr.setNext(null);
        tmp = null;
        length --;
    }

    /**
     * ��ȡ����Ԫ�ص���һ���ڵ�
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
