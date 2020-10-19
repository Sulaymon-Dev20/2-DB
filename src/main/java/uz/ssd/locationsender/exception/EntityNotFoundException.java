package uz.ssd.locationsender.exception;

/**
 * Author: Khumoyun Khujamov
 * Date: 10/18/20
 * Time: 5:13 PM
 */
public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException() {
       this("Could not find entity with given criteria");
    }

    public EntityNotFoundException(String message) {
        super(message);
    }
}
