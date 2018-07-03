class CustomCheckedException extends Exception {

  CustomCheckedException() {}

  CustomCheckedException(String message) {
    super(message);
  }
}
