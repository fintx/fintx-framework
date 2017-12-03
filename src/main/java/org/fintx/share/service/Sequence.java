package org.fintx.share.service;


public interface Sequence {

	/**
	 * @Title: getSeqValue
	 * @Description: 获取固定长度的序列号
	 * @param seqName
	 *            序列名称
	 * @param length
	 *            序列长度
	 * @return
	 */
	public String getSeqValue(String seqName, int length/*,String tableName*/);

	/**
	 * @Title: getSeqValue
	 * @Description: 获取序列号
	 * @param seqName
	 *            序列名称
	 * @return
	 */
	public String getSeqValue(String seqName/*,String tableName*/);

}
