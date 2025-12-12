package org.example.viewer;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.example.model.Position;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Image {
    private Position position;
    private final BufferedImage sprite;
    private TextCharacter[][] cachedPixelData;

    public Image(Position position, String path) throws IOException {
        this.position = position;
        this.sprite = ImageIO.read(getClass().getClassLoader().getResourceAsStream(path));
        precomputeImage();
    }

    public Image(Position position, BufferedImage sprite) {
        this.position = position;
        this.sprite = sprite;
        precomputeImage();
    }

    private void precomputeImage() {
        int width = sprite.getWidth();
        int height = sprite.getHeight();
        cachedPixelData = new TextCharacter[width][height];

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int a = sprite.getRGB(x, y);
                int alpha = (a >> 24) & 0xff;
                if (alpha != 0) {
                    int red = (a >> 16) & 255;
                    int green = (a >> 8) & 255;
                    int blue = a & 255;

                    cachedPixelData[x][y] = new TextCharacter(' ', new TextColor.RGB(red, green, blue), new TextColor.RGB(red, green, blue));
                }
            }
        }
    }

    public Position getPosition() { return this.position; }
    public void setPosition(Position position) { this.position = position; }
    public int getWidth() { return sprite.getWidth(); }
    public int getHeight() { return sprite.getHeight(); }

    public Image resizeImage(int new_width, int new_height) throws IOException {
        BufferedImage resized_img = new BufferedImage(new_width, new_height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resized_img.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
        g2.drawImage(this.sprite, 0, 0, new_width, new_height, null);
        g2.dispose();
        return new Image(this.position, resized_img);
    }

    public void draw(TextGraphics graphics) {
        for (int x = 0; x < cachedPixelData.length; x++) {
            for (int y = 0; y < cachedPixelData[0].length; y++) {
                TextCharacter c = cachedPixelData[x][y];
                if (c != null) {
                    graphics.setCharacter(position.getX() + x, position.getY() + y, c);
                }
            }
        }
    }
}