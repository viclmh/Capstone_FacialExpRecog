package com.umsi.backend.controller;

import org.deeplearning4j.nn.modelimport.keras.exceptions.InvalidKerasConfigurationException;
import org.deeplearning4j.nn.modelimport.keras.exceptions.UnsupportedKerasConfigurationException;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.umsi.backend.service.ClassifyImageService;
import java.io.IOException;

@RestController
public class ImageController {
        private ClassifyImageService imageService;

    @Autowired
    public ImageController(ClassifyImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping("/image")
    public int classifyImage(@RequestParam("base64") String base64) throws IOException, UnsupportedKerasConfigurationException, InvalidKerasConfigurationException {

        return imageService.classify(base64);

    }

}