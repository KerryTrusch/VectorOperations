import java.util.*;
class Main {
  public static void main(String[] args) {
     Scanner scan = new Scanner(System.in);
    double[] a = vectorCreator();
    double[] b = vectorCreator();
    String ans = "";
    String longText = "A) Add two vectors\nB) Subtract vector one from two\nC) Find the dot product\nD) Find the cross product\nE" +
    ") Multiply by a scalar\nF) Find the angle between two vectors\nG) Find the magnitutde\nH) Project vector A onto vector B\n" +
    "Type 'Clear' to clear the vectors, or type 'Display' to print these options again. Type 'quit' to stop.";
    System.out.println(longText);
    while (!(ans = scan.nextLine()).equals("quit") ) {
    ans.toLowerCase();
    if (ans.equals("a")) { System.out.println(vectorForm(Vector.add(a,b))); }
    if (ans.equals("b")) { System.out.println(vectorForm(Vector.subtract(a,b))); }
    if (ans.equals("c")) { System.out.println(Vector.dotProduct(a,b)); }
    if (ans.equals("d")) {
      System.out.println(vectorForm(Vector.crossProduct(a,b)));
      continue;
    }
    if (ans.equals("e")) {
        System.out.println("Which vector would you like to multiply? Press A for vector one and B for vector two.");
        String secondAns = scan.nextLine();
        System.out.println("Choose your scalar multiple: ");
        String thirdAns = scan.nextLine();
        if (secondAns.toLowerCase().equals("a")) {
          System.out.println(vectorForm(Vector.multByScalar(a, Double.valueOf(thirdAns))));
        }
        else if (secondAns.toLowerCase().equals("b")) {
          System.out.println(vectorForm(Vector.multByScalar(b, Double.valueOf(thirdAns))));
        }
        else {
          System.out.println("Please choose either A or B.");
        }
     }
     if (ans.equals("f")) { System.out.println(Vector.angleBetween(a,b)); }
     if (ans.equals("g")) {
       System.out.println("Which vector's magnitude do you want? Type A for the first vector or B for the second: ");
       String thisMag = scan.nextLine();
       if (thisMag.toLowerCase().equals("a")) { System.out.println(Vector.magnitude(a)); }
       if (thisMag.toLowerCase().equals("b")) { System.out.println(Vector.magnitude(b)); }
       else if (!thisMag.toLowerCase().equals("a") && !thisMag.toLowerCase().equals("b")) {
         System.out.println("Please choose either A or B.");
            }
       }
      if (ans.equals("h")) { System.out.println(vectorForm(Vector.projection(a,b))); }
      if (ans.equals("Clear")) {
         a = vectorCreator();
         b = vectorCreator();
      }
      if (ans.equals("Display")) { System.out.println(longText); }
      else { continue; }

    }
  }

  public static String vectorForm(double[] arr) {
    if (arr.length == 1) { return arr[0] + "i"; }
    if (arr.length == 2) { return arr[0] + "i + " + arr[1] + "j"; }
    if (arr.length == 3) { return arr[0] + "i + " + arr[1] + "j + " + arr[2] + "k"; }
    String str = "";
    for (double n: arr) {
       str = str + arr + ", ";
    }
    return "< " + str + " >";
  }

  public static double[] vectorCreator() {
     Scanner scan = new Scanner(System.in);
    List<Double> arrg = new ArrayList<Double>();
    String ans = " ";
    boolean isEnter = false;
    System.out.println("Enter the digits of your vector or press enter to stop.");
    while (!isEnter) {
      ans = scan.nextLine();
      if (ans.equals("")) {
        isEnter = true;
        break;
      }
      double value = 0.0;
      value = Double.valueOf(ans);
      arrg.add(value);
    }
    double[] end = new double[arrg.size()];
    for (int i = 0; i < end.length; i++) {
      end[i] = arrg.get(i);
    }
    return end;
  }
}
