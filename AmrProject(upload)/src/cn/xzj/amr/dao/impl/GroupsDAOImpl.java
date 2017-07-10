package cn.xzj.amr.dao.impl;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import cn.xzj.amr.dao.IGroupsDAO;
import cn.xzj.amr.dao.abs.AbstractDAO;
import cn.xzj.amr.vo.Groups;

@Component
public class GroupsDAOImpl extends AbstractDAO implements IGroupsDAO {

	@Override
	public boolean doCreate(Groups vo) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doUpdate(Groups vo) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doRemoveBatch(Set<Integer> ids) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Groups findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Groups> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Groups> findAllSplit(String column, String keyWord,
			Integer currentPage, Integer lineSize) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getAllCount(String column, String keyWord) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Groups> findAllByDept(Integer did) throws Exception {
		return super.getSession().selectList(
				"cn.xzj.amr.mapping.GroupsNS.findAllByDept", did);
	}

}
