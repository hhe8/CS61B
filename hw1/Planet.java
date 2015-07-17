public class Planet{
  public static double G = 6.67e-11;
  public static double dt;

  private double xNetForce;
  private double yNetForce;
  public double xAccel;
  public double yAccel;

  // initialization
  public double x;
  public double y;
  public double xVelocity;
  public double yVelocity;
  public double mass;
  public String img;




  public Planet(double xStart, double yStart, double xVelocityStart,
  double yVelocityStart, double massStart, String imgStart){
    x = xStart;
    y = yStart;
    xVelocity = xVelocityStart;
    yVelocity = yVelocityStart;
    mass = massStart;
    img = "/images/"+ imgStart;
  }

  public double calcDistance(Planet a){
    return Math.sqrt( Math.pow((a.x-this.x),2) + Math.pow((a.y-this.y),2) );
  }

  public double calcPairwiseForce(Planet a){
    return G*mass*a.mass/(calcDistance(a) * calcDistance(a) );
  }

  public double calcPairwiseForceX(Planet a){
    return calcPairwiseForce(a)/calcDistance(a)*Math.abs(this.x - a.x);
  }

  public double calcPairwiseForceY(Planet a){
    return calcPairwiseForce(a)/calcDistance(a)*Math.abs(this.y - a.y);
  }

  public void setNetForce(Planet[] a){
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
      xVelocity = xVelocity + dt*xAccel;
      yVelocity = yVelocity + dt*yAccel;
      x = x + dt*xVelocity;
      y = y + dt*yVelocity;
  }

}
