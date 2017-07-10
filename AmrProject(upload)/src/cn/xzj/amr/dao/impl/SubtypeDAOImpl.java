package cn.xzj.amr.dao.impl;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import cn.xzj.amr.dao.ISubtypeDAO;
import cn.xzj.amr.dao.abs.AbstractDAO;
import cn.xzj.amr.vo.Subtype;

@Component
public class SubtypeDAOImpl extends AbstractDAO implements ISubtypeDAO {

	@Override
	public boolean doCreate(Subtype vo) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doUpdate(Subtype vo) throws Exception {
		return super.getSession().update(
				"cn.mldn.amr.mapping.SubtypeNS.doUpdate", vo) > 0;
	}

	@Override
	public boolean doRemoveBatch(Set<Integer> ids) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Subtype findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Subtype> findAll() throws Exception {
		return null ;
	}

	@Override
	public List<Subtype> findAllSplit(String column, String keyWord,
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
	public List<Subtype> findAllByType(Integer tid) throws Exception {
		return super.getSession().selectList(
				"cn.mldn.amr.mapping.SubtypeNS.findAllByType",tid);
	}


}
