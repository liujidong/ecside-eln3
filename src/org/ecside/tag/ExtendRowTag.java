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

import org.ecside.core.TableModel;
import org.ecside.util.ExceptionUtils;


/**
 * @author Wei Zijun
 *
 */

public class ExtendRowTag extends BodyTagSupport   {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String location;


	public String getBefore() {
		return location;
	}


	public void setBefore(String before) {
		this.location = before;
	}


	protected Object getBodyValue() throws JspException {
        Object result = getBodyContent().getString();

        return result;
    }


    public int doAfterBody() throws JspException {
        try {
            TableModel model = TagUtils.getModel(this);
            if ("top".equalsIgnoreCase(location)) {
            	model.getTable().setAttribute("ExtendRowTop", getBodyValue());
            }else if ("before".equalsIgnoreCase(location)) {
            	model.getTable().setAttribute("ExtendRowBefore", getBodyValue());
            }else{
            	model.getTable().setAttribute("ExtendRowAfter", getBodyValue());
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