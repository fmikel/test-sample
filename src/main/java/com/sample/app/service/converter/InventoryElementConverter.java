package com.sample.app.service.converter;

import com.sample.app.dao.InventoryElementDAO;
import com.sample.app.model.db.InventoryElement;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class InventoryElementConverter implements Converter<InventoryElement, InputStream> {
    private static final Logger logger = Logger.getLogger(InventoryElementConverter.class);

    @Autowired
    InventoryElementDAO inventoryElementDAO;

    public List<InventoryElement> convert(InputStream stream) throws IOException {
        ArrayList<InventoryElement> result = new ArrayList<>();

        HSSFWorkbook wb = null;

        try {
            wb = new HSSFWorkbook(stream);
            Sheet sheet = wb.getSheetAt(0);
            for (Row row : sheet) {
                InventoryElement inventoryElement = new InventoryElement();
                inventoryElement.setCode(getCodeFromRow(row));
                inventoryElement.setName(getNameFromRow(row));
                inventoryElement.setCost(getCostFromRow(row));
                inventoryElement.setDate(getDateFromRow(row));

                result.add(inventoryElement);
            }
        } finally {
            IOUtils.closeQuietly(stream);
        }

        return result;
    }

    private int getCodeFromRow(Row row) {
        return new Double(row.getCell(0).getNumericCellValue()).intValue();
    }

    private String getNameFromRow(Row row) {
        return row.getCell(1).getStringCellValue();
    }

    private double getCostFromRow(Row row) {
        return row.getCell(2).getNumericCellValue();
    }

    private Date getDateFromRow(Row row) {
        return row.getCell(3).getDateCellValue();
    }
}
