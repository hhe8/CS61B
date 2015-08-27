package creatures;
import huglife.Creature;
import huglife.Direction;
import huglife.Action;
import huglife.Occupant;
import huglife.HugLifeUtils;
import java.awt.Color;
import java.util.Map;
import java.util.List;

public class Clorus extends Creature{
  private int r;
  private int g;
  private int b;
  private double moveProbability = 0.5;

  public Clorus(double e){
    super("clorus");
    r=0;
    g=0;
    b=0;
    energy = e;
  }

  public Clorus(){
    this(0.5);
  }

  public Color color() {
    r = 34;
    b = 231;
    g = 0;
    return color(r, g, b);
  }

  /** Do nothing with C, Plips are pacifists. */
  public void attack(Creature c) {
    energy += c.energy();
  }

  /** Plips should lose 0.15 units of energy when moving. If you want to
   *  to avoid the magic number warning, you'll need to make a
   *  private static final variable. This is not required for this lab.
   */
  public void move() {
    energy -= 0.03;
  }


  /** Plips gain 0.2 energy when staying due to photosynthesis. */
  public void stay() {
    energy -= 0.01;
  }

  /** Plips and their offspring each get 50% of the energy, with none
   *  lost to the process. Now that's efficiency! Returns a baby
   *  Plip.
   */
  public Clorus replicate() {
    energy = 0.5*energy;
    return new Clorus(energy);
  }

  public Action chooseAction(Map<Direction,Occupant> neighbors){
    List<Direction> empties = getNeighborsOfType(neighbors, "empty");
    if (empties.size() == 0){
      return new Action(Action.ActionType.STAY);
    }
    List<Direction> plips = getNeighborsOfType(neighbors,"plip");
    if (plips.size() > 0){
      Direction attackDir = HugLifeUtils.randomEntry(plips);
      return new Action(Action.ActionType.ATTACK,attackDir);
    }
    Direction moveDir = HugLifeUtils.randomEntry(empties);
    if (energy >= 1){
      return new Action(Action.ActionType.REPLICATE, moveDir);
    }
    return new Action(Action.ActionType.MOVE, moveDir);

  }

}
