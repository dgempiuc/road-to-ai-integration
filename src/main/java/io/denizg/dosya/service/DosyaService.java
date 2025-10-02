package io.denizg.dosya.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

@Service
public class DosyaService {

    private final Map<String, String> dataStore = new ConcurrentHashMap<>();

    public List<String> getAll() {
        return new ArrayList<>(dataStore.values());
    }

    public String getById(String id) {
        return dataStore.getOrDefault(id, "Not found");
    }

    public String create(String data) {
        String id = String.valueOf(System.currentTimeMillis());
        dataStore.put(id, data);
        return "Created with ID: " + id;
    }

    public String update(String id, String data) {
        if (dataStore.containsKey(id)) {
            dataStore.put(id, data);
            return "Updated successfully";
        }
        return "Not found";
    }

    public void delete(String id) {
        dataStore.remove(id);
    }
}
