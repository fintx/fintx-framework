package org.fintx.share.service;


public interface Number {

	/**
	 * @Title: getNumber
	 * @Description: 获取固定长度的序列号
	 * @param name
	 *            序列名称
	 * @param length
	 *            序列长度
	 * @return
	 */
	public String getNumber(String name, int length,String type);

	/**
	 * @Title: getNumber
	 * @Description: 获取序列号
	 * @param name
	 *            序列名称
	 * @return
	 */
	public String getNumber(String name,String type);

}
