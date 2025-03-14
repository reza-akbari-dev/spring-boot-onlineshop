package shop.common.exceptions;

public class NotFoundException extends Exception {
  public NotFoundException() {
    super("Data Not Found!");
  }
}
