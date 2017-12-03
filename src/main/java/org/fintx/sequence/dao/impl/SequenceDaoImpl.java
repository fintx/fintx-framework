package org.fintx.sequence.dao.impl;


import java.util.List;

import org.fintx.sequence.dao.SequenceDao;
import org.fintx.sequence.dao.mapper.SequenceMapper;
import org.fintx.sequence.entity.Sequence;
import org.fintx.util.Strings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class SequenceDaoImpl implements SequenceDao {
	@Autowired
	public SequenceMapper sequenceMapper;
	@Override
	public boolean save(Sequence record) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Sequence get(Sequence record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int remove(Sequence record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modify(Sequence record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Sequence> listAll(Sequence record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int saveAll(List<Sequence> records) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getSeqValue(String seqName, int length) {
		return Strings.leftPad(getSeqValue(seqName), length, "0");

	}

	@Override
	public String getSeqValue(String seqName) {
		return sequenceMapper.selectNextValueByName(seqName);
	}
}
