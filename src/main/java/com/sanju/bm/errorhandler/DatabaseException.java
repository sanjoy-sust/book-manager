package com.sanju.bm.errorhandler;

import lombok.Getter;

/**
 * Created by Lenovo on 08/10/2017.
 */
@Getter
public class DatabaseException extends Exception  {
    private String code;
    private String feature;
    private String reason;

    public DatabaseException(String feature, String code, String reason) {
        super(reason);
        this.reason=reason;
        this.feature = feature;
        this.code = code;
    }
}
