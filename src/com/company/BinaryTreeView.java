package com.company;

import javax.swing.*;
import java.awt.*;

public class BinaryTreeView extends JFrame {

    private BinaryTree binaryTree;
    private TreePanel treePanel;

    public BinaryTreeView(BinaryTree binaryTree) {

        this.binaryTree = binaryTree;
        this.treePanel = new TreePanel(this.binaryTree);
    }

    public void initialise() {

        this.add(this.treePanel);
        this.setTitle("Natürlicher Binärbaum");
        this.setSize(1200, 675);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
}
