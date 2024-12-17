public class lab2 {
    public static double ex11(double a, double b, double c, double d) {
        double arcsinA = Math.asin(a);
        double sqrtAbsB = Math.sqrt(Math.abs(b));
        double cosSqrtAbsB = Math.cos(sqrtAbsB);
        double powerTerm = Math.pow(2.43, d);
        double lnC = Math.log(c);
        double ans = (9 * arcsinA / cosSqrtAbsB) + powerTerm + lnC;
        return ans;
    }

    public static double ex2(double a, double b, double c, double d) {
        double expA = Math.exp(a);
        double logC = Math.log10(c);
        double arctgD = Math.atan(d);
        double absArctgD = Math.abs(arctgD);
        double powerBC = Math.pow(b, c);
        double sqrtPowerBC = Math.sqrt(powerBC);
        double ans = (expA + 3 * logC * absArctgD) / sqrtPowerBC;

        return ans;
    }

    public static double ex30(double a, double b, double c, double d) {
        double cosA = Math.cos(a);
        double tanhAbsB = Math.tanh(Math.abs(b));
        double lnD = Math.log(d);
        double part1 = (3 * a) / cosA;
        double part2 = Math.sqrt((tanhAbsB * c) / lnD);
        double ans = part1 + part2;

        return ans;
    }



    public static void main(String[] args) {
        System.out.println(ex11(0.478, -1.26, 2.68, 18.24));
        System.out.println(ex2(2.34, 0.756, 2.23, -1.653));
        System.out.println(ex30(0.58, -0.34, 1.25, 1.89));

    }
}