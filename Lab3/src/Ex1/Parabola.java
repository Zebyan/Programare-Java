package Ex1;

public class Parabola {
    //1.membrii
    private int a;
    private int b;
    private int c;

    //2.Constructor
    Parabola(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    //3.Varful parabolei
    public double[] varfParabola() {
        double x = -b / (2.0 *a);
        double y = a * x * x + b * x + c;
        return new double[]{x,y};
    }

    //4.redefinire ToString
    @Override
    public String toString() {
        return "f(x) = " + a + " x^2 + " + b + " x + " + c;
    }

    //5. Mijlocul segmentului
    public double[] mijlocSegment(Parabola p) {
        double[] varf1 = this.varfParabola();
        double[] varf2 = p.varfParabola();
        double mijloc1 = (varf1[0] + varf2[0]) / 2.0;
        double mijloc2 = (varf1[1] + varf2[1]) / 2.0;
        return new double[]{mijloc1,mijloc2};
    }

    //6. Mijlocul metoda statica
    public static double [] mijlocSegmentStatic (Parabola p1, Parabola p2) {
        double[] varf1 = p1.varfParabola();
        double[] varf2 = p2.varfParabola();
        double mijloc1 = (varf1[0] + varf2[0]) / 2.0;
        double mijloc2 = (varf1[1] + varf2[1]) / 2.0;
        return new double[]{mijloc1,mijloc2};
    }

    //7.Calculeaza lungime segment
    public double lungimeSegment(Parabola p) {
        double[] varf1 = this.varfParabola();
        double[] varf2 = p.varfParabola();
        return Math.hypot(varf1[0] - varf2[0], varf1[1] - varf2[1]);
    }

    //8.Metoda statica pentru calcularea lungimii segmetului
    public static double lungimeSegmentStatic(Parabola p1, Parabola p2) {
        double[] varf1 = p1.varfParabola();
        double[] varf2 = p2.varfParabola();
        return Math.hypot(varf1[0] - varf2[0], varf1[1] - varf2[1]);
    }
}
