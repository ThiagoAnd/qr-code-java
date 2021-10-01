package br.com.thiago.qrcodeproject.util;

import lombok.experimental.UtilityClass;

import static java.lang.String.format;

@UtilityClass
public class QrCodeMapper {

    public String vCardParser(String nome,String empresa,String cargo,String telefone,String site,String email,String endereco){
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
        return format(vCardTemplate,nome,empresa,cargo,telefone,site,email,endereco);
    }

}
