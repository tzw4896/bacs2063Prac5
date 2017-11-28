package samplecode;

public class TestNode {

  public static void main(String[] args) {
//    Node<String> node5 = new Node<>("Language");
//    Node<String> node1 = new Node<>("Programming",node5);
//    Node<String> node2 = new Node<>("Java", node1);
//    Node<String> node3 = new Node<>("Love", node2);
//    Node<String> node4 = new Node<>("I", node3);
//    
//    Node<String> firstNode;
//        
////    System.out.println("node 1: " + node1.getData());
////    System.out.println("node 2: " + node2.getData());
////    
//    System.out.println("\n\nTraversing list: ");
//    
//    for (firstNode = node4; firstNode != null; firstNode = firstNode.getNext()) {
//      System.out.print(firstNode.getData() + " ");
//    }
//    System.out.println();
    


    // Exercise 2 - to be completed    
    
    Node<String> firstNode;    
    
    //Adding first node to empty list
    Node<String> node1 = new Node<>("Five");
    firstNode = node1;
    
    //Add to the front
    Node<String> node2 = new Node<>("Three",node1);
    firstNode = node2;
    
    //Add to the end
    Node<String> node3 = new Node<>("Eight");
    node1.setNext(node3);
    
    //Add to the middle
    Node<String> node4 = new Node<>("Seven",node3);
    node1.setNext(node4);
    
    System.out.println("\n\nPrinting linked chain of nodes starting from firstNode: ");
    while (firstNode != null) {
      System.out.println(firstNode.getData());
      firstNode = firstNode.getNext();
    }


//    Node<Integer> firstNode = new Node<>(10);
//    Node<Integer> secondNode = new Node<>(20);
//    Node<Integer> thirdNode = new Node<>(30);
//    Node<Integer> fourthNode = new Node<>(40);
//    
//    firstNode.setNext(secondNode);
//    secondNode.setNext(thirdNode);
//    thirdNode.setNext(fourthNode);
//    
//    Node tempNode = firstNode;
//    System.out.println("\n\nPrinting linked chain of nodes starting from firstNode: ");
//    while (tempNode != null) {
//      System.out.println(tempNode.getData());
//      tempNode = tempNode.getNext();
//    }


//Node<Integer> firstNode;
//    Node<Integer> numNode1 = new Node<>(5);
//   
//    firstNode = numNode1;
//        
//    //Add to first
//    Node<Integer> numNode2 = new Node<>(3,numNode1);
//    firstNode = numNode2;
//    
//    //Add to last
//    Node<Integer> numNode3 = new Node<>(8);    
//    numNode1.setNext(numNode3);
//    
//    //Add to middle
//    Node<Integer> numNode4 = new Node<>(7,numNode3); 
//    numNode1.setNext(numNode4);
  }
  
}
