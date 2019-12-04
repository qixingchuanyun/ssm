package com.atguigu.common.utils;

import javax.servlet.http.HttpServletRequest;

import com.github.pagehelper.PageInfo;

public class PageInfoUtil {

	public static <T> String getPageInfo(HttpServletRequest request, PageInfo<T> pageInfo) {
		String url = request.getContextPath()+"/emps/";
		
		StringBuffer sb = new StringBuffer();
		// 首页
		sb.append("<a href='" + url + "/1'>首页<a>");
		// 上一页
		if (pageInfo.isHasPreviousPage()) {
			sb.append("<a href='" + url + "/" + (pageInfo.getPageNum() - 1) + "'>上一页<a>");
			sb.append("&nbsp;&nbsp;");
		} else {
			sb.append("上一页");
			sb.append("&nbsp;&nbsp;");
		}
		// 页码
		int[] navigatepageNums = pageInfo.getNavigatepageNums();
		for (int i : navigatepageNums) {
			if (i == pageInfo.getPageNum()) {
				sb.append("<a href='" + url + "/" + i + "' style='color:green'>" + i + "<a>");
				sb.append("&nbsp;&nbsp;");
			} else {
				sb.append("<a href='" + url + "/" + i + "'>" + i + "<a>");
				sb.append("&nbsp;&nbsp;");
			}
		}
		// 下一页
		if (pageInfo.isHasNextPage()) {
			sb.append("<a href='" + url + "/" + (pageInfo.getPageNum() + 1) + "'>下一页<a>");
			sb.append("&nbsp;&nbsp;");
		} else {
			sb.append("下一页");
			sb.append("&nbsp;&nbsp;");
		}

		return sb.toString();

	}

}
