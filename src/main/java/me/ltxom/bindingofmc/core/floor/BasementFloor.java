package me.ltxom.bindingofmc.core.floor;

import me.ltxom.bindingofmc.core.room.RoomType;

import java.util.HashMap;

public class BasementFloor extends Floor {
    public BasementFloor() {
        super("The Basement", Chapter.ONE, new HashMap<RoomType, Integer>() {{
            put(RoomType.TREASURE, 1);
            put(RoomType.SHOP, 1);
        }});
    }

    @Override
    public FloorSchema generateFloorSchema() {
        int numOfRooms = getNumberOfRooms(getChapter());
        numOfRooms -= getNumOfSpecialRooms();
        FloorSchema floorSchema = generateBaseSchema(numOfRooms + 15, 8);
        return floorSchema;
    }

    public static void main(String[] args) {
        BasementFloor basementFloor = new BasementFloor();
        FloorSchema floorSchema = basementFloor.generateFloorSchema();
        System.out.println(floorSchema.toString());
        new FloorTestDrawer(floorSchema);
    }
}
