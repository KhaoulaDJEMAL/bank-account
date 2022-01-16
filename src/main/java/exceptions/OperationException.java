package exceptions;

public class OperationException extends Exception {


    public OperationException() {
        super();
    }

    /**
     * Exception creation
     *
     * @param message error message.
     */
    public OperationException(final String message) {
        super(message);
    }


    public OperationException(final Throwable cause) {
        super(cause);
    }

    public OperationException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
