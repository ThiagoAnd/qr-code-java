package br.com.thiago.qrcodeproject.controller;

import br.com.thiago.qrcodeproject.service.QRCodeGeneratorService;
import com.google.zxing.WriterException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * https://github.com/zxing/zxing/wiki/Barcode-Contents
 */
@RestController
public class QRCodeController {

    @GetMapping("/string")
    public String generateStringQrCode() throws IOException, WriterException {
        return QRCodeGeneratorService.generateStringQrCode();
    }

    @GetMapping("/url")
    public String generateUrlQrCode() throws IOException, WriterException {
        return QRCodeGeneratorService.generateUrlQrCode();
    }

    @GetMapping("/wifi")
    public String generateWifiQrCode() throws IOException, WriterException {
        return QRCodeGeneratorService.generateWifiQrCode();
    }

    @GetMapping("/call")
    public String generateCallQrCode() throws IOException, WriterException {
        return QRCodeGeneratorService.generateCallQrCode();
    }

    @GetMapping("/email")
    public String generateEmailQrCode() throws IOException, WriterException {
        return QRCodeGeneratorService.generateEmailQrCode();
    }

    @GetMapping("/sms")
    public String generateSmsQrCode() throws IOException, WriterException {
        return QRCodeGeneratorService.generateSmsQrCode();
    }

    @GetMapping("/map")
    public String generateMapQrCode() throws IOException, WriterException {
        return QRCodeGeneratorService.generateMapQrCode();
    }
}
