package me.msc.support;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by jliu on 3/27/2015.
 */

@Component
public class CucumberWorld {
    private Map<String, Object> entities = new HashMap<String, Object>();

    public Object get(String key) {
        return entities.get(key);
    }

    public void put(String key, Object val) {
        entities.put(key, val);
    }

    public Map<String, Object> getEntities() {
        return entities;
    }

    public void setEntities(Map<String, Object> entities) {
        this.entities = entities;
    }

    @Override
    public String toString() {
        return "CucumberWorld{" +
                "entities=" + entities +
                '}';
    }
}
