package com.tom.taxes;

public enum FormType {
    FORM_W2(FormW2.class),
    FORM_1099(Form1099.class);

    final Class formClass;

    FormType(Class formClass) {
        this.formClass = formClass;
    }

    public Class getFormClass() {
        return formClass;
    }
}
