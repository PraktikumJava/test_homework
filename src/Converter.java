public class Converter {
    public double getDistance(int steps) {
        double distance = ((steps * 0.75) / 1000);
        return distance;
    }

    public double getSumKlc(int steps) {
        double sumcal = ((steps * 50) / 1000);
        return sumcal;
    }

}
