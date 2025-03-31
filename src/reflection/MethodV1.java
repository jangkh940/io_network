package reflection;

import java.lang.reflect.Method;
import reflection.data.BasicData;

public class MethodV1 {

  public static void main(String[] args) {
    Class<BasicData> helloClass = BasicData.class;

    System.out.println("===== method() ======");
    Method[] methods = helloClass.getMethods(); // public 만 찾아줌.

    for (Method method : methods) {
      System.out.println("method = " + method);
    }

    System.out.println("===== declaredMethods() =====");
    for (Method method : helloClass.getDeclaredMethods()) {
      System.out.println("method = " + method);
    }

  }
}
