package network.tcp.autocloseable;

public class ResourceV2 implements AutoCloseable {

  @Override
  public void close() throws CloseException {
    System.out.println(name + " close");
    throw new CloseException(name + " ex");
  }

  private String name;

  public ResourceV2(String name) {
    this.name = name;
  }

  public void call() {
    System.out.println(name + " call");
  }

  public void callEx() throws CallException {
    System.out.println(name + " callEx");
    throw new CallException(name + " ex");
  }


  public void closeEx() throws CloseException {
    System.out.println(name + " closeEx");
    throw new CloseException(name + " ex");
  }

}
