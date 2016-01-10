/**
 * @inheritDoc
 *
 * @author Matt Bostock
 */
public class ReturnObjectImpl implements ReturnObject {
  private Object obj;
  private ErrorMessage errMsg;

  public ReturnObjectImpl(Object o) {
    this.obj = o;
  }

  public ReturnObjectImpl(ErrorMessage e) {
    this.errMsg = e;
  }

  @Override
  public boolean hasError() {
    return this.errMsg != ErrorMessage.NO_ERROR;
  }

  @Override
  public ErrorMessage getError() {
    return this.errMsg;
  }

  @Override
  public Object getReturnValue() {
    if (this.hasError()) {
      return null;
    }

    return this.obj;
  }
}
