package org.lsp.liferay.portlet.socialliving.servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.fortuna.ical4j.data.CalendarOutputter;
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
import com.liferay.portal.model.Company;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.Encryptor;
import com.liferay.util.EncryptorException;

public class ICalEventsServlet extends HttpServlet {
	
	private static final Log log = LogFactoryUtil
			.getLog(ICalEventsServlet.class);

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		try {

			String user_uuid = null;
			String cookie = req.getHeader("cookie");

			String[] split1 = cookie.split("USER_UUID=");
			if (split1.length == 2) {
				String[] split2 = split1[1].split(";");
				user_uuid = split2[0];
			}

			Company company = CompanyLocalServiceUtil.getCompany(PortalUtil.getCompanyId(req));
			
			//String[] decrypted = Encryptor.decrypt(company.getKeyObj(), user_uuid).split("."); 
			long userId = Float.valueOf(Encryptor.decrypt(company.getKeyObj(), user_uuid).trim()).longValue();
			log.debug("Connected user is : "+userId);
			
			if ((userId > 0) && (PortalUtil.getCompanyId(req) > 0)) {
				resp.setContentType("text/calendar; charset=UTF-8");
				getEvents(PortalUtil.getCompanyId(req),	userId, resp);
			} else {
				throw new PortalException("Authentication Error");
			}
		} catch (PortalException e) {
			log.error(e.getMessage(), e);
		} catch (SystemException e) {
			log.error(e.getMessage(), e);
		} catch (ValidationException e) {
			log.error(e.getMessage(), e);
		} catch (EncryptorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void getEvents(long companyId, long userId, HttpServletResponse resp)
			throws IOException, SystemException, PortalException,
			ValidationException {
		ServletOutputStream out = resp.getOutputStream();
		List<EventRegistration> registrations = EventRegistrationLocalServiceUtil
				.getEventPositiveRegistrations(companyId, userId);
		Iterator<EventRegistration> iter = registrations.iterator();
		List<Component> result = new Vector<Component>();

		final Calendar calendar = new Calendar();
		calendar.getProperties().add(
				new ProdId("-//Ben Fortuna//iCal4j 1.0//EN"));
		calendar.getProperties().add(Version.VERSION_2_0);
		calendar.getProperties().add(CalScale.GREGORIAN);

		while (iter.hasNext()) {
			EventEntry e = EventEntryLocalServiceUtil.getEventEntry(iter.next()
					.getEventEntryId());
			final VEvent event = new VEvent(new DateTime(e.getStartDate()),
					e.getTitle());
			event.getProperties().add(new DtEnd(new DateTime(e.getEndDate())));
			event.getProperties().add(new Description(e.getDescription()));
			result.add(event);
		}
		
		calendar.getComponents().addAll(result);

		final CalendarOutputter output = new CalendarOutputter();
		output.output(calendar, out);
		out.flush();
		out.close();
	}

}
