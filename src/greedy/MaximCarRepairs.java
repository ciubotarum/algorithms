package greedy;

import java.util.Arrays;

public class MaximCarRepairs {
//    În curtea unui atelier de reparaţii auto, sunt n maşini care trebuie sa fie reparate.
//    Deoarece nu sunt suficienţi mecanici, în fiecare moment de timp se poate lucra doar la o singură maşină.

//    Cunoscând timpul necesar pentru repararea fiecărei maşini, scrieţi un program care calculează
//    numărul maxim de maşini care pot fi reparate într-un interval de timp T.

    // Example:
    // Input: n = 5
    //        T = 10
    //        carsRepairTime = {6, 2, 4, 8, 2}
    // Output: 3

    public static int maximCarRepairs(int[] carsRepairTime, int n, int T) {
        Arrays.sort(carsRepairTime);

        int countRepairedCars = 0;
        int timePassed = 0;

        for (int i = 0; i < n; i++) {
            timePassed += carsRepairTime[i];
            if (timePassed <= T) {
                countRepairedCars++;
            }
        }

        return countRepairedCars;
    }

    public static void main(String[] args) {
        int[] carsRepairTime = {6, 2, 4, 8, 2};
        int T = 10;
        int n = 5;

        System.out.println(maximCarRepairs(carsRepairTime, n, T));
    }
}
