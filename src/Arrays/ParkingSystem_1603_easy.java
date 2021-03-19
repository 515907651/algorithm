package Arrays;

public class ParkingSystem_1603_easy {
    // 先初始化，防止存的时候是null
    private int big = 0;
    private int medium = 0;
    private int small = 0;
    public ParkingSystem_1603_easy(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    public boolean addCar(int carType) {
        switch (carType) {
            case 1: {
                if (big > 0) {
                    big--;
                    return true;
                } else {
                    return false;
                }
            }
            case 2: {
                if (medium > 0) {
                    medium--;
                    return true;
                } else {
                    return false;
                }
            }
            case 3: {
                if (small > 0) {
                    small--;
                    return true;
                } else {
                    return false;
                }
            }
            default: return false;
        }
    }

}
