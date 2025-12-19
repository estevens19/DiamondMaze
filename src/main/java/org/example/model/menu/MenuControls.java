package org.example.model.menu;

import org.example.model.Position;
import org.example.viewer.Image;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

    public class MenuControls extends Menu {

        private final Image backSelected;
        private final Image text;

        private final int buttonWidth = 130;
        private final int buttonHeight = 105;

        public MenuControls() throws IOException, URISyntaxException, FontFormatException {
            this.screenWidth = 640;
            this.screenHeight = 360;

            backSelected = new Image(new Position(0, 0), "images_menu/Back_shine.png").resizeImage(buttonWidth, buttonHeight);
            text = textImage();

            refreshButtons();
            updateSize(screenWidth, screenHeight);
        }

        private void refreshButtons() throws IOException, URISyntaxException, FontFormatException {

            Position backPos = (backSelected != null) ? backSelected.getPosition() : new Position(0, 0);

            backSelected.setPosition(backPos);
        }

        @Override
        public void updateSize(int width, int height) throws IOException {
            setBackground(getBackground().resizeImage(width, height));

            int backX = width - buttonWidth - 20;
            int backY = 0;

            backSelected.setPosition(new Position(backX - 20, backY + 20));
        }

        public Image getBack() {
            return backSelected;
        }
        public Image getText(){return text;}

        public Image textImage() throws IOException, URISyntaxException, FontFormatException {
            String t = """
                    Arrows / WASD - Move Knight
                    
                    Space - Select
                    
                    Esc - Exit
                    
                    Q - Back if in game or Exit if in menus
                    
                    
                    
                    Diamonds - Increase Score and can
                    
                               reveal key position
                    
                    Potions - Give a random effect
                    
                    Guards - Kill the knight
                    
                    Key - Open the door
                    
                    Door - To pass the level""";
            return Image.createTextImage(new Position(150,60), t,10);
        }

    }