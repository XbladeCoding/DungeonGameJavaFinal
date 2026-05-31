public class ItemTester {
    public static void main(String[] args) {
        Item item = new Item("Shield", 5, 10, 15);

        if (item.getName().equals("Shield")) {
            System.out.println("PASS: item name stored correctly");
        } else {
            System.out.println("FAIL: item name not stored correctly");
        }

        if (item.getDmg() == 5 && item.getHP() == 10 && item.getDef() == 15) {
            System.out.println("PASS: item stats stored correctly");
        } else {
            System.out.println("FAIL: item stats not stored correctly");
        }
    }
}