package com.codenjoy.dojo.snake.client;

import com.codenjoy.dojo.services.RandomDice;
import com.codenjoy.dojo.snake.model.Elements;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class YourSolverTest {//круто, тестами мы можем сразу выставить нужную ситуацию на борде?
    @Test
    public void testSameDirection() {
        assertB("☼☼☼☼☼☼" +
                "☼    ☼" +
                "☼ ▼  ☼" +
                "☼    ☼" +
                "☼ ☺  ☼" +
                "☼☼☼☼☼☼", "DOWN");

        assertB("☼☼☼☼☼☼" +
                "☼    ☼" +
                "☼    ☼" +
                "☼► ☺ ☼" +
                "☼    ☼" +
                "☼☼☼☼☼☼", "RIGHT");

        assertB("☼☼☼☼☼☼" +
                "☼    ☼" +
                "☼ ☺  ☼" +
                "☼    ☼" +
                "☼ ▲  ☼" +
                "☼☼☼☼☼☼", "UP");

        assertB("☼☼☼☼☼☼" +
                "☼    ☼" +
                "☼☺  ◄☼" +
                "☼    ☼" +
                "☼    ☼" +
                "☼☼☼☼☼☼", "LEFT");

    }

    @Test
    public void testEatMe() {
        assertB("☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼" +
                "☼             ☼" +
                "☼             ☼" +
                "☼             ☼" +
                "☼╔═════════►  ☼" +
                "☼╙            ☼" +
                "☼             ☼" +
                "☼             ☼" +
                "☼             ☼" +
                "☼             ☼" +
                "☼             ☼" +
                "☼        ☺    ☼" +
                "☼          ☻  ☼" +
                "☼             ☼" +
                "☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼", "DOWN");
    }

    @Test
    public void testNotSameDirection() {
        assertB("☼☼☼☼☼☼" +
                "☼    ☼" +
                "☼ ►  ☼" +
                "☼    ☼" +
                "☼ ☺  ☼" +
                "☼☼☼☼☼☼", "DOWN");

        assertB("☼☼☼☼☼☼" +
                "☼    ☼" +
                "☼    ☼" +
                "☼◄ ☺ ☼" +
                "☼    ☼" +
                "☼☼☼☼☼☼", "RIGHT");

        assertB("☼☼☼☼☼☼" +
                "☼    ☼" +
                "☼ ☺  ☼" +
                "☼    ☼" +
                "☼ ►  ☼" +
                "☼☼☼☼☼☼", "UP");

        assertB("☼☼☼☼☼☼" +
                "☼    ☼" +
                "☼☺  ►☼" +
                "☼    ☼" +
                "☼    ☼" +
                "☼☼☼☼☼☼", "LEFT");

    }
    @Test
    public void testEat_GoodApple_Die(){

//        assertB("☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼" +
//                "☼          ☻☺ ☼" +
//                "☼     ╙═══►☼" +
//                "☼             ☼" +
//                "☼             ☼" +
//                "☼             ☼" +
//                "☼             ☼" +
//                "☼             ☼" +
//                "☼             ☼" +
//                "☼             ☼" +
//                "☼             ☼" +
//                "☼             ☼" +
//                "☼             ☼" +
//                "☼             ☼" +
//                "☼☼☼☼☼☼☼☼☼☼☼", "DOWN");
//        assertB("☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼" +
//                "☼          ☻☺ ☼" +
//                "☼     ╙═══►☼" +
//                "☼             ☼" +
//                "☼             ☼" +
//                "☼             ☼" +
//                "☼             ☼" +
//                "☼             ☼" +
//                "☼             ☼" +
//                "☼             ☼" +
//                "☼             ☼" +
//                "☼             ☼" +
//                "☼             ☼" +
//                "☼             ☼" +
//                "☼☼☼☼☼☼☼☼☼☼☼", "UP");
//        assertB("☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼" +
//                "☼          ☻☺ ☼" +
//                "☼     ╙═══►☼" +
//                "☼             ☼" +
//                "☼             ☼" +
//                "☼             ☼" +
//                "☼             ☼" +
//                "☼             ☼" +
//                "☼             ☼" +
//                "☼             ☼" +
//                "☼             ☼" +
//                "☼             ☼" +
//                "☼             ☼" +
//                "☼             ☼" +
//                "☼☼☼☼☼☼☼☼☼☼☼", "DOWN");
//        assertB("☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼" +
//                "☼          ☻☺ ☼" +
//                "☼     ╙═══►☼" +
//                "☼             ☼" +
//                "☼             ☼" +
//                "☼             ☼" +
//                "☼             ☼" +
//                "☼             ☼" +
//                "☼             ☼" +
//                "☼             ☼" +
//                "☼             ☼" +
//                "☼             ☼" +
//                "☼             ☼" +
//                "☼             ☼" +
//                "☼☼☼☼☼☼☼☼☼☼☼", "DOWN");

    }

    @Test
    public void testEat_BadApple(){
        assertB("☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼" +
                "☼         ☻◄╗☼" +
                "☼     ╙═══╝☼" +
                "☼             ☼" +
                "☼             ☼" +
                "☼             ☼" +
                "☼             ☼" +
                "☼          ☺  ☼" +
                "☼             ☼" +
                "☼             ☼" +
                "☼             ☼" +
                "☼             ☼" +
                "☼             ☼" +
                "☼             ☼" +
                "☼☼☼☼☼☼☼☼☼☼☼", "LEFT");

        assertB("☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼" +
                "☼   ╔►☻     ☼" +
                "☼   ╚═══╕ ☼" +
                "☼             ☼" +
                "☼             ☼" +
                "☼             ☼" +
                "☼             ☼" +
                "☼          ☺  ☼" +
                "☼             ☼" +
                "☼             ☼" +
                "☼             ☼" +
                "☼             ☼" +
                "☼             ☼" +
                "☼             ☼" +
                "☼☼☼☼☼☼☼☼☼☼☼", "RIGHT");

        assertB("☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼" +
                "☼   ╙════►☼" +
                "☼            ☻☼" +
                "☼             ☼" +
                "☼             ☼" +
                "☼             ☼" +
                "☼             ☼" +
                "☼          ☺  ☼" +
                "☼             ☼" +
                "☼             ☼" +
                "☼             ☼" +
                "☼             ☼" +
                "☼             ☼" +
                "☼             ☼" +
                "☼☼☼☼☼☼☼☼☼☼☼", "DOWN");

        assertB("☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼" +
                "☼              ☼" +
                "☼              ☼" +
                "☼     ╓       ☼" +
                "☼     ║☻      ☼" +
                "☼     ║◄══╗ ☼" +
                "☼     ╚═══╝ ☼" +
                "☼          ☺  ☼" +
                "☼             ☼" +
                "☼             ☼" +
                "☼             ☼" +
                "☼             ☼" +
                "☼             ☼" +
                "☼             ☼" +
                "☼☼☼☼☼☼☼☼☼☼☼", "UP");

    }

    private void assertB(String boardString, String expected) {
        // given
        YourSolver solver = new YourSolver(new RandomDice());

        // when
        String direction = solver.get((Board)new Board().forString(
                boardString));

        // then
        assertEquals(expected, direction);
    }
}
