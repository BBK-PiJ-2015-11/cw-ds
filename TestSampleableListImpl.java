public class TestSampleableListImpl {
  public static void main(String[] args) {
    SampleableList l = new SampleableListImpl();

    TestHelpers.assertEquals(l.size(), 0);
    TestHelpers.assertEquals(l.isEmpty(), true);
    SampleableList tmp = l.sample();
    TestHelpers.assertEquals(tmp.size(), 0);

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

    l.add("bibble");
    l.add("bobble");
    l.add("wibble");
    l.add("wobble");

    SampleableList s = l.sample();
    TestHelpers.assertEquals(s.size(), 3);
    TestHelpers.assertEquals(s.get(0).getReturnValue(), "foo");
    TestHelpers.assertEquals(s.get(1).getReturnValue(), "bibble");
    TestHelpers.assertEquals(s.get(2).getReturnValue(), "wibble");

    // Ensure original list not affected by modifying new list
    // returned by sample()
    s.remove(1);
    TestHelpers.assertEquals(l.size(), 6);
    TestHelpers.assertEquals(s.size(), 2);

    // Check we can sample a list with just one element
    s.remove(1);
    TestHelpers.assertEquals(s.size(), 1);
    s = s.sample();
    TestHelpers.assertEquals(s.size(), 1);
    TestHelpers.assertEquals(s.get(0).getReturnValue(), "foo");
  }
}
