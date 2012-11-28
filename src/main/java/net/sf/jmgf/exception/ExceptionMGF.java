package net.sf.jmgf.exception;

public class ExceptionMGF extends Exception {

    private static final long serialVersionUID = -8221476999104581714L;

    public ExceptionMGF() {

    }

    public ExceptionMGF(final String message) {
        super(message);

    }

    public ExceptionMGF(final String message, final Throwable cause) {
        super(message, cause);

    }

    public ExceptionMGF(final Throwable cause) {
        super(cause);

    }

}
