package com.sample.app.dao;

import com.sample.app.model.db.InventoryElement;

import java.util.List;

public interface InventoryElementDAO {
    List<InventoryElement> findAll();

    InventoryElement findById(Integer id);

    void save(InventoryElement inventoryElement);

    void delete(Integer id);
}
