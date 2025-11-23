package org.example;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Image implements Drawable {
    private final Position position;
    private final BufferedImage sprite;

    public Image(Position position, String path) throws IOException {
        this.position = position;
        this.sprite = ImageIO.read(getClass().getClassLoader().getResourceAsStream(path));
    }

    public Image(Position position, BufferedImage sprite) {
        this.position = position;
        this.sprite = sprite;
    }

    public Image resizeImage(int new_width, int new_height) throws IOException {
        BufferedImage resized_img = new BufferedImage(new_width, new_height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resized_img.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);

        g2.drawImage(this.sprite, 0, 0, new_width, new_height, null);
        g2.dispose();

        return new Image(this.position, resized_img);
    }

    @Override
    public void draw(TextGraphics graphics) {
        for (int x = 0; x < sprite.getWidth(); x++) {
            for (int y = 0; y < sprite.getHeight(); y++) {
                int a = sprite.getRGB(x, y);
                int alpha = (a >> 24) & 0xff;
                int red = (a >> 16) & 255;
                int green = (a >> 8) & 255;
                int blue = a & 255;

                if (alpha != 0) {
                    TextCharacter c = new TextCharacter(' ', new TextColor.RGB(red, green, blue), new TextColor.RGB(red, green, blue));
                    graphics.setCharacter(position.getX() + x, position.getY() + y, c);
                }
            }
        }
    }
}