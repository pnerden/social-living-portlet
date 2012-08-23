create index IX_FA7D6978 on LSPSL_ChannelEntry (groupId);
create index IX_E8D5C9B2 on LSPSL_ChannelEntry (groupId, userId);
create index IX_8FAC91AC on LSPSL_ChannelEntry (userId);

create index IX_D50E680D on LSPSL_EventEntry (companyId);
create index IX_DED057B4 on LSPSL_EventEntry (companyId, eventEntryId);
create index IX_DAE6CB3D on LSPSL_EventEntry (companyId, groupId);
create index IX_EF3B8DCF on LSPSL_EventEntry (groupId);
create index IX_44FD0675 on LSPSL_EventEntry (userId);

create index IX_ACC94786 on LSPSL_EventRegistration (companyId, userId);
create index IX_F2A2A06C on LSPSL_EventRegistration (companyId, userId, status);
create index IX_FE0090C3 on LSPSL_EventRegistration (eventEntryId);
create index IX_F4CF5CA9 on LSPSL_EventRegistration (eventEntryId, status);
create index IX_276BDF7D on LSPSL_EventRegistration (userId, eventEntryId);