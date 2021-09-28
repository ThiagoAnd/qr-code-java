package br.com.thiago.qrcodeproject.controller;

import br.com.thiago.qrcodeproject.service.QRCodeGeneratorService;
import com.google.zxing.WriterException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class QRCodeController {

    private static final String QR_CODE_IMAGE_PATH = "./src/main/resources/QdddRCode.png";


    @GetMapping(value = "/genrateAndDownloadQRCode/{codeText}/{width}/{height}")
    public void download(
            @PathVariable("codeText") String codeText,
            @PathVariable("width") Integer width,
            @PathVariable("height") Integer height) throws IOException, WriterException {
       // codeText ="https://apps.apple.com/br/app/banco-bv/id1494202346";
        //codeText = "https://play.google.com/store/apps/details?id=com.votorantim.bvpd&hl=pt_BR&gl=US";
       // codeText="https://apps.apple.com/br/app/banco-ita%C3%BA/id474505665";
        codeText ="Testandooo";
        QRCodeGeneratorService.generateQRCodeImage(codeText, width, height, QR_CODE_IMAGE_PATH);
    }

    @GetMapping(value = "/genrateQRCode/{codeText}/{width}/{height}")
    public ResponseEntity<byte[]> generateQRCode(
            @PathVariable("codeText") String codeText,
            @PathVariable("width") Integer width,
            @PathVariable("height") Integer height) throws IOException, WriterException {
        return ResponseEntity.status(HttpStatus.OK).body(QRCodeGeneratorService.getQRCodeImage(codeText, width, height));
    }

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
}
