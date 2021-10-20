package ru.netology.manager;

import ru.netology.domain.Product;
import ru.netology.repository.ProductRepository;

public class Manager {
    private ProductRepository[] products = new ProductRepository[0];

   public Manager(ProductRepository[] products) {
        this.products = products;
    }

    public Manager() {
    }

    private Product[] items = new Product[0];

    public void add(Product item) {
        // создаём новый массив размером на единицу больше
        int length = products.length + 1;
        ProductRepository[] tmp = new ProductRepository[length];
        // itar + tab
        // копируем поэлементно
        // for (int i = 0; i < films.length; i++) {
        //   tmp[i] = films[i];
        // }
        System.arraycopy(products, 0, tmp, 0, products.length);
        // кладём последним наш элемент
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        products = tmp;
    }


}
