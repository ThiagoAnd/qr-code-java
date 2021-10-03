package br.com.thiago.qrcodeproject.controller;

import br.com.thiago.qrcodeproject.service.QRCodeGeneratorService;
import com.google.zxing.WriterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * <h3>Para maiores informações sobre a lib:</h3>
 * <a href="https://github.com/zxing/zxing/wiki/Barcode-Contents">Github ZXing</a>
 */
@RestController
public class QRCodeController {

    @Autowired
    private QRCodeGeneratorService service;

    @GetMapping("/string")
    public String generateStringQrCode() throws IOException, WriterException {
        return service.generateStringQrCode();
    }

    @GetMapping("/url")
    public String generateUrlQrCode() throws IOException, WriterException {
        return service.generateUrlQrCode();
    }

    @GetMapping("/wifi")
    public String generateWifiQrCode() throws IOException, WriterException {
        return service.generateWifiQrCode();
    }

    @GetMapping("/call")
    public String generateCallQrCode() throws IOException, WriterException {
        return service.generateCallQrCode();
    }

    @GetMapping("/email")
    public String generateEmailQrCode() throws IOException, WriterException {
        return service.generateEmailQrCode();
    }

    @GetMapping("/sms")
    public String generateSmsQrCode() throws IOException, WriterException {
        return service.generateSmsQrCode();
    }

    @GetMapping("/map")
    public String generateMapQrCode() throws IOException, WriterException {
        return service.generateMapQrCode();
    }

    @GetMapping("/calendar")
    public String generateCalendarQrCode() throws IOException, WriterException {
        return service.generateCalendarQrCode();
    }

    @GetMapping("/vcard")
    public String generateVCardQrCode() throws IOException, WriterException {
        return service.generateVCardQrCode();
    }
}
