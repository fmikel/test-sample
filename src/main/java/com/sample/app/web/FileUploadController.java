package com.sample.app.web;

import com.sample.app.model.db.InventoryElement;
import com.sample.app.service.InventoryElementService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class FileUploadController {
    private static final Logger logger = Logger.getLogger(FileUploadController.class);

    @Autowired
    InventoryElementService inventoryElementService;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(@RequestParam("file") MultipartFile file) throws Exception {
        if (!file.isEmpty()) {
            List<InventoryElement> inventoryElements = inventoryElementService.loadInventoryElements(file.getInputStream());
            logger.debug("File is uploaded successfully");
            return "redirect:./allInventoryElements";
        } else {
            throw new Exception("File upload failed because it was empty");
        }
    }

    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String uploadForm() {
        return "upload";
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleError(HttpServletRequest req, Exception exception) {
        logger.error("Request: " + req.getRequestURL() + " raised " + exception);

        ModelAndView modelAndView = new ModelAndView("error/error");
        modelAndView.addObject("exception", exception);
        modelAndView.addObject("url", req.getRequestURL());
        return modelAndView;
    }
}
