package fi.al.courses.oopcontinued.ballevents;


import java.awt.event.ActionEvent;
import java.util.Hashtable;




public class Animator implements Runnable {

  private static final long STANDARD_SLEEPING_TIME = 50;

  private static final String[] COMMAND_STRINGS = { "", "Up", "Down", "Left", "Right", "UpLeft",
      "DownLeft", "UpRight", "DownRight" };

  private Hashtable<Integer, String> commandStrings = new Hashtable<Integer, String>(10);

  private Controller controller = null;
  private MovementInfo currentMovement = MovementInfo.values()[0];



  private enum MovementInfo {
    RANDOM_SLOW(-1, new int[] { -1, 1, 500 }),
    RANDOM_MEDIUM(-1, new int[] { -1, 1, 50 }),
    RANDOM_FAST(-1, new int[] { -1, 1, 10 }),
    SHORT_JUMP(5, new int[] { -1, 4, -1 }),
    LONG_JUMP(2, new int[] { -1, 9, -1 }),
    CROSS(2, new int[] { 4, 3, 250,
        3, 3, 250,
        2, 3, 250,
        1, 3, 250,
        3, 3, 250,
        4, 3, 250,
        1, 3, 500,
        2, 6, 3000 }),
    BOX(1, new int[] { 4, 6, 250,
        2, 3, 250,
        3, 3, 250,
        1, 3, 250,
        4, 3, 250,
        2, 3, 250,
        3, 3, 250,
        1, 6, 2000 }),
    WAIT_RANDOM(1, new int[] { 0, 1, -1 });

    int[] movementData = null;
    int maximumRepeats = 0;

    private MovementInfo(int maximumRepeats, int[] movementData) {
      this.maximumRepeats = maximumRepeats;
      this.movementData = movementData;
    }

    public int[] getMovementRecords() {
      return this.movementData;
    }

    public int getMaximumRepeats() {
      return this.maximumRepeats;
    }
  }



  public Animator(Controller controller) {
    this.controller = controller;

    for (int i = 0; i < COMMAND_STRINGS.length; i++)
      this.commandStrings.put(new Integer(i), COMMAND_STRINGS[i]);
  }


  public void run() {
    long sleepingTime = 0L;
    long lastMovementSwitchTime = 0L;
    int movementRepeats = 0;
    int currentDataItem = 0;
    int actionCommand = 0;
    int actionRepeats = 0;
    String actionCommandString = null;
    int[] movementRecords = this.currentMovement.getMovementRecords();
    int newMovementIndex = this.currentMovement.ordinal();
    boolean movementCanContinue = true;

    lastMovementSwitchTime = System.currentTimeMillis();
    while (!Thread.currentThread().isInterrupted()) {
      sleepingTime = STANDARD_SLEEPING_TIME;

      if (this.currentMovement.getMaximumRepeats() < 0 ||
          movementRepeats <= this.currentMovement.getMaximumRepeats())
        movementCanContinue = true;
      else
        movementCanContinue = false;

      if ((System.currentTimeMillis() - lastMovementSwitchTime > 500 && Math.random() > 0.95)
          || !movementCanContinue) {

        while (newMovementIndex == this.currentMovement.ordinal())
          newMovementIndex = (int) (Math.random() * 100000) % MovementInfo.values().length;

        this.currentMovement = MovementInfo.values()[newMovementIndex];
        movementRecords = this.currentMovement.getMovementRecords();
        currentDataItem = 0;
        movementRepeats = 0;
        lastMovementSwitchTime = System.currentTimeMillis();
      }
      // -- DEBUG -- System.out.println("Movement: " + this.currentMovement.toString());

      actionCommand = movementRecords[currentDataItem++];
      actionRepeats = movementRecords[currentDataItem++];
      sleepingTime = movementRecords[currentDataItem++];

      if (currentDataItem >= movementRecords.length) {
        currentDataItem = 0;
        movementRepeats++;
      }

      if (actionCommand == -1)
        actionCommand = (int) (Math.random() * this.commandStrings.size());

      actionCommandString = this.commandStrings.get(new Integer(actionCommand));
      // -- DEBUG -- System.out.println("ActionCommand: " + actionCommandString);

      if (!actionCommandString.equals("")) {
        for (int i = 0; i < actionRepeats; i++)
          this.controller.actionPerformed(new ActionEvent(this, 0, actionCommandString));
      }

      if (sleepingTime < 0)
        sleepingTime = 10 + (int) (Math.random() * 2000);

      try {
        Thread.sleep(sleepingTime);
      }
      catch (InterruptedException e) {
        return;
      }
    }
  }

} // end of class Animator
