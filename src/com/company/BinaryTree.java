package com.company;

public class BinaryTree {

    private TreeNode root;
    private String relationship = "R = { ";

    public BinaryTree(int[] keys) {

        initialise(keys);
    }

    private void initialise(int[] keys) {

        for (int key : keys) {

            root = addRecursive(root, key);
        }
    }

    private TreeNode addRecursive(TreeNode currentNode, int key) {

        if (currentNode == null)
            return new TreeNode(key);

        if (key <= currentNode.getKey()) {

            currentNode.setLeftSon(addRecursive(currentNode.getLeftSon(), key));
        } else if (key > currentNode.getKey()) {

            currentNode.setRightSon(addRecursive(currentNode.getRightSon(), key));
        } else {

            return currentNode;
        }

        return currentNode;
    }

    private void searchRecursive(TreeNode currentNode) {

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

    public int computeHeight(TreeNode currentNode) {

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

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }
}
