package com.yi.persistence;

import java.util.List;

import com.yi.domain.ProjectVO;

public interface ProjectDAO {
	public void register(ProjectVO vo);

	public void modify(ProjectVO vo);

	public void remove(int serial_number);

	public List<ProjectVO> list();

	public ProjectVO read(int serial_number);

	public void last();
}
