package br.com.thiago.qrcodeproject.util;

import lombok.experimental.UtilityClass;

import static java.lang.String.format;

/**
 * Classe responsavel por mapear os atributos fornecidos para uma string que será reconhecida no QRCode
 */
@UtilityClass
public class QrCodeMapper {

    public String wifiParser(String ssid, String seguranca, String password, Boolean estaEscondido) {
        String wifiTemplate = "WIFI:S:%s;T:%s;P:%s;H:%s;";
        return format(wifiTemplate, ssid, seguranca, password, estaEscondido);
    }

    public String simpleEmailParser(String email) {
        String simpleEmailTemplate = "MAILTO:%s";
        return format(simpleEmailTemplate, email);
    }

    public String normalEmailParser(String email, String assunto) {
        String normalEmailTemplate = "MAILTO:%s?SUBJECT=%s";
        return format(normalEmailTemplate, email, assunto);
    }

    //TODO Fazer o compostEmail e o compostComCorpo. Precisa tratar o array.
    public String compostEmailParser(String, email, String[] copia, String copiaEscondida, String assunto) {
        String compostEmailParser = "MAILTO:%s?CC=";
        //String emailEAssuntoECCEBCC = "mailto:thiago@gmail.com?cc=pedro@gmail.com,rodrigo@outlook.com&bcc=emailescondido@gmail.comm&subject=Assunto do email aqui";

    }

    public String smsParser(String fone, String texto) {
        String EncodingString = "SMSTO:%s:%s";
        return format(EncodingString, fone, texto);
    }

    public String vCardParser(String nome, String empresa, String cargo, String telefone, String site, String email, String endereco) {
        String vCardTemplate = "BEGIN:VCARD\n"
                + "VERSION:4.0\n"
                + "N:%s\n"
                + "ORG:%s\n"
                + "TITLE:%s\n"
                + "TEL:%s\n"
                + "URL:%s\n"
                + "EMAIL:%s\n"
                + "ADR:%s\n"
                + "END:VCARD\n";
        return format(vCardTemplate, nome, empresa, cargo, telefone, site, email, endereco);
    }


}
