public class TestStackImpl {
  public static void main(String[] args) {
    StackImpl s = new StackImpl(new ArrayList());

    TestHelpers.assertEquals(s.size(), 0);
    TestHelpers.assertEquals(s.isEmpty(), true);

    s.push("foo");
    TestHelpers.assertEquals(s.isEmpty(), false);
    TestHelpers.assertEquals(s.size(), 1);

    s.push("bar");
    TestHelpers.assertEquals(s.isEmpty(), false);
    TestHelpers.assertEquals(s.size(), 2);

    ReturnObject r = s.top();
    TestHelpers.assertEquals(s.isEmpty(), false);
    TestHelpers.assertEquals(s.size(), 2);
    TestHelpers.assertEquals(r.getReturnValue(), "bar");

    r = s.pop();
    TestHelpers.assertEquals(s.isEmpty(), false);
    TestHelpers.assertEquals(s.size(), 1);
    TestHelpers.assertEquals(r.getReturnValue(), "bar");
    r = s.pop();
    TestHelpers.assertEquals(r.getReturnValue(), "foo");
    TestHelpers.assertEquals(s.isEmpty(), true);
    TestHelpers.assertEquals(s.size(), 0);
  }
}
