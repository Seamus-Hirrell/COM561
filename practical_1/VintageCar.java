public class VintageCar {
  int modelYear;
  String modelName;

  public VintageCar(int year, String name) {
    modelYear = year;
    modelName = name;
  }

  public static void main(String[] args) {
    VintageCar oldCar = new VintageCar(1969, "Mustang");
    System.out.println(oldCar.modelYear + " " + oldCar.modelName);
  }
}
