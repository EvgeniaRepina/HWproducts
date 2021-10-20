package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
  private ProductRepository repository = new ProductRepository();
  private Book coreJava = new Book();
  private Smartphone xiaomi = new Smartphone();

  @Test
  public void shouldSaveOneItem() {
    repository.save(coreJava);
    repository.save(xiaomi);

    Product[] expected = new Product[]{coreJava, xiaomi};
    Product[] actual = repository.findAll();
    assertArrayEquals(expected, actual);
  }
}
