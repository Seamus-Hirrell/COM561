package practical_4;

import java.util.concurrent.Semaphore;

class HolbyHospital {
  public static void main(String[] args) {
    TreatmentRoom treatmentBeds = new TreatmentRoom(6);

    Semaphore empty = new Semaphore(4);
    Semaphore full = new Semaphore(0);

    AmbulancePorter ambulancePorter = new AmbulancePorter(empty, full, treatmentBeds);
    WardPorter wardPorter = new WardPorter(empty, full, treatmentBeds);

    ambulancePorter.start();
    wardPorter.start();

    System.out.println("Threads ambulancePorter and wardPorter have been commanded to start");
  }
}

class AmbulancePorter extends Thread {
  private Semaphore pempty;
  private Semaphore pfull;

  private TreatmentRoom treatmentBeds;

  public AmbulancePorter(Semaphore empty, Semaphore full, TreatmentRoom beds) {
    pempty = empty;
    pfull = full;
    treatmentBeds = beds;
  }

  public void run() {
    for (int round = 1; round <= 8; round++) {
      System.out.println("Ambluance Porter trying to put patient: " + round + " into treatment room");

      try {
        pempty.acquire();
      } catch (InterruptedException ie) {
        System.out.println("Ambluance Porter Interrupted");
      }

      treatmentBeds.putPatient(round);
      CDS.idleQuietly(1000);

      pfull.release();
      System.out.println("Ambluance Porter has put patient: " + round + " into treatment room");

      CDS.idleQuietly(2000);
    }

    System.out.println("Ambluence Porter finished");
  }
}

class WardPorter extends Thread {
  private Semaphore pempty;
  private Semaphore pfull;

  private TreatmentRoom treatmentBeds;

  public WardPorter(Semaphore empty, Semaphore full, TreatmentRoom beds) {
    pempty = empty;
    pfull = full;
    treatmentBeds = beds;
  }

  public void run() {
    for (int round = 1; round <= 8; round++) {
      System.out.println("Ward Porter trying to get, patient: " + round + " out of treatment room");

      try {
        pfull.acquire();
      } catch (InterruptedException ie) {
        System.out.println("Ward Porter Interrupted");
      }

      int patient = treatmentBeds.getPatient();
      CDS.idleQuietly(500);

      pempty.release();
      System.out.println("Ward Porter got patient:" + patient + " from treatment room");

      CDS.idleQuietly(1000);
    }

    System.out.println("Ward Porter finished");
  }
}

class TreatmentRoom {

  int size;
  int[] treatmentRoom;

  public TreatmentRoom(int numberOfBeds) {
    size = numberOfBeds;
    treatmentRoom = new int[size];
  }

  int putPtr = 0;
  int getPtr = 0;

  public void putPatient(int patientNum) {
    treatmentRoom[putPtr] = patientNum;
    putPtr = (putPtr + 1) % size;
  }

  public int getPatient() {
    int value = treatmentRoom[getPtr];

    getPtr = (getPtr + 1) % size;
    return value;
  }
}