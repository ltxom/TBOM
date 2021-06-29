package me.ltxom.bindingofmc.core.floor;

public class BasementFloor extends Floor {
    public BasementFloor() {
        super("The Basement", Chapter.ONE);
    }

    @Override
    public FloorSchema generateFloorSchema() {
        int numOfRooms = getNumberOfRooms(getChapter());
        FloorSchema floorSchema = generateBaseSchema(numOfRooms, 5);
        return floorSchema;
    }

    public static void main(String[] args) {
        BasementFloor basementFloor = new BasementFloor();
        FloorSchema floorSchema = basementFloor.generateFloorSchema();
        System.out.println(floorSchema.toString());
    }
}
