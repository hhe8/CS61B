public class Planet{
  public static double G = 6.67e-11;
  public static double dt;

  public double xNetForce;
  public double yNetForce;
  public double xAccel;
  public double yAccel;

  // initialization
  public double x;
  public double y;
  public double xVelocity;
  public double yVelocity;
  public double mass;
  public String img;

  private double radius;


  public Planet(double xStart, double yStart, double xVelocityStart,
  double yVelocityStart, double massStart, String imgStart, double radius){
    x = xStart;
    y = yStart;
    xVelocity = xVelocityStart;
    yVelocity = yVelocityStart;
    mass = massStart;
    img = "/images/"+ imgStart;
    this.radius = radius;
  }

  public double getRadius(){
    return radius;
  }

  public double getMass(){
    return mass;
  }

  public double calcDistance(Planet a){
    return Math.sqrt( Math.pow((a.x-this.x),2) + Math.pow((a.y-this.y),2) );
  }

  public double calcPairwiseForce(Planet a){
    return G*mass*a.mass/(calcDistance(a) * calcDistance(a) );
  }

  public double calcPairwiseForceX(Planet a){
    return calcPairwiseForce(a)/calcDistance(a)*(a.x-this.x);
  }

  public double calcPairwiseForceY(Planet a){
    return calcPairwiseForce(a)/calcDistance(a)*(a.y-this.y);
  }

  public void setNetForce(Planet[] a){
      this.xNetForce = 0;
      this.yNetForce = 0;
      for (Planet planet : a){
          if (this != planet){
              this.xNetForce = this.xNetForce + calcPairwiseForceX(planet);
              this.yNetForce = this.yNetForce + calcPairwiseForceY(planet);
          }
      }
  }

  public void draw(){
      StdDraw.picture(x,y,img);
  }

  public void update(double dt){
    // assume that netforce is set already
      xAccel = xNetForce/mass;
      yAccel = yNetForce/mass;
      xVelocity = xVelocity + dt*xAccel;
      yVelocity = yVelocity + dt*yAccel;
      x = x + dt*xVelocity;
      y = y + dt*yVelocity;
  }

}
