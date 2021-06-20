package sample;

import java.util.Random;

class CustomMethods {

    /** Replace the below method with your own method. Refactor the name so it'll change in the Controller.initialize() as well. */
    /** Returns an array a such that, for all j, a[j] equals the average of x[0], ..., x[j]. */
    public static double[] prefixAverage1(double[] x) {
        int n = x.length;
        double[] a = new double[n];
        for (int j=0; j < n; j++) {
            double total = 0;
            for (int i=0; i <= j; i++)
                total += x[i];
            a[j] = total / (j+1);
        }
        return a;
    }

    /** Replace the below method with your own method. Refactor the name so it'll change in the Controller.initialize() as well. */
    /** Returns an array a such that, for all j, a[j] equals the average of x[0], ..., x[j]. */
    public static double[] prefixAverage2(double[] x) {
        int n = x.length;
        double[] a = new double[n];
        double total = 0;
        for (int j=0; j < n; j++) {
            total += x[j];
            a[j] = total / (j+1);
        }
        return a;
    }

    public static double[] inputSize(int n) {
        double[] inputs = new double[n];
        for (int i = 0; i < n; i++) {
            inputs[i] = new Random().nextInt(10);
        }
        return inputs;
    }
}

