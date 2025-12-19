package org.example.viewer;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.example.gui.LanternaGUI;
import org.example.model.Position;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URISyntaxException;


public class Image {
    private Position position;
    private final BufferedImage sprite;
    private TextCharacter[][] cachedPixelData;
    private Font font;

    public Image(Position position, String path) throws IOException, URISyntaxException, FontFormatException {
        this.position = position;
        this.sprite = ImageIO.read(getClass().getClassLoader().getResourceAsStream(path));
        precomputeImage();
        this.font = LanternaGUI.getFont();
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

                    cachedPixelData[x][y] = TextCharacter.fromCharacter(' ', new TextColor.RGB(red, green, blue), new TextColor.RGB(red, green, blue))[0];
                }
            }
        }
    }

    public BufferedImage getSprite() {
        return sprite;
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

    public static Image createTextImage(Position position, String text, int fontSize) throws IOException, URISyntaxException, FontFormatException {
        Font baseFont = LanternaGUI.getFont();
        Font font = baseFont.deriveFont(Font.PLAIN, (float)fontSize);

        String[] lines = text.split("\n");

        BufferedImage imgTemp = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2dTemp = imgTemp.createGraphics();
        g2dTemp.setFont(font);
        FontMetrics fm = g2dTemp.getFontMetrics();

        int maxWidth = 0;
        for (String line : lines) {
            int w = fm.stringWidth(line);
            if (w > maxWidth) maxWidth = w;
        }

        int lineHeight = fm.getHeight();
        int totalHeight = lineHeight * lines.length;
        g2dTemp.dispose();

        if (maxWidth == 0) maxWidth = 1;
        if (totalHeight == 0) totalHeight = 1;
        BufferedImage img = new BufferedImage(maxWidth + 5, totalHeight + 5, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = img.createGraphics();

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
        g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_OFF);

        g2d.setFont(font);
        g2d.setColor(Color.WHITE);

        int x = 0;
        int y = fm.getAscent();

        for (String line : lines) {
            g2d.drawString(line, x, y);
            y += lineHeight;
        }

        g2d.dispose();

        return new Image(position, img);
    }
}