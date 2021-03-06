package cn.xzj.amr.dao.impl;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import cn.xzj.amr.dao.ILevelDAO;
import cn.xzj.amr.dao.abs.AbstractDAO;
import cn.xzj.amr.vo.Level;
@Component
public class LevelDAOImpl extends AbstractDAO implements ILevelDAO {

	@Override
	public boolean doCreate(Level vo) throws Exception {
		return false;
	}

	@Override
	public boolean doUpdate(Level vo) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doRemoveBatch(Set<Integer> ids) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Level findById(Integer id) throws Exception {
		return super.getSession().selectOne("cn.xzj.amr.mapping.LevelNS.findById", id);
	}

	@Override
	public List<Level> findAll() throws Exception {
		return super.getSession().selectList("cn.xzj.amr.mapping.LevelNS.findAll");
	}

	@Override
	public List<Level> findAllSplit(String column, String keyWord,
			Integer currentPage, Integer lineSize) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getAllCount(String column, String keyWord) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
