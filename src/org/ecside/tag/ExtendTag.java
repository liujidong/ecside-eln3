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
package org.ecside.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.commons.lang.StringUtils;
import org.ecside.core.TableModel;
import org.ecside.util.ExceptionUtils;


/**
 * @author Wei Zijun
 *
 */

public class ExtendTag extends BodyTagSupport   {

    /**
	 * 
	 */
	private static final long serialVersionUID = 3767467674048711091L;

	// top bottom toolbar
	
	private String location;

	protected Object getBodyValue() throws JspException {
        Object result = getBodyContent().getString();

        return result;
    }


    public int doAfterBody() throws JspException {
        try {
            TableModel model = TagUtils.getModel(this);
            
            if (StringUtils.isBlank(location)|| location.equalsIgnoreCase("toolbar")){
            	model.getTable().setAttribute("ExtendTool", getBodyValue());
            }else if (location.equalsIgnoreCase("top")){
            	model.getTable().setAttribute("ExtendTableTop", getBodyValue());
            }else if (location.equalsIgnoreCase("bottom")){
            	model.getTable().setAttribute("ExtendTableBottom", getBodyValue());
            }else{
            	model.getTable().setAttribute("ExtendTool", getBodyValue());
            }

        } catch (Exception e) {
            throw new JspException("TDExtendTag.doAfterBody() Problem: " + ExceptionUtils.formatStackTrace(e));
        }

        return SKIP_BODY;
    }



    public void release() {

        super.release();
    }


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}

}