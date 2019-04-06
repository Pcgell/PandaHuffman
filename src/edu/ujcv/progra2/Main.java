package edu.ujcv.progra2;

import javax.swing.tree.TreeNode;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Main {
// para el examen 1. fortalezas 2. debilidades 3. conjunto de funcionalidad critica
    //todas las estructruas de datos
    //Heap => PriorityQueue
    //AssociativeArray => HashMap => Dictionary
    // ArrayList  => Vector => DynamicArray
    // Linked List => Double Linked List

    // ejemplo Dictionary:
    // 1. fortaleza busquedas rapidas indexadas por una llave.
    // 2. no es lineal, usa mas memoria
    // 3. put, get, contains, remove


    //codecademy
    public static void main(String[] args) {

        Main main = new Main();
        main.run();
    }
    //tamaño: 23
    // frequencia o : 0.17

    private String message = "Hola mundo comprimido!!";
    private Map<Character,Double> frequency = new HashMap<>();
    PriorityQueue<HuffmanNode> priorityQueue = new PriorityQueue<>();
    HuffmanTree tree;
    private void run() {

        calculateFrequencyTable();
        fillPQueue();
        buildTree();
        calculateCodes();
    }

    private void calculateCodes() {
        HuffmanNode root = priorityQueue.peek();
        tree = new HuffmanTree(root);
        System.out.println("\n\nHuffmanCodes:\n"+tree.getHuffmanCodes());
    }

    private void buildTree() {
        while (priorityQueue.size() > 1){
            HuffmanNode lc = priorityQueue.poll();
            HuffmanNode rc = priorityQueue.poll();
            HuffmanNode node = new HuffmanNode(lc,rc);
            priorityQueue.add(node);
        }
        HuffmanNode raiz = priorityQueue.peek();
        System.out.println("raiz nodo huffman.\nkey: "+ raiz.subMensaje +"\t Value: "+ raiz.frequencia);


    }

    private void fillPQueue() {
        Set<Character> charSet = frequency.keySet();
        for (Character c: charSet) {
           HuffmanNode node = new HuffmanNode(c,frequency.get(c));
           priorityQueue.add(node);
        }

    }

    private void calculateFrequencyTable() {
        //tamaño del mensaje original
        int messageSize =  message.length();

        //contamos cuantas veces cada caracter se repite
        for (int i = 0; i < messageSize; i++) {
            Character c = message.charAt(i);

            if(frequency.containsKey(c)){
                double value = frequency.get(c);
                value += 1.0;
                frequency.put(c,value);
            }else{
                frequency.put(c,1.0);
            }
        }

        //para cada caracter calculamos la frequencia de el en el mensaje.
        Set<Character> charSet = frequency.keySet();
        for (Character c: charSet) {
            double value = frequency.get(c);
            value = value / messageSize;
            frequency.put(c,value);


        }
        printTable(frequency);

    }


    void printTable(Map<Character,Double> table){
        double accum = 0.0;
        Set<Character> charSet = table.keySet();
        for (Character c: charSet) {
            accum += table.get(c);
            System.out.println("Key: "+ c +"\tValue: "+table.get(c));
        }

        System.out.println("\n\ttotal frecuencia = "+ accum);
    }


}
