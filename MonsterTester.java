public class MonsterTester {
    public static void main(String[] args) {
        Monster monster = new Monster(100, 15, "Tank", 20);

        if (monster.getHp() == 100 && monster.getDmg() == 15 && monster.getType().equals("Tank") && monster.getPoints() == 20) {
            System.out.println("PASS: monster values stored correctly");
        } else {
            System.out.println("FAIL: monster values not stored correctly");
        }

        monster.takeDamage(30);

        if (monster.getHp() == 70) {
            System.out.println("PASS: takeDamage updates monster hp");
        } else {
            System.out.println("FAIL: takeDamage did not update monster hp correctly");
        }
    }
}