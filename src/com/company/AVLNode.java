package com.company;

public class AVLNode {

    private int key;
    private int height;
    private AVLNode leftSon;
    private AVLNode rightSon;

    public AVLNode(int key) {

        this.key = key;
        this.height = 0;
        this.leftSon = null;
        this.rightSon = null;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public AVLNode getLeftSon() {
        return leftSon;
    }

    public void setLeftSon(AVLNode leftSon) {
        this.leftSon = leftSon;
    }

    public AVLNode getRightSon() {
        return rightSon;
    }

    public void setRightSon(AVLNode rightSon) {
        this.rightSon = rightSon;
    }
}
