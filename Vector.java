import java.util.*;
class Vector {

  public static double[] add(double[] vectorOne, double[] vectorTwo) {
    int largestVector = Math.max(vectorOne.length, vectorTwo.length);
    double[] resultingVector = new double[largestVector];
    for (int i = 0; i < largestVector; i++) {
      if (i >= vectorOne.length) {
        resultingVector[i] = vectorTwo[i];
      } else if (i >= vectorTwo.length) {
        resultingVector[i] = vectorOne[i];
      } else {
        resultingVector[i] = vectorOne[i] + vectorTwo[i];
      }
    }
    return resultingVector;
  }

  public static double[] subtract(double[] vectorOne, double[] vectorTwo) {
    int largestVector = Math.max(vectorOne.length, vectorTwo.length);
    double[] resultingVector = new double[largestVector];
    for (int i = 0; i < largestVector; i++) {
      if (i >= vectorOne.length) {
        resultingVector[i] = -vectorTwo[i];
      } else if (i >= vectorTwo.length) {
        resultingVector[i] = vectorOne[i];
      } else {
        resultingVector[i] = vectorOne[i] - vectorTwo[i];
      }
    }
    return resultingVector;
  }

  public static double[] multByScalar(double[] vectorOne, double scalar) {
    double resultingVector[] = new double[vectorOne.length];
    for (int i = 0; i < vectorOne.length; i++) {
      resultingVector[i] = vectorOne[i]*scalar;
    }
    return resultingVector;
  }

  public static int dotProduct(double[] vectorOne, double[] vectorTwo) {
    int sum = 0;
    int smallestVector = Math.min(vectorOne.length, vectorTwo.length);
    for (int i = 0; i < smallestVector; i++) {
      sum += vectorOne[i]*vectorTwo[i];
    }
    return sum;
  }
  
  public static double[] crossProduct(double[] vectorOne, double[] vectorTwo) {
    int v1L = vectorOne.length;
    int v2L = vectorTwo.length;
    if (v1L > 3 || v2L > 3) {
      throw new RuntimeException("I currently do not support cross products above 3D vectors.");
    }
    double [] resultingVector = new double[Math.max(v1L, v2L)];
    //If the vectors are both 2D, we can use the 2X2 matrix determinant 
    if (v1L == 2 && v2L == 2) {
      resultingVector[0] = vectorOne[0]*vectorTwo[1];
      resultingVector[1] = -vectorOne[1]*vectorTwo[0];
      return resultingVector;
    }
     //For the 3x3 matrix, we will need to add a 0 to the smaller matrix (if there is one)
     List<Double> v1 = new ArrayList<Double>();
     List<Double> v2 = new ArrayList<Double>();
     for (int i = 0; i < v1L; i++) { v1.add(vectorOne[i]); }
     for (int j = 0; j < v2L; j++) { v2.add(vectorTwo[j]); }
     if (v1L != v2L) {
       if (v1L > v2L) {
         while (v2.size() <= v1L) { v2.add(0.0); }
         resultingVector[0] = (vectorOne[1]*v2.get(2)) - (vectorOne[2]*v2.get(1));
         resultingVector[1] = (vectorOne[2]*v2.get(0)) - (vectorOne[0]*v2.get(2));
         resultingVector[2] = (vectorOne[0]*v2.get(1)) - (vectorOne[1]*v2.get(0));
         return resultingVector;
       }
       else {
         while (v1.size() <= v2L) { v1.add(0.0); }
         resultingVector[0] = (v1.get(1)*vectorTwo[2]) - (v1.get(2)*vectorTwo[1]);
         resultingVector[1] = (v1.get(2)*vectorTwo[0]) - (v1.get(0)*vectorTwo[2]);
         resultingVector[2] = (v1.get(0)*vectorTwo[1]) - (v1.get(1)*vectorTwo[0]);
         return resultingVector;
       }
     }
    else {
      resultingVector[0] = (vectorOne[1]*vectorTwo[2]) - (vectorOne[2]*vectorTwo[1]);
      resultingVector[1] = (vectorOne[2]*vectorTwo[0]) - (vectorOne[0]*vectorTwo[2]);
      resultingVector[2] = (vectorOne[0]*vectorTwo[1]) - (vectorOne[1]*vectorTwo[0]);
      return resultingVector;
    }
  }

  public static double magnitude(double[] vectorOne) {
    return Math.sqrt(dotProduct(vectorOne, vectorOne));
  }
  
  public static double angleBetween(double[] vectorOne, double[] vectorTwo) {
    double dot = dotProduct(vectorOne, vectorTwo);
    double magnitudes = magnitude(vectorOne)*magnitude(vectorTwo);
    return Math.acos(dot / magnitudes);
  }

  public static double[] projection(double[] vectorOne, double[] vectorTwo) {
    double dot1 = dotProduct(vectorOne, vectorTwo);
    double dot2 = dotProduct(vectorTwo, vectorTwo);
    return multByScalar(vectorTwo, (dot1/dot2));
  }
}