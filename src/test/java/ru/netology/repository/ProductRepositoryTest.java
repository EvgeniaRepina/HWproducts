package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();

    private Book coreJava = new Book(1, "coreJava", 300, "Ivanov");
    private Smartphone xiaomi = new Smartphone(2, "xiaomiMI9", 10000, "xiaomi");

    @Test
    public void shouldSaveOneItem() {
        repository.save(coreJava);
        repository.save(xiaomi);

        Product[] expected = new Product[]{coreJava, xiaomi};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByI() {
        repository.save(coreJava);
        repository.save(xiaomi);

        repository.removeById(2);

        Product[] expected = new Product[]{coreJava};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }
}
