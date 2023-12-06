package org.tacc.green1.model.pages.catalog;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.tacc.green1.model.base.Component;
import org.tacc.green1.util.XPath;

import java.util.List;

public class SortDropdown extends Component implements XPath.SortDropdown {
    @FindBy(xpath = SORT_DROPDOWN)
    private WebElement sortDropdown;

    @FindAll(
            @FindBy(xpath = SORT_OPTIONS)
    )
    private List<WebElement> sortDropdownOptions;

    void chooseOption(String optionValue) {
        WebElement chosenOption = sortDropdownOptions.stream()
                .filter(option -> option.getText().equals(optionValue))
                .toList()
                .get(0);

        chosenOption.click();
    }
}
