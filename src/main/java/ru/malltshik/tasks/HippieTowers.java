package ru.malltshik.tasks;


/**
 * In this task you get an array of tower where each element means high of tower
 * High of tower at the same time means how many steps you allow to do
 * For instance:
 * Given [1,2,0,3]
 * From index 0 at the first tower which high is 1 you allow to do only one step
 * From index 1 at the second tower which high is 2 you allow to do 2 steps or less (to third or fourth tower)
 *
 * Therefore you need return true if towers in possible to hopped over the end and false at the other way
 *
 */
class HopTowers {

    static boolean isHoppable(int[] towers){
        return isHoppable(towers, 0);
    }

    private static boolean isHoppable(int[] towers, int i) {
        // if index of element or elements itself more then array length return true, cause we've came over the array
        boolean isHoppable = towers.length <= i;
        if (isHoppable) return true;

        for (int j = towers[i]; j > 0; j--) {
            isHoppable = j >= towers.length || towers[i] + towers[j] > towers.length || isHoppable(towers, i + j);
            if (isHoppable) break;
        }
        return isHoppable;
    }

}
