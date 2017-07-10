package cn.xzj.amr.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.xzj.amr.dao.IGroupsDAO;
import cn.xzj.amr.service.IGroupsService;
import cn.xzj.amr.service.abs.AbstractService;
import cn.xzj.amr.vo.Groups;

@Service
public class GroupsServiceImpl extends AbstractService implements
		IGroupsService {
	@Resource
	private IGroupsDAO groupsDAO;

	@Override
	public List<Groups> listByDept(int eid, int did) throws Exception {
		if (!super.checkAuth(eid, 6)) {
			return null;
		}
		return this.groupsDAO.findAllByDept(did);
	}

}
