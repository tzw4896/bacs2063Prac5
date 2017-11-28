package adt2;

/**
 * LList.java A class that implements the ADT list by using a chain of nodes,
 * with the node implemented as an inner class with setters and getters.
 *
 * @author Frank M. Carrano
 * @version 2.0
 */
public class LList<T> implements ListInterface<T> {

  private Node<T> firstNode;
  private int numberOfEntries;

  public LList() {
    clear();
  }

  public final void clear() {
    firstNode = null;
    numberOfEntries = 0;
  }

  public boolean add(T newEntry) {
    Node<T> newNode = new Node<>(newEntry);

    if (isEmpty()) {
      firstNode = newNode;
    } else {
      Node<T> lastNode = getNodeAt(numberOfEntries);
      lastNode.setNext(newNode);
    }

    numberOfEntries++;
    return true;
  }

  public boolean add(int newPosition, T newEntry) {
    boolean isSuccessful = true;

    if ((newPosition >= 1) && (newPosition <= numberOfEntries + 1)) {
      Node<T> newNode = new Node<T>(newEntry);

      if (isEmpty() || (newPosition == 1)) {     // case 1: add to beginning of list
        newNode.setNext(firstNode);
        firstNode = newNode;
      } else {								                      // case 2: list is not empty and newPosition > 1
        Node nodeBefore = getNodeAt(newPosition - 1);
        Node nodeAfter = nodeBefore.getNext();
        newNode.setNext(nodeAfter);
        nodeBefore.setNext(newNode);
      }

      numberOfEntries++;
    } else {
      isSuccessful = false;
    }

    return isSuccessful;
  }

  public T remove(int givenPosition) {
    T result = null;

    if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
      if (givenPosition == 1) {      // case 1: remove first entry
        result = firstNode.getData();     // save entry to be removed 
        firstNode = firstNode.getNext();
      } else {                         // case 2: givenPosition > 1
        Node<T> nodeBefore = getNodeAt(givenPosition - 1);
        Node<T> nodeToRemove = nodeBefore.getNext();
        Node<T> nodeAfter = nodeToRemove.getNext();
        nodeBefore.setNext(nodeAfter); // disconnect the node to be removed
        result = nodeToRemove.getData();  // save entry to be removed
      }

      numberOfEntries--;
    }

    return result;
  }

  public boolean replace(int givenPosition, T newEntry) {
    boolean isSuccessful = true;

    if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
      Node<T> desiredNode = getNodeAt(givenPosition);
      desiredNode.setData(newEntry);
    } else {
      isSuccessful = false;
    }

    return isSuccessful;
  }

  public T getEntry(int givenPosition) {
    T result = null;

    if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
      result = getNodeAt(givenPosition).getData();
    }

    return result;
  }

  public boolean contains(T anEntry) {
    boolean found = false;
    Node<T> currentNode = firstNode;

    while (!found && (currentNode != null)) {
      if (anEntry.equals(currentNode.getData())) {
        found = true;
      } else {
        currentNode = currentNode.getNext();
      }
    }

    return found;
  }

  public int getNumberOfEntries() {
    return numberOfEntries;
  }

  public boolean isEmpty() {
    boolean result;

    if (numberOfEntries == 0) {
      result = true;
    } else {
      result = false;
    }

    return result;
  }

  public boolean isFull() {
    return false;
  }

  public String toString() {
    String outputStr = "";
    Node<T> currentNode = firstNode;
    while (currentNode != null) {
      outputStr += currentNode.getData() + "\n";;
      currentNode = currentNode.getNext();
    }
    return outputStr;
  }

  private void displayChain(Node nodeOne) {
    if (nodeOne != null) {
      System.out.print(nodeOne.getData() + " ");
      displayChain(nodeOne.getNext());
    }
  }

  /**
   * Task: Returns a reference to the node at a given position. Precondition:
   * List is not empty; 1 <= givenPosition <= numberOfEntries.
   */
  private Node<T> getNodeAt(int givenPosition) {
    Node<T> currentNode = firstNode;

    // traverse the list to locate the desired node
    for (int counter = 1; counter < givenPosition; counter++) {
      currentNode = currentNode.getNext();
    }

    return currentNode;
  }

}
