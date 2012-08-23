package org.lsp.liferay.portlet.socialliving.events.portlet;

import java.io.File;
import java.util.Calendar;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.lsp.liferay.portlet.socialliving.service.EventEntryServiceUtil;
import org.lsp.liferay.portlet.socialliving.service.EventRegistrationLocalServiceUtil;

import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public abstract class CommonEventsPortlet extends MVCPortlet {
	public void deleteEventEntry(ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		long eventEntryId = ParamUtil
				.getLong(actionRequest, "eventEntryId");

		EventEntryServiceUtil.deleteEventEntry(themeDisplay.getCompanyId(),
				eventEntryId);
	}

	public void updateEventEntry(ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {

		UploadPortletRequest uploadPortletRequest = PortalUtil
				.getUploadPortletRequest(actionRequest);

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		long eventEntryId = ParamUtil.getLong(uploadPortletRequest,
				"eventEntryId");

		String title = ParamUtil.getString(uploadPortletRequest, "title");
		String description = ParamUtil.getString(uploadPortletRequest,
				"description");

		int startDateMonth = ParamUtil.getInteger(uploadPortletRequest,
				"startDateMonth");
		int startDateDay = ParamUtil.getInteger(uploadPortletRequest,
				"startDateDay");
		int startDateYear = ParamUtil.getInteger(uploadPortletRequest,
				"startDateYear");
		int startDateHour = ParamUtil.getInteger(uploadPortletRequest,
				"startDateHour");
		int startDateMinute = ParamUtil.getInteger(uploadPortletRequest,
				"startDateMinute");
		int startDateAmPm = ParamUtil.getInteger(uploadPortletRequest,
				"startDateAmPm");

		if (startDateAmPm == Calendar.PM) {
			startDateHour += 12;
		}

		int endDateMonth = ParamUtil.getInteger(uploadPortletRequest,
				"endDateMonth");
		int endDateDay = ParamUtil.getInteger(uploadPortletRequest,
				"endDateDay");
		int endDateYear = ParamUtil.getInteger(uploadPortletRequest,
				"endDateYear");
		int endDateHour = ParamUtil.getInteger(uploadPortletRequest,
				"endDateHour");
		int endDateMinute = ParamUtil.getInteger(uploadPortletRequest,
				"endDateMinute");
		int endDateAmPm = ParamUtil.getInteger(uploadPortletRequest,
				"endDateAmPm");

		if (endDateAmPm == Calendar.PM) {
			endDateHour += 12;
		}

		int totalAttendees = ParamUtil.getInteger(uploadPortletRequest,
				"totalAttendees");
		int maxAttendees = ParamUtil.getInteger(uploadPortletRequest,
				"maxAttendees");
		double price = ParamUtil.getDouble(uploadPortletRequest, "price");

		String latitude = ParamUtil.getString(uploadPortletRequest, "latitude");
		String longitude = ParamUtil.getString(uploadPortletRequest, "longitude");
		String location = ParamUtil.getString(uploadPortletRequest, "location");
		
		boolean withSpouse = ParamUtil.getBoolean(uploadPortletRequest, "withSpouse");
		boolean withChildren = ParamUtil.getBoolean(uploadPortletRequest, "withChildren");
		
		File file = uploadPortletRequest.getFile("fileName");
		byte[] bytes = FileUtil.getBytes(file);
		int visibility = ParamUtil.getInteger(uploadPortletRequest,
				"visibility");

		if (eventEntryId <= 0) {
			EventEntryServiceUtil.addEventEntry(
					themeDisplay.getScopeGroupIdOrLiveGroupId(),
					themeDisplay.getUserId(), title, description,
					startDateMonth, startDateDay, startDateYear, startDateHour,
					startDateMinute, endDateMonth, endDateDay, endDateYear,
					endDateHour, endDateMinute, totalAttendees, maxAttendees,
					price, bytes, visibility, latitude, longitude, location, withSpouse, withChildren);
		} else {
			EventEntryServiceUtil.updateEventEntry(
					themeDisplay.getUserId(), eventEntryId, title,
					description, startDateMonth, startDateDay, startDateYear,
					startDateHour, startDateMinute, endDateMonth, endDateDay,
					endDateYear, endDateHour, endDateMinute, totalAttendees,
					maxAttendees, price, bytes, visibility, latitude, longitude, location, withSpouse, withChildren);
		}
	}

	public void updateEventRegistration(ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		long eventEntryId = ParamUtil
				.getLong(actionRequest, "eventEntryId");
		int status = ParamUtil.getInteger(actionRequest, "status");
		String comments = ParamUtil.getString(actionRequest, "comments");

		EventRegistrationLocalServiceUtil.updateEventRegistration(
				themeDisplay.getUserId(), eventEntryId, status, comments);
	}
}
