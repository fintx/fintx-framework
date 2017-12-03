package org.fintx.business.dao;

import org.fintx.business.entity.RequestFail;

public interface RequestFailDao {
	/**
	 * 查询所有状态为0-未处理的请求
	 * @return
	 */
  /*  public List<RequestFail> selectByStatus();*/
   /**
    * 添加一个失败的请求信息    * @param request
    * @return
    */
    public int add(RequestFail request);
  /**
   * 更新请求处理状态
   * @return
   */
  /*  public int updateStatus();*/

}
