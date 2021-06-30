package me.ltxom.bindingofmc.core.room;

public enum RoomType {
    NORMAL(1), BEGINNING(2), BOSS(3), TREASURE(4), HIDDEN(5), SUPER_HIDDEN(6), SHOP(7), SACRIFICE(8);
    private int id;

    RoomType(int id) {
        this.id = id;
    }
}
