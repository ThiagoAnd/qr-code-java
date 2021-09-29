package br.com.thiago.qrcodeproject.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import lombok.experimental.UtilityClass;
import com.google.zxing.client.result.VCardResultParser;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

@UtilityClass
public class QRCodeGeneratorService {

    private final int WIDTH = 650;
    private final int HEIGHT = 650;
    private final String QR_CODE_STRING_IMAGE = "./src/main/resources/QrCodeStringImage.png";
    private final String QR_CODE_URL_IMAGE = "./src/main/resources/QrCodeUrlImage.png";
    private final String QR_CODE_WIFI_IMAGE = "./src/main/resources/QrCodeWifiImage.png";
    private final String QR_CODE_CALL_IMAGE = "./src/main/resources/QrCodeCallImage.png";
    private final String QR_CODE_VCARD_IMAGE = "./src/main/resources/QrCodeVCardImage.png";



    public  String generateStringQrCode() throws WriterException, IOException {
        var msg = "Teste de mensagem utilizando QRCode";
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(msg, BarcodeFormat.QR_CODE, WIDTH, HEIGHT);
        Path path = FileSystems.getDefault().getPath(QR_CODE_STRING_IMAGE);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
        return new File(QR_CODE_STRING_IMAGE).getAbsolutePath();
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

    public static String generateWifiQrCode() throws IOException, WriterException {
        var wifiLogin = "WIFI:T:WPA;S:NOMEREDE;P:SENHA;;";
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(wifiLogin, BarcodeFormat.QR_CODE, WIDTH, HEIGHT);
        Path path = FileSystems.getDefault().getPath(QR_CODE_WIFI_IMAGE);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
        return new File(QR_CODE_WIFI_IMAGE).getAbsolutePath();
    }

    public static String generateLigacaoQrCode() throws IOException, WriterException {
        var ligacao = " 4199771-9771\nThiago de Andrade";
        var ligacaoComum = "41997713790";
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(ligacao, BarcodeFormat.QR_CODE, WIDTH, HEIGHT);
        Path path = FileSystems.getDefault().getPath(QR_CODE_CALL_IMAGE);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
        return new File(QR_CODE_CALL_IMAGE).getAbsolutePath();
    }

    public static String generateVCardQrCode() throws IOException, WriterException {
        var ligacao = " 4199771-9771\nThiago de Andrade";
        var ligacaoComum = "41997713790";
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(ligacao, BarcodeFormat.QR_CODE, WIDTH, HEIGHT);
        Path path = FileSystems.getDefault().getPath(QR_CODE_CALL_IMAGE);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
        return new File(QR_CODE_CALL_IMAGE).getAbsolutePath();
    }
}
