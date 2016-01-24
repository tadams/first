package com.tom.taxes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class TaxReturn1040EZ {

    List<Form> forms = new ArrayList<>();

    private final Taxpayer taxpayer;

    public TaxReturn1040EZ(Taxpayer taxpayer,
                           Form... form) {
        this.taxpayer = taxpayer;
        this.forms = Arrays.asList(form);

        calculateTax();
    }

    private void calculateTax() {

    }

    private List<FormW2> getForm() {
        return findForm(FormType.FORM_W2);
    }

    private <T> List<T> findForm(FormType formType) {

        Class clazz = formType.getFormClass();
        return forms.stream()
                    .filter(form -> form.getFormType() == formType)
                    .map(form -> (T) clazz.cast(form))
                    .collect(toList());
    }

}
