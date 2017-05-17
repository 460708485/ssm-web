package com.yingjun.ssm.web;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yingjun.ssm.entity.Content;
import com.yingjun.ssm.entity.Title;
import com.yingjun.ssm.service.ContentService;
import com.yingjun.ssm.service.TitleService;

@Controller
@RequestMapping("/title")
public class TitleController {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private TitleService titleService;
	@Resource
	private ContentService contentService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model, Integer offset, Integer limit) {
		LOG.info("invoke----------/user/list");
		offset = offset == null ? 0 : offset;//默认便宜0
		limit = limit == null ? 50 : limit;//默认展示50条
		List<Title> list = titleService.getTitleList(offset, limit);
		
		List<Content> contentLists=contentService.getContentList(null, offset, limit);
		model.addAttribute("titlelist", list);
		model.addAttribute("contentList", contentLists);
		return "userlist";
	}

}
