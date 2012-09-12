package org.lsp.liferay.portlet.socialliving.events.portlet;

import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;

import org.lsp.liferay.portlet.socialliving.model.EventEntry;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.Group;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.webserver.WebServerServletTokenUtil;

public class EventsMapPortletUtil {

	private static final Log log = LogFactoryUtil.getLog(EventsMapPortletUtil.class);
	
	public static String getEventPlotDescription(EventEntry entry, Group entryGroup, PortletURL viewEventEntryURL, ThemeDisplay themeDisplay, HttpServletRequest request) {
		
		StringBuilder sb = new StringBuilder();
		
		try {
			String groupName;
			groupName = entryGroup.getDescriptiveName(themeDisplay.getLocale());
			String groupFriendlyURL = entryGroup.getFriendlyURL();
			String groupURL = ((!groupFriendlyURL.equals("/guest")) && (GroupLocalServiceUtil.hasUserGroup(themeDisplay.getUserId(), entry.getGroupId()))) ? "/group" : "/web";
			groupURL += groupFriendlyURL;
			
			String thumbnailURL = null;

			if (entry.getThumbnailId() == 0) {
				thumbnailURL = request.getContextPath() + "/common/images/calendar.png";
			}
			else {
				thumbnailURL = themeDisplay.getPathImage() + "/events?img_id=" + entry.getThumbnailId() + "&t=" + WebServerServletTokenUtil.getToken(entry.getThumbnailId());
			}
			
			sb.append("<table>");
				sb.append("<tr>");
					sb.append("<td class=\"events-map-event-image\">");
						sb.append("<a href=\"");
						sb.append(viewEventEntryURL);
						sb.append("\">");
							sb.append("<img src=\"");
							sb.append(thumbnailURL);
							sb.append("\" alt=\"Event Image\" />");
						sb.append("</a>");
					sb.append("</td>");
					sb.append("<td class=\"events-map-event-description\">");
						sb.append("<a href=\"");
						sb.append(groupURL);
						sb.append("\">");
							sb.append(groupName);
						sb.append("</a>");
						sb.append("<br />");
						sb.append("<a href=\"");
						sb.append(viewEventEntryURL);
						sb.append("\">");
							sb.append(entry.getTitle());
						sb.append("</a>");
						sb.append("<br />");
						sb.append(entry.getLocation());
						sb.append("<br />");
						if (entry.getDescription().length() > 100) {
							sb.append(entry.getDescription().substring(0, 100));
						} else {
							sb.append(entry.getDescription());
						}
						sb.append(" ");
						sb.append("<a href=\"");
						sb.append(viewEventEntryURL);
						sb.append("\">");
							sb.append("("+LanguageUtil.get(themeDisplay.getLocale(), "more")+")");
						sb.append("</a>");
						sb.append("<br />");
					sb.append("</td>");
				sb.append("</tr>");
			sb.append("</table>");
			
		} catch (PortalException e) {
			log.error(e.getMessage(), e);
		} catch (SystemException e) {
			log.error(e.getMessage(), e);
		}
		
		return sb.toString();
		
	}
	
}
