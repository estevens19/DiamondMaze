package org.example.controller.menu;

import com.googlecode.lanterna.input.KeyStroke;
import org.example.controller.Controller;
import org.example.model.menu.MenuLevels;

import java.io.IOException;

public class MenuLevelsController extends Controller<MenuLevels> {

    @Override
    public void getKey(KeyStroke key) throws IOException {
        switch (key.getKeyType()) {
            case ArrowUp:
                if (currButton == 1) {
                    currButton = 0;
                    refreshButtons();
                }
                break;
            case ArrowDown:
                if (currButton == 0) {
                    currButton = 1;
                    refreshButtons();
                }
                break;
            case ArrowLeft:
                break;
            case ArrowRight:
                break;
            case Character:
                if (currButton == 1 && key.getCharacter() == ' ')
                    break;

                break;


        }
    }
}
