/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package org.lsp.liferay.portlet.socialliving.events.portlet;

import java.io.IOException;
import java.io.OutputStream;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import net.fortuna.ical4j.data.CalendarOutputter;
import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.ValidationException;

import org.lsp.liferay.portlet.socialliving.api.ICalEventsService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

/**
 * @author Brian Wing Shun Chan
 * @author Patrick Nerden
 */
public class EventsPortlet extends CommonEventsPortlet {
	
	private static final Log log = LogFactoryUtil
			.getLog(EventsPortlet.class);

	@Override
	public void serveResource(
			ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws IOException, PortletException {
		
		if ((ParamUtil.getString(resourceRequest, "resource") != null) && (ParamUtil.getString(resourceRequest, "resource").equals("ical"))) {
		
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest
					.getAttribute(WebKeys.THEME_DISPLAY);
			
			if ((themeDisplay.getUserId() > 0)) {
				Calendar cal;
				try {
					cal = ICalEventsService.getEvents(themeDisplay.getCompanyId(), themeDisplay.getUserId());
					OutputStream out = resourceResponse.getPortletOutputStream();
					final CalendarOutputter output = new CalendarOutputter();
					output.output(cal, out);
					out.flush();
					out.close();
				} catch (SystemException e) {
					log.error(e.getMessage(), e);
				} catch (PortalException e) {
					log.error(e.getMessage(), e);
				} catch (ValidationException e) {
					log.error(e.getMessage(), e);
				}
				
			} else {
				try {
					PortalUtil.sendError(HttpServletResponse.SC_FORBIDDEN, new RuntimeException("Forbidden"), PortalUtil.getHttpServletRequest(resourceRequest), PortalUtil.getHttpServletResponse(resourceResponse));
				} catch (ServletException e) {
					log.error(e.getMessage(), e);
				}
			}
		} else {
			super.serveResource(resourceRequest, resourceResponse);
		}
	}

}