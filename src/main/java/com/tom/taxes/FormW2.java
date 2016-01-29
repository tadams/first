package com.tom.taxes;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class FormW2 implements Form {

    BigDecimal compensation;

    @Override
    public FormType getFormType() {
        return FormType.FORM_W2;
    }

}
