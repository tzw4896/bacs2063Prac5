package adt;

public class AList {
  private Node firstNode;
  
  public void test() {
    firstNode = new Node(50); 
    firstNode.next = new Node(30); 
    Node newNode = new Node(40); 
    newNode.next = firstNode.next; 
    firstNode.next = newNode; 
    
    Node temp = firstNode; 
    while (temp.next != null) { 
      temp = temp.next;   
    }
    temp.next = new Node(20);
    
    Node before = firstNode.next;
    Node current = before.next;
    newNode = new Node(70);
    newNode.next = current;
    before.next = newNode;
          
    int total = 0;
    temp = firstNode;
    while(temp != null){
        total += temp.data;
        temp = temp.next;
    }
    System.out.println("Total = " + total);
  }
  
  public static void main(String[] args) {
    new AList().test();     
  }
  
  private class Node {
    Integer data;
    Node next;

    public Node(Integer data) {
      this.data = data;
    }

    public Node(Integer data, Node next) {
      this.data = data;
      this.next = next;
    }
    
    
    
  }
  
}
