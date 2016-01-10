/**
 *  LinkedListElement is an element of the linked list
 *  implemented in {@see LinkedList}.
 *
 *  @author Matt Bostock
 */
public class LinkedListElement {
  private LinkedListElement next;
  private Object value;

  public Object getValue() {
    return this.value;
  }

  public void setValue(Object v) {
    this.value = v;
  }

  public LinkedListElement getNext() {
    return this.next;
  }

  public void setNext(LinkedListElement e) {
    this.next = e;
  }
}
