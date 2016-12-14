package com.github.maximkirko.wpserver.util;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Pavel on 04.12.2016.
 */
public class PhotoConverter {

    public BufferedImage getBufferedImagePhoto(byte[] imageInByte) throws IOException {

        InputStream in = new ByteArrayInputStream(imageInByte);
        BufferedImage bImageFromConvert = ImageIO.read(in);

        return bImageFromConvert;
    }

    public byte[] getByteArrayPhoto(BufferedImage img) throws IOException {

        byte[] imageInByte;

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(img, "png", baos);
        baos.flush();
        imageInByte = baos.toByteArray();
        baos.close();

        return imageInByte;
    }

}
