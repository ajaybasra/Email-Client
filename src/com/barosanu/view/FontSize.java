package com.barosanu.view;

public enum FontSize {
    SMALL,
    MEDIUM,
    LARGE;

    public static String getCssPath(FontSize fontSize){
        switch (fontSize) {
            case MEDIUM:
                return "css/fontMedium.css";
            case LARGE:
                return "css/fontBig.css";
            case SMALL:
                return "css/fontSmall.css";
            default:
                return null;
        }
    }
}

