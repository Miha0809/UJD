package Lab1;

public interface IntSequence {
  boolean hasNext();
  int next();

  public static IntSequence of(int... values) {
    var obj = new IntSequenceClass(values);
    return obj;
  }
}