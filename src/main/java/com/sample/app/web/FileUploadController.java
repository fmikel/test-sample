package com.sample.app.web;

import com.sample.app.model.db.InventoryElement;
import com.sample.app.service.InventoryElementService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class FileUploadController {
    private static final Logger logger = Logger.getLogger(FileUploadController.class);

    @Autowired
    InventoryElementService inventoryElementService;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public @ResponseBody
    String upload(@RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                List<InventoryElement> inventoryElements = inventoryElementService.loadInventoryElements(file.getInputStream());
                return "File successfully uploaded";
            } catch (Exception e) {
                return "File upload failed" + " => " + e.getMessage();
            }
        } else {
            return "File upload failed because it was empty";
        }
    }

    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String uploadForm() {
        return "upload";
    }
}
