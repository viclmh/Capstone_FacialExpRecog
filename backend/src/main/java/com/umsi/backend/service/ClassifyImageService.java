package com.umsi.backend.service;

import org.datavec.image.loader.NativeImageLoader;
import org.deeplearning4j.nn.graph.ComputationGraph;
import org.nd4j.linalg.dataset.api.preprocessor.DataNormalization;
import org.nd4j.linalg.dataset.api.preprocessor.ImagePreProcessingScaler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.Base64;
import org.deeplearning4j.nn.modelimport.keras.KerasModelImport;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.deeplearning4j.nn.modelimport.keras.exceptions.InvalidKerasConfigurationException;
import org.deeplearning4j.nn.modelimport.keras.exceptions.UnsupportedKerasConfigurationException;
import org.nd4j.linalg.api.ndarray.INDArray;
import javax.imageio.ImageIO;
import java.io.IOException;


@Service
public class ClassifyImageService {
    @Autowired
    public ClassifyImageService() {
    }

    public int classify(String images) throws IOException, UnsupportedKerasConfigurationException, InvalidKerasConfigurationException {
        System.out.println("Received image!");
        System.out.println(images);

        String encodedImg = images.split(",")[1];
        System.out.println(encodedImg);

        byte[] img = Base64.getDecoder().decode(encodedImg);

        ByteArrayInputStream inputImg = new ByteArrayInputStream(img);
        BufferedImage bufferedImg = ImageIO.read(inputImg);



        int width = bufferedImg.getWidth();
        int height = bufferedImg.getHeight();

        // convert to grayscale
        // bit operations are referenced from https://www.geeksforgeeks.org/image-processing-in-java-colored-image-to-grayscale-image-conversion/#
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int p = bufferedImg.getRGB(x, y);

                int a = (p >> 24) & 0xff;
                int r = (p >> 16) & 0xff;
                int g = (p >> 8) & 0xff;
                int b = p & 0xff;
                int avg = (r + g + b) / 3;
                p = (a << 24) | (avg << 16) | (avg << 8)
                        | avg;
                bufferedImg.setRGB(x, y, p);
            }
        }
        BufferedImage resizedImage = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = resizedImage.createGraphics();
        graphics2D.drawImage(bufferedImg, 0, 0, 100, 100, null);
        graphics2D.dispose();

//        File output = new File("/Users/liminghan/Downloads/input.jpg");

        File file = File.createTempFile("image", null);
        System.out.println(file);

        ImageIO.write(resizedImage, "jpg", file);

        System.out.println("Image Processed");


        return predict(img, file);

    }

    private int predict(byte[] img, File outputFile) throws IOException, UnsupportedKerasConfigurationException, InvalidKerasConfigurationException {

        // load machine learning model
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("CNN.h5");
//        InputStream inputStream = classLoader.getResourceAsStream("baseline_model.h5");

        MultiLayerNetwork model = KerasModelImport.importKerasSequentialModelAndWeights(inputStream);


        // load the image
        System.out.println(outputFile);

        NativeImageLoader loader = new NativeImageLoader(100, 100, 1);

        INDArray image = loader.asMatrix(outputFile);

        // normalize the image
        DataNormalization scalar = new ImagePreProcessingScaler(0, 1);
        scalar.transform(image);

        // feed the image into CNN model and get the classification result
        double output = model.output(image).getDouble(0);
        int[] res = model.predict(image);

        System.out.println(output);
        System.out.println(res[0]);

        return res[0];
    }
}
