package com.yingjun.ssm.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yingjun.ssm.entity.Content;
import com.yingjun.ssm.service.ContentService;

@Controller
@RequestMapping("/content")
public class ContentController {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ContentService contentService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public List<Content> list(Model model, int type, Integer offset, Integer limit) {
		LOG.info("invoke----------/user/list");
		offset = offset == null ? 0 : offset;//默认展示0
		limit = limit == null ? 50 : limit;//默认展示50条
		List<Content> list = contentService.getContentList(type, offset, limit);
		model.addAttribute("userlist", list);
		return list;
	}
	
	/**
	 * 获取详情
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/id", method = RequestMethod.GET)
	public String queryById( Integer id) {
		LOG.info("invoke----------/user/list");
		//每当访问一次详情，缓存次数+1。
		contentService.addCount(id);
		Content content = contentService.queryById(id);
//		model.addAttribute("content", content);
		return "detail";
	}

}
