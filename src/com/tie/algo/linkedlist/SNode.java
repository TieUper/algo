package com.tie.algo.linkedlist;

/**
 * Á´±í½Úµã
 * @param <T>
 */
public class SNode<T> {

    private T element;

    private SNode next;

    public SNode() {
    }

    public SNode(T element, SNode next) {
        this.element = element;
        this.next = next;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public SNode getNext() {
        return next;
    }

    public void setNext(SNode next) {
        this.next = next;
    }
}
