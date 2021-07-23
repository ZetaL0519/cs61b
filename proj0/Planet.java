public class Planet {
    double xxPos;
    double yyPos;
    double xxVel;
    double yyVel;
    double mass;
    String imgFileName;
    private static final double G = 6.67e-11;

    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }


    public Planet(Planet p){
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet other) {
        // return Math.sqrt(Math.pow(this.xxPos - other.xxPos, 2) + Math.pow(this.yyPos
        // - other.yyPos, 2));
        double xxDiff = this.xxPos - other.xxPos;
        double yyDiff = this.yyPos - other.yyPos;
        return Math.sqrt(xxDiff * xxDiff + yyDiff * yyDiff);
    }

    public double calcForceExertedBy(Planet other) {
        double dist = calcDistance(other);
        return G * this.mass * other.mass / (dist * dist);
    }

    public double calcForceExertedByX(Planet other) {
        double dist = calcDistance(other);
        double force = calcForceExertedBy(other);
        return (other.xxPos - this.xxPos) / dist * force;
    }

    public double calcForceExertedByY(Planet other) {
        double dist = calcDistance(other);
        double force = calcForceExertedBy(other);
        return (other.yyPos - this.yyPos) / dist * force;
    }

    public double calcNetForceExertedByX(Planet[] others) {
        double totalForce = 0;
        for (Planet other : others) {
            if (this.equals(other))
                continue;
            totalForce += calcForceExertedByX(other);
        }
        return totalForce;
    }

    public double calcNetForceExertedByY(Planet[] others) {
        double totalForce = 0;
        for (Planet other : others) {
            if (this.equals(other))
                continue;
            totalForce += calcForceExertedByY(other);
        }
        return totalForce;
    }

    public void update(double duration, double xxForce, double yyForce) {
        double xxAcc = xxForce / this.mass;
        double yyAcc = yyForce / this.mass;
        double newXXVel = this.xxVel + duration * xxAcc;
        double newYYVel = this.yyVel + duration * yyAcc;
        this.xxVel = newXXVel;
        this.yyVel = newYYVel;
        this.xxPos = this.xxPos + duration * newXXVel;
        this.yyPos = this.yyPos + duration * newYYVel;
    }
    public void draw(){
        StdDraw.picture(xxPos, yyPos, imgFileName);
    }
//
//    public Double calcForceExertedByX(Planet p){
//        Planet temp = p;
//        double f = this.calcForceExertedBy(temp);
//        double dx = p.xxPos - this.xxPos;
//        double dist = this.calcDistance(temp);
//        double forceX = f * dx / dist;
//        return forceX;
//    }
//
//    public Double calcForceExertedByY(Planet p){
//        Planet temp = p;
//        double f = this.calcForceExertedBy(temp);
//        double dy = p.yyPos - this.yyPos;
//        double dist = this.calcDistance(temp);
//        double forceY = f * dy / dist;
//        return forceY;
//    }

//    public double calcNetForceExertedByX(Planet[] allPlanets){
//        double forcex = 0;
//        for(int i = 0; i < allPlanets.length;i++){
//            Planet p = allPlanets[i];
//            if (this.equals(p)){
//                continue;
//            }
//            forcex += calcForceExertedByX(p);
//        }
//        return forcex;
//    }
//
//    public double calcNetForceExertedByY(Planet[] allPlanets){
//        double forcey = 0;
//        for(int i = 0; i < allPlanets.length;i++){
//            Planet p = allPlanets[i];
//            if (this.equals(p)){
//                continue;
//            }
//            forcey += calcForceExertedByY(p);
//        }
//        return forcey;
//    }
//
//    public void update(double dt, double fX, double fY){
//        double newxxvel = this.xxVel + dt * fX/mass;
//        double newyyvel = this.yyVel + dt * fY/mass;
//        this.xxVel = newxxvel;
//        this.yyVel = newyyvel;
//        double newxxpos = this.xxPos + dt * newxxvel;
//        double newyypos = this.yyPos + dt * newyyvel;
//        this.xxPos = newxxpos;
//        this.yyPos = newyypos;
//    }

}

