public class NBody {
    public static double readRadius(String filename) {
        In in = new In(filename);
        int Planetnum = in.readInt();
        double PlanetR = in.readDouble();
        return PlanetR;
    }

    public static Planet[] readPlanets(String filename) {
        In in = new In(filename);
        int Planetnum = in.readInt();
        double PlanetR = in.readDouble();
        Planet[] p = new Planet[Planetnum];
        double xxPos, yyPos, xxVel, yyVel, mass;
        String imgFileName;

        for (int k = 0; k < Planetnum; k++) {
            xxPos = in.readDouble();
            yyPos = in.readDouble();
            xxVel = in.readDouble();
            yyVel = in.readDouble();
            mass = in.readDouble();
            imgFileName = in.readString();
            p[k] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, "images/" + imgFileName);
        }
        return p;
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = readRadius(filename);
        Planet[] planets = readPlanets(filename);

        StdDraw.enableDoubleBuffering();

        StdDraw.setScale(-radius, radius);
        StdDraw.picture(0, 0, "images/starfield.jpg");

        for (Planet p : planets) {
            p.draw();
        }


        int plantNum = planets.length;
        double time = 0;
        while (time < T) {
            double[] xForces = new double[plantNum];
            double[] yForces = new double[plantNum];

            for (int i = 0; i < plantNum; i++) {
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }

            for (int i = 0; i < plantNum; i++) {
                planets[i].update(dt, xForces[i], yForces[i]);
            }

//            StdDraw.clear();
            StdDraw.picture(0, 0, "images/starfield.jpg");
            for (Planet p : planets) {
                p.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);

            T += dt;


            StdOut.printf("%d\n", planets.length);
            StdOut.printf("%.2e\n", radius);
            for (int i = 0; i < planets.length; i++) {
                StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n", planets[i].xxPos, planets[i].yyPos,
                        planets[i].xxVel, planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
            }

        }
    }
}