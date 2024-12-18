package Lab3;

public class Main {
    public static double first(double s, double t, int k) {
        if (k < 2 || k > 25) throw new IllegalArgumentException("Incorrect value for argument k!");
        double sum = 0.0;

        for (int i = 1; i <= k; i++) {
            sum += Math.log(-t * i) * Math.cos(Math.sqrt(s / (i * i)));

        }
        return sum;
    }

    public static double second(double t, int i) {
        if (i == 1) {
            return Math.sqrt(t);
        } else if (i == 2) {
            return 1 / Math.sqrt(t);
        } else {
            double sum = 0.0;
            for (int k = 1; k <= i; k++) {
                sum += k * t;
            }
            return sum;
        }
    }
    public static Double third (double e) {
        if (e <= 0) throw new IllegalArgumentException("Incorrect value for argument e!");
        double sum = 0;
        for (int i = 1; i < Double.POSITIVE_INFINITY; i++) {
            double current = ((Math.pow(-1, i+1)) / (i * (i + 1) * (i + 2)));
            if (Math.abs(current) < e) {
                break;
            }
            sum += current;
        }
        return sum;
    }

    static void printResultsFirst(double s, double t, int k) {
        System.out.print("s: " + s + " t: " + t + " k: " + k + " result: ");
        try {
            System.out.println(first(s, t, k));
        } catch (IllegalArgumentException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }

    static void printResultsSecond(double t, int i) {
        System.out.print("t: " + t + " i: " + i + " result: ");
        try {
            System.out.println(second(t, i));
        } catch (IllegalArgumentException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }

    static void printResultsThird(double e) {
        System.out.print("e: " + e + " result: ");
        try {
            System.out.println(third(e));
        } catch (IllegalArgumentException ex) {
            System.out.println("Error occurred: " + ex.getMessage());
        }
    }
    public static void main(String[] args) {
        printResultsFirst(2, -2, 3);
        printResultsSecond(4, 1);
        printResultsThird(0.1);
    }
}