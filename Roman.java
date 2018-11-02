
class Test {
  private int next_index;
  private int value;

  public int value() {
    return value;
  }
  public int next_index() {
    return next_index;
  }
  public Test(int value, int index) {
    this.value = value;
    this.next_index = index;
  }
}

public class Roman {

  private static Test OneDigit(String raw_input, int head_index) {
    int value = 0;
    int index = head_index;
    if (index >= raw_input.length()) return new Test(value, index);
    if (raw_input.charAt(index) == 'I') {
      value++;
      index++;
      if (raw_input.length() > 1) {
        for (int i = index; i < raw_input.length() && i - index < 3; i++) {
          if (raw_input.charAt(i) == 'I') {
            value++;
            index++;
          }
          else if (raw_input.charAt(i) == 'V') {
            value = 5 - value;
            index++;
            break;
          }
          else if (raw_input.charAt(i) == 'X') {
            value = 10 - value;
            index++;
            break;
          }
          else {
            break;
          }
        }
      }
    }
    else if (raw_input.charAt(index) == 'V') {
      value += 5;
      index++;
      for (int i = index; i < raw_input.length() && i - index < 4; i++) {
        if (raw_input.charAt(i) == 'I') {
          value++;
          index++;
        }
        else {
          break;
        }
      }
    }
    return new Test(value, index);
  }

  private static Test TwoDigit(String raw_input, int head_index) {
    int value = 0;
    int index = head_index;
    if (index >= raw_input.length()) return new Test(value, index);
    if (raw_input.charAt(index) == 'X') {
      value++;
      index++;
      if (raw_input.length() > 1) {
        for (int i = index; i < raw_input.length() && i - index < 3; i++) {
          if (raw_input.charAt(i) == 'X') {
            value++;
            index++;
          }
          else if (raw_input.charAt(i) == 'L') {
            value = 5 - value;
            index++;
            break;
          }
          else if (raw_input.charAt(i) == 'C') {
            value = 10 - value;
            index++;
            break;
          }
          else {
            break;
          }
        }
      }
    }
    else if (raw_input.charAt(index) == 'L') {
      value += 5;
      index++;
      for (int i = index; i < raw_input.length() && i - index < 4; i++) {
        if (raw_input.charAt(i) == 'X') {
          value++;
          index++;
        }
        else {
          break;
        }
      }
    }
    return new Test(value, index);
  }

  private static Test ThreeDigit(String raw_input, int head_index) {
    int value = 0;
    int index = head_index;
    if (index >= raw_input.length()) return new Test(value, index);
    if (raw_input.charAt(index) == 'C') {
      value++;
      index++;
      if (raw_input.length() > 1) {
        for (int i = index; i < raw_input.length() && i - index < 3; i++) {
          if (raw_input.charAt(i) == 'C') {
            value++;
            index++;
          }
          else if (raw_input.charAt(i) == 'D') {
            value = 5 - value;
            index++;
            break;
          }
          else if (raw_input.charAt(i) == 'M') {
            value = 10 - value;
            index++;
            break;
          }
          else {
            break;
          }
        }
      }
    }
    else if (raw_input.charAt(index) == 'D') {
      value += 5;
      index++;
      for (int i = index; i < raw_input.length() && i - index < 4; i++) {
        if (raw_input.charAt(i) == 'C') {
          value++;
          index++;
        }
        else {
          break;
        }
      }
    }
    return new Test(value, index);
  }

  private static Test FourDigit(String raw_input, int head_index) {
    int value = 0;
    int index = head_index;
    if (index >= raw_input.length()) return new Test(value, index);
    if (raw_input.charAt(index) == 'M') {
      value++;
      index++;
      for (int i = index; i < raw_input.length() && i - index < 3; i++) {
        if (raw_input.charAt(i) == 'M') {
          value++;
          index++;
        }
        else {
          break;
        }
      }
    }
    return new Test(value, index);
  }

  public static void main(String[] args) {
    // 引数チェック
    if (args.length == 0) {
      System.out.println("Please input Roman number.");
      System.exit(1);
    }

    // 1つ目の引数に渡された文字列を解析
    String roman = args[0];
    Test d = FourDigit(roman, 0);
    Test c = ThreeDigit(roman, d.next_index());
    Test b = TwoDigit(roman, c.next_index());
    Test a = OneDigit(roman, b.next_index());
    System.err.println("a=" + a.value() + " b=" + b.value() + " c=" + c.value() + " d=" + d.value());
    if (a.next_index() != roman.length()) {
      System.out.println(0);
    }
    else {
      System.out.println(a.value() + b.value() * 10 + c.value() * 100 + d.value() * 1000);
    }
  }
}
