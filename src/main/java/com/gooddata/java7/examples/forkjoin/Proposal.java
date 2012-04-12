/**
 * Copyright (C) 2007-2012, GoodData(R) Corporation. All rights reserved.
 */
package com.gooddata.java7.examples.forkjoin;

@SuppressWarnings("unused")
public class Proposal {

    private final String vorname;
    private final String nachname;
    private final String hsn;
    private final String tsn;
    private final boolean comprehensive;
    private final boolean partInsuranceCover;
    private final boolean automotiveLiability;

    public Proposal(String vorname, String nachname, String hsn, String tsn, boolean comprehensive,
            boolean partInsuranceCover, boolean automotiveLiability) {
        super();
        this.vorname = vorname;
        this.nachname = nachname;
        this.hsn = hsn;
        this.tsn = tsn;
        this.comprehensive = comprehensive;
        this.partInsuranceCover = partInsuranceCover;
        this.automotiveLiability = automotiveLiability;
    }

    public boolean multipleCovers() {
        return ((isAutomotiveLiability() ? 1 : 0) + (isComprehensive() ? 1 : 0) + (isPartInsuranceCover() ? 1 : 0)) > 1;
    }

    public boolean isComprehensive() {
        return comprehensive;
    }

    public boolean isPartInsuranceCover() {
        return partInsuranceCover;
    }

    public boolean isAutomotiveLiability() {
        return automotiveLiability;
    }

    public String getHsn() {
        return hsn;
    }

    public String getTsn() {
        return tsn;
    }
}