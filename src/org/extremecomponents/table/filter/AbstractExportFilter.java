/*
 * Copyright 2004 original author or authors.
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
package org.extremecomponents.table.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.ecside.core.TableConstants;
import org.ecside.core.TableModelUtils;
import org.ecside.core.context.WebContext;
import org.ecside.core.context.HttpServletRequestContext;
import org.ecside.preferences.TableProperties;
import org.ecside.resource.MimeUtils;
import org.extremecomponents.table.core.Preferences;

/**
 * @author Jeff Johnston
 */
public abstract class AbstractExportFilter implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        WebContext context = new HttpServletRequestContext((HttpServletRequest) request);
        boolean isExported = ExportFilterUtils.isExported(context);
        if (isExported) {
            String exportFileName = ExportFilterUtils.getExportFileName(context);
            doFilterInternal(request, response, chain, exportFileName);
            handleExport((HttpServletRequest) request, (HttpServletResponse) response, context);
        } else {
            chain.doFilter(request, response);
        }
    }

    protected void handleExport(HttpServletRequest request, HttpServletResponse response, WebContext context) {
        try {
            Object viewData = request.getAttribute(TableConstants.VIEW_DATA);
            if (viewData != null) {
                Preferences preferences = new TableProperties();
                preferences.init(null, TableModelUtils.getPreferencesLocation(context));
                String viewResolver = (String) request.getAttribute(TableConstants.VIEW_RESOLVER);
                Class classDefinition = Class.forName(viewResolver);
                ViewResolver handleExportViewResolver = (ViewResolver) classDefinition.newInstance();
                handleExportViewResolver.resolveView(request, response, preferences, viewData);
                response.getOutputStream().flush();
                response.getOutputStream().close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void setResponseHeaders(HttpServletResponse response, String exportFileName) {
        String mimeType = MimeUtils.getFileMimeType(exportFileName);
        if (StringUtils.isNotBlank(mimeType)) {
            response.setContentType(mimeType);
        }

        response.setHeader("Content-Disposition", "attachment;filename=\"" + exportFileName + "\"");
        response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
        response.setHeader("Pragma", "public");
        response.setDateHeader("Expires", (System.currentTimeMillis() + 1000));
    }

    protected abstract void doFilterInternal(ServletRequest request, ServletResponse response, FilterChain chain, String exportFileName) throws IOException, ServletException;
}
