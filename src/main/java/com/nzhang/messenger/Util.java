package com.nzhang.messenger;

import javafx.scene.image.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.IntBuffer;

public class Util {

    public static byte[] imageToBytes(File imgPath) throws IOException {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(ImageIO.read(imgPath), "png", baos);
        return baos.toByteArray();

    }

    public static Image bytesToImage(byte[] bytes) throws IOException {

        BufferedImage image = ImageIO.read(new ByteArrayInputStream(bytes));

        WritableImage wr = null;
        if (image != null) {
            wr = new WritableImage(image.getWidth(), image.getHeight());
            PixelWriter pw = wr.getPixelWriter();
            for (int x = 0; x < image.getWidth(); x++) {
                for (int y = 0; y < image.getHeight(); y++) {
                    pw.setArgb(x, y, image.getRGB(x, y));
                }
            }
        }
        return wr;
    }
}
