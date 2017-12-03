package org.fintx.share.service.impl;


import org.fintx.sequence.dao.SequenceDao;
import org.fintx.share.service.Sequence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class SequenceImpl implements Sequence {

	@Autowired
	public SequenceDao sequenceDao;

	@Override
	public String getSeqValue(String seqName, int length) {
		return sequenceDao.getSeqValue(seqName, length);
	}

	@Override
	public String getSeqValue(String seqName) {
		return sequenceDao.getSeqValue(seqName);
	}

}
