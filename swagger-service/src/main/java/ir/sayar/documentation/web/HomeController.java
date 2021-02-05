package ir.sayar.documentation.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author yaqub
 *
 */
@Controller
public class HomeController {

	@RequestMapping(value = "/")
	public String index() {
		return "redirect:swagger-ui.html";
	}
}