package me.ltxom.bindingofmc.core.floor;

import me.ltxom.bindingofmc.core.room.RoomType;
import net.minecraft.util.Direction;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class FloorSchema {
    private int x;
    private int y;
    private Map<Integer, Map<Integer, RoomType>> xToyToRoomType;
    private Direction direction;

    public FloorSchema() {
        xToyToRoomType = new HashMap<>();
        direction = Direction.SOUTH;
        x = 0;
        y = 0;
        setXYType(x, y, RoomType.BEGINNING);
    }

    private int[] getNewCoordinate(Direction direction) {
        int[] result = new int[]{x, y};
        switch (direction) {
            case NORTH:
                result[1]++;
                break;
            case SOUTH:
                result[1]--;
                break;
            case WEST:
                result[0]--;
                break;
            case EAST:
                result[0]++;
                break;
        }
        return result;
    }

    public void generate(RoomType roomType, boolean newBranch) {
        while (true) {
            if (newBranch) {
                switch (direction) {
                    case NORTH:
                        direction = chooseRandomDirection(Direction.EAST, Direction.WEST);
                        break;
                    case SOUTH:
                        direction = chooseRandomDirection(Direction.EAST, Direction.WEST);
                        break;
                    case EAST:
                        direction = chooseRandomDirection(Direction.NORTH, Direction.SOUTH);
                        break;
                    case WEST:
                        direction = chooseRandomDirection(Direction.NORTH, Direction.SOUTH);
                        break;
                }
            }

            int[] newCoordinate = getNewCoordinate(direction);
            if (getXYType(newCoordinate[0], newCoordinate[1]) == null) {
                setXYType(newCoordinate[0], newCoordinate[1], roomType);

                this.x = newCoordinate[0];
                this.y = newCoordinate[1];
                return;
            } else {
                newBranch = true;
            }
        }
    }

    private static Direction chooseRandomDirection(Direction d1, Direction d2, Direction d3) {
        int ran = new Random().nextInt(3);
        return ran == 0 ? d1 : (ran == 1 ? d2 : d3);
    }

    private static Direction chooseRandomDirection(Direction d1, Direction d2) {
        int ran = new Random().nextInt(2);
        return ran == 0 ? d1 : d2;
    }

    public void setXYType(int x, int y, RoomType roomType) {
        if (!xToyToRoomType.containsKey(x)) {
            xToyToRoomType.put(x, new HashMap<>());
        }
        xToyToRoomType.get(x).put(y, roomType);
    }

    @Nullable
    public RoomType getXYType(int x, int y) {
        return xToyToRoomType.containsKey(x) ? (xToyToRoomType.get(x).getOrDefault(y, null)) : null;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer x : xToyToRoomType.keySet()) {
            for (Integer y : xToyToRoomType.get(x).keySet()) {
                stringBuilder.append("x: ").append(x).append(" y: ").append(y).append(" type: ").append(xToyToRoomType.get(x).get(y)).append("\n");
            }
        }
        return stringBuilder.toString();
    }
}
