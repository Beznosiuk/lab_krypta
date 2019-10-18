package com.company.lab3;


import static java.lang.Math.*;

class ElipsAction {

    private int a;
    private int p;

    ElipsAction(int a, int p) {
        this.a = a;
        this.p = p;
    }

    // mod calculation
    private int Mod(double a, int b) {
        int aTmp = (int) a;
        if (aTmp >= b)
            return aTmp % b;
        else if (aTmp < 0)
            return b - ((abs(aTmp) - b * (abs(aTmp) / b)) % b); // negative mod calc.
        else
            return aTmp;
    }

// calc mod like a^(b-1) mod b
    private int powMod(int a, int b) {
        int tmp = 1;
        for (int j = 0; j < b - 2; j++) {
            tmp *= a;
            tmp %= b;
        }
        return tmp;
    }

    private Coordinates doublePoint(Coordinates P) {
        // l = (3*x1^2+a)/(2*y1) mod p
        // l = (3*x1^2+a) * (2*y1)^-1 modp p
        // a^-1 mod p = a^(phi(p)-1) mod p = a^p-2 mod p
        double l = (3 * pow(P.getX(), 2) + a) * powMod((2 * P.getY()), p);
        Coordinates res = new Coordinates();
        res.setX(Mod(pow(l, 2) - 2 * P.getX(), p)); // x =l^2-2*x1
        res.setY(Mod((l * (P.getX() - res.getX()) - P.getY()), p)); // y3=l*(x1-x3)-y1
        return res;
    }

    Coordinates addPoints(Coordinates P, Coordinates Q) {
        if (P == Q) {
            return doublePoint(P);
        } else {
            double l = ((Q.getY() - P.getY()) * powMod(Q.getX() - P.getX(), p)) % p; // l = (y2-y1)/(x2-x1)
            Coordinates res = new Coordinates();
            res.setX(Mod(pow(l, 2) - P.getX() - Q.getX(), p)); // x =l^2-x1-x2
            res.setY(Mod(l * (P.getX() - res.getX()) - P.getY(), p)); // y3=l*(x1-x3)-y1

            return res;
        }
    }

    Coordinates multToNum(int n, Coordinates G) {
        if (n == 1)
            return G;
        Coordinates res = G;
        for (int i = 1; i < n; i++) {
            res = addPoints(res, G);
        }
        return res;
    }

// calculation y value of points
    int calc_y(int y_sq, int it) {
        double y = sqrt(y_sq);
        if (it == 20)
            return -1;
        else if (y - ceil(y) != 0)
            return calc_y(y_sq + p, it + 1);
        else
            return (int) y;
    }
}