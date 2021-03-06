/*
 * Copyright (c) 2015 IBM Corporation and others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package org.brunel.data.util;

import org.brunel.data.Data;

import java.util.HashMap;
import java.util.Map;

public class Informative {
    protected  Map<String, Object> info = new HashMap<String, Object>();                    // Store the info

    public void copyPropertiesFrom(Informative other) {
        info.putAll(other.info);
    }

    public Double numericProperty(String key) {
        return Data.asNumeric(property(key));
    }

    public Object property(String key) {
        return info.get(key);
    }

    public String stringProperty(String key) {
        Object v = property(key);
        return v == null ? null : v.toString();
    }

    public void set(String key, Object value) {
        if (value == null)
            info.remove(key);
        else
            info.put(key, value);
    }
}
