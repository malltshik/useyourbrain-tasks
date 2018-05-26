package ru.malltshik.tasks;

/**
 * In this task you have a N stairs and set of allowed step's sizes
 *
 * For instance:
 * Given N = 2, S = {1,2}
 * You have to decide how many paths you might to use to going from bottom to top
 * In that example return value will be 2, because you could finish starts by one step from bottom to top
 * and by two steps from 0 to 1 stair and next step would be from 1 to 2 stair
 *
 */
class StairsToTheTop {

    /**
     * Function for count all of possible paths
     * @param n number of stairs
     * @param asteps allowed steps
     * @return all possible paths
     */
    static int countSteps(int n, int[] asteps) {
        int paths = 0;
        for(int as: asteps) {
            int i = n - as;
            if(i == 0) paths++;
            if(i > 0) paths += countSteps(i, asteps);
        }
        return paths;
    }

}
