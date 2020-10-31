package com.comcast.LongestCommonSubstring.exception.mapper;

import com.comcast.LongestCommonSubstring.exception.UniqueConstraintException;
import com.comcast.LongestCommonSubstring.vo.LCSResponse;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Exception mapper for runtime exceptions
 */
@Provider
@Produces(MediaType.APPLICATION_JSON)
public class UniqueConstraintExceptionMapper implements ExceptionMapper<UniqueConstraintException> {

    @Override
    public Response toResponse(UniqueConstraintException exception) {
        // build the response
        LCSResponse response = new LCSResponse();
        return Response.status(Response.Status.NOT_ACCEPTABLE.getStatusCode()).type(MediaType.APPLICATION_JSON).entity(response).build();
    }
}
