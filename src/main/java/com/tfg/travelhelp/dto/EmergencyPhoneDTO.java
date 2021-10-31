package com.tfg.travelhelp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class EmergencyPhoneDTO {
    private long id;
    private String phoneNumber;
    private String service;
    private long idCountry;
}
