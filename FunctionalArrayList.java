/**
 * Extend {@see ArrayList} by implementing the {@see FunctionalList} interface.
 *
 * @author Matt Bostock
 */
public class FunctionalArrayList extends ArrayList implements FunctionalList {
  @Override
  public ReturnObject head() {
    if (this.list[0] == null) {
      return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
    }

    return new ReturnObjectImpl(this.list[0]);
  }

  @Override
  public FunctionalList rest() {
    FunctionalArrayList tmpList = new FunctionalArrayList();

    if (this.size == 0) {
      tmpList.list = this.list;
      return tmpList;
    }

    for (int i = 1; i < this.size; i++) {
      tmpList.add(this.list[i]);
    }

    return tmpList;
  }
}
