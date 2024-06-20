//GFG
//Integral Points Inside Triangle
//Time complexity: O(Log2(10^9))
//Space complexity: O(1)

public class IntegralPointsInsideTriangle {

    class Point {
        long x, y;

        Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        long p[] = { 0, 0 }, q[] = { 0, 5 }, r[] = { 5, 0 };
        IntegralPointsInsideTriangle obj1 = new IntegralPointsInsideTriangle();
        System.out.println(obj1.InternalCount(p, q, r));
    }

    long InternalCount(long p[], long q[], long r[]) {
        // code here
        Point P = new Point(p[0], p[1]);
        Point Q = new Point(q[0], q[1]);
        Point R = new Point(r[0], r[1]);

        long boundary = boundryPoint(P, Q) + boundryPoint(Q, R) + boundryPoint(R, P) + 3;

        long area = Math.abs(P.x * (Q.y - R.y) + Q.x * (R.y - P.y) + R.x * (P.y - Q.y)) / 2;

        long internalPoints = area + 1 - boundary / 2;
        return internalPoints;
    }

    public long boundryPoint(Point p, Point q) {
        if (p.x == q.x)
            return Math.abs(p.y - q.y) - 1;
        if (p.y == q.y)
            return Math.abs(p.x - q.x) - 1;
        return gcd(Math.abs(p.x - q.x), Math.abs(p.y - q.y)) - 1;
    }

    public long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}
