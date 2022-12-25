package com.epam.tc.hw4;

import io.qameta.allure.Attachment;

public class AttachmentClass {

    @Attachment(type = "image/jpg", value = "parameter: {name}")
    public static byte[] attachScreenshot(String name, byte[] source) {
        return source;
    }

}
