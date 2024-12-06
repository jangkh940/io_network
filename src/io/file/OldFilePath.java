package io.file;

import java.io.File;

public class OldFilePath {

  public static void main(String[] args) {
    File file = new File("temp/..");
    System.out.println("path = " + file.getPath());
  }
}
