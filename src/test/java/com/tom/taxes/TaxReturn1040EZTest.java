package com.tom.taxes;

import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;


public class TaxReturn1040EZTest {

    Taxpayer taxpayer = new Taxpayer();

    @Test
    public void shouldCalculateCompensation() {

        FormW2 firstJobFormW2 = new FormW2();
        firstJobFormW2.setCompensation(BigDecimal.valueOf(11_000.23));

        FormW2 secondJobFormW2 = new FormW2();
        secondJobFormW2.setCompensation(BigDecimal.valueOf(9_000.77));

        TaxReturn1040EZ taxReturn = new TaxReturn1040EZ(taxpayer, firstJobFormW2, secondJobFormW2);

        assertThat(taxReturn.totalCompensation()).isEqualTo(new BigDecimal("20001.00"));
    }
}