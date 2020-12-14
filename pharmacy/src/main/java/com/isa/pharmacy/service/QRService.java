package com.isa.pharmacy.service;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeWriter;

@Service
public class QRService {
	
	public static final String QR_CODE_IMAGE_PATH = "./MyQRCode.png";
	
	public static void generateQRCodeImage(String text, int width, int height, String filePath)
            throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

        Path path = FileSystems.getDefault().getPath(filePath);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
    }
	
	public String readQrCode(String path) throws IOException {
		
		try {
			BufferedImage bufferedImage = ImageIO.read(new FileInputStream(path));
				
			BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(
					new BufferedImageLuminanceSource(bufferedImage)));
			Result result = new MultiFormatReader().decode(bitmap);
			return result.getText();			
		}catch(NotFoundException e) {
			System.out.println("There is no QR code in the image");
            return null;
		}
			
		
	}
	
	

}
