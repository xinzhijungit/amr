package cn.xzj.amr.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.xzj.amr.dao.IActionDAO;
import cn.xzj.amr.service.IActionService;
import cn.xzj.amr.service.abs.AbstractService;
import cn.xzj.amr.vo.Action;

@Service
public class ActionServiceImpl extends AbstractService implements
		IActionService {
	@Resource
	private IActionDAO actionDAO;

	@Override
	public List<Action> listByGroups(int eid, int gid) throws Exception {
		if (!super.checkAuth(eid, 6)) {
			return null;
		}
		return this.actionDAO.findAllByGroups(gid);
	}

}
