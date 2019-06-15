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
public class SimpleNode<T> {
    private SimpleNode<T> nextNode;
    private SimpleNode<T> prevNode;
    private T content;

    public SimpleNode(T content) {
        this.content = content;
        this.nextNode=null;
        this.prevNode=null;
        
    }

    public SimpleNode<T> getNextNode() {
        return nextNode;
    }
    
    public SimpleNode<T> getPrevNode() {
        return prevNode;
    }

    public void setNextNode(SimpleNode<T> nextNode) {
        this.nextNode = nextNode;
    }
    public void setPrevNode(SimpleNode<T> prevNode) {
        this.prevNode = prevNode;
    }
    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "SimpleNode{" + content + '}';
    }
    
    
    
}
