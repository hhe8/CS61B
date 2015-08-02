import java.util.Comparator;
import java.util.Arrays;
/* Import anything else you need here. */

/**
 * MaxPlanet.java
 */

public class MaxPlanet {

    /** Returns the Planet with the maximum value according to Comparator c. */
    public static Planet maxPlanet(Planet[] planets, Comparator<Planet> c) {
        // REPLACE THIS LINE WITH YOUR SOLUTION
        // if (planets.length == 0){
        //   return null;
        // }
        //
        // Planet ans = planets[0];
        // for (Planet planet: planets){
        //   if (c.compare(ans,planet) < 0){
        //     ans = planet;
        //   }
        // }
        // return ans;
        Arrays.sort(planets,c);
        return planets[planets.length-1];
    }
}
