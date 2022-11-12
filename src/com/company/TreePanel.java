package com.company;

import javax.swing.*;
import java.awt.*;

public class TreePanel extends JPanel {

    private BinaryTree binaryTree;

    public TreePanel(BinaryTree binaryTree) {

        this.binaryTree = binaryTree;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawString("Aufgabe 4:", 20, 20);
        this.binaryTree.getRoot().point = new Point(this.getWidth() / 2, 40);

        paintRecursive(this.binaryTree.getRoot(), g, 1.0f);
    }

    public void paintRecursive(TreeNode currentNode, Graphics g, float ratio) {

        if (currentNode != null) {

            g.drawOval(currentNode.point.x, currentNode.point.y, 20, 20);
            g.drawString(String.valueOf(currentNode.getKey()), currentNode.point.x + 6, currentNode.point.y + 15);

            if (currentNode.getLeftSon() != null) {

                currentNode.getLeftSon().point = new Point(currentNode.point.x - (int) (200 * (ratio * ratio * ratio)), currentNode.point.y + 50);

                g.drawLine(currentNode.point.x, currentNode.point.y + 10, currentNode.getLeftSon().point.x + 10, currentNode.getLeftSon().point.y);
                g.drawOval(currentNode.getLeftSon().point.x, currentNode.getLeftSon().point.y, 20, 20);
                g.drawString(String.valueOf(currentNode.getLeftSon().getKey()), currentNode.getLeftSon().point.x + 5, currentNode.getLeftSon().point.y + 15);
            }
            if (currentNode.getRightSon() != null) {

                currentNode.getRightSon().point = new Point(currentNode.point.x + (int) (200 * (ratio * ratio * ratio)), currentNode.point.y + 50);

                g.drawLine(currentNode.point.x + 20, currentNode.point.y + 10, currentNode.getRightSon().point.x + 10, currentNode.getRightSon().point.y);
                g.drawOval(currentNode.getRightSon().point.x, currentNode.getRightSon().point.y, 20, 20);
                g.drawString(String.valueOf(currentNode.getRightSon().getKey()), currentNode.getRightSon().point.x + 5, currentNode.getRightSon().point.y + 15);
            }
            paintRecursive(currentNode.getLeftSon(), g, ratio - 0.15f);
            paintRecursive(currentNode.getRightSon(), g, ratio - 0.15f);
        }
    }
}
