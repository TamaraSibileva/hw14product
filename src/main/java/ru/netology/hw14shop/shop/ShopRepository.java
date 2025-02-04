package ru.netology.hw14shop.shop;

public class ShopRepository {
    private Product[] products = new Product[0];

    private Product[] addToArray(Product[] current, Product product) {
        Product[] tmp = new Product[current.length + 1];
        for (int i = 0; i < current.length; i++) {
            tmp[i] = current[i];
        }
        tmp[tmp.length - 1] = product;
        return tmp;
    }

    public Product findById(int currentId) {
        for (Product product : products) {
            if (product.getId() == currentId) {
                return product;
            }
        }
        return null;
    }

    public Product[] findAll() {
        return products;
    }

    public void add(Product product) {
        for (Product currentProducts : products) {
            if (currentProducts.getId() == product.id) {
                throw new AlreadyExistsException(
                        "Element with id: " + product.getId() + " already exists");
            }
        }
        products = addToArray(products, product);
    }

    public void remove(int id) {
        for (Product product : products) {
            if (findById(id) == null) {
                throw new NotFoundException(
                        "Element with id: " + id + " not found"
                );
            }
        }
        Product[] tmp = new Product[products.length - 1];
        int copyToIndex = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[copyToIndex] = product;
                copyToIndex++;
            }
        }
        products = tmp;
    }
}
