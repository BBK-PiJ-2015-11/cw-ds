public class TestHelpers {
  public static void assertEquals(Object actual, Object expected) {
    if (actual.equals(expected)) {
      printSuccess();
    } else {
      printFailure(actual, expected);
    }
  }

  public static void assertNull(Object actual) {
    if (actual == null) {
      printSuccess();
    } else {
      printFailure(actual, null);
    }
  }

  private static void printSuccess() {
    System.out.println(".");
  }

  private static void printFailure(Object actual, Object expected) {
      System.out.println("Fail: Expected '" + expected + "', got '" + actual + "'");
  }
}
