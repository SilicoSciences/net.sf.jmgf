package net.sf.jmgf.exception;

import java.io.IOException;

public class ExceptionMGFIO extends IOException {

    private static final long serialVersionUID = -4593143188790271314L;

    public ExceptionMGFIO() {

    }

    public ExceptionMGFIO(final String message) {
        super(message);

    }

    public ExceptionMGFIO(final String message, final Throwable cause) {
        super(message, cause);

    }

    public ExceptionMGFIO(final Throwable cause) {
        super(cause);

    }

}
