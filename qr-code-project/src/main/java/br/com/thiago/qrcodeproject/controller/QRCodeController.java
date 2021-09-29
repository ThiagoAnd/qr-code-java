package br.com.thiago.qrcodeproject.controller;

import br.com.thiago.qrcodeproject.service.QRCodeGeneratorService;
import com.google.zxing.WriterException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class QRCodeController {

    @GetMapping("/gerarStringQrCode")
    public String generateStringQrCode() throws IOException, WriterException {
        String image = QRCodeGeneratorService.generateStringQrCode();
        return "A imagem foi criada em: "+image;
    }

    @GetMapping("/gerarUrlQrCode")
    public String generateUrlQrCode() throws IOException, WriterException {
        String image = QRCodeGeneratorService.generateUrlQrCode();
        return "A imagem foi criada em: "+image;
    }

    @GetMapping("/gerarWifiQrCode")
    public String generateWifiQrCode() throws IOException, WriterException {
        String image = QRCodeGeneratorService.generateWifiQrCode();
        return "A imagem foi criada em: "+image;
    }

    @GetMapping("/gerarCallQrCode")
    public String generateCallQrCode() throws IOException, WriterException {
        String image = QRCodeGeneratorService.generateLigacaoQrCode();
        return "A imagem foi criada em: "+image;
    }
}
