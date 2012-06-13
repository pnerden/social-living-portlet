Liferay.Service.register("Liferay.Service.LSPSL", "org.lsp.liferay.portlet.socialliving.service", "social-living-portlet");

Liferay.Service.registerClass(
	Liferay.Service.LSPSL, "EventEntry",
	{
		deleteEventEntry: true,
		getEventEntry: true,
		getVisibility: true
	}
);