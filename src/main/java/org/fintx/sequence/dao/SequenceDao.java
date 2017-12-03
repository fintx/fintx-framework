package org.fintx.sequence.dao;

import org.fintx.dao.BaseDao;
import org.fintx.sequence.entity.Sequence;

public interface SequenceDao extends BaseDao<Sequence> {
	
	public String getSeqValue(String seqName, int length);
	
	public String getSeqValue(String seqName);
}
