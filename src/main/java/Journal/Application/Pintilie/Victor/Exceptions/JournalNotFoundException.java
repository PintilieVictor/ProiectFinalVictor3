package Journal.Application.Pintilie.Victor.Exceptions;

public class JournalNotFoundException extends RuntimeException {
    public JournalNotFoundException(String message) {
        super(message);
    }
}
