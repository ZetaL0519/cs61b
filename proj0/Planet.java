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

    public double calcDistance(Planet p){
        double dx = this.xxPos - p.xxPos;
        double dy = this.yyPos - p.yyPos;
        double dis = Math.sqrt(dx*dx + dy*dy);
        return dis;
    }

    public double calcForceExertedBy(Planet p){
        double upper = G * this.mass * p.mass;
        double dis = calcDistance(p);
        double Force = upper / dis;
        return Force;
    }

    public double calcForceExertedByX(Planet p){
        double Force = calcForceExertedBy(p);
        double dx = p.xxPos - this.xxPos;
        double dis = calcDistance(p);
        double Forcex = Force * dx / dis;
        return Forcex;
    }

    public double calcForceExertedByY(Planet p){
        double Force = calcForceExertedBy(p);
        double dy = p.yyPos - this.yyPos;
        double dis = calcDistance(p);
        double Forcey = Force * dy / dis;
        return Forcey;
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

    public double calcNetForceExertedByX(Planet[] allPlanets){
        double forcex = 0;
        for(int i = 0; i < allPlanets.length;i++){
            Planet p = allPlanets[i];
            if (this.equals(p)){
                continue;
            }
            forcex += calcForceExertedByX(p);
        }
        return forcex;
    }

    public double calcNetForceExertedByY(Planet[] allPlanets){
        double forcey = 0;
        for(int i = 0; i < allPlanets.length;i++){
            Planet p = allPlanets[i];
            if (this.equals(p)){
                continue;
            }
            forcey += calcForceExertedByY(p);
        }
        return forcey;
    }

    public void update(double dt, double fX, double fY){
        double newxxvel = this.xxVel + dt * fX/mass;
        double newyyvel = this.yyVel + dt * fY/mass;
        this.xxVel = newxxvel;
        this.yyVel = newyyvel;
        double newxxpos = this.xxPos + dt * newxxvel;
        double newyypos = this.yyPos + dt * newyyvel;
        this.xxPos = newxxpos;
        this.yyPos = newyypos;
    }

}

