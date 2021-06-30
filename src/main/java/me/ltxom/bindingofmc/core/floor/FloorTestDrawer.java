package me.ltxom.bindingofmc.core.floor;

import me.ltxom.bindingofmc.core.room.RoomType;

import javax.swing.*;
import java.awt.*;

public class FloorTestDrawer extends JFrame {

    private static final int sx = 50;
    private static final int sy = 50;
    private static final int w = 40;
    private Graphics jg;
    private Color rectColor = new Color(0xf5f5f5);

    public FloorTestDrawer(FloorSchema floorSchema) {
        Container p = getContentPane();
        setBounds(10, 10, 1300, 1000);
        setVisible(true);
        p.setBackground(rectColor);
        setLayout(null);
        setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try {
            Thread.sleep(500);
        } catch (Exception e) {
            e.printStackTrace();
        }

        jg = this.getGraphics();
        paintComponents(jg, floorSchema);
    }

    private void drawString(Graphics g, int x, int y, RoomType roomType) {
        g.setColor(Color.RED);
        g.setFont(new Font("Arial", 0, 25));
        String str = " ";
        if (roomType != null) {
            switch (roomType) {
                case NORMAL:
                    str = "N";
                    break;
                case BEGINNING:
                    str = "Be";
                    break;
                case BOSS:
                    str = "Bo";
                    break;
                case TREASURE:
                    str = "T";
                    break;
                case SHOP:
                    str = "S";
                    break;
            }
        }
        g.drawString(str, sx + (y * w) + 5, sy + ((x + 1) * w) - 5);

    }

    public void paintComponents(Graphics g, FloorSchema floorSchema) {
        try {
            g.setColor(Color.RED);
            for (int i = 1; i < 30; i++) {

                for (int j = 0; j < 30; j++) {
                    drawString(g, j, i, floorSchema.getXYType(j - 10, i - 10));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
