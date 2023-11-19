package com.selenium.core.enums;

public enum Config {

    BROWSER("browser"),
    BROWSERTYPE("browserType"),
    URL("url");

    private final String key;

    public String getKey() {
        return key;
    }

    Config(String key) {
        this.key = key;
    }
}
