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
package org.ecside.table.cell;

import org.ecside.core.TableModel;
import org.ecside.core.bean.Column;
import org.ecside.util.HtmlBuilder;
import org.ecside.view.html.ColumnBuilder;


/**
 * @author Wei Zijun
 *
 */

public class RadioBoxCell implements Cell {
	
    public String getHtmlDisplay(TableModel model, Column column) {
    	ColumnBuilder columnBuilder = new ColumnBuilder(column);
        columnBuilder.tdStart();
        columnBuilder.tdBody(getCellValue(model, column));
        columnBuilder.tdEnd();
        return columnBuilder.toString();
    }
    
    public String getExportDisplay(TableModel model, Column column) {
        return "";
    }
    protected String getCellValue(TableModel model, Column column) {
 
        String value = column.getValueAsString();
        String radioBoxName = column.getAlias();
        HtmlBuilder build = new HtmlBuilder();
        
        //if (StringUtils.isNotBlank(value)) {
        	build.input("radio").name(radioBoxName).value(value);
        	if (column.getStyleClass()!=null){
        		build.styleClass(column.getStyleClass());
        	}else{
        		build.styleClass("radio");
        	}
        	build.append(" ").append(column.getTagAttributes()).append(" ");
        	build.xclose();       	
        //}
        	
        return build.toString();
    }
}
