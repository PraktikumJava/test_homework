public class Converter {
    static double DISTANCE_VALUE = 0.75;
    static double CALORIES_VALUE = 50;

    public double getDistance(int steps) {
        double distance = ((steps * DISTANCE_VALUE) / 1000);
        return distance;
    }

    public double getSumKlc(int steps) {
        double sumcal = ((steps * CALORIES_VALUE) / 1000);
        return sumcal;
    }

}
