package com.example.paketproduct.model;

public class Rule {

    private final String premise1;
    private final String premise2;
    private final String conclusion;
    private final Double confidance;
    private final String description;

    public Rule(RuleBuilder builder) {
        this.premise1 = builder.premise1;
        this.premise2 = builder.premise2;
        this.conclusion = builder.conclusion;
        this.confidance = builder.confidance;
        this.description = builder.description;
    }

    public String getPremise1() {
        return premise1;
    }

    public String getPremise2() {
        return premise2;
    }

    public String getConclusion() {
        return conclusion;
    }

    public Double getConfidance() {
        return confidance;
    }

    public String getDescription() {
        return description;
    }

    public static class RuleBuilder{
        private final String premise1;
        private String premise2;
        private final String conclusion;
        private final Double confidance;
        private final String description;

        public RuleBuilder(String premise1, String conclusion, Double confidance, String description) {
            this.premise1 = premise1;
            this.conclusion = conclusion;
            this.confidance = confidance;
            this.description = description;
        }

        public RuleBuilder premise2(String premise2){
            this.premise2 = premise2;
            return this;
        }

        public Rule build(){
            Rule rule = new Rule(this);
            return rule;
        }
    }

}
