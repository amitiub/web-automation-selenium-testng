package com.amit.portfolio.utils;

import java.util.UUID;

public final class TestData {
    private TestData() {}

    public static String uniqueEmail() {
        return "amit.das+" + UUID.randomUUID().toString().substring(0, 8) + "@automationconsultant.com";
    }
}
