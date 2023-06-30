package com.market.controller.index;
import com.market.controller.*;
import com.market.dao.*;
import com.market.model.*;
import com.market.service.*;
import com.market.util.*;
import com.market.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import java.text.DecimalFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import java.text.DecimalFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@Controller
@RequestMapping("index")
public class IndexController {
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	DecimalFormat df = new DecimalFormat("#.00");
	//校园网上超市系统入口
	@RequestMapping(value = "")
	public String index(ModelMap modelMap, String childPageUrl,  HttpServletRequest request) {
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		modelMap.addAttribute("childPageUrl",childPageUrl);
		modelMap.addAttribute("login",login);
		return "index";
	}
}
