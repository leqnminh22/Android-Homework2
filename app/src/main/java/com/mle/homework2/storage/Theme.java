package com.mle.homework2.storage;

import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;

import com.mle.homework2.R;

public enum Theme {
    ONE(R.style.Theme_Homework2, R.string.theme_one, "THEME_ONE"),
    TWO(R.style.Theme_Homework2_V2, R.string.theme_two, "THEME_TWO");

    private @StyleRes
    final int theme;

    private @StringRes
    final int title;
    private final String key;

    Theme(int theme, int title, String key) {
        this.theme = theme;
        this.title = title;
        this.key = key;
    }

    public int getTitle() {
        return title;
    }

    public String getKey() {
        return key;
    }

    public int getTheme() {
        return theme;
    }
}
