/**
 * Use a linked list to implement the {@see List} interface.
 *
 * @author Matt Bostock
 */
public class LinkedList implements List {
  private LinkedListElement first;
  private int size = 0;

  @Override
  public boolean isEmpty() {
    return this.size == 0;
  }

  @Override
  public int size() {
    return this.size;
  }

  @Override
  public ReturnObject get(int index) {
    if (indexIsOutOfBounds(index)) {
      return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
    }

    LinkedListElement current = this.first;
    int i = 0;
    while (i != index) {
      current = current.getNext();
      i++;
    }

    return new ReturnObjectImpl(current.getValue());
  }

  @Override
  public ReturnObject remove(int index) {
    if (indexIsOutOfBounds(index)) {
      return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
    }

    LinkedListElement current = this.first;
    int i = 0;
    while (i != index) {
      if (i + 1 == index) {
        current.setNext(current.getNext().getNext());
        break;
      }

      current = current.getNext();
      i++;
    }

    this.size--;
    return new ReturnObjectImpl(null);
  }

  @Override
  public ReturnObject add(int index, Object item) {
    if (indexIsOutOfBounds(index)) {
      return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
    }

    LinkedListElement e = new LinkedListElement();
    e.setValue(item);
    this.size++;

    LinkedListElement current = this.first;
    int i = 0;
    while (i != index) {
      if (i + 1 == index) {
        LinkedListElement oldNext = current.getNext();
        current.setNext(e);
        e.setNext(oldNext);
        break;
      }

      current = current.getNext();
      i++;
    }

    return new ReturnObjectImpl(null);
  }

  @Override
  public ReturnObject add(Object item) {
    LinkedListElement e = new LinkedListElement();
    e.setValue(item);
    this.size++;

    if (this.first == null) {
      this.first = e;
      return new ReturnObjectImpl(null);
    }

    LinkedListElement current = this.first;
    int i = 0;
    while (current.getNext() != null) {
      current = current.getNext();
      i++;
    }

    current.setNext(e);

    return new ReturnObjectImpl(null);
  }

  private boolean indexIsOutOfBounds(int index) {
    return index < 0 || index >= this.size;
  }
}
