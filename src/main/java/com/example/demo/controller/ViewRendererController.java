package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * This spring mvc rest controller is responsible for rendering the different
 * front end views created in this project
 * 
 * @author Suresh Chinnaswamy
 *
 */

@Controller
public class ViewRendererController {
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home() {
		return "index";
	}

	@RequestMapping(value = "/vehiclefinance", method = RequestMethod.GET)
	public String getMainView() {
		return "main";
	}
}
