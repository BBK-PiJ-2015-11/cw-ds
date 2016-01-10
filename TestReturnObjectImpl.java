public class TestReturnObjectImpl {
  public static void main(String[] args) {
    ReturnObject r = new ReturnObjectImpl("foo");
    TestHelpers.assertEquals(r.getReturnValue(), "foo");
    TestHelpers.assertEquals(r.hasError(), false);
    TestHelpers.assertNull(r.getError());

    r = new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
    TestHelpers.assertEquals(r.getError(), ErrorMessage.INVALID_ARGUMENT);
  }
}
