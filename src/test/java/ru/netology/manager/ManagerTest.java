package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ManagerTest {
    private ProductRepository repository = new ProductRepository();
    private Manager manager = new Manager(repository);


    private Book coreJava1 = new Book(1, "coreJava1", 300, "Ivanov");
    private Book coreJava2 = new Book(2, "coreJava2", 300, "Petrov");
    private Book coreJava3 = new Book(3, "coreJava3", 300, "Petrov");
    private Book coreJava4 = new Book(4, "coreJava4", 300, "Sidorov");
    private Book coreJava5 = new Book(5, "coreJava5", 300, "Musk");

    private Smartphone xiaomi1 = new Smartphone(1, "MI1", 10000, "xiaomi");
    private Smartphone xiaomi2 = new Smartphone(2, "MI2", 10000, "xiaomi");
    private Smartphone xiaomi3 = new Smartphone(3, "MI2", 10000, "xiaomi");
    private Smartphone xiaomi4 = new Smartphone(4, "MI4", 10000, "xiaomi");
    private Smartphone xiaomi5 = new Smartphone(5, "Musk", 10000, "xiaomi");

    //  _________________ add________________________________
    @Test
    public void shouldSaveOneItem() {
        manager.add(coreJava1);
        manager.add(xiaomi1);
        manager.add(xiaomi1);
        manager.add(xiaomi1);

        Product[] expected = new Product[]{coreJava1, xiaomi1, xiaomi1, xiaomi1};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    //_________________ Match____________________________________
    @Test
    public void shouldMatchPositive() {
        Book book = new Book(1, "coreJava", 300, "Ivanov");
        Smartphone smartphone = new Smartphone(2, "xiaomiMI9", 10000, "xiaomi");


        boolean expected = true;
        boolean actual = manager.matches(book, "Ivanov");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchNegative() {
        Book book = new Book(1, "coreJava", 300, "Ivanov");
        Smartphone smartphone = new Smartphone(2, "xiaomiMI9", 10000, "xiaomi");


        boolean expected = false;
        boolean actual = manager.matches(book, "Ivanot");
        assertEquals(expected, actual);
    }

    //    ____________для покрытия___________________________
    @Test
    public void shouldMatchCoverForCoverage() {

        Product book = new Product();

        boolean expected = false;
        boolean actual = manager.matches(book, "Ivanot");
        assertEquals(expected, actual);
    }

    //_________________ searchBy____________________________________
//    таблица комбинаций
//    размер массива,	количество совпадений,	тип продукта,	сочетание продуктов при совпадениях =	название
//    5,	5,	смартфон,	один тип продукта    = shouldSearchByLength5Matches5_Smartphones
//    5,	5,	книга,	один тип продукта	    = shouldSearchByLength5Matches5_Books
//    5,	2,	книга,	разный тип продукта	    = shouldSearchByLength5Matches2_BookSmartphone
//    5,	2,	книга,	один и тот же продукт 2 раза	    = shouldSearchByLength5Matches2_BookEqualBook
//    5,	2,	книга,	один тип продукта	    = shouldSearchByLength5Matches2_BookBook
//    5,	1,	смартфон, -		    = shouldSearchByLength5Matches1_Smartphone
//    5,	1,	книга,	-	    = shouldSearchByLength5Matches1_Book
//    5,	0,	смартфон,	-	    = shouldSearchByLength5Matches0_Smartphone
//    5,	0,	книга,		-    = shouldSearchByLength5Matches0_Book
//    1,	1,	смартфон,-		    = shouldSearchByLength1Matches1_Smartphone
//    1,	1,	книга,		-    = shouldSearchByLength1Matches1_Book
//    1,	0,	смартфон,	-	    = shouldSearchByLength1Matches0_Smartphone
//    1,	0,	книга,	-	    = shouldSearchByLength1Matches0_Book
//    0,	0,		-,	-   = shouldSearchByLength0Matches0

    //_________________  _____________________________

    @Test
    public void shouldSearchByLength5Matches5_Smartphones() {
        manager.add(xiaomi1);
        manager.add(xiaomi2);
        manager.add(xiaomi3);
        manager.add(xiaomi4);
        manager.add(xiaomi5);

        Product[] expected = new Product[]{xiaomi1, xiaomi2, xiaomi3, xiaomi4, xiaomi5};
        Product[] actual = manager.searchBy("xiaomi");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByLength5Matches1_Smartphone() {
        manager.add(xiaomi1);
        manager.add(xiaomi2);
        manager.add(xiaomi3);
        manager.add(xiaomi4);
        manager.add(xiaomi5);

        Product[] expected = new Product[]{xiaomi1};
        Product[] actual = manager.searchBy("MI1");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByLength5Matches0_Smartphone() {
        manager.add(xiaomi1);
        manager.add(xiaomi2);
        manager.add(xiaomi3);
        manager.add(xiaomi4);
        manager.add(xiaomi5);

        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("45");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByLength5Matches5_Books() {
        manager.add(coreJava1);
        manager.add(coreJava2);
        manager.add(coreJava3);
        manager.add(coreJava4);
        manager.add(coreJava5);

        Product[] expected = new Product[]{coreJava1, coreJava2, coreJava3, coreJava4, coreJava5};
        Product[] actual = manager.searchBy("coreJava");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByLength5Matches2_BookEqualBook() {
        manager.add(coreJava1);
        manager.add(coreJava1);
        manager.add(coreJava3);
        manager.add(coreJava4);
        manager.add(coreJava5);

        Product[] expected = new Product[]{coreJava1, coreJava1};
        Product[] actual = manager.searchBy("Ivanov");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByLength5Matches2_BookBook() {
        manager.add(coreJava1);
        manager.add(coreJava2);
        manager.add(coreJava3);
        manager.add(coreJava4);
        manager.add(coreJava5);

        Product[] expected = new Product[]{coreJava2, coreJava3};
        Product[] actual = manager.searchBy("Petrov");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByLength5Matches2_BookSmartphone() {
        manager.add(xiaomi5);
        manager.add(coreJava2);
        manager.add(coreJava3);
        manager.add(coreJava4);
        manager.add(coreJava5);

        Product[] expected = new Product[]{xiaomi5, coreJava5};
        Product[] actual = manager.searchBy("Musk");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByLength5Matches1_Book() {
        manager.add(coreJava1);
        manager.add(coreJava2);
        manager.add(coreJava3);
        manager.add(coreJava4);
        manager.add(coreJava5);

        Product[] expected = new Product[]{coreJava1};
        Product[] actual = manager.searchBy("Ivanov");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByLength5Matches0_Book() {
        manager.add(coreJava1);
        manager.add(coreJava2);
        manager.add(coreJava3);
        manager.add(coreJava4);
        manager.add(coreJava5);

        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("NHK");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByLength1Matches1_Smartphone() {
        manager.add(xiaomi1);

        Product[] expected = new Product[]{xiaomi1};
        Product[] actual = manager.searchBy("MI1");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByLength1Matches0_Smartphone() {
        manager.add(xiaomi1);

        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("df");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByLength1Matches1_Book() {
        manager.add(coreJava1);

        Product[] expected = new Product[]{coreJava1};
        Product[] actual = manager.searchBy("Ivanov");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByLength1Matches0_Book() {
        manager.add(coreJava1);

        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("fgdfv");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByLength0Matches0() {

        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Ivanov");
        assertArrayEquals(expected, actual);
    }
}