package  ru.netology.hw14shop.shop;

public class AlreadyExistsException extends RuntimeException {

    public AlreadyExistsException(String s) {
        super(s);
    }
}
