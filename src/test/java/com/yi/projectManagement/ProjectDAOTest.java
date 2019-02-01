package com.yi.projectManagement;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yi.domain.ProjectVO;
import com.yi.persistence.ProjectDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class ProjectDAOTest {
	@Autowired
	ProjectDAO dao;

	@Test
	public void test01Register() {
		ProjectVO vo = new ProjectVO();
		vo.setProject_name("프로젝트 제목");
		vo.setProject_content("프로젝트 내용");
		vo.setStart_date(new Date());
		vo.setEnd_date(new Date());
		vo.setProject_progress("준비 중");
		dao.register(vo);
	}

	@Test
	public void test02Modify() {
		ProjectVO vo = new ProjectVO();
		vo.setSerial_number(1);
		vo.setProject_name("수정된 프로젝트 제목");
		vo.setProject_content("수정된 프로젝트 내용");
		vo.setStart_date(new Date());
		vo.setEnd_date(new Date());
		vo.setProject_progress("진행 중");
		dao.modify(vo);
	}

	@Test
	public void test03Remove() {
		dao.remove(1);
	}

	@Test
	public void test04List() {
		dao.list();
	}

	@Test
	public void test05Read() {
		dao.read(2);
	}

	@Test
	public void test06Last() {
		dao.last();
	}

}
