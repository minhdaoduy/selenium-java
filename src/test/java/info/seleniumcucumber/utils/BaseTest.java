package info.seleniumcucumber.utils;

import info.seleniumcucumber.utils.dataproviders.*;

public interface BaseTest {
    NavigateMethodsByElement navigationObj = new NavigateMethodsByElement();
    ClickElementsMethodsByElement clickObj = new ClickElementsMethodsByElement();
    InputMethodsByElement inputObj = new InputMethodsByElement();
    ConfigFileReader configFileReader = new ConfigFileReader();
}
