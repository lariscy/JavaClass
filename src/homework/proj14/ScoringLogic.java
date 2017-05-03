package homework.proj14;

import java.util.Arrays;

/**
 * @author Steven Lariscy
 */
public class ScoringLogic {
    
    private static int getScoreForN(int[] dieValues, int num){
        int retVal = 0;
        for (int val : dieValues){
            if (val == num){
                retVal += num;
            }
        }
        return retVal;
    }
    
    private static int getSumOfDiceValues(int[] dieValues){
        int retVal = 0;
        for (int val : dieValues){
            retVal += val;
        }
        return retVal;
    }
    
    private static boolean hasNOfAKind(int[] dieValues, int count){
        boolean wasFound = false;
        for (int number : new int[]{1,2,3,4,5}){
            if (ScoringLogic.hasNOrGreaterOfNumber(dieValues, count, number)){
                wasFound = true;
                break;
            }
        }
        return wasFound;
    }
    
    private static boolean hasNOrGreaterOfNumber(int[] dieValues, int count, int number){
        int[] numOfEachNumber = {0, 0, 0, 0, 0, 0};
        for (int val : dieValues){
            numOfEachNumber[val-1]++;
        }
        return numOfEachNumber[number-1] >= count;
    }
    
    private static boolean hasSameColor(int[] dieValues){
        boolean allDiceBlack = false;
        boolean allDiceRed = false;
        boolean allDiceGreen = false;
        switch (dieValues[0]) {
            case 1:
            case 6:
                for (int val : dieValues){
                    if (val != 1 && val != 6){
                        allDiceBlack = false;
                        break;
                    } else {
                        allDiceBlack = true;
                    }
                }
                break;
            case 2:
            case 5:
                for (int val : dieValues){
                    if (val != 2 && val != 5){
                        allDiceBlack = false;
                        break;
                    } else {
                        allDiceBlack = true;
                    }
                }
                break;
            case 3:
            case 4:
                for (int val : dieValues){
                    if (val != 3 && val != 4){
                        allDiceBlack = false;
                        break;
                    } else {
                        allDiceBlack = true;
                    }
                }
                break;
            default:
                System.err.println("check default switch case in ScoringLogic.hasFlush()");
                break;
        }
        return allDiceBlack || allDiceRed || allDiceGreen;
    }
    
    private static boolean hasFullHouse(int[] dieValues){
        int[] counts = new int[6];
        for (int num : dieValues) {
            counts[num - 1]++;
        } // end for
        boolean check2 = false;
        boolean check3 = false;
        for (int i: counts) {
            check2 |= (i==2);
            check3 |= (i==3);
        } // end for
        return (check2 && check3);
    }
    
    public static int getScoreForAces(int[] dieValues){
        return ScoringLogic.getScoreForN(dieValues, 1);
    }
    
    public static int getScoreForDueces(int[] dieValues){
        return ScoringLogic.getScoreForN(dieValues, 2);
    }
    
    public static int getScoreForTreys(int[] dieValues){
        return ScoringLogic.getScoreForN(dieValues, 3);
    }
    
    public static int getScoreForFours(int[] dieValues){
        return ScoringLogic.getScoreForN(dieValues, 4);
    }
    
    public static int getScoreForFives(int[] dieValues){
        return ScoringLogic.getScoreForN(dieValues, 5);
    }
    
    public static int getScoreForSixes(int[] dieValues){
        return ScoringLogic.getScoreForN(dieValues, 6);
    }
    
    public static int getBasicScoreBonus(int totalOfSingles){
        int totalBonus = 0;
        if (totalOfSingles >= 63 && totalOfSingles <=70){
            totalBonus = 35;
        } else if (totalOfSingles >= 71 && totalOfSingles <= 77){
            totalBonus = 55;
        } else if (totalOfSingles >= 78){
            totalBonus = 75;
        }
        return totalBonus;
    }
    
    public static int getScoreTwoPairSameColor(int[] dieValues){
        boolean isValid = false;
        Arrays.sort(dieValues);
        if (dieValues[0] == dieValues[1] && dieValues[2] == dieValues[3]){
            isValid = ScoringLogic.hasSameColor(new int[]{
                dieValues[0], dieValues[1], dieValues[2], dieValues[3]
            });
        }
        if (dieValues[0] == dieValues[1] && dieValues[3] == dieValues[4]){
            isValid = ScoringLogic.hasSameColor(new int[]{
                dieValues[0], dieValues[1], dieValues[3], dieValues[4]
            });
        }
        if (dieValues[1] == dieValues[2] && dieValues[3] == dieValues[4]){
            isValid = ScoringLogic.hasSameColor(new int[]{
                dieValues[1], dieValues[2], dieValues[3], dieValues[4]
            });
        }
        return isValid ? ScoringLogic.getSumOfDiceValues(dieValues) : 0;
    }
    
    public static int getScoreThreeOfAKind(int[] dieValues){
        return ScoringLogic.hasNOfAKind(dieValues, 3) ? 
                ScoringLogic.getSumOfDiceValues(dieValues) : 0;
    }
    
    public static int getScoreStraight(int[] dieValues){
        int inLine = 0;
        Arrays.sort(dieValues);
        for (int i=0; i<dieValues.length - 1; i++){
            if (dieValues[i] == (dieValues[i+1] - 1)){
                inLine++;
            }
        }
        return (inLine == 4) ? 30 : 0;
    }
    
    public static int getScoreFlush(int[] dieValues){
        return ScoringLogic.hasSameColor(dieValues) ? 45 : 0;
    }
    
    public static int getScoreFullHouse(int[] dieValues){
        return ScoringLogic.hasFullHouse(dieValues) ? 
                ScoringLogic.getSumOfDiceValues(dieValues) + 15 : 0;
    }
    
    public static int getScoreFullHouseSameColor(int[] dieValues){
        return (ScoringLogic.hasSameColor(dieValues) && 
                ScoringLogic.hasFullHouse(dieValues)) ? 
                    ScoringLogic.getSumOfDiceValues(dieValues) + 20 : 0;
    }
    
    public static int getScoreFourOfAKind(int[] dieValues){
        return ScoringLogic.hasNOfAKind(dieValues, 4) ? 
                ScoringLogic.getSumOfDiceValues(dieValues) + 25 : 0;
    }
    
    public static int getScoreYarborough(int[] dieValues){
        return ScoringLogic.getSumOfDiceValues(dieValues);
    }
    
    public static int getScoreKismet(int[] dieValues){
        boolean allSame = true;
        for (int i=1; i<dieValues.length; i++){
            if (dieValues[0] != dieValues[i]){
                allSame = false;
                break;
            }
        }
        return allSame ? ScoringLogic.getSumOfDiceValues(dieValues) + 50 : 0;
    }
    
    // @TODO remove - added for testing
    public static void main(String[] args) {
        System.out.println(getScoreTwoPairSameColor(new int[]{3,4,3,4,3}));
    }
    
} // end of class
