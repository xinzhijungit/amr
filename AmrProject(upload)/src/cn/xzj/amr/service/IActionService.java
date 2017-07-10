package cn.xzj.amr.service;

import java.util.List;

import cn.xzj.amr.vo.Action;

public interface IActionService {
	/**
	 * 根据权限组列出对应的所有权限数据 
	 * @param eid
	 * @param gid
	 * @return
	 * @throws Exception
	 */
	public List<Action> listByGroups(int eid, int gid) throws Exception;
}
