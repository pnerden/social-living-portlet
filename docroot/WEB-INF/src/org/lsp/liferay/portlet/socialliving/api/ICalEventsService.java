package org.lsp.liferay.portlet.socialliving.api;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.Component;
import net.fortuna.ical4j.model.DateTime;
import net.fortuna.ical4j.model.ValidationException;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.property.CalScale;
import net.fortuna.ical4j.model.property.Description;
import net.fortuna.ical4j.model.property.DtEnd;
import net.fortuna.ical4j.model.property.ProdId;
import net.fortuna.ical4j.model.property.Version;

import org.lsp.liferay.portlet.socialliving.model.EventEntry;
import org.lsp.liferay.portlet.socialliving.model.EventRegistration;
import org.lsp.liferay.portlet.socialliving.service.EventEntryLocalServiceUtil;
import org.lsp.liferay.portlet.socialliving.service.EventRegistrationLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class ICalEventsService {
	
	private static final Log log = LogFactoryUtil
			.getLog(ICalEventsService.class);

	@SuppressWarnings("unchecked")
	public static Calendar getEvents(long companyId, long userId)
			throws IOException, SystemException, PortalException,
			ValidationException {
		
		log.debug("Looking up registrations for User "+userId+" inside Company "+companyId);
		
		List<EventRegistration> registrations = EventRegistrationLocalServiceUtil
				.getEventPositiveRegistrations(companyId, userId);
		Iterator<EventRegistration> iter = registrations.iterator();
		List<Component> result = new Vector<Component>();

		final Calendar calendar = new Calendar();
		calendar.getProperties().add(new ProdId("-//Ben Fortuna//iCal4j 1.0//EN"));
		calendar.getProperties().add(Version.VERSION_2_0);
		calendar.getProperties().add(CalScale.GREGORIAN);

		while (iter.hasNext()) {
			EventEntry e = EventEntryLocalServiceUtil.getEventEntry(iter.next()
					.getEventEntryId());
			final VEvent event = new VEvent(new DateTime(e.getStartDate()),
					e.getTitle());
			event.getProperties().add(new DtEnd(new DateTime(e.getEndDate())));
			StringBuilder sb = new StringBuilder();
			sb.append(e.getLocation());
			sb.append(" - ");
			sb.append(e.getDescription());
			sb.append(" - ");
			sb.append(e.getPrice());
			sb.append(" €");
			event.getProperties().add(new Description(sb.toString()));
			result.add(event);
		}
		
		calendar.getComponents().addAll(result);

		return calendar;
	}

}
