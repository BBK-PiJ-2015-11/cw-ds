/**
 * Use an array to implement the {@see List} interface.
 *
 * @author Matt Bostock
 */
public class ArrayList implements List {
  private final static int DEFAULT_LENGTH = 20;
  private Object[] list = new Object[DEFAULT_LENGTH];
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

    return new ReturnObjectImpl(this.list[index]);
  }

  @Override
  public ReturnObject remove(int index) {
    if (indexIsOutOfBounds(index)) {
      return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
    }

    Object item = this.list[index];
    Object[] tmpArray = new Object[this.list.length];

    int j = 0;
    for (int i = 0; i < this.size; i++) {
      if (i != index) {
        tmpArray[j] = this.list[i];
        j++;
      }
    }

    this.size--;
    this.list = tmpArray;
    return new ReturnObjectImpl(item);
  }

  @Override
  public ReturnObject add(int index, Object item) {
    if (indexIsOutOfBounds(index)) {
      return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
    }

    if (item == null) {
      return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
    }

    Object[] tmpArray = new Object[this.list.length];
    this.size++;

    int j = 0;
    for (int i = 0; i < this.size; i++) {
      if (i == index) {
        tmpArray[i] = item;
      } else {
        tmpArray[i] = this.list[j];
        j++;
      }
    }

    this.list = tmpArray;
    return new ReturnObjectImpl(null);
  }

  @Override
  public ReturnObject add(Object item) {
    ensureArrayLength();

    if (item == null) {
      return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
    }

    this.list[this.size] = item;
    this.size++;

    return new ReturnObjectImpl(null);
  }

  private boolean indexIsOutOfBounds(int index) {
    return index < 0 || index >= this.size;
  }

  private void ensureArrayLength() {
    if (this.size == this.list.length - 1) {
      int newLength = (int)(this.list.length * 1.5);
      Object[] tmpArray = new Object[newLength];

      for (int i = 0; i < this.size; i++) {
        tmpArray[i] = this.list[i];
      }

      this.list = tmpArray;
    }
  }
}
