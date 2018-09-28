import java.util.Random;

public class StdRandom
{
    public static int uniform(int n)
    {
        return (int) (Math.random() * n);
    }

    public static double uniform() {
        return Math.random();
    }

    public static double uniform(double lo, double hi)
    {
        return lo + Math.random() * (hi - lo);
    }

    public static boolean bernoulli(double p)
    {
        return Math.random() < p;
    }

    public static double gaussian(){
      double r, x,y;
      do{
          x = uniform(-1.0, 1.0);
          y = uniform(-1.0, 1.0);
          r = x*x + y*y;
      }while(r >= 1 || r == 0);
      return x * Math.sqrt(-2 * Math.log(r) / r);

    }

    public static double gaussian(double mu, double sigma){
        return mu + sigma * gaussian();
    }

    /*public static int discrete(double[] probabilities){

    }*/
    public static int discrete(double[] probabilities)
    {
        // precondition: sum of array entries equals 1
        double r = uniform();
        double sum = 0.0;
        for (int i = 0; i < probabilities.length; i++) {
            sum += probabilities[i];
            if (sum >= r) return i;
        }
        //assert (false);
        return -1;

    }

    public  static void shuffle(double[] a){
        int n = a.length;
        for(int i = 0; i < n; i++){
            int r = i + uniform( n -1);
            double temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }
    public static void main(String[] args){
        int n = Integer.parseInt(args[0]);
        double[] probabilitites = {0.5, 0.3, 0.1, 0.1};
        for(int i = 0; i < n; i++){
            StdOut.printf(" %2d ", uniform(100));
            StdOut.printf(" %8.5f ", uniform(10.0, 99.0));
            StdOut.printf(" %5b ", bernoulli(0.5));
            StdOut.printf(" %7.5f ", gaussian(9.0, 0.2));
            StdOut.printf(" %2d ", discrete(probabilitites));
            StdOut.println();
        }
    }








}