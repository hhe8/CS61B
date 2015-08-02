public class launcher{
  public static void main(String[] args) {
    Animal a0 = new Fox();   // Line 1
    Fox f0 = new Fox();         // Line 2
    a0.speak();                 // Line 3
    f0.speak();                 // Line 4
    ((Animal) f0).speak();      // Line 5
    ((Fox) a0).speak();         // Line 6
  }
}
