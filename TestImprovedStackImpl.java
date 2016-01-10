public class TestImprovedStackImpl {
  public static void main(String[] args) {
    ImprovedStackImpl s = new ImprovedStackImpl(new LinkedList());

    TestHelpers.assertEquals(s.size(), 0);
    TestHelpers.assertEquals(s.isEmpty(), true);

    s.push("foo");
    TestHelpers.assertEquals(s.isEmpty(), false);
    TestHelpers.assertEquals(s.size(), 1);

    s.push("baz");
    TestHelpers.assertEquals(s.size(), 2);
    s.push("bar");
    TestHelpers.assertEquals(s.size(), 3);

    ImprovedStack t = s.reverse();
    TestHelpers.assertEquals(t.isEmpty(), false);
    TestHelpers.assertEquals(t.size(), 3);
    TestHelpers.assertEquals(t.pop().getReturnValue(), "bar");
    TestHelpers.assertEquals(t.pop().getReturnValue(), "baz");
    TestHelpers.assertEquals(t.pop().getReturnValue(), "foo");
    TestHelpers.assertEquals(t.isEmpty(), true);
    TestHelpers.assertEquals(t.size(), 0);

    TestHelpers.assertEquals(s.size(), 3);

    s.pop();
    TestHelpers.assertEquals(s.isEmpty(), false);
    TestHelpers.assertEquals(s.size(), 2);
    TestHelpers.assertEquals(s.pop().getReturnValue(), "baz");
    s.remove("foo");

    ReturnObject ret = s.pop();
    TestHelpers.assertNull(ret.getReturnValue());
    TestHelpers.assertEquals(ret.getError(), ErrorMessage.EMPTY_STRUCTURE);
    TestHelpers.assertEquals(ret.hasError(), true);
  }
}
