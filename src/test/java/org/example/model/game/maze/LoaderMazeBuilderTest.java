package org.example.model.game.maze;

import org.example.model.game.character.Knight;
import org.junit.jupiter.api.Test;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class LoaderMazeBuilderTest {

    @Test
    void testConstructorLevel1InitializesKnight() throws IOException {
        LoaderMazeBuilder builder = new LoaderMazeBuilder(1);

        assertNotNull(builder.getKnight(), "O Knight não deve ser nulo");

        assertEquals(800, builder.getKnight().getPosition().getX());
        assertEquals(100, builder.getKnight().getPosition().getY());

    }

    @Test
    void testGetKnight() throws IOException {
        LoaderMazeBuilder builder = new LoaderMazeBuilder(1);
        Knight knight = builder.getKnight();

        assertNotNull(knight);
        assertTrue(knight instanceof Knight);
    }

    @Test
    void testCreateKnightPositions() throws IOException {
        LoaderMazeBuilder builder = new LoaderMazeBuilder(1);
        Knight knight = builder.getKnight(); // O createKnight é chamado aqui dentro

        assertAll("Verificar Posição Inicial do Cavaleiro",
                () -> assertEquals(800, knight.getPosition().getX()),
                () -> assertEquals(100, knight.getPosition().getY())
        );
    }
}
