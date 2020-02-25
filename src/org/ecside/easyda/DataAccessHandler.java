package org.ecside.easyda;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ecside.core.ECSideConstants;
import org.ecside.util.RequestUtil;
import org.ecside.util.ServletUtil;

public class DataAccessHandler {
	

	
	public void exportList(DataExportModel dataAccessModel,String sqlName,String type,
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (dataAccessModel == null){
			return;
		}

		DataAccessInterceptor dataAccessInterceptor=dataAccessModel.getInterceptor(sqlName);
		Map parameterMap=ServletUtil.getParameterMap(request);
		if (dataAccessInterceptor!=null) {
			dataAccessInterceptor.before(parameterMap,request, response);
		}
		dataAccessModel.doExport(sqlName,type, parameterMap,response.getOutputStream());
		
		if (dataAccessInterceptor!=null) {
			dataAccessInterceptor.after(parameterMap,request, response);
		}
	}
	
	public void dataAccess(DataAccessModel dataAccessModel,String sqlName,
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		if (dataAccessModel==null){
			return ;
		}
			
		DataAccessInterceptor dataAccessInterceptor=dataAccessModel.getInterceptor(sqlName);
		Map parameterMap=ServletUtil.getParameterMap(request);
		if (dataAccessInterceptor!=null) {
			dataAccessInterceptor.before(parameterMap,request, response);
		}
		Object result=dataAccessModel.executeSql(sqlName, parameterMap);
		
		if (result instanceof List){
			request.setAttribute(ECSideConstants.TABLE_RECORDS_KEY, result);
		}else if (result instanceof Map){
			request.setAttribute(ECSideConstants.TABLE_RECORD_KEY, result);
		}else if(result instanceof Integer){
			if ( ((Integer)result).intValue()>0 ){
				request.setAttribute(ECSideConstants.C_UPDATE_RESULT_CODE, RequestUtil.successfulInfo(request));
			}else{
				request.setAttribute(ECSideConstants.C_UPDATE_RESULT_CODE, RequestUtil.failedInfo(request));
			}
		}
		
		
		if (dataAccessInterceptor!=null) {
			dataAccessInterceptor.after(parameterMap,request, response);
		}
	}

	   
}
