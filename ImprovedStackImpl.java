/**
 * Implements {@see ImprovedStack}.
 *
 * @author Matt Bostock
 */
public class ImprovedStackImpl implements ImprovedStack {
  /**
   * The data structure where the elements on the stack are stored.
   */
  private List internalList;

  /**
   * Creates a new abstract stack using the provided list as the
   * underlying data structure.
   *
   * @param list the list to be used
   */
  public ImprovedStackImpl(List list) {
    this.internalList = list;
  }

  @Override
  public ImprovedStack reverse() {
    ImprovedStackImpl tmpStack = new ImprovedStackImpl(new ArrayList());

    for (int i = 0; i < this.internalList.size(); i++) {
      ReturnObject r = this.internalList.get(i);
      Object item = r.getReturnValue();
      tmpStack.push(item);
    }

    return tmpStack;
  }

  @Override
  public void remove(Object object) {
    if (object == null) {
      return;
    }

    for(int i = 0; i < this.size(); i++) {
      ReturnObject r = this.internalList.get(i);

      if (r.hasError() || r.getReturnValue() == null) {
        continue;
      }

      if (r.getReturnValue().equals(object)) {
        this.internalList.remove(i);
      }
    }
  }

  @Override
  public boolean isEmpty() {
    return this.internalList.isEmpty();
  }

  @Override
  public int size() {
    return this.internalList.size();
  }

  @Override
  public void push(Object item) {
    this.internalList.add(item);
  }

  @Override
  public ReturnObject top() {
    if (this.internalList.size() == 0) {
      return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
    }

    return this.internalList.get(this.getLastIndex());
  }

  @Override
  public ReturnObject pop() {
    ReturnObject top = this.top();
    if (top.hasError()) {
      return top;
    }

    ReturnObject r = this.internalList.remove(this.getLastIndex());
    if (r.hasError()) {
      return r;
    }

    return top;
  }

  private int getLastIndex() {
    return this.internalList.size() - 1;
  }
}
