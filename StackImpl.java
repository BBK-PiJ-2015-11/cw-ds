/**
 * Extends {@see AbstractStack} using a {@see List} as the internal data
 * structure.
 *
 * @author Matt Bostock
 */
public class StackImpl extends AbstractStack {
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

  public StackImpl(List list) {
    super(list);
  }

  private int getLastIndex() {
    return this.internalList.size() - 1;
  }
}

