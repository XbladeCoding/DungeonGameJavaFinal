public class Item {
    private final String itemName;
    private final int itemDmg;
    private final int itemHP;

    public Item(String name, int dmg, int hp) {
        this.itemName = name;
        this.itemDmg = dmg;
        this.itemHP = hp;
    }

    public int getDmg() {
        return this.itemDmg;
    }

    public int getHP() {
        return this.itemHP;
    }

    public String getName() {
        return this.itemName;
    }
}
