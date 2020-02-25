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

import javax.servlet.jsp.tagext.TagData;
import javax.servlet.jsp.tagext.TagExtraInfo;
import javax.servlet.jsp.tagext.VariableInfo;


/**
 * @author Wei Zijun
 *
 */

/**
 * @jsp.tag name="row" display-name="RowTag" body-content="JSP" description="The
 *          container which holds all the row specific information."
 * 
 */

public class RowTagExtraInfo extends TagExtraInfo {

	public VariableInfo[] getVariableInfo(TagData tagdata) {
        String var = tagdata.getAttributeString("var");
        String beanClassName = tagdata.getAttributeString("beanClassName");
        
        if (beanClassName == null) {
        	beanClassName = "java.lang.String[]";
        }

        if (var == null) {
            return null;
        } else {
            VariableInfo variableinfo = new VariableInfo(var, beanClassName,
                    true, VariableInfo.NESTED);
            VariableInfo[] avariableinfo = { variableinfo };

            return avariableinfo;
        }
    }


}
