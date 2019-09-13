package com.sanju.bm.errorhandler;

import lombok.Data;

/**
 * The {@code ErrorResponse} class represents response for any Exception.
 * <p>
 * Feature identifies which feature Exception Occured.
   Code uniquely defined exception
 * <p>
 * @author Sanjoy Kumer Deb
 * @since  06/10/2017.
 */
@Data
public class ErrorResponse {
    String feature;
    String code;
    String message;
}
