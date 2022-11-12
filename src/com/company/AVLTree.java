package com.company;

public class AVLTree {

    private AVLNode root;
    private String relationship = "R = { ";

    public AVLTree(int[] keys) {

        initialise(keys);
    }

    private void initialise(int[] keys) {

        for (int key : keys) {

            root = insert(root, key);
        }
    }

    private void updateHeight(AVLNode n) {
        n.setHeight(1 + Math.max(height(n.getLeftSon()), height(n.getRightSon())));
    }

    private int height(AVLNode n) {
        return n == null ? -1 : n.getHeight();
    }

    private int getBalance(AVLNode n) {
        return (n == null) ? 0 : height(n.getRightSon()) - height(n.getLeftSon());
    }

    private AVLNode rotateRight(AVLNode y) {

        AVLNode x = y.getLeftSon();
        AVLNode z = x.getRightSon();
        x.setRightSon(y);
        y.setLeftSon(z);
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    private AVLNode rotateLeft(AVLNode y) {

        AVLNode x = y.getRightSon();
        AVLNode z = x.getLeftSon();
        x.setLeftSon(y);
        y.setRightSon(z);
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    private AVLNode rebalance(AVLNode z) {

        updateHeight(z);
        int balance = getBalance(z);

        if (balance > 1) {

            if (height(z.getRightSon().getRightSon()) > height(z.getRightSon().getLeftSon())) {

                z = rotateLeft(z);
            } else {

                z.setRightSon(rotateRight(z.getRightSon()));
                z = rotateLeft(z);
            }
        } else if (balance < -1) {

            if (height(z.getLeftSon().getLeftSon()) > height(z.getLeftSon().getRightSon())) {

                z = rotateRight(z);
            } else {

                z.setLeftSon(rotateLeft(z.getLeftSon()));
                z = rotateRight(z);
            }
        }
        return z;
    }

    public AVLNode insert(AVLNode node, int key) {

        if (node == null) {

            return new AVLNode(key);
        } else if (node.getKey() > key) {

            node.setLeftSon(insert(node.getLeftSon(), key));
        } else if (node.getKey() < key) {

            node.setRightSon(insert(node.getRightSon(), key));
        } else {

            throw new RuntimeException("duplicate Key!");
        }
        return rebalance(node);
    }

    private void searchRecursive(AVLNode currentNode) {

        if (currentNode != null) {

            relationship += " { " + currentNode.getKey() + ", ";
            if (currentNode.getLeftSon() != null) {
                relationship += currentNode.getLeftSon().getKey() + ", ";
            } else {
                relationship += "null, ";
            }
            if (currentNode.getRightSon() != null) {
                relationship += currentNode.getRightSon().getKey() + " }, ";
            } else {
                relationship += "null }, ";
            }
            searchRecursive(currentNode.getLeftSon());
            searchRecursive(currentNode.getRightSon());
        }
    }

    public String print() {

        searchRecursive(root);
        relationship += " }";
        return relationship;
    }

    public int computeHeight(AVLNode currentNode) {

        if (currentNode == null) {

            return 0;
        } else {

            int leftHeight = computeHeight(currentNode.getLeftSon());
            int rightHeight = computeHeight(currentNode.getRightSon());

            if (leftHeight > rightHeight) {
                return (leftHeight + 1);
            } else {
                return (rightHeight + 1);
            }
        }
    }

    public AVLNode getRoot() {
        return root;
    }

    public void setRoot(AVLNode root) {
        this.root = root;
    }
}
