import java.util.ArrayList;

public class RoomTester {
    public static void main(String[] args) {
        Room room = new Room(1, 2, "loot");

        if (room.getPosx() == 1 && room.getPosy() == 2 && room.getRoomType().equals("loot")) {
            System.out.println("PASS: room values stored correctly");
        } else {
            System.out.println("FAIL: room values not stored correctly");
        }

        room.setPosx(3);
        room.setPosy(4);
        room.setRoomType("battle");
        if (room.getPosx() == 3 && room.getPosy() == 4 && room.getRoomType().equals("battle")) {
            System.out.println("PASS: room setters work correctly");
        } else {
            System.out.println("FAIL: room setters do not work correctly");
        }

        Room lootRoom = new Room(0, 0, "loot");
        ArrayList<Item> loot = lootRoom.rollLoot(lootRoom);
        if (loot.size() >= 4) {
            System.out.println("PASS: loot room creates loot");
        } else {
            System.out.println("FAIL: loot room did not create enough loot");
        }

        Room battleRoom = new Room(0, 0, "battle");
        ArrayList<Monster> monsters = battleRoom.rollEnemies(battleRoom);
        if (monsters.size() >= 1 && monsters.size() <= 3) {
            System.out.println("PASS: battle room creates monsters");
        } else {
            System.out.println("FAIL: battle room monster count is incorrect");
        }
    }
}