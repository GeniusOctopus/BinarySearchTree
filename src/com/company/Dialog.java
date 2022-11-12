package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Dialog {

    private boolean shouldShowDetails = true;
    private int boundSingleTree = 0;
    private int keyCountSingleTree = 0;
    private int treeCount = 0;
    private int boundMultipleTrees = 0;
    private int keyCountMultipleTrees = 0;
    private int heightOfMultipleBinaryTrees = 0;
    private int averageBinaryTreeHeight = 0;
    private int heightOfMultipleAVLTrees = 0;
    private int averageAVLTreeHeight = 0;
    private Random random;

    public void aufgabe4() {

        // Dialog
        System.out.println("=================================================");
        System.out.println("Erzeugen und Analysieren eines binären Suchbaumes");
        System.out.println("=================================================\n");
        System.out.println("Was soll der größtmögliche ganzzahlige Schlüssel sein? (Bitte eingeben):");
        boundSingleTree = Integer.parseInt(System.console().readLine());
        System.out.println("Wieviele ganzzahlige Schlüssel zwischen 0 und " + boundSingleTree + " sollen erzeugt werden? (Bitte eingeben):");
        keyCountSingleTree = Integer.parseInt(System.console().readLine());

        // Initialisieren eines Arrays von Ganzzahlen mit den vorher erfragten Parametern
        random = new Random();
        int[] keys = new int[keyCountSingleTree];

        // Füllen des Arrays und gleichzeitige Ausgabe der Werte auf der Konsole
        System.out.println("\n" + keyCountSingleTree + " zufällige ganzzahlige Schlüssel zwischen 0 und " + boundSingleTree + ":");
        System.out.print("{");
        for (int i = 0; i < keyCountSingleTree; i++) {

            keys[i] = random.nextInt(boundSingleTree);
            System.out.print(" " + keys[i] + ",");
        }
        System.out.print(" }\n\n");

        // Ausgabe der Ergebnisse
        BinaryTree binaryTree = new BinaryTree(keys);
        System.out.println("Binärbaum mit " + keyCountSingleTree + " Knoten in Vater/Sohn Beziehung {Vater, linker Sohn, rechter Sohn}:");
        System.out.println(binaryTree.print());

        System.out.println("\nHöhe des Baumes: " + binaryTree.computeHeight(binaryTree.getRoot()));

        BinaryTreeView btv = new BinaryTreeView(binaryTree);
        btv.initialise();
    }

    public void aufgabe5() {

        // Dialog
        System.out.println("\n============================================");
        System.out.println("Vergleich natürlicher Binärbaum und AVL-Baum");
        System.out.println("============================================\n");
        System.out.println("Was soll der größtmögliche ganzzahlige Schlüssel sein? (Bitte eingeben):");
        boundMultipleTrees = Integer.parseInt(System.console().readLine());
        System.out.println("Wieviele Bäume sollen jeweils konstruiert werden? (Bitte eingeben):");
        treeCount = Integer.parseInt(System.console().readLine());
        System.out.println("Wieviele ganzzahlige Schlüssel zwischen 0 und " + boundMultipleTrees + " sollen erzeugt werden? (Bitte eingeben):");
        keyCountMultipleTrees = Integer.parseInt(System.console().readLine());
        System.out.println("Sollen Details zu den Bäumen angezeigt werden? Dies umfasst Listen mit Zufallszahlen und die Knotenverbindungen. (j/n):");
        String result = System.console().readLine();

        if (result.equals("j")) {
            shouldShowDetails = true;
        } else if (result.equals("n")) {
            shouldShowDetails = false;
        }

        // Erstellen aller Baumstrukturen gemäß der erfragten Anzahl
        for (int i = 0; i < treeCount; i++) {

            int[] keysN = new int[keyCountMultipleTrees];
            List<Integer> keysNList = new ArrayList<>();

            // Ausgabe der ganzzahligen Schlüssel, falls aktiviert
            if (shouldShowDetails) {
                System.out.println("Baum " + (i + 1) + ":");
                System.out.println("\n" + keyCountMultipleTrees + " zufällige ganzzahlige Schlüssel zwischen 0 und " + boundMultipleTrees + ":");
                System.out.print("{");
            }
            for (int j = 0; j < keyCountMultipleTrees; j++) {

                int newKey = random.nextInt(boundMultipleTrees);

                // Verhindern von Duplikaten
                while (keysNList.contains(newKey)){
                    newKey = random.nextInt(boundMultipleTrees);
                }
                keysNList.add(newKey);

                keysN = keysNList.stream().mapToInt(x->x).toArray();

                if (shouldShowDetails) {

                    System.out.print(" " + keysN[j] + ",");
                }
            }
            if (shouldShowDetails) {
                System.out.print(" }\n\n");
            }

            // Initialisieren eines neuen Binärbaumes
            BinaryTree binaryTreeN = new BinaryTree(keysN);

            // Ausgabe der Knotenbeziehungen, falls aktiviert
            if (shouldShowDetails) {
                System.out.println("Natürlicher Binärbaum mit " + keyCountMultipleTrees + " Knoten in Vater/Sohn Beziehung {Vater, linker Sohn, rechter Sohn}:");
                System.out.println(binaryTreeN.print());
                System.out.println("Wurzelknoten: " + binaryTreeN.getRoot().getKey());
                System.out.println("Höhe: " + binaryTreeN.computeHeight(binaryTreeN.getRoot()) + "\n");
            }
            // Berechnung der Gesamthöhe aller natürlicher Binärbäume
            heightOfMultipleBinaryTrees += binaryTreeN.computeHeight(binaryTreeN.getRoot());

            // Initialisieren eines AVL-Baumes
            AVLTree avlTree = new AVLTree(keysN);

            // Ausgabe der Knotenbeziehungen, falls aktiviert
            if (shouldShowDetails) {
                System.out.println("AVL-Baum mit " + keyCountMultipleTrees + " Knoten in Vater/Sohn Beziehung {Vater, linker Sohn, rechter Sohn}:");
                System.out.println(avlTree.print());
                System.out.println("Wurzelknoten: " + avlTree.getRoot().getKey());
                System.out.println("Höhe: " + avlTree.computeHeight(avlTree.getRoot()) + "\n");
            }

            // Berechnung der Gesamthöhe aller AVL-Bäume
            heightOfMultipleAVLTrees += avlTree.computeHeight(avlTree.getRoot());
        }

        System.out.println("\n*********************");
        System.out.println("NATÜRLICHER BINÄRBAUM");
        System.out.println("*********************\n");

        // Arithmetisches Mittel der Gesamthöhe
        averageBinaryTreeHeight = heightOfMultipleBinaryTrees / treeCount;
        System.out.println("\nDurchschnittliche Höhe der natürlichen Binärbaume: " + averageBinaryTreeHeight);

        System.out.println("\n\n********");
        System.out.println("AVL BAUM");
        System.out.println("********\n");


        // Arithmetisches Mittel der Höhe der AVL-Bäume
        averageAVLTreeHeight = heightOfMultipleAVLTrees / treeCount;
        System.out.println("\nDurchschnittliche Höhe der AVL-Bäume: " + averageAVLTreeHeight + "\n");

        System.out.println("\n********");
        System.out.println("ERGEBNIS");
        System.out.println("********\n\n");

        // Vergleich der durchschnittlichen Höhe von natürlichen Binärbäumen und AVL-Bäumen
        if (averageAVLTreeHeight < averageBinaryTreeHeight) {
            System.out.println("Die durchschnittliche Höhe eines AVL-Baumes ist geringer als die eines natürlichen Binärbaumes.\n");
        } else if (averageAVLTreeHeight > averageBinaryTreeHeight) {
            System.out.println("Die durchschnittliche Höhe eines AVL-Baumes ist größer als die eines natürlichen Binärbaumes.\n");
        }
    }
}
