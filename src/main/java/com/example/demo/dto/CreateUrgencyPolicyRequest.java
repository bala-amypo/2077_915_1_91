package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;

public class CreateUrgencyPolicyRequest {

    @NotBlank
    private String policyName;

    @NotBlank
    private String keyword;

    @NotBlank
    private String urgencyOverride;

    public String getPolicyName() {
        return policyName;
    }

    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getUrgencyOverride() {
        return urgencyOverride;
    }

    public void setUrgencyOverride(String urgencyOverride) {
        this.urgencyOverride = urgencyOverride;
    }
}
