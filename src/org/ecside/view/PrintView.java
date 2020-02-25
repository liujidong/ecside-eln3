/*
 * Copyright 2006-2007 original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.ecside.view;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.ecside.core.TableModel;
import org.ecside.core.bean.Column;
import org.ecside.core.bean.Table;
import org.ecside.util.ECSideUtils;
import org.ecside.util.HtmlBuilder;
import org.ecside.view.html.CalcBuilder;
import org.ecside.view.html.FormBuilder;
import org.ecside.view.html.RowBuilder;
import org.ecside.view.html.TableBuilder;
import org.extremecomponents.table.view.View;

/**
 * @author Wei Zijun
 *
 */

public class PrintView implements View {

	
    private HtmlBuilder html;
    private TableBuilder tableBuilder;
    private RowBuilder rowBuilder;
    private FormBuilder formBuilder;
    private CalcBuilder calcBuilder;
    

    
    boolean bufferView;
    
    protected HtmlBuilder getHtmlBuilder() {
        return html;
    }

    protected CalcBuilder getCalcBuilder() {
        return calcBuilder;
    }

    protected FormBuilder getFormBuilder() {
        return formBuilder;
    }

    protected RowBuilder getRowBuilder() {
        return rowBuilder;
    }

    protected TableBuilder getTableBuilder() {
        return tableBuilder;
    }
    
    public void beforeBody(TableModel model) {
    	Table table=model.getTable();
        bufferView = table.isBufferView();
        if (bufferView) {
            html = new HtmlBuilder();
        } else {
            html = new HtmlBuilder(model.getContext().getWriter());
        }

        tableBuilder = new TableBuilder(html, model);
        rowBuilder = new RowBuilder(html, model);
        calcBuilder = new CalcBuilder(model);
        
        formBuilder = new FormBuilder(html, model);
         
        formBuilder.formStart();

        tableBuilder.themeStart();
//        html.newline();
//        String theme = TDTableConstants.PRINT_VIEW_THEME;
//        html.div().styleClass(theme);
//        html.close();

        tableBuilder.title();
            
        
        tableBuilder.tableStart();
        
        tableBuilder.theadStart();
        


   	
    	List trListTop=(List)model.getTable().getAttribute("ExtendTableTrListTop");
    	String extendRowTop=null;
    	
    	if (trListTop!=null&& trListTop.size()>0){
    		extendRowTop=ECSideUtils.getTrHTML(trListTop,model);
    	}else{
    		extendRowTop=(String)(model.getTable().getAttribute("ExtendRowTop"));
    	}
        

        boolean scrollList=false;
        String height=table.getHeight();
        
        if (StringUtils.isNotBlank(height)){
        	scrollList=true;
        }
        boolean showHeader=model.getTable().isShowHeader();
        boolean hasExtendRowTop=StringUtils.isNotBlank(extendRowTop);
        //        boolean resizeable=model.getTable().getResizeColWidth().booleanValue();

        if (showHeader){
        	if (hasExtendRowTop){
            	tableBuilder.headerHideRow();
        		html.append(extendRowTop);
        	}
        	tableBuilder.headerRow();
        }else if ( !showHeader && !scrollList){
           	if (hasExtendRowTop){
        		html.append(extendRowTop);
        	}
           	tableBuilder.headerHideRow();
        }else if ( !showHeader && scrollList){
           	tableBuilder.headerHideRow();
        	if (hasExtendRowTop){
        		html.append(extendRowTop);
        	}
        }
        

        tableBuilder.theadEnd();

        tableBuilder.tbodyStart();
        
    	List trListBefore=(List)model.getTable().getAttribute("ExtendTableTrListBefore");
    	String extendRowBefore=null;
    	if (trListBefore!=null&& trListBefore.size()>0){
    		extendRowBefore=ECSideUtils.getTrHTML(trListBefore,model);
    	}else{
    		extendRowBefore=(String)(model.getTable().getAttribute("ExtendRowBefore"));
    	}
    	
        if (StringUtils.isNotBlank(extendRowBefore)){
        	html.append(extendRowBefore);
        }
        
    }
    

	
    public Object afterBody(TableModel model) {
        calcBuilder.defaultCalcLayout();
        
        html.append(calcBuilder.getHtmlBuilder());
       
    	List trListAfter=(List)model.getTable().getAttribute("ExtendTableTrListAfter");
    	String extendRowAfter=null;
    	if (trListAfter!=null&& trListAfter.size()>0){
    		extendRowAfter=ECSideUtils.getTrHTML(trListAfter,model);
    	}else{
    		extendRowAfter=(String)(model.getTable().getAttribute("ExtendRowAfter"));
    	}
    	
        if (StringUtils.isNotBlank(extendRowAfter)){
        	html.append(extendRowAfter);
        }
        
        tableBuilder.tbodyEnd();
       
        tableBuilder.tableEnd();
 		
		
        tableBuilder.themeEnd();

        formBuilder.formEnd();
        
        if (this.bufferView) {
            return html.toString();
        }

        return "";
    }
    


    public void body(TableModel model, Column column) {
        if (column.isFirstColumn()) {
            rowBuilder.rowStart();
        }

        html.append(column.getCellDisplay());

        if (column.isLastColumn()) {
            rowBuilder.rowEnd();
        }
    }


}
