create table SUP_GlobalInformation (
	globalInformationId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	date_ DATE null,
	message VARCHAR(75) null,
	display INTEGER,
	status INTEGER
);

create table StandupEntry (
	entryId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	quantity INTEGER,
	difficulty INTEGER,
	createDate DATE null,
	modifiedDate DATE null,
	blocking VARCHAR(75) null,
	additionalDetails VARCHAR(75) null,
	status INTEGER
);