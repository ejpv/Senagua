create table users(
  id	Serial	not null,
  username	character varying	(30) unique not null,
  password	character varying	(40) not null,
  type	character varying	(15) not null,
  dni	character varying	(10) unique not null,
  telephone	character varying	(13) unique not null,
  firstname	character varying	(30) not null,
  lastname	character varying	(30) not null,
  address	character varying	(100) not null,
  email	character varying	(100  ) unique not null,
  constraint pk_user primary key(id)
);

create table recordsperson(
  id	Serial	not null,
  userid	integer	not null,
  constraint pk_recordsperson primary key(id)
);


create table debtcollector(
  id	Serial	not null,
  userid	integer	not null,
  constraint pk_debtcollector primary key(id)
);

create table administrator(
  id	Serial	not null,
  userid	integer	not null,
  constraint pk_administrator primary key(id)
);


create table village(
  id	Serial	not null,
  name	character varying	(40) not null,
  constraint pk_village primary key(id)
);

create table beneficiary(
  id	Serial not null,
  dni	character varying	(10) not null,
  lastname	character varying	(30) not null,
  firsname	character varying	(30) not null,
  address	character varying	(100) not null,
  resferences	character varying	(100),
  villageid	integer	 not null,
  constraint pk_beneficiary primary key(id)
);

create table pwstype(
  id	Serial		not null,
  isactive	boolean		not null,
  name	character varying(40)	not null,
  basevolume	int		not null,
  baseprice	double precision		not null,
  extraprice	double precision		not null,
  constraint pk_pwstype primary key(id)
);


create table watermeter(
  watermeternumber	Serial not null,
  status	character varying	(10) not null,
  beneficiaryid	integer	not null,
  pwstypeid	integer	not null,
  constraint pk_watermeter primary key(watermeternumber)
);



create table uptake(
  id	Serial not null,
  datetaked	date default current_date not null,
  lastvaluetaken real	not null,
  currentvaluetaken	real not null,
  totalcubicmeters	real not null,
  price	double precision	not null,
  watermeterid	integer	not null,
  constraint pk_uptake primary key(id)
);


create table service(
  id	Serial not null,
  name	character varying	(50) not null,
  price	double precision	not null,
  constraint pk_service primary key(id)
);


create table invoice(
  invoicenumber	Serial not null,
  dateofissue	character varying(10) not null,
  totaltopay	double precision,
  ispayed	boolean	default false,
  beneficiaryid	integer	not null,
  debtcollectorid	integer	not null,
  constraint pk_invoice primary key(invoicenumber)
);


create table servicedetail(
  invoiceid	integer	not null,
  serviceid	integer	not null,
  quantity integer,
  subtotal double precision,
  total	double precision
);


create table pwsdetail(
  invoiceid	integer	not null,
  uptakeid	integer	not null,
  subtotal double precision	,
  total	double precision
);
