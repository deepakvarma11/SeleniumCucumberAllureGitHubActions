package com.selenium.pages.interfaces;

public interface IBasePage {

    void openDispatcherPage(final String url);

    String getPageTitle();

    void pageLoaded();
}
