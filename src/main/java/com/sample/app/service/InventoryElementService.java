package com.sample.app.service;

import com.sample.app.model.db.InventoryElement;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public interface InventoryElementService {
    List<InventoryElement> loadInventoryElements(InputStream inputStream) throws Exception;

    void add(InventoryElement inventoryElement);

    void addAll(List<InventoryElement> inventoryElements);

    InventoryElement get(Integer id);

    List<InventoryElement> getAll();

    void update(InventoryElement inventoryElement);

    void remove(Integer id);
}
