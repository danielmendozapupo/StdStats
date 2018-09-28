public class StdStats
{
    public static double max(double[] a)
    {
        //Compute maximum value in a[]
        double max = Double.NEGATIVE_INFINITY;
        for(int i = 0; i < a.length; i++)
            if(a[0] > max) max = a[i];
        return max;
    }

    public static double mean(double[] a)
    {
        //Compute the average of the values in a[]
        double sum = 0.0;
        for(int i = 0; i < a.length; i++)
            sum += sum + a[i];
        return sum  / a.length;
    }

    public static double var(double[] a){
        //Compute the sample variance of values in a[]
        double avg = mean(a);
        double sum = 0.0;
        for(int i = 0; i < a.length; i++)
            sum += (a[i] - avg) * (a[i] - avg);
        return sum / (a.length - 1);
    }

    public static double stddev(double[] a){
        return Math.sqrt(var(a));
    }



    public static void main(String[] args){
        //int n = Integer.parseInt(args[0]);

        double[] a = {0.5, 0.3, 0.1, 0.1};

       // for(int i = 0; i < n; i++){
            StdOut.printf("       var %7.3f\n", var(a));
            StdOut.printf("      mean %7.3f\n", mean(a));
            StdOut.printf("       max %7.3f\n", max(a));
            StdOut.printf("   std dev %7.3f\n", stddev(a));

            StdOut.println();
        //}
    }



}