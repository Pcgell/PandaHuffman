package edu.ujcv.progra2;

public class HuffmanNode  implements Comparable<HuffmanNode>{

    HuffmanNode leftChild;
    HuffmanNode rightChild;

    public String subMensaje;
    public double frequencia;

    public HuffmanNode(Character caracter, Double frequencia)
    {
        // crear hoja.
        leftChild = null;
        rightChild = null;
        subMensaje = caracter.toString();
        this.frequencia = frequencia;
    }

    public HuffmanNode(HuffmanNode leftChild, HuffmanNode rightChild){
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        subMensaje = ""+leftChild.subMensaje+rightChild.subMensaje;
        this.frequencia = leftChild.frequencia + rightChild.frequencia;

    }

    @Override
    public int compareTo(HuffmanNode o) {
        if(this.frequencia > o.frequencia){
            return 1;
        }
        if(this.frequencia == o.frequencia){
            return 0;
        }
        return -1;
    }
}
