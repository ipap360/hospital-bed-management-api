package com.timelyworks.clinical.web.mappers;

import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Slf4j
@Provider
public class RuntimeExceptionMapper implements ExceptionMapper<RuntimeException> {

    @Override
    public Response toResponse(RuntimeException exception) {

        JSONObject o = new JSONObject();

        o.put("name", exception.getClass().getSimpleName());
        o.put("message", exception.getMessage());

        log.error(exception.getLocalizedMessage(), exception);

        // domain exceptions are treated as bad requests...
        return Response.status(Status.BAD_REQUEST).entity(o.toString()).build();
    }
}
