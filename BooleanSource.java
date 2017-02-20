public class BooleanSource {

   private static double probability;  //probability of returning true


   public BooleanSource(double p) {

      if ((p < 0) || (1 < p))
         throw new IllegalArgumentException("Illegal p: " + p);
      probability = p;

   }

   public static boolean query() {

      return (Math.random() < probability);

   }
}
