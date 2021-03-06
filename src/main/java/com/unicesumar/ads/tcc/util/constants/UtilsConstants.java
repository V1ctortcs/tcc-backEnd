package com.unicesumar.ads.tcc.util.constants;


import org.springframework.beans.factory.annotation.Value;

public class UtilsConstants {

    /**
     * Define CORS properties
     */
    public static final String ACCESS_CONTROL_ALLOW_ORIGIN = "Access-Control-Allow-Origin";
    public static final String ACCESS_CONTROL_ALLOW_CREDENTIALS = "Access-Control-Allow-Credentials";
    public static final String ACCESS_CONTROL_ALLOW_METHODS = "Access-Control-Allow-Methods";
    public static final String ACCESS_CONTROL_ALLOW_HEADERS = "Access-Control-Allow-Headers";
    public static final String ACCESS_CONTROL_MAX_AGE = "Access-Control-Max-Age";

    /**
     * Define ValidatePasswordUtil properties
     */
    public static final String REGEX_PASSWORD = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";

    /**
     * Define PaginatorUtil properties
     */
    public static final String PAGINA_NAO_ENCONTRADA = "Pagina não Encontrada";
}
