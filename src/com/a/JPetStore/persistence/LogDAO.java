package com.a.JPetStore.persistence;

import com.a.JPetStore.domain.extra.Log;

/**
 * @author A
 * Created by IamA#1536 on 2018/12/14 14:38
 */
public interface LogDAO {
    void InsertLog(Log log) throws Exception;
}
