public class DungeonTester {
    public static void main(String[] args) {
        int diff = 3;
        Room[][] grid = new Room[diff][diff];
        Dungeon dungeon = new Dungeon(diff, grid);

        dungeon.createDungeon(diff);

        int bossCount = 0;
        boolean allRoomsFilled = true;

        for (int row = 0; row < diff; row++) {
            for (int col = 0; col < diff; col++) {
                if (grid[row][col] == null) {
                    allRoomsFilled = false;
                } else if (grid[row][col].getRoomType().equals("boss")) {
                    bossCount++;
                }
            }
        }

        if (dungeon.getDiff() == diff) {
            System.out.println("PASS: difficulty stored correctly");
        } else {
            System.out.println("FAIL: difficulty not stored correctly");
        }

        if (dungeon.getDungeon() == grid) {
            System.out.println("PASS: dungeon grid stored correctly");
        } else {
            System.out.println("FAIL: dungeon grid not stored correctly");
        }

        if (allRoomsFilled) {
            System.out.println("PASS: all rooms were created");
        } else {
            System.out.println("FAIL: some rooms are still null");
        }

        if (bossCount == 1) {
            System.out.println("PASS: exactly one boss room exists");
        } else {
            System.out.println("FAIL: boss room count = " + bossCount);
        }
    }
}