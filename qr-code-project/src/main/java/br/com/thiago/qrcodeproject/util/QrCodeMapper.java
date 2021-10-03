package br.com.thiago.qrcodeproject.util;

import lombok.experimental.UtilityClass;

import static java.lang.String.format;

@UtilityClass
public class QrCodeMapper {

    public String wifiParser(String seguranca, String ssid, String password, Boolean estaEscondido) {
        String wifiTemplate = "WIFI:T:%s;S:%s;P:%s;H:%s;";
        return format(wifiTemplate, seguranca, ssid, password, estaEscondido);
    }

    public String simpleEmailParser(String email) {
        String simpleEmailTemplate = "MAILTO:%s";
        return format(simpleEmailTemplate, email);
    }

    public String normalEmailParser(String email, String assunto,String corpo) {
        String normalEmailTemplate = "MAILTO:%s?SUBJECT=%s&BODY=%s";
        return format(normalEmailTemplate, email, assunto,corpo);
    }

    public String fowardEmailParser(String email, String copia1, String copia2, String copiaOculta){
        String mixedEmailTemplate = "MAILTO:%s?CC=%s,%s&BCC=%s";
        return format(mixedEmailTemplate, email,copia1,copia2,copiaOculta);
    }

    public String smsParser(String fone, String texto) {
        String EncodingString = "SMSTO:%s:%s";
        return format(EncodingString, fone, texto);
    }

    public String mapParser(String latitude,String longitude,String distancia){
        String mapTemplate = "GEO:%s,%s,%s";
        return format(mapTemplate, latitude,longitude,distancia);
    }

    public String simpleCalendarParser(String titulo,String descricao,String inicio,String fim){

        String simpleCalendarTemplate = "BEGIN:VEVENT\n" +
                                            "SUMMARY:%s\n" +
                                            "DESCRIPTION:%s\n"+
                                            "DTSTART:%s\n" +
                                            "DTEND:%s\n" +
                                        "END:VEVENT\n";

        return format(simpleCalendarTemplate,titulo,descricao,inicio,fim);

    }

    public String multiCalendarParser(String titulo,String descricao,String inicio,String fim){
        String evento = "BEGIN:VEVENT\n" +
                "SUMMARY:Testando o titulo dddo calendario\n" +
                "DESCRIPTION:Teste de descrição de calendario\n"+
                "CLASS:PRIVATE\n" +
                "CATEGORIES:MEETING\n" +
                "ORGANIZER:mailto:jane_doe@example.com\n" +
                "ATTENDEE:mailto:john_public@example.com\n"+
                "URL:http://github/thiagoand\n"+
                "DTSTART:20180601T070000Z\n" +
                "DTEND:20180831T070000Z\n" +
                "END:VEVENT\n";
        return null;
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
