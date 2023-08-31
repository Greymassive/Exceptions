package ru.javamv;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    Product product1 = new Product(1, "Маленькая коробка", 100);
    Product product2 = new Product(2, "Коробка", 600);
    Product product3 = new Product(3, "Большая Коробка", 900);
    Product product4 = new Product(4, "Огромная Коробка", 1200);
    Product product5 = new Product(5, "Гигантская Коробка", 5000);

    @Test
    public void shouldRemoveById() {
        ShopRepository sr = new ShopRepository();
        sr.add(product1);
        sr.add(product2);
        sr.add(product3);
        sr.add(product4);
        sr.add(product5);
        sr.removeById(4);

        Product[] expected = {product1, product2, product3, product5};
        Product[] actual = sr.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveNullElement() {
        ShopRepository sr = new ShopRepository();
        sr.add(product1);
        sr.add(product2);
        sr.add(product3);
        sr.add(product4);
        sr.add(product5);

        Assertions.assertThrows(NotFoundException.class, () -> {
            sr.removeById(7);
        });
    }

    @Test
    public void shouldRemoveIfThereIsOneElement() {
        ShopRepository sr = new ShopRepository();
        sr.add(product1);
        sr.removeById(1);

        Product[] expected = {};
        Product[] actual = sr.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldRemoveIfNoElements() {
        ShopRepository sr = new ShopRepository();

        Assertions.assertThrows(NotFoundException.class, () -> {
            sr.removeById(1);
        });
    }
}
