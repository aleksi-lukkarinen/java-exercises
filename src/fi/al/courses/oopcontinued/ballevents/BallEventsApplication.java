package fi.al.courses.oopcontinued.ballevents;


import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;




public class BallEventsApplication extends JFrame
    implements ActionListener, KeyEventPostProcessor {

  static final long serialVersionUID = 115;

  private static final int MAX_UNDOABLE_ACTIONS = 500;

  private static final int WINDOW_WIDTH = 800;
  private static final int WINDOW_HEIGHT = 600;

  private static final String ACTION_FILE_NAME = "Sources\\fi\\al\\OOPContinued\\BallEvents\\ActionData.dat";

  private static final String BTN_TXT_START_ANIMATION = "Start Animation";
  private static final String BTN_TXT_STOP_ANIMATION = "Stop Animation";
  private static final String BTN_TXT_UP = "Up";
  private static final String BTN_TXT_LEFT = "Left";
  private static final String BTN_TXT_DOWN = "Down";
  private static final String BTN_TXT_RIGHT = "Right";
  private static final String BTN_TXT_UPLEFT = "UpLeft";
  private static final String BTN_TXT_UPRIGHT = "UpRight";
  private static final String BTN_TXT_DOWNLEFT = "DownLeft";
  private static final String BTN_TXT_DOWNRIGHT = "DownRight";
  private static final String BTN_TXT_START_RECORDING = "Start Recording";
  private static final String BTN_TXT_STOP_RECORDING = "Stop Recording";
  private static final String BTN_TXT_PLAY_LAST_RECORDING = "Play Last Recording";
  private static final String BTN_TXT_UNDO = "Undo";


  // Järjestelmän kokoaminen
  protected JButton btnAnimationStartStop = null, // järjestelmän ohjauspainikkeet
      btnLeft = null,
      btnRight = null,
      btnUp = null,
      btnDown = null,
      btnRecordingStartStop = null,
      btnPlayRecording = null,
      btnUndoLastMovement = null;
  private Deque<ActionEvent> undoQueue = new ArrayDeque<ActionEvent>(MAX_UNDOABLE_ACTIONS);
  private boolean isRecording = false;
  private boolean isRecordingMade = false;
  private ObjectOutputStream actionWriter = null;
  private Ball ball = null; // model
  private Animator animator = null; // animoija
  protected BallPanel pnlDisplay = null; // varsinainen view
  protected Controller controller = null; // controller
  protected Thread animatorThread = null; // animoijaa suorittava säie
  protected Thread recordPlayerThread = null;



  public static void main(final String[] args) {
    initPLF();
    new BallEventsApplication();
  }



  public BallEventsApplication() {
    super(
        "Movable Event-Driven Ball with a Simple Movement Generator, Undoable Actions and Multiple Event Sources");

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    JPanel pnlButtons = null;
    JPanel pnlDirectionButtons = null;
    JPanel pnlRecordingButtons = null;
    JMenuBar menuBar = null;
    JMenu menuTmp = null;
    JMenuItem itemTmp = null;
    int iWndLeft = 0;
    int iWndTop = 0;

    this.pnlDisplay = new BallPanel();
    this.ball = new Ball();
    this.controller = new Controller(this.pnlDisplay, this.ball);
    this.animator = new Animator(this.controller);

    this.pnlDisplay.setBackground(javax.swing.plaf.metal.MetalLookAndFeel.getControlDisabled());
    this.pnlDisplay.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));

    menuBar = new JMenuBar();

    menuTmp = new JMenu("File", true);
    menuTmp.add(new JMenuItem("New"));
    menuTmp.add(new JMenuItem("Open..."));
    menuTmp.addSeparator();
    menuTmp.add(new JMenuItem("Save"));
    menuTmp.addSeparator();
    menuTmp.add(new JMenuItem("Exit"));
    menuBar.add(menuTmp);

    for (int i = 0; i < menuBar.getMenuCount(); i++) {
      menuTmp = menuBar.getMenu(i);

      for (int j = 0; j < menuTmp.getItemCount(); j++) {
        itemTmp = menuTmp.getItem(j);
        if (itemTmp != null) { // Separator = null
          itemTmp.addActionListener(this);
          itemTmp.addActionListener(this.controller);
        }
      }
    }


    pnlDirectionButtons = new JPanel();
    pnlDirectionButtons.setLayout(new BorderLayout());

    this.btnLeft = new JButton(BTN_TXT_LEFT);
    this.btnLeft.setPreferredSize(new Dimension(100, 25));
    this.btnLeft.addActionListener(this);
    this.btnLeft.addActionListener(this.controller);
    pnlDirectionButtons.add(this.btnLeft, BorderLayout.LINE_START);

    this.btnRight = new JButton(BTN_TXT_RIGHT);
    this.btnRight.setPreferredSize(new Dimension(100, 25));
    this.btnRight.addActionListener(this);
    this.btnRight.addActionListener(this.controller);
    pnlDirectionButtons.add(this.btnRight, BorderLayout.LINE_END);

    this.btnUp = new JButton(BTN_TXT_UP);
    this.btnUp.setPreferredSize(new Dimension(100, 25));
    this.btnUp.addActionListener(this);
    this.btnUp.addActionListener(this.controller);
    pnlDirectionButtons.add(this.btnUp, BorderLayout.PAGE_START);

    this.btnDown = new JButton(BTN_TXT_DOWN);
    this.btnDown.setPreferredSize(new Dimension(100, 25));
    this.btnDown.addActionListener(this);
    this.btnDown.addActionListener(this.controller);
    pnlDirectionButtons.add(this.btnDown, BorderLayout.PAGE_END);

    this.btnUndoLastMovement = new JButton(BTN_TXT_UNDO);
    this.btnUndoLastMovement.setPreferredSize(new Dimension(100, 25));
    this.btnUndoLastMovement.setEnabled(false);
    this.btnUndoLastMovement.addActionListener(this);
    this.btnUndoLastMovement.addActionListener(this.controller);
    pnlDirectionButtons.add(this.btnUndoLastMovement, BorderLayout.CENTER);


    pnlRecordingButtons = new JPanel();
    pnlRecordingButtons.setLayout(new BorderLayout());

    this.btnRecordingStartStop = new JButton(BTN_TXT_START_RECORDING);
    this.btnRecordingStartStop.setPreferredSize(new Dimension(160, 25));
    this.btnRecordingStartStop.addActionListener(this);
    pnlRecordingButtons.add(this.btnRecordingStartStop, BorderLayout.PAGE_START);

    this.btnPlayRecording = new JButton(BTN_TXT_PLAY_LAST_RECORDING);
    this.btnPlayRecording.setEnabled(false);
    this.btnPlayRecording.setPreferredSize(new Dimension(160, 25));
    this.btnPlayRecording.addActionListener(this);
    pnlRecordingButtons.add(this.btnPlayRecording, BorderLayout.PAGE_END);


    pnlButtons = new JPanel();

    pnlButtons.setBorder(BorderFactory.createEtchedBorder());

    this.btnAnimationStartStop = new JButton(BTN_TXT_START_ANIMATION);
    this.btnAnimationStartStop.setPreferredSize(new Dimension(160, 25));
    this.btnAnimationStartStop.addActionListener(this);
    pnlButtons.add(this.btnAnimationStartStop);

    pnlButtons.add(new JSeparator());
    pnlButtons.add(pnlDirectionButtons);
    pnlButtons.add(new JSeparator());
    pnlButtons.add(pnlRecordingButtons);

    setLayout(new BorderLayout());
    add(this.pnlDisplay, BorderLayout.CENTER);
    add(pnlButtons, BorderLayout.PAGE_END);

    this.setJMenuBar(menuBar);


    addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(final WindowEvent e) {
        KeyboardFocusManager.getCurrentKeyboardFocusManager()
            .removeKeyEventPostProcessor(BallEventsApplication.this);

        BallEventsApplication.this.stopAnimator();
        BallEventsApplication.this.stopActionRecording();
        BallEventsApplication.this.stopActionRecordPlaying();
        super.windowClosing(e);
      }
    });

    iWndLeft = (screenSize.width - WINDOW_WIDTH) / 2;
    iWndTop = (screenSize.height - WINDOW_HEIGHT) / 2;
    if (iWndLeft < 0) {
      iWndLeft = 0;
    }
    if (iWndTop < 0) {
      iWndTop = 0;
    }
    setLocation(iWndLeft, iWndTop);
    setMinimumSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
    setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
    setResizable(false);

    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    setVisible(true);

    KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventPostProcessor(this);
  }


  protected void startAnimator() {
    if (this.animatorThread == null) {
      this.animatorThread = new Thread(this.animator, "Animator");
      this.animatorThread.start();
    }
  }


  protected void stopAnimator() {
    if (this.animatorThread != null) {
      this.animatorThread.interrupt();
      while (this.animatorThread.isAlive()) {
        Thread.yield();
      }
      this.animatorThread = null;
    }
  }


  protected boolean startActionRecording() {
    stopActionRecording();

    try {
      File outFile = new File(ACTION_FILE_NAME);

      if (!outFile.isFile())
        outFile.createNewFile();

      if (outFile.canWrite()) {
        this.actionWriter = new ObjectOutputStream(new FileOutputStream(outFile));
        this.isRecording = true;
        this.isRecordingMade = true;
        return true;
      }

      JOptionPane.showMessageDialog(this, "The action file is not writable.",
          "Error", JOptionPane.ERROR_MESSAGE);
    }
    catch (IOException e) {
      e.printStackTrace();
    }

    return false;
  }


  protected void stopActionRecording() {
    try {
      if (this.actionWriter != null) {
        this.actionWriter.close();
      }
    }
    catch (final IOException e) {
      /* Nothing */
    }

    this.actionWriter = null;
    this.isRecording = false;
  }


  private void recordAction(final ActionEvent evt) {
    if (this.isRecording) {
      try {
        this.actionWriter.writeObject(evt);
      }
      catch (IOException e) {
        System.err.println("Unable to write an action to the action file: " + e);
      }
    }
  }


  private void playActionRecording() {
    if (!new File(ACTION_FILE_NAME).canRead())
      return;

    this.recordPlayerThread = new Thread(new Runnable() {
      private ObjectInputStream actionReader = null;

      public void run() {
        try {
          this.actionReader = new ObjectInputStream(new FileInputStream(ACTION_FILE_NAME));

          while (!Thread.currentThread().isInterrupted()) {
            try {
              BallEventsApplication.this.controller.actionPerformed(
                  (ActionEvent) this.actionReader.readObject());
            }
            catch (EOFException e) {
              break;
            }

            try {
              Thread.sleep(50);
            }
            catch (InterruptedException e) {
              /* Nothing */ }
          }

          this.actionReader.close();
          this.actionReader = null;
        }
        catch (Exception e) {
          e.printStackTrace();
        }

        BallEventsApplication.this.btnPlayRecording.setEnabled(true);
        BallEventsApplication.this.btnRecordingStartStop.setEnabled(true);

        BallEventsApplication.this.recordPlayerThread = null;
      }
    }, "RecordPlayer");

    this.recordPlayerThread.start();
    this.pnlDisplay.paint(this.pnlDisplay.getGraphics());
  }


  protected void stopActionRecordPlaying() {
    if (this.recordPlayerThread != null) {
      this.recordPlayerThread.interrupt();
      while (this.recordPlayerThread != null && this.recordPlayerThread.isAlive())
        Thread.yield();
    }
  }


  public void actionPerformed(final ActionEvent evt) {
    String command = evt.getActionCommand();

    // -- DEBUG -- System.out.println(command);

    if (command.equals(BTN_TXT_START_ANIMATION)) {
      this.pnlDisplay.setBackground(javax.swing.plaf.metal.MetalLookAndFeel.getWindowBackground());
      this.pnlDisplay.repaint();
      this.btnAnimationStartStop.setText(BTN_TXT_STOP_ANIMATION);
      this.btnRecordingStartStop.setEnabled(false);
      this.btnPlayRecording.setEnabled(false);
      startAnimator();
    }
    else if (command.equals(BTN_TXT_STOP_ANIMATION)) {
      stopAnimator();
      this.pnlDisplay.setBackground(javax.swing.plaf.metal.MetalLookAndFeel.getControlDisabled());
      this.pnlDisplay.repaint();
      this.btnAnimationStartStop.setText(BTN_TXT_START_ANIMATION);
      this.btnRecordingStartStop.setEnabled(true);
      this.btnPlayRecording.setEnabled(this.isRecordingMade);
    }
    else if (command.equals(BTN_TXT_START_RECORDING)) {
      if (startActionRecording()) {
        this.btnRecordingStartStop.setText(BTN_TXT_STOP_RECORDING);
        this.btnPlayRecording.setEnabled(false);
      }
    }
    else if (command.equals(BTN_TXT_STOP_RECORDING)) {
      stopActionRecording();
      this.isRecording = false;
      this.btnRecordingStartStop.setText(BTN_TXT_START_RECORDING);
      this.btnPlayRecording.setEnabled(true);
    }
    else if (command.equals(BTN_TXT_PLAY_LAST_RECORDING)) {
      if (!new File(ACTION_FILE_NAME).canRead()) {
        JOptionPane.showMessageDialog(this, "The action file is not readable.",
            "Error", JOptionPane.ERROR_MESSAGE);
        return;
      }

      this.btnRecordingStartStop.setEnabled(false);
      this.btnPlayRecording.setEnabled(true);

      playActionRecording();
    }
    else if (command.equalsIgnoreCase(BTN_TXT_LEFT) || command.equalsIgnoreCase(BTN_TXT_RIGHT)
        || command.equalsIgnoreCase(BTN_TXT_UP) || command.equalsIgnoreCase(BTN_TXT_DOWN)
        || command.equalsIgnoreCase(BTN_TXT_UPLEFT) || command.equalsIgnoreCase(BTN_TXT_UPRIGHT)
        || command.equalsIgnoreCase(BTN_TXT_DOWNLEFT)
        || command.equalsIgnoreCase(BTN_TXT_DOWNRIGHT)) {
      recordAction(evt);

      if (this.undoQueue.size() == MAX_UNDOABLE_ACTIONS)
        this.undoQueue.removeLast();

      this.undoQueue.addFirst(evt);

      this.btnUndoLastMovement.setEnabled(true);
    }
    else if (command.equalsIgnoreCase(BTN_TXT_UNDO)) {
      String strCommand = null;

      if (!this.undoQueue.isEmpty()) {
        strCommand = this.undoQueue.removeFirst().getActionCommand();

        if (strCommand.equalsIgnoreCase(BTN_TXT_LEFT)) {
          strCommand = BTN_TXT_RIGHT;
        }
        else if (strCommand.equalsIgnoreCase(BTN_TXT_RIGHT)) {
          strCommand = BTN_TXT_LEFT;
        }
        else if (strCommand.equalsIgnoreCase(BTN_TXT_UP)) {
          strCommand = BTN_TXT_DOWN;
        }
        else if (strCommand.equalsIgnoreCase(BTN_TXT_DOWN)) {
          strCommand = BTN_TXT_UP;
        }
        else if (strCommand.equalsIgnoreCase(BTN_TXT_UPLEFT)) {
          strCommand = BTN_TXT_DOWNRIGHT;
        }
        else if (strCommand.equalsIgnoreCase(BTN_TXT_UPRIGHT)) {
          strCommand = BTN_TXT_DOWNLEFT;
        }
        else if (strCommand.equalsIgnoreCase(BTN_TXT_DOWNLEFT)) {
          strCommand = BTN_TXT_UPRIGHT;
        }
        else if (strCommand.equalsIgnoreCase(BTN_TXT_DOWNRIGHT)) {
          strCommand = BTN_TXT_UPLEFT;
        }

        this.controller.actionPerformed(new ActionEvent(this, 0, strCommand));
      }

      if (this.undoQueue.isEmpty()) {
        this.btnUndoLastMovement.setEnabled(false);
      }
    }
    else if (command.equalsIgnoreCase("Exit")) {
      this.dispose();
    }
    else {
      System.err.println("Tuntematon komento: " + command);
    }
  }


  public boolean postProcessKeyEvent(final KeyEvent evt) {
    int keyCode = evt.getKeyCode();
    int keyLocation = evt.getKeyLocation();
    String strCommand = null;

    if (evt.getID() != KeyEvent.KEY_PRESSED) {
      return false;
    }

    // -- DEBUG -- System.out.println("KeyPressed");
    // -- DEBUG -- System.out.println(keyCode);

    switch (keyCode) {
    case KeyEvent.VK_NUMPAD8:
    case KeyEvent.VK_UP:
      strCommand = BTN_TXT_UP;
      break;
    case KeyEvent.VK_NUMPAD2:
    case KeyEvent.VK_DOWN:
      strCommand = BTN_TXT_DOWN;
      break;
    case KeyEvent.VK_NUMPAD4:
    case KeyEvent.VK_LEFT:
      strCommand = BTN_TXT_LEFT;
      break;
    case KeyEvent.VK_NUMPAD6:
    case KeyEvent.VK_RIGHT:
      strCommand = BTN_TXT_RIGHT;
      break;

    default:
      if (keyLocation == KeyEvent.KEY_LOCATION_NUMPAD) {
        switch (keyCode) {
        case KeyEvent.VK_NUMPAD9:
        case KeyEvent.VK_PAGE_UP:
          strCommand = BTN_TXT_UPRIGHT;
          break;
        case KeyEvent.VK_NUMPAD3:
        case KeyEvent.VK_PAGE_DOWN:
          strCommand = BTN_TXT_DOWNRIGHT;
          break;
        case KeyEvent.VK_NUMPAD7:
        case KeyEvent.VK_HOME:
          strCommand = BTN_TXT_UPLEFT;
          break;
        case KeyEvent.VK_NUMPAD1:
        case KeyEvent.VK_END:
          strCommand = BTN_TXT_DOWNLEFT;
          break;
        case KeyEvent.VK_CLEAR:
        case KeyEvent.VK_NUMPAD5:
          strCommand = BTN_TXT_UNDO;
          break;
        }
      }
    }

    if (strCommand != null) {
      this.actionPerformed(new ActionEvent(this, 0, strCommand));

      if (strCommand != BTN_TXT_UNDO)
        this.controller.actionPerformed(new ActionEvent(this, 0, strCommand));
    }

    return true;
  }


  public static void initPLF() {
    try {
      // JFrame.setDefaultLookAndFeelDecorated(true);
      // JDialog.setDefaultLookAndFeelDecorated(true);
      // Toolkit.getDefaultToolkit().setDynamicLayout(true);

    }
    catch (Exception e) {
      e.printStackTrace(System.err);
    }
  }

} // end of class BallEventsApplication
