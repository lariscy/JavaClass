package homework.proj14;

import java.util.Arrays;

/**
 * @author Steven Lariscy
 * @projectNumber PL004T
 * @date 5.3.2017
 * @dueDate 5.4.2017
 * @description Kismet
 */
public class ScoringLogic {
    
    private static int getScoreForN(int[] dieValues, int num){
        int retVal = 0;
        for (int val : dieValues){
            if (val == num){
                retVal += num;
            } // end if
        } // end for
        return retVal;
    } // end getScoreForN
    
    private static int getSumOfDiceValues(int[] dieValues){
        int retVal = 0;
        for (int val : dieValues){
            retVal += val;
        } // end for
        return retVal;
    } // end getSumOfDiceValues
    
    private static boolean hasNOfAKind(int[] dieValues, int count){
        boolean wasFound = false;
        for (int number : new int[]{1,2,3,4,5}){
            if (ScoringLogic.hasNOrGreaterOfNumber(dieValues, count, number)){
                wasFound = true;
                break;
            } // end if
        } // end for
        return wasFound;
    } // end hasNOfAKind
    
    private static boolean hasNOrGreaterOfNumber(int[] dieValues, int count, int number){
        int[] numOfEachNumber = {0, 0, 0, 0, 0, 0};
        for (int val : dieValues){
            numOfEachNumber[val-1]++;
        } // end for
        return numOfEachNumber[number-1] >= count;
    } // end hasNOrGreaterOfNumber
    
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
                    } else { // end if
                        allDiceBlack = true;
                    } // end else
                } // end for
                break;
            case 2:
            case 5:
                for (int val : dieValues){
                    if (val != 2 && val != 5){
                        allDiceBlack = false;
                        break;
                    } else { // end if
                        allDiceBlack = true;
                    } // end else
                } // end for
                break;
            case 3:
            case 4:
                for (int val : dieValues){
                    if (val != 3 && val != 4){
                        allDiceBlack = false;
                        break;
                    } else { // end if
                        allDiceBlack = true;
                    } // end else
                } // end for
                break;
            default:
                System.err.println("check default switch case in ScoringLogic.hasFlush()");
                break;
        } // end switch
        return allDiceBlack || allDiceRed || allDiceGreen;
    } // end hasSameColor
    
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
    } // end hasFullHouse
    
    public static int getScoreForAces(int[] dieValues){
        return ScoringLogic.getScoreForN(dieValues, 1);
    } // end getScoreForAces
    
    public static int getScoreForDueces(int[] dieValues){
        return ScoringLogic.getScoreForN(dieValues, 2);
    } // end getScoreForDueces
    
    public static int getScoreForTreys(int[] dieValues){
        return ScoringLogic.getScoreForN(dieValues, 3);
    } // end getScoreForTreys
    
    public static int getScoreForFours(int[] dieValues){
        return ScoringLogic.getScoreForN(dieValues, 4);
    } // end getScoreForFours
    
    public static int getScoreForFives(int[] dieValues){
        return ScoringLogic.getScoreForN(dieValues, 5);
    } // end getScoreForFives
    
    public static int getScoreForSixes(int[] dieValues){
        return ScoringLogic.getScoreForN(dieValues, 6);
    } // end getScoreForSixes
    
    public static int getBasicScoreBonus(int totalOfSingles){
        int totalBonus = 0;
        if (totalOfSingles >= 63 && totalOfSingles <=70){
            totalBonus = 35;
        } else if (totalOfSingles >= 71 && totalOfSingles <= 77){ // end if
            totalBonus = 55;
        } else if (totalOfSingles >= 78){ // end else if
            totalBonus = 75;
        } // end else if
        return totalBonus;
    } // end getBasicScoreBonus
    
    public static int getScoreTwoPairSameColor(int[] dieValues){
        boolean isValid = false;
        Arrays.sort(dieValues);
        if (dieValues[0] == dieValues[1] && dieValues[2] == dieValues[3]){
            isValid = ScoringLogic.hasSameColor(new int[]{
                dieValues[0], dieValues[1], dieValues[2], dieValues[3]
            });
        } // end if
        if (dieValues[0] == dieValues[1] && dieValues[3] == dieValues[4]){
            isValid = ScoringLogic.hasSameColor(new int[]{
                dieValues[0], dieValues[1], dieValues[3], dieValues[4]
            });
        } // end if
        if (dieValues[1] == dieValues[2] && dieValues[3] == dieValues[4]){
            isValid = ScoringLogic.hasSameColor(new int[]{
                dieValues[1], dieValues[2], dieValues[3], dieValues[4]
            });
        } // end if
        return isValid ? ScoringLogic.getSumOfDiceValues(dieValues) : 0;
    } // end getScoreTwoPairSameColor
    
    public static int getScoreThreeOfAKind(int[] dieValues){
        return ScoringLogic.hasNOfAKind(dieValues, 3) ? 
                ScoringLogic.getSumOfDiceValues(dieValues) : 0;
    } // end getScoreThreeOfAKind
    
    public static int getScoreStraight(int[] dieValues){
        int inLine = 0;
        Arrays.sort(dieValues);
        for (int i=0; i<dieValues.length - 1; i++){
            if (dieValues[i] == (dieValues[i+1] - 1)){
                inLine++;
            } // end if
        } // end for
        return (inLine == 4) ? 30 : 0;
    } // end getScoreStraight
    
    public static int getScoreFlush(int[] dieValues){
        return ScoringLogic.hasSameColor(dieValues) ? 35 : 0;
    } // end getScoreFlush
    
    public static int getScoreFullHouse(int[] dieValues){
        return ScoringLogic.hasFullHouse(dieValues) ? 
                ScoringLogic.getSumOfDiceValues(dieValues) + 15 : 0;
    } // end getScoreFullHouse
    
    public static int getScoreFullHouseSameColor(int[] dieValues){
        return (ScoringLogic.hasSameColor(dieValues) && 
                ScoringLogic.hasFullHouse(dieValues)) ? 
                    ScoringLogic.getSumOfDiceValues(dieValues) + 20 : 0;
    } // end getScoreFullHouseSameColor
    
    public static int getScoreFourOfAKind(int[] dieValues){
        return ScoringLogic.hasNOfAKind(dieValues, 4) ? 
                ScoringLogic.getSumOfDiceValues(dieValues) + 25 : 0;
    } // end getScoreFourOfAKind
    
    public static int getScoreYarborough(int[] dieValues){
        return ScoringLogic.getSumOfDiceValues(dieValues);
    } // end getScoreYarborough
    
    public static int getScoreKismet(int[] dieValues){
        boolean allSame = true;
        for (int i=1; i<dieValues.length; i++){
            if (dieValues[0] != dieValues[i]){
                allSame = false;
                break;
            } // end if
        } // end for
        return allSame ? ScoringLogic.getSumOfDiceValues(dieValues) + 50 : 0;
    } // end getScoreKismet
    
} // end class
