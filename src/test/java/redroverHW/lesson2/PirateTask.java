package redroverHW.lesson2;

public class PirateTask {
    public static void main(String[] args) {

        int fullPreyCoins = 1243;
        int piratesNumber = 20;
        int shipOwnersNumber = 1;
        int captainsNumber = 1;

        int shipOwnerCoins = fullPreyCoins / 2;
        int captainCoins = shipOwnerCoins / 2;
        int eachMemberOfTeamCoins = (fullPreyCoins - shipOwnerCoins - captainCoins) / (piratesNumber + captainsNumber);

        // reminder calculation
        int sumOfAllDivided = shipOwnerCoins + captainCoins + (eachMemberOfTeamCoins * (piratesNumber + captainsNumber));
        int remainder = fullPreyCoins - sumOfAllDivided;

        System.out.println(shipOwnerCoins + remainder +  " piasters for ship Owner");
        System.out.println(captainCoins + eachMemberOfTeamCoins + " piasters for captain");
        System.out.println(eachMemberOfTeamCoins + " piasters for each pirate");
        System.out.println(sumOfAllDivided + " remainder after divided");
    }
}
