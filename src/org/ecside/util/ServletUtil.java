package org.ecside.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ecside.core.ECSideConstants;
import org.ecside.core.TableConstants;

public class ServletUtil {

	public static void writeDefaultTextToClient(Map parameterMap,
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.flush();
		out.println((String) request
				.getAttribute(ECSideConstants.C_UPDATE_RESULT_CODE));
		out.println((String) parameterMap.get(TableConstants.RECORDKEY_NAME));
		out.print(String.valueOf(request
				.getAttribute(ECSideConstants.C_UPDATE_RESULT_MESSAGE)));
		out.flush();
		out.close();
	}

	public static Map getParameterMap(HttpServletRequest request) {
		Map parameterMap = new HashMap();
		Enumeration names = request.getParameterNames();
		while (names.hasMoreElements()) {
			String name = (String) names.nextElement();
			String[] s = request.getParameterValues(name);
			if (s != null) {
				if (s.length == 1) {
					parameterMap.put(name, request.getParameterValues(name)[0]);
				} else {
					parameterMap.put(name, request.getParameterValues(name));
				}
			}
		}
		return parameterMap;
	}

	public static Object getAttributeFromMapList(ServletRequest request,
			String para) {
	
		String[] paras = para.split("\\.");
		String listName = null;
		int idx = 0;
		String propertyname = null;
		if (paras.length > 2) {
			listName = paras[0];
			try {
				idx = Integer.parseInt(paras[1]);
			} catch (Exception e) {
				idx = 0;
			}
			propertyname = paras[2];
		}
	
		List recordList = (List) request.getAttribute(listName);
		if (recordList != null && recordList.size() > idx) {
			Map map = (Map) recordList.get(idx);
			return map != null ? map.get(propertyname) : null;
		}
		return null;
	}



}
