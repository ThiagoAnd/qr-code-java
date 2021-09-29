package br.com.thiago.qrcodeproject.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class VCard {

    private String email;
    private String name;
    private String firstName;
    private String lastName;
    private String address;
    private String title;
    private String Company;
    private String phoneNumber;
    private String website;
}
