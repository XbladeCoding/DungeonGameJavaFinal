public class Item {
    private final String itemName;
    private final int itemDmg;
    private final int itemHP;
    private final int itemDef;

    public Item(String name, int dmg, int hp, int def) {
        this.itemName = name;
        this.itemDmg = dmg;
        this.itemHP = hp;
        this.itemDef = def;
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

    public int getDef() {
        return itemDef;
    }
}
