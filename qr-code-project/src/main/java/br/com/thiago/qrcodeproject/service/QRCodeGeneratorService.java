package br.com.thiago.qrcodeproject.service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import lombok.experimental.UtilityClass;

@UtilityClass
public class QRCodeGeneratorService {

    private final int WIDTH = 650;
    private final int HEIGHT = 650;
    private final String QR_CODE_STRING_IMAGE = "./src/main/resources/QrCodeStringImage.png";
    private final String QR_CODE_URL_IMAGE = "./src/main/resources/QrCodeUrlImage.png";



    public  String generateStringQrCode() throws WriterException, IOException {
        var msg = "Teste de mensagem utilizando QRCode";
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(msg, BarcodeFormat.QR_CODE, WIDTH, HEIGHT);
        Path path = FileSystems.getDefault().getPath(QR_CODE_STRING_IMAGE);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
        return new File(QR_CODE_STRING_IMAGE).getAbsolutePath();
    }

    public  void generateQRCodeImage(String text, int width, int height, String filePath)
            throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

        Path path = FileSystems.getDefault().getPath(filePath);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);

    }


    public  byte[] getQRCodeImage(String text, int width, int height) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
        byte[] pngData = pngOutputStream.toByteArray();
        return pngData;
    }

    public  String generateUrlQrCode() throws WriterException, IOException {
        var urlAndroid = "https://play.google.com/store/apps/details?id=com.votorantim.bvpd&hl=pt_BR&gl=US";
        var urlIphone = "https://apps.apple.com/br/app/banco-ita%C3%BA/id474505665";
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(urlIphone, BarcodeFormat.QR_CODE, WIDTH, HEIGHT);
        Path path = FileSystems.getDefault().getPath(QR_CODE_URL_IMAGE);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
        return new File(QR_CODE_URL_IMAGE).getAbsolutePath();
    }
}
