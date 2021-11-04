package br.com.thiago.qrcodeproject.service;

import br.com.thiago.qrcodeproject.util.QrCodeMapper;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Service
public class QRCodeGeneratorService {

    private static final int WIDTH = 650;
    private static final int HEIGHT = 650;
    private static final String QR_CODE_STRING_IMAGE = "./src/main/resources/QrCodeStringImage.png";
    private static final String QR_CODE_URL_IMAGE = "./src/main/resources/QrCodeUrlImage.png";
    private static final String QR_CODE_WIFI_IMAGE = "./src/main/resources/QrCodeWifiImage.png";
    private static final String QR_CODE_CALL_IMAGE = "./src/main/resources/QrCodeCallImage.png";
    private static final String QR_CODE_EMAIL_IMAGE = "./src/main/resources/QrCodeEmailImage.png";
    private static final String QR_CODE_VCARD_IMAGE = "./src/main/resources/QrCodeVCardImage.png";
    private static final String QR_CODE_SMS_IMAGE = "./src/main/resources/QrCodeSmsImage.png";
    private static final String QR_CODE_MAP_IMAGE = "./src/main/resources/QrCodeMapImage.png";
    private static final String QR_CODE_CALENDAR_IMAGE = "./src/main/resources/QrCodeCalendarImage.png";


    public String generateStringQrCode() throws WriterException, IOException {
        String msg = "Me add no github galera!!! ThiagoAnd";
        return generateBaseQrCode(msg, QR_CODE_STRING_IMAGE);
    }

    public String generateUrlQrCode() throws WriterException, IOException {
        String urlIphone = "https://apps.apple.com/br/app/banco-ita%C3%BA/id474505665";
        return generateBaseQrCode(urlIphone, QR_CODE_URL_IMAGE);
    }

    public String generateWifiQrCode() throws IOException, WriterException {
        String wifi = QrCodeMapper.wifiParser("WPA", "NomeDaRede", "Senha", false);
        return generateBaseQrCode(wifi, QR_CODE_WIFI_IMAGE);
    }

    public String generateCallQrCode() throws IOException, WriterException {
        String call = "Thiago de Andrade\n\n+5541997719771";
        return generateBaseQrCode(call, QR_CODE_CALL_IMAGE);
    }

    public String generateEmailQrCode() throws IOException, WriterException {
        String simpleEmail = QrCodeMapper.simpleEmailParser("s4lezardv@gmail.com");
        String normalEmail = QrCodeMapper.normalEmailParser("s4lezardv@gmail.com", "Assunto do email", "<h1>Inicio do email</h1><br><p>paragrafo do email</p>");
        String fowardEmail = QrCodeMapper.fowardEmailParser("s4lezardv@gmail.com", "email1@gmail.com", "email2@gmail.com", "emailOculto@gmail.com");
        return generateBaseQrCode(normalEmail, QR_CODE_EMAIL_IMAGE);
    }

    public String generateSmsQrCode() throws IOException, WriterException {
        String sms = QrCodeMapper.smsParser("+5541997719771", "Texto de exemplo");
        return generateBaseQrCode(sms, QR_CODE_SMS_IMAGE);
    }

    public String generateMapQrCode() throws IOException, WriterException {
        String map = QrCodeMapper.mapParser("25.48766", "-73.98905", "100");
        return generateBaseQrCode(map, QR_CODE_MAP_IMAGE);
    }

    public String generateCalendarQrCode() throws IOException, WriterException {
        String event = QrCodeMapper.simpleCalendarParser("Reunião", "Descrição", dateFormat("04/07/2023", "14:29"), dateFormat("04/07/2023", "15:47"));
        return generateBaseQrCode(event, QR_CODE_CALENDAR_IMAGE);
    }

    public String generateVCardQrCode() throws IOException, WriterException {
        String vCard = QrCodeMapper.vCardParser("Thiago Andrade", "Google",
                "Desenvolvedor", "+5541997719771",
                "github/thiagoand", "s4lezardv@gmail.com",
                "Rua Medico, numero 248,Curitiba,Parana");
        return generateBaseQrCode(vCard, QR_CODE_VCARD_IMAGE);
    }

    private String generateBaseQrCode(String conteudo, String arquivo) throws IOException, WriterException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(conteudo, BarcodeFormat.QR_CODE, WIDTH, HEIGHT);
        Path path = FileSystems.getDefault().getPath(arquivo);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
        return new File(arquivo).getAbsolutePath();
    }

    private String dateFormat(String dia, String hora) {
        var data = LocalDateTime.of(LocalDate.parse(dia, DateTimeFormatter.ofPattern("dd/MM/yyyy")), LocalTime.parse(hora, DateTimeFormatter.ofPattern("HH:mm")));
        return data.format(DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmmss"));
    }
}
