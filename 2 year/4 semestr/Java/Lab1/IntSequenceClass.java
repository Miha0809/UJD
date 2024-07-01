package Lab1;

public class IntSequenceClass implements IntSequence {

  private int[] values;
  private int index;

  public IntSequenceClass() {
    super();
  }

  public IntSequenceClass(int... values) {
    super();
    this.values = values;
    this.index = 0;
  }

  @Override
  public boolean hasNext() {
    return values.length > 0 && index < values.length;
  }

  @Override
  public int next() {
    return values[index++];
  }
}
