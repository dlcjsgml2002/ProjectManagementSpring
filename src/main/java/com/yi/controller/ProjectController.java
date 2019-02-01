package com.yi.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.yi.domain.ProjectVO;
import com.yi.service.ProjectService;

@Controller
@RequestMapping("/project/*")
public class ProjectController {
	private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);

	@Autowired
	private ProjectService service;

	@RequestMapping(value = "register", method = RequestMethod.GET)
	public void registerGet(Model model) {
		logger.info("register ----- get");
	}

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String registerPost(ProjectVO vo, Model model) {
		logger.info("register ----- post");
		service.register(vo);

		return "redirect:/project/list";
	}

	@RequestMapping(value = "modify", method = RequestMethod.GET)
	public void modifyGet(int serial_number, Model model) {
		logger.info("modify ----- get");
		ProjectVO vo = service.read(serial_number);
		model.addAttribute("ProjectVO", vo);
	}

	@RequestMapping(value = "modify", method = RequestMethod.POST)
	public String modifyPost(ProjectVO vo) {
		logger.info("modify ----- post");
		System.out.println(vo);
		service.modify(vo);

		return "redirect:/project/read?serial_number=" + vo.getSerial_number();
	}

	@RequestMapping(value = "remove", method = RequestMethod.POST)
	public String remove(int serial_number) {
		logger.info("remove ----- post");
		service.remove(serial_number);

		return "redirect:/project/list";
	}

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void list(Model model) {
		logger.info("list");
		List<ProjectVO> list = service.list();
		model.addAttribute("list", list);
		logger.info("list = " + list);
	}

	@RequestMapping(value = "read", method = RequestMethod.GET)
	public void read(@RequestParam("serial_number") int serial_number, Model model) {
		logger.info("read ----- get");
		ProjectVO vo = service.read(serial_number);
		model.addAttribute("ProjectVO", vo);
	}
}
