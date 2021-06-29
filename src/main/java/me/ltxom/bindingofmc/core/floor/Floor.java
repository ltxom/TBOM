package me.ltxom.bindingofmc.core.floor;

import me.ltxom.bindingofmc.core.room.RoomType;

import java.util.HashMap;
import java.util.Map;

public abstract class Floor {
    private String floorName;
    private Chapter chapter;
    private static Map<Chapter, Float> chapterIntegerMap = new HashMap<>();


    static {
        chapterIntegerMap.put(Chapter.ONE, 1f);
        chapterIntegerMap.put(Chapter.ONE_HALF, 1.5f);
        chapterIntegerMap.put(Chapter.TWO, 2f);
        chapterIntegerMap.put(Chapter.THREE, 3f);
        chapterIntegerMap.put(Chapter.THREE_HALF, 3.5f);
        chapterIntegerMap.put(Chapter.FOUR, 4f);
        chapterIntegerMap.put(Chapter.FOUR_HALF, 4.5f);
        chapterIntegerMap.put(Chapter.FIVE, 5f);
        chapterIntegerMap.put(Chapter.SIX, 6f);
        chapterIntegerMap.put(Chapter.ENDGAME, 7f);

    }

    public Floor(String floorName, Chapter chapter) {
        this.floorName = floorName;
        this.chapter = chapter;
    }

    public abstract FloorSchema generateFloorSchema();

    public static int getNumberOfRooms(Chapter chapter) {
        return Math.min(20, (int) (3.33 * chapterIntegerMap.get(chapter) + (Math.random() > 0.5 ? 5 : 6)));
    }

    public static FloorSchema generateBaseSchema(int numOfRooms, int numOfBranches) {
        FloorSchema floorSchema = new FloorSchema();
        int curNumOfRooms = numOfRooms;
        for (int i = 0; i < numOfBranches; i++) {
            for (int j = 0; j < numOfRooms / numOfBranches; j++) {
                floorSchema.generate(RoomType.NORMAL, false);
                curNumOfRooms--;
                if (curNumOfRooms == 0) {
                    break;
                }
            }
            floorSchema.generate(RoomType.NORMAL, true);
            curNumOfRooms--;
            if (curNumOfRooms == 0) {
                break;
            }
        }

        return floorSchema;
    }

    public String getFloorName() {
        return floorName;
    }

    public Chapter getChapter() {
        return chapter;
    }
}
