package com.sample.app.service;

import com.sample.app.dao.InventoryElementDAO;
import com.sample.app.model.db.InventoryElement;
import com.sample.app.service.converter.InventoryElementConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
@Transactional
public class InventoryElementServiceImpl implements InventoryElementService {
    @Autowired
    InventoryElementConverter inventoryElementConverter;

    @Autowired
    InventoryElementDAO inventoryElementDAO;

    public List<InventoryElement> loadInventoryElements(InputStream inputStream) throws Exception {
        List<InventoryElement> inventoryElements = inventoryElementConverter.convert(inputStream);
        if (inventoryElements != null && !inventoryElements.isEmpty()) {
            addAll(inventoryElements);
        }

        return inventoryElements;
    }

    public void add(InventoryElement inventoryElement) {
        inventoryElementDAO.save(inventoryElement);
    }

    public void addAll(List<InventoryElement> inventoryElements) {
        if (inventoryElements != null) {
            for (InventoryElement inventoryElement : inventoryElements) {
                add(inventoryElement);
            }
        }
    }

    public InventoryElement get(Integer id) {
        return inventoryElementDAO.findById(id);
    }

    public List<InventoryElement> getAll() {
        return inventoryElementDAO.findAll();
    }

    public void update(InventoryElement inventoryElement) {
        inventoryElementDAO.save(inventoryElement);
    }

    public void remove(Integer id) {
        inventoryElementDAO.delete(id);
    }
}
