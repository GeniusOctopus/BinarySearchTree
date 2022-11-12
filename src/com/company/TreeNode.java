package com.company;

import java.awt.*;

public class TreeNode {

    private int key;
    private TreeNode leftSon;
    private TreeNode rightSon;
    public Point point;

    public TreeNode(int key) {

        this.key = key;
        this.leftSon = null;
        this.rightSon = null;
        this.point = new Point(0, 0);
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public TreeNode getLeftSon() {
        return leftSon;
    }

    public void setLeftSon(TreeNode leftSon) {
        this.leftSon = leftSon;
    }

    public TreeNode getRightSon() {
        return rightSon;
    }

    public void setRightSon(TreeNode rightSon) {
        this.rightSon = rightSon;
    }
}
