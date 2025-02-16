/**********************************************************************
Copyright (c) 2012-2014 Alexander Kerner. All rights reserved.
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 ***********************************************************************/

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
