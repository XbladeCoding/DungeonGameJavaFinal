import java.util.ArrayList;

public class Player {
    private int posx;
    private int posy;
    private int hp;
    private int dmg;
    private int def;
    private int points;
    ArrayList<Item> inventory = new ArrayList<>();

    public void pickUpItem(Item item) {
        inventory.add(item);
    }

    public void equip(Item Item) {
        if (inventory.contains(Item)) {
            dmg += Item.getDmg();
            def += Item.getDef();
            inventory.remove(Item);
        }
    }

    public void takeDmg(int dmgTaken) {
        this.dmg -= dmgTaken;
    }

    public void heal(Item healingItem) {
        if (healingItem.getHP() > 0 && inventory.contains(healingItem)) {
            hp += healingItem.getHP();
            inventory.remove(healingItem);
        }
    }

    public int getPoints() {
        return points;
    }

    public void addPoints(int pts) {
        points += pts;
    }

    public int getDmg() {
        return this.dmg;
    }

    public int getHp() {
        return this.hp;
    }

    public int getDef() {
        return def;
    }

    public int getPosx() {
        return posx;
    }

    public int getPosy() {
        return posy;
    }

    public void setPosx(int posx) {
        this.posx = posx;
    }

    public void setPosy(int posy) {
        this.posy = posy;
    }

    public ArrayList<Item> getInventory() {
        return this.inventory;
    }

    public void move(String direction) {
        switch (direction) {
            case "north":
                posy++;
            case "south":
                posy--;
            case "east":
                posx++;
            case "west":
                posx--;
        }
    }
}