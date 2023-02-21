package practical_4;

public class RegTest2 {
  public static void main(String[] args) {
    AnyData x = new AnyData(0);
    Qprog q = new Qprog(x, "Qprog");
    Rprog r = new Rprog(x, "Rprog");

    q.start();
    r.start();
    System.out.println("Threads q and r have been commanded to start");
  }
}

class Rprog extends Thread {
  private AnyData localdata;

  public Rprog(AnyData a, String threadName) {
    super(threadName);
    this.localdata = a;
  }

  public void run() {
    int reg1;

    CDS.idle(3000);

    reg1 = this.localdata.value;
    System.out.println("Rprog has read x as: " + reg1);

    CDS.idle(1000);

    reg1 = reg1 + 2;
    this.localdata.value = reg1;
    System.out.println("Rprog has copied " + reg1 + " back to x");
  }
}
