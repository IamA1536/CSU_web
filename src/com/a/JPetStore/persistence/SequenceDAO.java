package com.a.JPetStore.persistence;

import com.a.JPetStore.domain.extra.Sequence;

/**
 * @author A
 * Created by IamA#1536 on 2018/12/12 0:38
 */
public interface SequenceDAO {
    Sequence getSequence(Sequence sequence) throws Exception;
    void updateSequence(Sequence sequence) throws Exception;
}
