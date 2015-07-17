public class NBody{
    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]); //time
        double dt = Double.parseDouble(args[1]); //incremental time
        String filename = args[2];
        int time = 0;

        In file = new In(filename);
        int N = file.readInt();
        double R = file.readDouble();

        // read planets into an array
        Planet[] planets = new Planet[5];
        for(int i=0; i<N; i++){
          planets[i] = getPlanet(file);
        }

        // initialization
        // set the scale of the universe
        StdDraw.setScale(-R,R);
        StdDraw.picture(0,0,"/images/starfield.jpg");
        double[] sound = StdAudio.read("/audio/2001.mid");
        StdAudio.play(sound);

        // draw the planets
        for (Planet planet: planets){
          planet.draw();
        }


        //animation
        while (time < T) {
          for (Planet planet: planets){
            planet.setNetForce(planets);
            planet.update(dt);
          }

          StdDraw.picture(0,0,"/images/starfield.jpg");
          for (Planet planet: planets){
            planet.draw();
          }
          StdDraw.show(10);
          time+=dt;
        }

        //print output

        StdOut.printf("%d\n", N);
        StdOut.printf("%.2e\n", R);
        for (int i = 0; i < N; i++) {
           StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                           planets[i].x, planets[i].y, planets[i].xVelocity, planets[i].yVelocity, planets[i].mass, planets[i].img);
        }

    }

    public static Planet getPlanet(In in){
        double x = in.readDouble();
        double y = in.readDouble();
        double xv = in.readDouble();
        double yv = in.readDouble();
        double mass = in.readDouble();
        String image = in.readString();
        return new Planet(x,y,xv,yv,mass,image);
    }
}
