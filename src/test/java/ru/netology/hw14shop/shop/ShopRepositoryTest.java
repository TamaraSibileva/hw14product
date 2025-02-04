package ru.netology.hw14shop.shop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    Product product1 = new Product(11, "T-Shirt", 900 );
    Product product2 = new Product(44, "Shorts", 600);
    Product product3 = new Product(77, "Dress", 1_700);
    Product product4 = new Product(33, "Skirt", 1_200);
    Product product5 = new Product(77, "Shirt", 1_900);

    ShopRepository repo = new ShopRepository();

    @BeforeEach
    void setUp() {
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
    }

    @Test
    public void shouldFindById() {

        Product expected = product2;
        Product actual = repo.findById(44);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldRemoveExistingId() {
        repo.remove(77);

        Product[] expected = { product1, product2 };
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveNonExistentId() {

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.remove(99);
        });
    }

    @Test
    public void shouldAddNewProduct() {
        repo.add(product4);

        Product[] expected = { product1, product2, product3, product4 };
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddAlreadyExistingId() {

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            repo.add(product5);
        });
    }
}
