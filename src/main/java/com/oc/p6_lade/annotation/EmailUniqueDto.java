package com.oc.p6_lade.annotation;

import javax.validation.constraints.NotEmpty;

import com.oc.p6_lade.annotation.EmailUnique;

public class EmailUniqueDto {

    @NotEmpty
    @EmailUnique(value="emailFormInscription")
    private String emailFormInscription;

    public String getEmailFormInscription() {
        return emailFormInscription;
    }

    public void setEmailFormInscription(String emailFormInscription) {
        this.emailFormInscription = emailFormInscription;
    }
}
