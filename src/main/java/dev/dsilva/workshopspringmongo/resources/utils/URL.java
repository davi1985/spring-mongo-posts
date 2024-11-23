package dev.dsilva.workshopspringmongo.resources.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class URL {

    public static String decodeParams(String text) {
        return URLDecoder.decode(text, StandardCharsets.UTF_8);
    }
}
