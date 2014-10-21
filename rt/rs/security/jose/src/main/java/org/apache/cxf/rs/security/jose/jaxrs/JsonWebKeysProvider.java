/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.cxf.rs.security.jose.jaxrs;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;

import org.apache.cxf.rs.security.jose.jwk.JsonWebKeys;
import org.apache.cxf.rs.security.jose.jwk.JwkUtils;

public class JsonWebKeysProvider implements MessageBodyReader<JsonWebKeys> {
    
    @Override
    public boolean isReadable(Class<?> cls, Type type, Annotation[] anns, MediaType mt) {
        return cls == JsonWebKeys.class;
    }

    @Override
    public JsonWebKeys readFrom(Class<JsonWebKeys> cls, Type t, Annotation[] anns, MediaType mt,
                             MultivaluedMap<String, String> headers, InputStream is) throws IOException,
        WebApplicationException {
        return JwkUtils.readJwkSet(is);
    }
    
}
