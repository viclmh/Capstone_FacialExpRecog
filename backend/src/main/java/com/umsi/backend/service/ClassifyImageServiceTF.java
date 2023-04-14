//package com.umsi.backend.service;

// *** Code for trying tensorflow-java library ***


//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//import org.tensorflow.SavedModelBundle;
//import org.tensorflow.Session;
//import org.tensorflow.internal.c_api.Tensor;
//import org.tensorflow.Tensor;
//import org.tensorflow.ndarray.*;
//import org.tensorflow.ndarray.buffer.ByteDataBuffer;
//import org.tensorflow.ndarray.buffer.DataBuffer;
//import org.tensorflow.ndarray.buffer.DataBuffers;
//import org.tensorflow.ndarray.buffer.FloatDataBuffer;
//import org.tensorflow.proto.framework.DataType;
//import org.tensorflow.types.TFloat32;
//import org.tensorflow.types.TInt32;
//
//import org.opencv.core.MatOfByte;
//import org.opencv.core.Core;
//import org.opencv.core.Mat;
//import org.opencv.core.Size;
//import org.opencv.imgcodecs.Imgcodecs;
//import org.opencv.imgproc.Imgproc;
//
//import java.io.IOException;
//import java.nio.ByteBuffer;
//import java.nio.FloatBuffer;
//import java.sql.SQLOutput;
//import java.util.Base64;
//
//import static org.tensorflow.proto.framework.DataType.*;
//
//import org.tensorflow.SavedModelBundle;
//import org.tensorflow.Session;
//import org.tensorflow.Tensor;
//
//@Service
//public class ClassifyImageServiceTF {
//    @Autowired
//    public ClassifyImageServiceTF() {
//    }
//
//    public void classify(String images) {
//
//        System.out.println("Received image!");
//        System.out.println(images);
//
//        String encodedImg = images.split(",")[1];
//
//        System.out.println(encodedImg);
//
//        byte[] img = Base64.getDecoder().decode(encodedImg);
//
//        Mat mat = Imgcodecs.imdecode(new MatOfByte(img), Imgcodecs.IMREAD_UNCHANGED);
//
//        String image_location = "/Users/vic/Desktop/SI699/ML/AffectNet-8Labels/val_set/images/1.jpg";
//        Mat src = Imgcodecs.imread(image_location);
//
//
//        // Scaling the Image using Resize function
//        Mat dst = new Mat();
//
//        Imgproc.resize(mat, dst, new Size(224, 224), 0,0, Imgproc.INTER_AREA);
//
//        Imgcodecs.imwrite("/Users/vic/Desktop/SI699/test.jpg", dst);
//
//        System.out.println("Image Processed");
//
//        loadModels(img);
//
//    }
//
//    public void loadModels(byte[] img) {
//        try (SavedModelBundle b = SavedModelBundle.load("/Users/liminghan/Downloads/tf_test_model", "serve")) {
//            Session s = b.session();
//            ByteDataBuffer bb = DataBuffers.of(img);
//            Tensor t = Tensor.of(TFloat32.class, Shape.of(1, 32, 32 ,3), bb);
//
//            TFloat32 result = (TFloat32) s.runner().feed("serving_default_conv2d_input", t).fetch("StatefulPartitionedCall").run().get(0);
//            FloatNdArray res = NdArrays.ofFloats(Shape.of(1, 10));
//
//            float[][] res = TFloat32.tensorOf(result);
//            System.out.println(res);
//            System.out.println(result.asRawTensor());
//            System.out.println(result.numBytes());
//            result.copyTo(res);
//
//            FloatDataBuffer floatDataBuffer = DataBuffers.ofFloats(1);
//            res.read(floatDataBuffer);
//            float[] array = new float[1];
//            floatDataBuffer.read(array);
//
//            float[][] array = StdArrays.array2dCopyOf(result);
//            float[][] array = new float[1][10];
//            result.copyTo(res);
//
//
//            System.out.println(res.elements(0));
//            System.out.println(res.elements(1));
//            System.out.println(res.scalars());
//            System.out.println(res.get(0, 1));
//            System.out.println(res.getFloat(0, 0));
//            System.out.println(res.getFloat(0, 1));
//            System.out.println(res.getFloat(0, 2));
//            System.out.println(res.getFloat(0, 3));
//            System.out.println(res.getFloat(0, 4));
//            System.out.println(res.getFloat(0, 5));
//            System.out.println(res.getFloat(0, 6));
//            System.out.println(res.getFloat(0, 7));
//            System.out.println(res.getFloat(0, 8));
//            System.out.println(res.getFloat(0, 9));
//            System.out.println(res.getFloat(0, 10));
//
//        }
//
//    }
//
//    public Tensor createTensor(byte[] img) {
//        float [][][] array = new float[32][32][3];
//
//        int index = 0;
//        FloatBuffer fb = FloatBuffer.allocate(32 * 32 * 3);
//        ByteBuffer fb = ByteBuffer.allocate(32 * 32 * 3);
//        ByteBuffer bb = ByteBuffer.wrap(img);
//        ByteDataBuffer bb = DataBuffers.of(img);
//
//        for(int i = 0; i < 32; i++){
//            for(int j = 0; j < 32; j++){
//                fb.put(index++, 0.5f);
//                fb.put(index++, 0.5f);
//                fb.put(index++, 0.5f);
//            }
//        }
//
//        return Tensor.of(DT_FLOAT, Shape.of(1, 32, 32 ,3), bb);
//    }
//}
//
