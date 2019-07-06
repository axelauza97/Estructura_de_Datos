/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

/**
 *
 * @author AxelAuzaA
 */
public class DoubleLinkedList<E> {
    private SimpleNode<E> header=null;
    private SimpleNode<E> last=null;

    public DoubleLinkedList() {
    }
    public void print(){
        SimpleNode node=null;
        for (node=header;node!=null;node=node.getNextNode()){
            System.out.println(node);
        } 
    }
    public SimpleNode removeFirst(){
        SimpleNode node=header;
        header=node.getNextNode();
        return node;
    }
    public SimpleNode removeLast(){
        SimpleNode node=null;
        int size=this.sizeList();
        int contador=0;
        for (node=header;node!=null;node=node.getNextNode()){
            contador=contador+1;
            if(contador==(size-1)){
                SimpleNode nodefinal=node;
                node=nodefinal.getNextNode();
                nodefinal.setNextNode(header);
                last=nodefinal;
                break;
            }
        } 
        return node;
    }
    public int sizeList(){
        int size=0;
        for (SimpleNode node=header;node!=null;node=node.getNextNode()){
                size=size+1;
        }
        return size;
    }
    public void insertFirst(SimpleNode node){
        if(last==null){
            last=node;
        }
        node.setNextNode(header);
        header=node;
    }
    public void insertLast(SimpleNode node){
        if(header!=null){
            if(last==null){
                header.setNextNode(node);
                last=node;
            }else{
                last.setNextNode(node);
                last=node;
                last.setNextNode(header);
            }
        }
        else{
            insertFirst(node);
        }
        

    }
    public SimpleNode getFirst() {
        return header;
    }

    public void setHeader(SimpleNode header) {
        this.header = header;
    }

    public SimpleNode getLast() {
        return last;
    }

    public void setLast(SimpleNode last) {
        this.last = last;
    }
    
    
}
