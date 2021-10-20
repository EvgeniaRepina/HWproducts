package ru.netology.manager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {
    private Manager manager = new Manager();
    private ProductRepository repository = new ProductRepository();

    private Book coreJava = new Book();
    private Smartphone xiaomi = new Smartphone();

        @Test
        void souldAddProduct () {
//        repository.save(xiaomi);
//        repository.save(coreJava);
            manager.add(repository);


            Product[] expected = new Product[]{coreJava, xiaomi};
            Product[] actual = repository.findAll();
            assertArrayEquals(expected, actual);
        }

    }
}