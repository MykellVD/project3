package project3;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.*;

import static org.junit.Assert.*;

public class Tester {
    private MySingleWithTailLinkedList list;
    SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");

    @Test
    public void gamesInOrderOfDate() {
        GregorianCalendar g1, g2, g3, g4, g5, g6, g7, g8;
        g1 = new GregorianCalendar();
        g2 = new GregorianCalendar();
        g3 = new GregorianCalendar();
        g4 = new GregorianCalendar();
        g5 = new GregorianCalendar();
        g6 = new GregorianCalendar();
        g7 = new GregorianCalendar();
        g8 = new GregorianCalendar();

        try {
            Date d1 = df.parse("7/02/2020");
            g1.setTime(d1);
            Date d2 = df.parse("7/05/2020");
            g2.setTime(d2);
            Date d3 = df.parse("7/06/2020");
            g3.setTime(d3);
            Date d4 = df.parse("7/08/2020");
            g4.setTime(d4);
            Date d5 = df.parse("7/11/2020");
            g5.setTime(d5);
            Date d6 = df.parse("7/15/2020");
            g6.setTime(d6);
            Date d7 = df.parse("7/25/2020");
            g7.setTime(d7);
            Date d8 = df.parse("7/29/2020");
            g8.setTime(d8);
        } catch (ParseException e) {
            throw new RuntimeException("Error in testing, creation of list");
        }

        list = new MySingleWithTailLinkedList();

        Game game1 = new Game("GPerson1", g3, g1, null, "title1",
                new Console("GPerson1", g3, g1, null, ConsoleTypes.PlayStation4));
        Game game2 = new Game("GPerson1", g3, g2, null, "title2",
                new Console("GPerson1", g3, g2, null, ConsoleTypes.PlayStation4));
        Game game3 = new Game("GPerson1", g5, g3, null, "title2",
                new Console("GPerson1", g5, g3, null, ConsoleTypes.SegaGenesisMini));
        Game game4 = new Game("GPerson7", g4, g4, null, "title2", null);
        Game game5 = new Game("GPerson3", g3, g5, g1, "title2",
                new Console("GPerson3", g3, g5, g1, ConsoleTypes.XBoxOneS));
        Game game6 = new Game("GPerson6", g4, g6, null, "title1",
                new Console("GPerson6", g4, g6, null, ConsoleTypes.NintendoSwich));
        Game game7 = new Game("GPerson5", g4, g7, null, "title1",
                new Console("GPerson5", g4, g7, null, ConsoleTypes.NintendoSwich));

        list.add(game5);
        list.add(game1);
        list.add(game2);
        list.add(game4);
        list.add(game7);
        list.add(game3);
        list.add(game6);

        list.display();

        ArrayList<Game> games = new ArrayList<>();

        games.add(game1);
        games.add(game2);
        games.add(game3);
        games.add(game4);
        games.add(game5);
        games.add(game6);
        games.add(game7);

        assertEquals(games.get(0).toString(), list.get(0).toString());
        assertEquals(games.get(1).toString(), list.get(1).toString());
        assertEquals(games.get(2).toString(), list.get(2).toString());
        assertEquals(games.get(3).toString(), list.get(3).toString());
        assertEquals(games.get(4).toString(), list.get(4).toString());
        assertEquals(games.get(5).toString(), list.get(5).toString());
        assertEquals(games.get(6).toString(), list.get(6).toString());

    }

    @Test
    public void gamesInOrderOfName() {
        GregorianCalendar g1, g3;
        g1 = new GregorianCalendar();
        g3 = new GregorianCalendar();
        try {
            Date d1 = df.parse("7/05/2020");
            g1.setTime(d1);
            Date d3 = df.parse("7/06/2020");
            g3.setTime(d3);
        } catch (ParseException e) {
            throw new RuntimeException("Error in testing, creation of list");
        }

        list = new MySingleWithTailLinkedList();

        Game game1 = new Game("GPerson1", g3, g1, null, "title2",
                new Console("GPerson1", g3, g1, null, ConsoleTypes.PlayStation4));
        Game game2 = new Game("GPerson2", g3, g1, null, "title2",
                new Console("GPerson2", g3, g1, null, ConsoleTypes.PlayStation4));
        Game game3 = new Game("GPerson3", g3, g1, null, "title2",
                new Console("GPerson3", g3, g1, null, ConsoleTypes.SegaGenesisMini));
        Game game4 = new Game("GPerson3", g3, g1, g1, "title2",
                new Console("GPerson3", g3, g1, g1, ConsoleTypes.XBoxOneS));
        Game game5 = new Game("GPerson4", g3, g1, g1, "title2",
                new Console("GPerson4", g3, g1, g1, ConsoleTypes.XBoxOneS));


        list.add(game2);
        list.add(game4);
        list.add(game1);
        list.add(game3);
        list.add(game5);

        list.display();

        ArrayList<Game> games = new ArrayList<>();

        games.add(game1);
        games.add(game2);
        games.add(game4);
        games.add(game3);
        games.add(game5);

        assertEquals(games.get(0).toString(), list.get(0).toString());
        assertEquals(games.get(1).toString(), list.get(1).toString());
        assertEquals(games.get(2).toString(), list.get(2).toString());
        assertEquals(games.get(3).toString(), list.get(3).toString());
        assertEquals(games.get(4).toString(), list.get(4).toString());

    }

    @Test
    public void gamesInOrderOfDateAndName() {
        GregorianCalendar g1, g2, g3, g4, g5, g6, g7, g8;
        g1 = new GregorianCalendar();
        g2 = new GregorianCalendar();
        g3 = new GregorianCalendar();
        g4 = new GregorianCalendar();
        g5 = new GregorianCalendar();
        g6 = new GregorianCalendar();
        g7 = new GregorianCalendar();
        g8 = new GregorianCalendar();

        try {
            Date d1 = df.parse("7/02/2020");
            g1.setTime(d1);
            Date d2 = df.parse("7/05/2020");
            g2.setTime(d2);
            Date d3 = df.parse("7/06/2020");
            g3.setTime(d3);
            Date d4 = df.parse("7/08/2020");
            g4.setTime(d4);
            Date d5 = df.parse("7/11/2020");
            g5.setTime(d5);
            Date d6 = df.parse("7/15/2020");
            g6.setTime(d6);
            Date d7 = df.parse("7/25/2020");
            g7.setTime(d7);
            Date d8 = df.parse("7/29/2020");
            g8.setTime(d8);
        } catch (ParseException e) {
            throw new RuntimeException("Error in testing, creation of list");
        }

        list = new MySingleWithTailLinkedList();

        Game game1 = new Game("GPerson1", g3, g1, null, "title1",
                new Console("GPerson1", g3, g1, null, ConsoleTypes.PlayStation4));
        Game game2 = new Game("GPerson2", g3, g1, null, "title2",
                new Console("GPerson2", g3, g1, null, ConsoleTypes.PlayStation4));
        Game game3 = new Game("GPerson1", g5, g3, null, "title2",
                new Console("GPerson1", g5, g3, null, ConsoleTypes.SegaGenesisMini));
        Game game4 = new Game("GPerson7", g4, g4, null, "title2", null);
        Game game5 = new Game("GPerson3", g3, g5, g1, "title2",
                new Console("GPerson3", g3, g5, g1, ConsoleTypes.XBoxOneS));
        Game game6 = new Game("GPerson6", g4, g6, null, "title1",
                new Console("GPerson6", g4, g6, null, ConsoleTypes.NintendoSwich));
        Game game7 = new Game("GPerson5", g4, g7, null, "title1",
                new Console("GPerson5", g4, g7, null, ConsoleTypes.NintendoSwich));
        Game game8 = new Game("GPerson1", g4, g8, null, "title1",
                new Console("GPerson1", g4, g8, null, ConsoleTypes.NintendoSwich));
        Game game9 = new Game("GPerson2", g4, g8, null, "title2", null);
        Game game10 = new Game("GPerson3", g3, g8, null, "title2",
                new Console("GPerson3", g3, g8, null, ConsoleTypes.PlayStation4));
        Game game11 = new Game("GPerson4", g3, g8, null, "title2",
                new Console("GPerson4", g3, g8, null, ConsoleTypes.PlayStation4));


        list.add(game5);
        list.add(game1);
        list.add(game10);
        list.add(game2);
        list.add(game8);
        list.add(game4);
        list.add(game7);
        list.add(game9);
        list.add(game3);
        list.add(game11);
        list.add(game6);

        list.display();

        ArrayList<Game> games = new ArrayList<>();

        games.add(game1);
        games.add(game2);
        games.add(game3);
        games.add(game4);
        games.add(game5);
        games.add(game6);
        games.add(game7);
        games.add(game8);
        games.add(game9);
        games.add(game10);
        games.add(game11);

        assertEquals(games.get(0).toString(), list.get(0).toString());
        assertEquals(games.get(1).toString(), list.get(1).toString());
        assertEquals(games.get(2).toString(), list.get(2).toString());
        assertEquals(games.get(3).toString(), list.get(3).toString());
        assertEquals(games.get(4).toString(), list.get(4).toString());
        assertEquals(games.get(5).toString(), list.get(5).toString());
        assertEquals(games.get(6).toString(), list.get(6).toString());
        assertEquals(games.get(7).toString(), list.get(7).toString());
        assertEquals(games.get(8).toString(), list.get(8).toString());
        assertEquals(games.get(9).toString(), list.get(9).toString());
        assertEquals(games.get(10).toString(), list.get(10).toString());
    }

    @Test
    public void inOrderOfNameAndDate() {
        GregorianCalendar g1, g2, g3, g4;
        g1 = new GregorianCalendar();
        g2 = new GregorianCalendar();
        g3 = new GregorianCalendar();
        g4 = new GregorianCalendar();

        try {
            Date d1 = df.parse("7/02/2020");
            g1.setTime(d1);
            Date d2 = df.parse("7/05/2020");
            g2.setTime(d2);
            Date d3 = df.parse("7/06/2020");
            g3.setTime(d3);
            Date d4 = df.parse("7/08/2020");
            g4.setTime(d4);
        } catch (ParseException e) {
            throw new RuntimeException("Error in testing, creation of list");
        }

        list = new MySingleWithTailLinkedList();

        Game game1 = new Game("GPerson1", g3, g1, null, "title1",
                new Console("GPerson1", g3, g1, null, ConsoleTypes.PlayStation4));
        Game game2 = new Game("GPerson1", g3, g2, null, "title2",
                new Console("GPerson1", g3, g2, null, ConsoleTypes.PlayStation4));
        Game game3 = new Game("GPerson3", g3, g2, null, "title2",
                new Console("GPerson3", g3, g2, null, ConsoleTypes.PlayStation4));
        Game game4 = new Game("GPerson1", g4, g3, null, "title2",
                new Console("GPerson1", g4, g3, null, ConsoleTypes.SegaGenesisMini));

        Console console1 = new Console("Person1", g3, g1, null, ConsoleTypes.PlayStation4);
        Console console2 = new Console("Person2", g2, g2, null, ConsoleTypes.PlayStation4);
        Console console3 = new Console("Person3", g3, g2, null, ConsoleTypes.PlayStation4);
        Console console4 = new Console("Person5", g4, g3, null, ConsoleTypes.SegaGenesisMini);
        Console console5 = new Console("Person6", g1, g4, null, ConsoleTypes.SegaGenesisMini);

        list.add(game1);
        list.add(game2);
        list.add(console2);
        list.add(console1);
        list.add(game4);
        list.add(console4);
        list.add(game3);
        list.add(console5);
        list.add(console3);

        list.display();

        ArrayList<String> games = new ArrayList<>();

        games.add(game1.toString());
        games.add(game2.toString());
        games.add(game3.toString());
        games.add(game4.toString());
        games.add(console1.toString());
        games.add(console2.toString());
        games.add(console3.toString());
        games.add(console4.toString());
        games.add(console5.toString());

        assertEquals(games.get(0), list.get(0).toString());
        assertEquals(games.get(1), list.get(1).toString());
        assertEquals(games.get(2), list.get(2).toString());
        assertEquals(games.get(3), list.get(3).toString());
        assertEquals(games.get(4), list.get(4).toString());
        assertEquals(games.get(5), list.get(5).toString());
        assertEquals(games.get(6), list.get(6).toString());
        assertEquals(games.get(7), list.get(7).toString());
        assertEquals(games.get(8), list.get(8).toString());

    }

    @Test
    public void consolesInOrderOfDate() {
        GregorianCalendar g1, g2, g3, g4, g5, g6, g7, g8;
        g1 = new GregorianCalendar();
        g2 = new GregorianCalendar();
        g3 = new GregorianCalendar();
        g4 = new GregorianCalendar();
        g5 = new GregorianCalendar();
        g6 = new GregorianCalendar();
        g7 = new GregorianCalendar();
        g8 = new GregorianCalendar();

        try {
            Date d1 = df.parse("7/02/2020");
            g1.setTime(d1);
            Date d2 = df.parse("7/05/2020");
            g2.setTime(d2);
            Date d3 = df.parse("7/06/2020");
            g3.setTime(d3);
            Date d4 = df.parse("7/08/2020");
            g4.setTime(d4);
            Date d5 = df.parse("7/11/2020");
            g5.setTime(d5);
            Date d6 = df.parse("7/15/2020");
            g6.setTime(d6);
            Date d7 = df.parse("7/25/2020");
            g7.setTime(d7);
            Date d8 = df.parse("7/29/2020");
            g8.setTime(d8);
        } catch (ParseException e) {
            throw new RuntimeException("Error in testing, creation of list");
        }

        list = new MySingleWithTailLinkedList();

        Console console1 = new Console("Person1", g3, g1, null, ConsoleTypes.PlayStation4);
        Console console2 = new Console("Person2", g2, g2, null, ConsoleTypes.PlayStation4);
        Console console3 = new Console("Person3", g4, g3, null, ConsoleTypes.SegaGenesisMini);
        Console console4 = new Console("Person4", g1, g4, null, ConsoleTypes.SegaGenesisMini);
        Console console5 = new Console("Person5", g2, g5, null, ConsoleTypes.XBoxOneS);
        Console console6 = new Console("Person6", g1, g6, null, ConsoleTypes.XBoxOneS);
        Console console7 = new Console("Person7", g5, g7, null, ConsoleTypes.PlayStation4);
        Console console8 = new Console("Person8", g1, g8, null, ConsoleTypes.NintendoSwich);

        list.add(console5);
        list.add(console2);
        list.add(console1);
        list.add(console4);
        list.add(console6);
        list.add(console3);
        list.add(console8);
        list.add(console7);

        list.display();

        ArrayList<Console> consoles = new ArrayList<>();

        consoles.add(console1);
        consoles.add(console2);
        consoles.add(console3);
        consoles.add(console4);
        consoles.add(console5);
        consoles.add(console6);
        consoles.add(console7);
        consoles.add(console8);

        assertEquals(consoles.get(0).toString(), list.get(0).toString());
        assertEquals(consoles.get(1).toString(), list.get(1).toString());
        assertEquals(consoles.get(2).toString(), list.get(2).toString());
        assertEquals(consoles.get(3).toString(), list.get(3).toString());
        assertEquals(consoles.get(4).toString(), list.get(4).toString());
        assertEquals(consoles.get(5).toString(), list.get(5).toString());
        assertEquals(consoles.get(6).toString(), list.get(6).toString());
        assertEquals(consoles.get(7).toString(), list.get(7).toString());

    }

    @Test
    public void consolesInOrderOfName() {
        GregorianCalendar g1;
        g1 = new GregorianCalendar();

        try {
            Date d1 = df.parse("7/02/2020");
            g1.setTime(d1);
        } catch (ParseException e) {
            throw new RuntimeException("Error in testing, creation of list");
        }

        list = new MySingleWithTailLinkedList();

        Console console1 = new Console("Person1", g1, g1, null, ConsoleTypes.PlayStation4);
        Console console2 = new Console("Person2", g1, g1, null, ConsoleTypes.PlayStation4);
        Console console3 = new Console("Person3", g1, g1, null, ConsoleTypes.SegaGenesisMini);
        Console console4 = new Console("Person4", g1, g1, null, ConsoleTypes.SegaGenesisMini);
        Console console5 = new Console("Person5", g1, g1, null, ConsoleTypes.XBoxOneS);
        Console console6 = new Console("Person6", g1, g1, null, ConsoleTypes.XBoxOneS);
        Console console7 = new Console("Person7", g1, g1, null, ConsoleTypes.PlayStation4);
        Console console8 = new Console("Person8", g1, g1, null, ConsoleTypes.NintendoSwich);

        list.add(console5);
        list.add(console2);
        list.add(console1);
        list.add(console4);
        list.add(console6);
        list.add(console3);
        list.add(console8);
        list.add(console7);

        list.display();

        ArrayList<Console> consoles = new ArrayList<>();

        consoles.add(console1);
        consoles.add(console2);
        consoles.add(console3);
        consoles.add(console4);
        consoles.add(console5);
        consoles.add(console6);
        consoles.add(console7);
        consoles.add(console8);

        assertEquals(consoles.get(0).toString(), list.get(0).toString());
        assertEquals(consoles.get(1).toString(), list.get(1).toString());
        assertEquals(consoles.get(2).toString(), list.get(2).toString());
        assertEquals(consoles.get(3).toString(), list.get(3).toString());
        assertEquals(consoles.get(4).toString(), list.get(4).toString());
        assertEquals(consoles.get(5).toString(), list.get(5).toString());
        assertEquals(consoles.get(6).toString(), list.get(6).toString());
        assertEquals(consoles.get(7).toString(), list.get(7).toString());

    }

    @Test
    public void consolesInOrderOfDateAndName() {
        GregorianCalendar g1, g2, g3, g4, g5, g6, g7, g8;
        g1 = new GregorianCalendar();
        g2 = new GregorianCalendar();
        g3 = new GregorianCalendar();
        g4 = new GregorianCalendar();
        g5 = new GregorianCalendar();
        g6 = new GregorianCalendar();
        g7 = new GregorianCalendar();
        g8 = new GregorianCalendar();

        try {
            Date d1 = df.parse("7/02/2020");
            g1.setTime(d1);
            Date d2 = df.parse("7/05/2020");
            g2.setTime(d2);
            Date d3 = df.parse("7/06/2020");
            g3.setTime(d3);
            Date d4 = df.parse("7/08/2020");
            g4.setTime(d4);
            Date d5 = df.parse("7/11/2020");
            g5.setTime(d5);
            Date d6 = df.parse("7/15/2020");
            g6.setTime(d6);
            Date d7 = df.parse("7/25/2020");
            g7.setTime(d7);
            Date d8 = df.parse("7/29/2020");
            g8.setTime(d8);
        } catch (ParseException e) {
            throw new RuntimeException("Error in testing, creation of list");
        }

        list = new MySingleWithTailLinkedList();


        Console console1 = new Console("Person1", g3, g1, null, ConsoleTypes.PlayStation4);
        Console console2 = new Console("Person2", g2, g1, null, ConsoleTypes.PlayStation4);
        Console console3 = new Console("Person3", g4, g2, null, ConsoleTypes.SegaGenesisMini);
        Console console4 = new Console("Person4", g1, g4, null, ConsoleTypes.SegaGenesisMini);
        Console console5 = new Console("Person5", g2, g5, null, ConsoleTypes.XBoxOneS);
        Console console6 = new Console("Person6", g1, g5, null, ConsoleTypes.XBoxOneS);
        Console console7 = new Console("Person7", g5, g6, null, ConsoleTypes.PlayStation4);
        Console console8 = new Console("Person8", g1, g7, null, ConsoleTypes.NintendoSwich);
        Console console9 = new Console("Person1", g1, g8, null, ConsoleTypes.NintendoSwich);
        Console console10 = new Console("Person2", g1, g8, null, ConsoleTypes.PlayStation4);
        Console console11 = new Console("Person3", g1, g8, null, ConsoleTypes.PlayStation4);


        list.add(console5);
        list.add(console1);
        list.add(console10);
        list.add(console2);
        list.add(console8);
        list.add(console4);
        list.add(console7);
        list.add(console9);
        list.add(console3);
        list.add(console11);
        list.add(console6);

        list.display();

        ArrayList<Console> games = new ArrayList<>();

        games.add(console1);
        games.add(console2);
        games.add(console3);
        games.add(console4);
        games.add(console5);
        games.add(console6);
        games.add(console7);
        games.add(console8);
        games.add(console9);
        games.add(console10);
        games.add(console11);

        assertEquals(games.get(0).toString(), list.get(0).toString());
        assertEquals(games.get(1).toString(), list.get(1).toString());
        assertEquals(games.get(2).toString(), list.get(2).toString());
        assertEquals(games.get(3).toString(), list.get(3).toString());
        assertEquals(games.get(4).toString(), list.get(4).toString());
        assertEquals(games.get(5).toString(), list.get(5).toString());
        assertEquals(games.get(6).toString(), list.get(6).toString());
        assertEquals(games.get(7).toString(), list.get(7).toString());
        assertEquals(games.get(8).toString(), list.get(8).toString());
        assertEquals(games.get(9).toString(), list.get(9).toString());
        assertEquals(games.get(10).toString(), list.get(10).toString());
    }
}
