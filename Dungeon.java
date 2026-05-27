import java.util.Random;

public class Dungeon {
    Random random = new Random();

    int diff;
    Room[][] dungeon = new Room[diff][diff];

    public Dungeon(int diff, Room[][] dungeon) {
        this.diff = diff;
        this.dungeon = dungeon;
    }

    public int getDiff() {
        return this.diff;
    }

    public Room[][] getDungeon() {
        return this.dungeon;
    }

    public void createDungeon(int diff) {
        int bossRoomNum = random.nextInt(0, diff*diff);
        int bry = bossRoomNum/diff;
        int brx = bossRoomNum%diff;

        Room bossRoom = new Room(brx, bry, "boss");

        for (int i = 0; i < diff; i++) {
            for (int j = 0; j < diff; j++) {
                int randRoom = random.nextInt(2);

                if (dungeon[i][j] != bossRoom) {
                    if (randRoom == 0) {
                        dungeon[i][j] = new Room(i, j, "loot");
                    } else {
                        dungeon[i][j] = new Room(i, j, "battle");
                    }
                }
            }
        }
    }
}