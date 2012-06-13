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

package org.lsp.liferay.portlet.socialliving.service.base;

import org.lsp.liferay.portlet.socialliving.service.EventEntryServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 */
public class EventEntryServiceClpInvoker {
	public EventEntryServiceClpInvoker() {
		_methodName30 = "getBeanIdentifier";

		_methodParameterTypes30 = new String[] {  };

		_methodName31 = "setBeanIdentifier";

		_methodParameterTypes31 = new String[] { "java.lang.String" };

		_methodName36 = "addEventEntry";

		_methodParameterTypes36 = new String[] {
				"long", "long", "java.lang.String", "java.lang.String", "int",
				"int", "int", "int", "int", "int", "int", "int", "int", "int",
				"int", "int", "double", "byte[][]", "int", "java.lang.String",
				"java.lang.String", "java.lang.String"
			};

		_methodName37 = "deleteEventEntry";

		_methodParameterTypes37 = new String[] { "long", "long" };

		_methodName38 = "getEventEntry";

		_methodParameterTypes38 = new String[] { "long", "long" };

		_methodName39 = "getEventEntries";

		_methodParameterTypes39 = new String[] {
				"com.liferay.portal.theme.ThemeDisplay", "int", "int"
			};

		_methodName40 = "getVisibility";

		_methodParameterTypes40 = new String[] {
				"org.lsp.liferay.portlet.socialliving.model.EventEntry"
			};

		_methodName41 = "updateEventEntry";

		_methodParameterTypes41 = new String[] {
				"long", "long", "java.lang.String", "java.lang.String", "int",
				"int", "int", "int", "int", "int", "int", "int", "int", "int",
				"int", "int", "double", "byte[][]", "int", "java.lang.String",
				"java.lang.String", "java.lang.String"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName30.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes30, parameterTypes)) {
			return EventEntryServiceUtil.getBeanIdentifier();
		}

		if (_methodName31.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes31, parameterTypes)) {
			EventEntryServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);
		}

		if (_methodName36.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes36, parameterTypes)) {
			return EventEntryServiceUtil.addEventEntry(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3],
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue(),
				((Integer)arguments[6]).intValue(),
				((Integer)arguments[7]).intValue(),
				((Integer)arguments[8]).intValue(),
				((Integer)arguments[9]).intValue(),
				((Integer)arguments[10]).intValue(),
				((Integer)arguments[11]).intValue(),
				((Integer)arguments[12]).intValue(),
				((Integer)arguments[13]).intValue(),
				((Integer)arguments[14]).intValue(),
				((Integer)arguments[15]).intValue(),
				((Double)arguments[16]).doubleValue(), (byte[])arguments[17],
				((Integer)arguments[18]).intValue(),
				(java.lang.String)arguments[19],
				(java.lang.String)arguments[20], (java.lang.String)arguments[21]);
		}

		if (_methodName37.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes37, parameterTypes)) {
			return EventEntryServiceUtil.deleteEventEntry(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName38.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes38, parameterTypes)) {
			return EventEntryServiceUtil.getEventEntry(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName39.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes39, parameterTypes)) {
			return EventEntryServiceUtil.getEventEntries((com.liferay.portal.theme.ThemeDisplay)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName40.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes40, parameterTypes)) {
			return EventEntryServiceUtil.getVisibility((org.lsp.liferay.portlet.socialliving.model.EventEntry)arguments[0]);
		}

		if (_methodName41.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes41, parameterTypes)) {
			return EventEntryServiceUtil.updateEventEntry(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3],
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue(),
				((Integer)arguments[6]).intValue(),
				((Integer)arguments[7]).intValue(),
				((Integer)arguments[8]).intValue(),
				((Integer)arguments[9]).intValue(),
				((Integer)arguments[10]).intValue(),
				((Integer)arguments[11]).intValue(),
				((Integer)arguments[12]).intValue(),
				((Integer)arguments[13]).intValue(),
				((Integer)arguments[14]).intValue(),
				((Integer)arguments[15]).intValue(),
				((Double)arguments[16]).doubleValue(), (byte[])arguments[17],
				((Integer)arguments[18]).intValue(),
				(java.lang.String)arguments[19],
				(java.lang.String)arguments[20], (java.lang.String)arguments[21]);
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName30;
	private String[] _methodParameterTypes30;
	private String _methodName31;
	private String[] _methodParameterTypes31;
	private String _methodName36;
	private String[] _methodParameterTypes36;
	private String _methodName37;
	private String[] _methodParameterTypes37;
	private String _methodName38;
	private String[] _methodParameterTypes38;
	private String _methodName39;
	private String[] _methodParameterTypes39;
	private String _methodName40;
	private String[] _methodParameterTypes40;
	private String _methodName41;
	private String[] _methodParameterTypes41;
}