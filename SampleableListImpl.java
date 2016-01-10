/**
 * Implements the {@see SampleableList} interface by extending {@see
 * ArrayList}.
 *
 * @author Matt Bostock
 */
public class SampleableListImpl extends ArrayList implements SampleableList {
  @Override
  public SampleableList sample() {
    int newLength = this.list.length / 2;
    SampleableList tmpList = new SampleableListImpl();

    for (int i = 0; i < this.size; i++) {
      if (i % 2 == 0) {
        tmpList.add(this.list[i]);
      }
    }

    return tmpList;
  }
}
