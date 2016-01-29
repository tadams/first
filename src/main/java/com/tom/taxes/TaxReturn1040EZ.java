package com.tom.taxes;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

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

    protected BigDecimal totalCompensation() {
        return getW2Forms().stream()
                           .map(FormW2::getCompensation)
                           .reduce(BigDecimal.ZERO,
                                  (a,b) -> a.add(b));
    }

    private List<FormW2> getW2Forms() {
        return findForm(FormType.FORM_W2, FormW2.class::cast);
    }

    private <R> List<R> findForm(FormType formType, Function<Form, R> mapper) {
        return forms.stream()
                    .filter(form -> form.getFormType() == formType)
                    .map(mapper::apply)
                    .collect(toList());
    }

}
