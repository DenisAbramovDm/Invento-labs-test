package com.denisabramov.postings.service.converter;

import com.opencsv.bean.AbstractBeanField;

public class BooleanToLowerCaseConverter extends AbstractBeanField {
    public BooleanToLowerCaseConverter() {
    }

    @Override
    protected Object convert(String value) {
        return Boolean.parseBoolean(value.trim());
    }
}
