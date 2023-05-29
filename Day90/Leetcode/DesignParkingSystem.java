//Leetcode
//1603. Design Parking System
//Time complexity: Just class design
//Space complexity: Just class design

public class DesignParkingSystem {

    static class ParkingSystem {

        int big, medium, small;
        public ParkingSystem(int big, int medium, int small) {
            this.big = big;
            this.medium = medium;
            this.small = small;
        }

        public boolean addCar(int carType) {
            if (carType == 1 && big == 0 || carType == 2 && medium == 0 || carType == 3 && small == 0)
                return false;
            if (carType == 1)
                big--;
            if (carType == 2)
                medium--;
            if (carType == 3)
                small--;
            return true;
        }
    }

    public static void main(String[] args) {
        ParkingSystem parkingSystem = new ParkingSystem(1, 1, 0);
        parkingSystem.addCar(1); // return true because there is 1 available slot for a big car
        parkingSystem.addCar(2); // return true because there is 1 available slot for a medium car
        parkingSystem.addCar(3); // return false because there is no available slot for a small car
        parkingSystem.addCar(1); // return false because there is no available slot for a big car. It is already
                                 // occupied.
    }
}
