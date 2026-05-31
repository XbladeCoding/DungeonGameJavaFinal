import java.util.ArrayList;

public class PlayerTester {
    public static void main(String[] args) {
        ArrayList<Item> inventory = new ArrayList<>();
        Item healItem = new Item("Small Heal", 0, 15, 0);
        Item sword = new Item("Sword", 10, 0, 0);
        inventory.add(healItem);
        inventory.add(sword);

        Player player = new Player(100, 10, 0, 0, inventory);

        player.move("north");
        if (player.getPosx() == 0 && player.getPosy() == 1) {
            System.out.println("PASS: player moves correctly");
        } else {
            System.out.println("FAIL: player movement is incorrect");
        }

        player.equip(sword);
        if (player.getDmg() == 20) {
            System.out.println("PASS: equip updates player damage");
        } else {
            System.out.println("FAIL: equip did not update player damage");
        }

        player.takeDmg(20);
        player.heal(healItem);
        if (player.getHp() == 95) {
            System.out.println("PASS: takeDmg and heal update player hp");
        } else {
            System.out.println("FAIL: player hp was not updated correctly");
        }

        player.addPoints(50);
        if (player.getPoints() == 50) {
            System.out.println("PASS: addPoints updates player points");
        } else {
            System.out.println("FAIL: addPoints did not update points");
        }
    }
}