package by.tc.task01.dao.impl.exception;

public class ApplianceException extends Exception {
    /**
     * Instantiates a new Appliance exception.
     */
    public ApplianceException() {
    }

    /**
     * Instantiates a new Appliance exception.
     *
     * @param message the message
     */
    public ApplianceException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Appliance exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public ApplianceException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Appliance exception.
     *
     * @param cause the cause
     */
    public ApplianceException(Throwable cause) {
        super(cause);
    }
}
