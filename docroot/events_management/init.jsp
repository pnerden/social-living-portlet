<%@ include file="/init.jsp" %>

<%
String portletResource = ParamUtil.getString(request, "portletResource");
String portletNameSpace = "_"+request.getAttribute("PORTLET_ID")+"_";

long companyId = company.getCompanyId();
long groupId = themeDisplay.getScopeGroupIdOrLiveGroupId();
String portalURL = themeDisplay.getPortalURL();
%>