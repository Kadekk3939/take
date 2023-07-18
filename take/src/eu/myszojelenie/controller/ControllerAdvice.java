package eu.myszojelenie.controller;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ControllerAdvice implements ExceptionMapper<Throwable> {

    @Override
    public Response toResponse(Throwable throwable) {
        ErrorMessage msg = new ErrorMessage();
        msg.setErrorMessage(throwable.getCause().getMessage());
        return Response.status(Response.Status.BAD_REQUEST).entity(msg).build();
    }

    private static class ErrorMessage {
        private String errorMessage;

        public String getErrorMessage() {
            return errorMessage;
        }

        public void setErrorMessage(String errorMessage) {
            this.errorMessage = errorMessage;
        }
    }

}
