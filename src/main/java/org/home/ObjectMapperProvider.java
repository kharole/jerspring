package org.home;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.springframework.stereotype.Component;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 24.04.13
 * Time: 23:53
 * To change this template use File | Settings | File Templates.
 */
// tell spring to look for this.
@Component
// tell spring it's a provider (type is determined by the implements)
@Provider
public class ObjectMapperProvider implements ContextResolver<ObjectMapper> {
    @Override
    public ObjectMapper getContext(Class<?> type) {
        // create the objectMapper.
        ObjectMapper objectMapper = new ObjectMapper();
        // configure the object mapper here, eg.
        objectMapper.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS, false);
        return objectMapper;
    }
}