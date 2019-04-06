package edu.ujcv.progra2;

import java.util.HashMap;
import java.util.Map;

public class HuffmanTree {
    private HuffmanNode root;

    private Map<Character,String> huffmanCodes = new HashMap<>();

    HuffmanTree(HuffmanNode root){
        this.root = root;
        calculateCodes();
    }

    private void calculateCodes() {
        depthFirst("",root);
    }

    private void depthFirst(String patialCode, HuffmanNode node){
        if(node.leftChild == null && node.rightChild == null){
            huffmanCodes.put(node.subMensaje.charAt(0),patialCode);
        }
        if(node.leftChild != null){
            depthFirst(patialCode+"0",node.leftChild);
        }
        if(node.rightChild != null ){
            depthFirst(patialCode+"1",node.rightChild);
        }
    }

    public Map<Character, String> getHuffmanCodes() {
        return huffmanCodes;
    }
}
