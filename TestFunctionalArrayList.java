public class TestFunctionalArrayList {
  public static void main(String[] args) {
    FunctionalArrayList l = new FunctionalArrayList();

    TestHelpers.assertEquals(l.size(), 0);
    TestHelpers.assertEquals(l.isEmpty(), true);
    TestHelpers.assertEquals(l.head().getError(), ErrorMessage.EMPTY_STRUCTURE);
    TestHelpers.assertEquals(l.rest().size(), 0);

    l.add("foo");
    TestHelpers.assertEquals(l.isEmpty(), false);
    TestHelpers.assertEquals(l.size(), 1);
    TestHelpers.assertEquals(l.head().getReturnValue(), "foo");
    TestHelpers.assertEquals(l.rest().size(), 0);

    l.add("bar");
    TestHelpers.assertEquals(l.isEmpty(), false);
    TestHelpers.assertEquals(l.size(), 2);
    TestHelpers.assertEquals(l.head().getReturnValue(), "foo");
    TestHelpers.assertEquals(l.rest().size(), 1);

    l.add(1, "baz");
    TestHelpers.assertEquals(l.isEmpty(), false);
    TestHelpers.assertEquals(l.size(), 3);
    TestHelpers.assertEquals(l.get(0).getReturnValue(), "foo");
    TestHelpers.assertEquals(l.get(1).getReturnValue(), "baz");
    TestHelpers.assertEquals(l.get(2).getReturnValue(), "bar");
    TestHelpers.assertEquals(l.head().getReturnValue(), "foo");
    TestHelpers.assertEquals(l.rest().size(), 2);

    l.remove(1);
    TestHelpers.assertEquals(l.isEmpty(), false);
    TestHelpers.assertEquals(l.size(), 2);
    TestHelpers.assertEquals(l.get(0).getReturnValue(), "foo");
    TestHelpers.assertEquals(l.get(1).getReturnValue(), "bar");
    TestHelpers.assertEquals(l.head().getReturnValue(), "foo");
    TestHelpers.assertEquals(l.rest().size(), 1);

    ReturnObject ret = l.get(2);
    TestHelpers.assertNull(ret.getReturnValue());
    TestHelpers.assertEquals(ret.getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
    TestHelpers.assertEquals(ret.hasError(), true);

    // Ensure original list not affected by modifying new list
    // returned by rest()
    FunctionalList f = l.rest();
    TestHelpers.assertEquals(l.size(), 2);
    f.remove(1);
    TestHelpers.assertEquals(l.size(), 2);
    TestHelpers.assertEquals(f.size(), 1);
  }
}
