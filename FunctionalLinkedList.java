/**
 * Extend {@see LinkedList} by implementing the {@see FunctionalList} interface.
 *
 * @author Matt Bostock
 */
public class FunctionalLinkedList extends LinkedList implements FunctionalList {
  public ReturnObject head() {
    if (this.first == null) {
      return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
    }

    return new ReturnObjectImpl(this.first.getValue());
  }

  public FunctionalList rest() {
    FunctionalLinkedList tmpList = new FunctionalLinkedList();

    LinkedListElement current = this.first;
    for (int i = 0; i < this.size; i++) {
      current = current.getNext();
      if (current != null) {
        tmpList.add(current.getValue());
      }
    }

    return tmpList;
  }
}
