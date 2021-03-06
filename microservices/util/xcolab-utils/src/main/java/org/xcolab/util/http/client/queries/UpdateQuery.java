package org.xcolab.util.http.client.queries;

import org.xcolab.util.http.RequestUtils;
import org.xcolab.util.http.UriBuilder;
import org.xcolab.util.http.client.RestResource;

public class UpdateQuery<T> {

    private final UriBuilder uriBuilder;
    private final T pojo;
    private String cacheIdentifierValue;

    public UpdateQuery(RestResource<T> restResource, long id, T pojo) {
        this.pojo = pojo;
        this.uriBuilder = restResource.getResourceUrl(id);
    }

    public UpdateQuery(RestResource<T> restResource, String id, T pojo) {
        this.pojo = pojo;
        this.uriBuilder = restResource.getResourceUrl(id);
    }

    public boolean execute() {
        if (cacheIdentifierValue == null) {
            return RequestUtils.put(uriBuilder, pojo);
        } else {
            return RequestUtils.put(uriBuilder, pojo, cacheIdentifierValue);
        }
    }

    public UpdateQuery<T> cacheIdentifier(String cacheIdentifier) {
        this.cacheIdentifierValue = cacheIdentifier;
        return this;
    }

    public UpdateQuery<T> queryParam(String name, Object value) {
        uriBuilder.queryParam(name, value);
        return this;
    }

    public UpdateQuery<T> optionalQueryParam(String name, Object value) {
        uriBuilder.optionalQueryParam(name, value);
        return this;
    }
}
