package org.ecside.easylist;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.ecside.core.ECSideConstants;
import org.ecside.core.TableConstants;
import org.ecside.easyda.DataAccessHandler;
import org.ecside.util.RequestUtil;
import org.ecside.util.ServletUtil;

public class EasyDataAccessHandler extends DataAccessHandler {


	
	public void easyList(HttpServletRequest request,
			HttpServletResponse response, AbstractEasyListModel easyListModel)
			throws ServletException, IOException {

		if (easyListModel == null){
			return;
		}

		Map parameterMap = ServletUtil.getParameterMap(request);

		easyListModel.beforeSelect(parameterMap, request, response);

		List rslist = null;
		boolean twiceSelect = true;

		String tableId = easyListModel.getTableId();

		if (StringUtils.isBlank(tableId)) {
			tableId = request.getParameter(ECSideConstants.TABLEID_KEY);
			if (StringUtils.isBlank(tableId)) {
				tableId = TableConstants.EXTREME_COMPONENTS;
			}
		}

		int defaultPageSize = easyListModel.getDefaultPageSize();

		int totalRows = RequestUtil.getTotalRowsFromRequest(request, tableId);

		if (totalRows < 0) {
			totalRows = easyListModel.getRecordsNumber(parameterMap);
		}

		if (totalRows == ECSideConstants.ONCE_SELECT_FLAG) {
			twiceSelect = false;
			rslist = easyListModel.getRecordsList(parameterMap);
			if (rslist == null) {
				totalRows = 0;
			} else {
				totalRows = rslist.size();
			}
		}

		int[] rowStartEnd = RequestUtil.getRowStartEnd(request, tableId,
				totalRows, defaultPageSize);
		if (twiceSelect) {
			int size = rowStartEnd[1] - rowStartEnd[0];
			parameterMap.put(ECSideConstants.C_ROW_START, rowStartEnd[0] + "");
			parameterMap.put(ECSideConstants.C_ROW_END, rowStartEnd[1] + "");
			parameterMap.put(ECSideConstants.C_PAGE_SIZE, size + "");
			rslist = easyListModel.getRecordsList(parameterMap);
		}

		String[] titles = null;

		if (easyListModel.getColumnTitles() != null) {
			titles = easyListModel.getColumnTitles().split(",");
		}
		if (rslist != null) {
			request.setAttribute(ECSideConstants.TABLE_RECORDS_KEY, rslist);
		}
		if (parameterMap.get(ECSideConstants.TABLE_FILEDS_KEY) != null) {
			request.setAttribute(ECSideConstants.TABLE_FILEDS_KEY, parameterMap
					.get(ECSideConstants.TABLE_FILEDS_KEY));
		}
		if (titles != null) {
			request.setAttribute(ECSideConstants.TABLE_TITLES_KEY, titles);
		}

		easyListModel.afterSelect(parameterMap, request, response);

	}

}
