package com.bittiger.AdsSearch.utils;

import org.springframework.dao.DataAccessException;

public class MongoDaoException extends DataAccessException {

    private static final long serialVersionUID = -5570491428171475848L;

    public MongoDaoException(String msg) {
        super(msg);
    }

}
