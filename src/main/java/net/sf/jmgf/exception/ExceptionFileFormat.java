package net.sf.jmgf.exception;

public class ExceptionFileFormat extends ExceptionMGFIO {

    private static final long serialVersionUID = 5190834062887299318L;

    public ExceptionFileFormat() {

    }

    public ExceptionFileFormat(final String message) {
        super(message);

    }

    public ExceptionFileFormat(final String message, final Throwable cause) {
        super(message, cause);

    }

    public ExceptionFileFormat(final Throwable cause) {
        super(cause);

    }

}
