package br.com.thiago.qrcodeproject.service;

import br.com.thiago.qrcodeproject.util.QrCodeMapper;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import lombok.experimental.UtilityClass;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import static java.lang.String.format;

@UtilityClass
public class QRCodeGeneratorService {

    private final int WIDTH = 650;
    private final int HEIGHT = 650;
    private final String QR_CODE_STRING_IMAGE = "./src/main/resources/QrCodeStringImage.png";
    private final String QR_CODE_URL_IMAGE = "./src/main/resources/QrCodeUrlImage.png";
    private final String QR_CODE_WIFI_IMAGE = "./src/main/resources/QrCodeWifiImage.png";
    private final String QR_CODE_CALL_IMAGE = "./src/main/resources/QrCodeCallImage.png";
    private final String QR_CODE_EMAIL_IMAGE = "./src/main/resources/QrCodeEmailImage.png";
    private final String QR_CODE_VCARD_IMAGE = "./src/main/resources/QrCodeVCardImage.png";
    private final String QR_CODE_SMS_IMAGE = "./src/main/resources/QrCodeSmsImage.png";
    private final String QR_CODE_MAP_IMAGE = "./src/main/resources/QrCodeMapImage.png";
    private final String QR_CODE_CALENDAR_IMAGE = "./src/main/resources/QrCodeCalendarImage.png";


    public String generateStringQrCode() throws WriterException, IOException {
        var msg = "Teste de mensagem utilizando QRCode";
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(msg, BarcodeFormat.QR_CODE, WIDTH, HEIGHT);
        Path path = FileSystems.getDefault().getPath(QR_CODE_STRING_IMAGE);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
        return new File(QR_CODE_STRING_IMAGE).getAbsolutePath();
    }

    public String generateUrlQrCode() throws WriterException, IOException {
        //var urlAndroid = "https://play.google.com/store/apps/details?id=com.votorantim.bvpd&hl=pt_BR&gl=US";
        var urlIphone = "https://apps.apple.com/br/app/banco-ita%C3%BA/id474505665";

        return generateBaseQrCode(urlIphone, QR_CODE_URL_IMAGE);
    }

    public static String generateWifiQrCode() throws IOException, WriterException {
//        String EncodingString = "WIFI:S:%s;T:%s;P:%s;H:%s;";
//        EncodingString = format(EncodingString, ssid, security, password, isHidden);
        var wifiLogin = "WIFI:T:WPA;S:NOMEREDE;P:SENHA;;";

        return generateBaseQrCode(wifiLogin, QR_CODE_WIFI_IMAGE);
    }

    public static String generateCallQrCode() throws IOException, WriterException {
        var ligacaoEConteudo = " 4199771-9771\nThiago de Andrade";
        //var ligacaoComum = "41997713790";

        return generateBaseQrCode(ligacaoEConteudo, QR_CODE_CALL_IMAGE);
    }

    /**
     * Subject: Assunto
     * CC: Carbon Copy(copia para alguem)
     * BCC: Blind Carbon Copy (copia invisivel para alguem)
     * Body: Corpo do email
     */
    public static String generateEmailQrCode() throws IOException, WriterException {

        //String emailSimples = "mailto:s4lezardv@gmail.com";
        String emailEAssunto = "mailto:thiago@gmail.com?subject=Assunto do email aqui";
        //String emailEAssuntoECCEBCC = "mailto:thiago@gmail.com?cc=pedro@gmail.com,rodrigo@outlook.com&bcc=emailescondido@gmail.comm&subject=Assunto do email aqui";
        //String emailEAssuntoECCEBCCECorpo = "mailto:thiago@gmail.com?cc=pedro@gmail.com,rodrigo@outlook.com&bcc=emailescondido@gmail.comm&subject=Assunto do email aqui&body=<h1>Corpo do email</h1><br>Aqui aceita <strong>HTML</strong>";

        return generateBaseQrCode(emailEAssunto, QR_CODE_EMAIL_IMAGE);
    }

    public static String generateSmsQrCode() throws IOException, WriterException {
//        String EncodingString = "smsto:%s:%s";
//        EncodingString = format(EncodingString, PhoneNumber, Text);
        String smsSimples = "sms:+5541997710000";
        //Este exemplo não funciona. Verificar String smsETexto = "sms:+18005551212:This%20is%20my%20text%20message.";

        return generateBaseQrCode(smsSimples, QR_CODE_SMS_IMAGE);
    }

    /**
     * Existem mais parametros para cada tipo de celular com ios ou android
     * latitude,longitude,distancia de zoom (testar um pouco melhor)
     */
    public static String generateMapQrCode() throws IOException, WriterException {
        String mapaSimples = "geo:40.71872,-73.98905,100";
        return generateBaseQrCode(mapaSimples, QR_CODE_MAP_IMAGE);
    }

    public static String generateCalendarQrCode() throws IOException, WriterException {
        String evento = "BEGIN:VEVENT\n"
                + "SUMMARY:%s\n"
                + "DTSTART:%s\n"
                + "DTEND:%s\n"
                + "LOCATION:%s\n"
                + "DESCRIPTION:%s\n"
                + "END:VEVENT";

        String x = "BEGIN:VCALENDAR\n" +
                "VERSION:1.0\n" +
                "BEGIN:VEVENT\n" +
                "CATEGORIES:MEETING\n" +
                "STATUS:TENTATIVE\n" +
                "DTSTART:19960401T033000Z\n" +
                "DTEND:19960401T043000Z\n" +
                "SUMMARY:Your Proposal Review\n" +
                "DESCRIPTION:Steve and John to review newest proposal material\n" +
                "CLASS:PRIVATE\n" +
                "END:VEVENT\n" +
                "END:VCALENDAR";




        String calendar = "BEGIN:VALARM;" +
                "TRIGGER:-PT1440M;" +
                "ACTION:DISPLAY;" +
                "DESCRIPTION:Reminder;" +
                "END:VALARM";
        return generateBaseQrCode(x, QR_CODE_CALENDAR_IMAGE);
    }

    public static String generateVCardQrCode() throws IOException, WriterException {

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
}
