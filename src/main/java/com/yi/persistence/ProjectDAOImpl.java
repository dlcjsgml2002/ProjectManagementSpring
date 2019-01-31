package com.yi.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yi.domain.ProjectVO;

@Repository
public class ProjectDAOImpl implements ProjectDAO {
	private static final String namespace = "com.yi.mapper.ProjectMapper";

	@Autowired
	private SqlSession sqlSession;

	@Override
	public void register(ProjectVO vo) {
		sqlSession.insert(namespace + ".register", vo);
	}

	@Override
	public void modify(ProjectVO vo) {
		sqlSession.update(namespace + ".modify", vo);
	}

	@Override
	public void remove(int serial_number) {
		sqlSession.delete(namespace + ".remove", serial_number);
	}

	@Override
	public List<ProjectVO> list() {
		return sqlSession.selectList(namespace + ".list");
	}

	@Override
	public ProjectVO read(int serial_number) {
		return sqlSession.selectOne(namespace + ".read", serial_number);
	}

	@Override
	public void last() {
		sqlSession.selectOne(namespace + ".last");
	}

}
