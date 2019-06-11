package com.tie.algo.linkedlist;

/**
 * �жϻ���
 */
public class SinglyLinkedList {

    private Node head;

    public void insertTail(int data) {
        Node newNode = new Node(data, null);
        if (head == null) {
            head = newNode;
        }else {
            Node q = head;
            while (q.getNext() != null) {
                q = q.getNext();
            }
            q.setNext(newNode);
        }
    }

    public void print() {
        if (head != null) {
            Node q = this.head;
            System.out.println(q.getData() + ",");
            while (q.getNext() != null) {
                q = q.getNext();
                System.out.println(q.getData() + ",");
            }
        }
    }

    /**
     * �Ƿ��ǻ���
     * @return
     */
    public boolean isPalindrome() {
        if (head == null) {
            return false;
        }

        if (head.getNext() == null) {
            return true;
        }

        Node slow = head;
        Node fast = head;

        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        Node leftLink = null;
        Node rightLink = null;
        if (fast.getNext() == null) {
            //slowΪ�е�
            rightLink = slow.getNext();
            leftLink = inverseLinkList(slow).next;
        }else {
            //slow �� fast ��Ϊ�е�
            rightLink = slow.next;
            leftLink = inverseLinkList(slow);
        }

        return TFResult(leftLink, rightLink);
    }

    /**
     * ��תǰ�벿����
     * @param p
     */
    public Node inverseLinkList(Node p) {
       Node pre = null;
       Node r = head;
       Node next = null;
        while (r != p) {
            next = r.next;
            r.next = pre;
            pre = r;
            r = next;
        }

        r.next = pre;

        return r;
    }

    /**
     * �ж� true or false
     * @return
     */
    public boolean TFResult(Node left, Node right) {
        Node l = left;
        Node r = right;

        while (l != null && r != null) {
            if (l.data == r.data) {
                l = l.next;
                r = r.next;
                continue;
            }else {
                break;
            }
        }

        if (l == null && r == null) {
            return true;
        }else {
            return false;
        }
    }

    public static class Node{

        private int data;

        private Node next;

        public Node() {
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }



    public static void main(String[] args) {
        SinglyLinkedList link = new SinglyLinkedList();
        System.out.println("hello");
        //int data[] = {1};
        //int data[] = {1,2};
        //int data[] = {1,2,3,1};
        //int data[] = {1,2,5};
        //int data[] = {1,2,2,1};
         int data[] = {1,2,5,2,1};
//        int data[] = {1,2,5,3,1};

        for(int i =0; i < data.length; i++){
            //link.insertToHead(data[i]);
            link.insertTail(data[i]);
        }
        link.print();
        if (link.isPalindrome()) {
            System.out.println("����");
        }else {
            System.out.println("���ǻ���");
        }
    }
}
