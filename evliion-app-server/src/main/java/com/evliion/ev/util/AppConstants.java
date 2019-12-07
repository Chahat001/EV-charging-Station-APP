package com.evliion.ev.util;

import java.text.DateFormatSymbols;

public interface AppConstants {
    String DEFAULT_PAGE_NUMBER = "0";
    String DEFAULT_PAGE_SIZE = "30";
    
    String[] SHORT_MONTHS = new DateFormatSymbols().getShortMonths();
    int MAX_PAGE_SIZE = 50;
}
