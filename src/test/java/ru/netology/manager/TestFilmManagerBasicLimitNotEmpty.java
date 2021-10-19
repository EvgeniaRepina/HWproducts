package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.FilmInformation;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TestFilmManagerBasicLimitNotEmpty {


    private FilmManager manager = new FilmManager();

    private FilmInformation first = new FilmInformation("1", "картинка1", "имя1", "боевик");
    private FilmInformation second = new FilmInformation("2", "картинка2", "имя2", "боевик");
    private FilmInformation third = new FilmInformation("3", "картинка3", "имя3", "боевик");
    private FilmInformation fourth = new FilmInformation("4", "картинка4", "имя4", "боевик");
    private FilmInformation fifth = new FilmInformation("5", "картинка5", "имя5", "боевик");
    private FilmInformation sixth = new FilmInformation("6", "картинка6", "имя6", "боевик");
    private FilmInformation seventh = new FilmInformation("7", "картинка7", "имя7", "боевик");
    private FilmInformation eighth = new FilmInformation("8", "картинка8", "имя8", "боевик");
    private FilmInformation ninth = new FilmInformation("9", "картинка9", "имя9", "боевик");
    private FilmInformation tenth = new FilmInformation("10", "картинка10", "имя10", "боевик");
    private FilmInformation eleventh = new FilmInformation("11", "картинка11", "имя11", "боевик");
    private FilmInformation twelve = new FilmInformation("12", "картинка12", "имя12", "боевик");
    private FilmInformation thirteen = new FilmInformation("13", "картинка13", "имя13", "боевик");
    private FilmInformation fourteen = new FilmInformation("14", "картинка14", "имя14", "боевик");
    private FilmInformation fifteen = new FilmInformation("15", "картинка15", "имя15", "боевик");


    @BeforeEach
    public void setUp() {
        manager.addFilm(first);
        manager.addFilm(second);
        manager.addFilm(third);
    }


    //----------------------- add Film-------------------
    @Test
    void souldAddFilmZero() {

        FilmInformation[] actual = manager.getFilms();
        FilmInformation[] expected = new FilmInformation[]{first, second, third};

//    assertEquals(expected, actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    void souldAddFilmOne() {
        manager.addFilm(fifteen);

        FilmInformation[] actual = manager.getFilms();
        FilmInformation[] expected = new FilmInformation[]{first, second, third, fifteen};

//    assertEquals(expected, actual);
        assertArrayEquals(expected, actual);
    }


    @Test
    void souldAddFilmFifteen() {
        manager.addFilm(first);
        manager.addFilm(second);
        manager.addFilm(third);
        manager.addFilm(fourth);
        manager.addFilm(fifth);
        manager.addFilm(sixth);
        manager.addFilm(seventh);
        manager.addFilm(eighth);
        manager.addFilm(ninth);
        manager.addFilm(tenth);
        manager.addFilm(eleventh);
        manager.addFilm(twelve);
        manager.addFilm(thirteen);
        manager.addFilm(fourteen);
        manager.addFilm(fifteen);
        FilmInformation[] actual = manager.getFilms();
        FilmInformation[] expected = new FilmInformation[]{first, second, third, first, second, third, fourth, fifth, sixth, seventh, eighth,
                ninth, tenth, eleventh, twelve, thirteen, fourteen, fifteen};

//    assertEquals(expected, actual);
        assertArrayEquals(expected, actual);
    }

    //_____________________getAll______________________
    @Test
    void getAlllengthSeveral2() {
        manager.addFilm(first);
        manager.addFilm(second);
        FilmInformation[] actual = manager.getAll();
        FilmInformation[] expected = new FilmInformation[]{second, first, third, second, first};

//    assertEquals(expected, actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    void getAlllengthSeveral8() {
        manager.addFilm(first);
        manager.addFilm(second);
        manager.addFilm(third);
        manager.addFilm(fourth);
        manager.addFilm(fifth);
        manager.addFilm(sixth);
        manager.addFilm(seventh);
        manager.addFilm(eighth);
        FilmInformation[] actual = manager.getAll();
        FilmInformation[] expected = new FilmInformation[]{eighth, seventh, sixth, fifth,
                fourth, third, second, first, third, second, first};

//    assertEquals(expected, actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    void getAlllengthOne() {
        manager.addFilm(first);
        FilmInformation[] actual = manager.getAll();
        FilmInformation[] expected = new FilmInformation[]{first, third, second, first};

//    assertEquals(expected, actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    void getAlllengthZero() {
        FilmInformation[] actual = manager.getAll();
        FilmInformation[] expected = new FilmInformation[]{third, second, first};

//    assertEquals(expected, actual);
        assertArrayEquals(expected, actual);
    }

    //    ------------------------getLast10----------------------------------

    //    -------------------UnderLimit-----------------------
    @Test
    void getLast10lengthUnderLimit3() {
        manager.addFilm(first);
        manager.addFilm(second);
        manager.addFilm(third);
        FilmInformation[] actual = manager.getLastLimit();
        FilmInformation[] expected = new FilmInformation[]{third, second, first, third, second, first};

//    assertEquals(expected, actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    void getLast10lengthUnderLimit9() {
        manager.addFilm(first);
        manager.addFilm(second);
        manager.addFilm(third);
        manager.addFilm(fourth);
        manager.addFilm(fifth);
        manager.addFilm(sixth);
        manager.addFilm(seventh);
        manager.addFilm(eighth);
        manager.addFilm(ninth);

        FilmInformation[] actual = manager.getLastLimit();
        FilmInformation[] expected = new FilmInformation[]{ninth, eighth, seventh, sixth, fifth,
                fourth, third, second, first, third};

//    assertEquals(expected, actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    void getLast10length1() {
        manager.addFilm(first);
        FilmInformation[] actual = manager.getLastLimit();
        FilmInformation[] expected = new FilmInformation[]{first, third, second, first};

//    assertEquals(expected, actual);
        assertArrayEquals(expected, actual);
    }

    // _______________ zero____________________________________
    @Test
    void getLast10lengthZero() {
        FilmInformation[] actual = manager.getLastLimit();
        FilmInformation[] expected = new FilmInformation[]{third, second, first};

//    assertEquals(expected, actual);
        assertArrayEquals(expected, actual);
    }

    //   ---------------------------- Limit------------------
    @Test
    void getLast10lengthLimit() {
        manager.addFilm(first);
        manager.addFilm(second);
        manager.addFilm(third);
        manager.addFilm(fourth);
        manager.addFilm(fifth);
        manager.addFilm(sixth);
        manager.addFilm(seventh);
        manager.addFilm(eighth);
        manager.addFilm(ninth);
        manager.addFilm(tenth);
        FilmInformation[] actual = manager.getLastLimit();
        FilmInformation[] expected = new FilmInformation[]{tenth, ninth, eighth, seventh, sixth, fifth,
                fourth, third, second, first};

//    assertEquals(expected, actual); тест упадет т.к. сравниваются массивы, а не их элементы
        assertArrayEquals(expected, actual);  // сравниваются именно элементы массивов, а не сам массив как объект
    }


    //--------------------OverLimit----------------------------

    @Test
    void getLast10lengthOverLimit11() {
        manager.addFilm(first);
        manager.addFilm(second);
        manager.addFilm(third);
        manager.addFilm(fourth);
        manager.addFilm(fifth);
        manager.addFilm(sixth);
        manager.addFilm(seventh);
        manager.addFilm(eighth);
        manager.addFilm(ninth);
        manager.addFilm(tenth);
        manager.addFilm(eleventh);
        FilmInformation[] actual = manager.getLastLimit();
        FilmInformation[] expected = new FilmInformation[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth,
                fourth, third, second};

//    assertEquals(expected, actual); тест упадет т.к. сравниваются массивы, а не их элементы
        assertArrayEquals(expected, actual);  // сравниваются именно элементы массивов, а не сам массив как объект
    }

    @Test
    void getLast10lengthOverLimit15() {
        manager.addFilm(first);
        manager.addFilm(second);
        manager.addFilm(third);
        manager.addFilm(fourth);
        manager.addFilm(fifth);
        manager.addFilm(sixth);
        manager.addFilm(seventh);
        manager.addFilm(eighth);
        manager.addFilm(ninth);
        manager.addFilm(tenth);
        manager.addFilm(eleventh);
        manager.addFilm(twelve);
        manager.addFilm(thirteen);
        manager.addFilm(fourteen);
        manager.addFilm(fifteen);
        FilmInformation[] actual = manager.getLastLimit();
        FilmInformation[] expected = new FilmInformation[]{fifteen, fourteen, thirteen, twelve, eleventh, tenth, ninth
                , eighth,
                seventh,
                sixth};

//    assertEquals(expected, actual); тест упадет т.к. сравниваются массивы, а не их элементы
        assertArrayEquals(expected, actual);  // сравниваются именно элементы массивов, а не сам массив как объект
    }
}