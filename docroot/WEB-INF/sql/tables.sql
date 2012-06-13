create table LSPSL_ChannelEntry (
	channelEntryId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	comments VARCHAR(75) null
);

create table LSPSL_EventEntry (
	eventEntryId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	title VARCHAR(75) null,
	description VARCHAR(75) null,
	startDate DATE null,
	endDate DATE null,
	totalAttendees INTEGER,
	maxAttendees INTEGER,
	price DOUBLE,
	thumbnailId LONG,
	latitude VARCHAR(75) null,
	longitude VARCHAR(75) null,
	location VARCHAR(75) null
);

create table LSPSL_EventRegistration (
	eventRegistrationId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	eventEntryId LONG,
	status INTEGER,
	comments VARCHAR(75) null
);