public class TestArrayList {
  public static void main(String[] args) {
    ArrayList l = new ArrayList();

    TestHelpers.assertEquals(l.size(), 0);
    TestHelpers.assertEquals(l.isEmpty(), true);

    l.add("foo");
    TestHelpers.assertEquals(l.isEmpty(), false);
    TestHelpers.assertEquals(l.size(), 1);

    l.add("bar");
    TestHelpers.assertEquals(l.isEmpty(), false);
    TestHelpers.assertEquals(l.size(), 2);

    l.add(1, "baz");
    TestHelpers.assertEquals(l.isEmpty(), false);
    TestHelpers.assertEquals(l.size(), 3);
    TestHelpers.assertEquals(l.get(0).getReturnValue(), "foo");
    TestHelpers.assertEquals(l.get(1).getReturnValue(), "baz");
    TestHelpers.assertEquals(l.get(2).getReturnValue(), "bar");

    l.remove(1);
    TestHelpers.assertEquals(l.isEmpty(), false);
    TestHelpers.assertEquals(l.size(), 2);
    TestHelpers.assertEquals(l.get(0).getReturnValue(), "foo");
    TestHelpers.assertEquals(l.get(1).getReturnValue(), "bar");

    ReturnObject ret = l.get(2);
    TestHelpers.assertNull(ret.getReturnValue());
    TestHelpers.assertEquals(ret.getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
    TestHelpers.assertEquals(ret.hasError(), true);
  }
}
