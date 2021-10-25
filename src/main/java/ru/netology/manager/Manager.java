package ru.netology.manager;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

public class Manager {

    private ProductRepository repository = new ProductRepository();

    Manager(ProductRepository repository) {
        this.repository = repository;
    }

//____________________добавление товаров__________________________

    public void add(Product item) {
        repository.save(item);
    }

    //    ______________ поиск______________________________
    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];

                // используйте System.arraycopy, чтобы скопировать всё из result в tmp
                System.arraycopy(result, 0, tmp, 0, result.length);

                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {

        if (product instanceof Book) { // если в параметре product лежит объект класса Book
            Book book = (Book) product; // положим его в переменную типа Book чтобы пользоваться методами класса Book
            if (book.getAuthor().contains(search)) { // проверим есть ли поисковое слово в данных об авторе
                return true;
            }
            if (book.getName().contains(search)) {
                return true;
            }
            return false;
        }
        if (product instanceof Smartphone) { // если в параметре product лежит объект класса Smartphone
            Smartphone smartphone = (Smartphone) product; // положим его в переменную типа smartphone чтобы
            // пользоваться методами класса Smartphone
            if (smartphone.getManufacturer().contains(search)) { // проверим есть ли поисковое слово в данных об
                // производителе
                return true;
            }
            if (smartphone.getName().contains(search)) {
                return true;
            }
            return false;
        }

        return false;
    }
}
