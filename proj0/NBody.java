public class NBody{
    public static double readRadius(String filename){
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
        double xxPos,yyPos,xxVel,yyVel,mass;
        String imgFileName;

        for (int k = 0; k < Planetnum; k++) {
            xxPos = in.readDouble();
            yyPos = in.readDouble();
            xxVel = in.readDouble();
            yyVel = in.readDouble();
            mass = in.readDouble();
            imgFileName = in.readString();
            p[k] = new Planet(xxPos,yyPos,xxVel,yyVel,mass,"images/"+imgFileName);
        }
        return p;
    }
}
