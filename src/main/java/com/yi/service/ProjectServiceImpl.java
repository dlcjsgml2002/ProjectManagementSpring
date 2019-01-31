package com.yi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yi.domain.ProjectVO;
import com.yi.persistence.ProjectDAO;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectDAO dao;

	@Override
	public void register(ProjectVO vo) {
		dao.register(vo);
	}

	@Override
	public void modify(ProjectVO vo) {
		dao.modify(vo);
	}

	@Override
	public void remove(int serial_number) {
		dao.remove(serial_number);
	}

	@Override
	public List<ProjectVO> list() {
		return dao.list();
	}

	@Override
	public ProjectVO read(int serial_number) {
		return dao.read(serial_number);
	}

	@Override
	public void last() {
		dao.last();
	}

}
