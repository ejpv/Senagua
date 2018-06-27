alter table recordsperson
  add constraint fk_recordsperson_user foreign key(userid) references users(id);

alter table debtcollector
  add constraint fk_debtcollector_user foreign key(userid) references users(id);


alter table administrator
  add constraint fk_administrator_user foreign key(userid) references users(id);

alter table beneficiary
  add constraint fk_beneficiary_village foreign key(villageid) references village(id);


alter table watermeter
  add constraint pk_watermeter_beneficiary foreign key(beneficiaryid) references beneficiary(id),
  add constraint pk_watermeter_pwstype foreign key(pwstypeid) references pwstype(id);

alter table uptake
  add constraint fk_uptake_watermeter foreign key(watermeterid) references watermeter(watermeternumber);


alter table invoice
  add constraint fk_invoice_beneficiary foreign key(beneficiaryid) references beneficiary(id),
  add constraint fk_invoice_debtcollector foreign key(debtcollectorid) references debtcollector(id);


alter table servicedetail
    add constraint fk_servicedetail_invoice foreign key(invoiceid) references invoice(invoicenumber),
    add constraint fk_servicedetail_service foreign key(serviceid) references service(id),
    add constraint pk_servicedetail primary key(invoiceid,serviceid);



alter table pwsdetail
  add constraint fk_pwsdetail_invoice foreign key(invoiceid) references invoice(invoicenumber),
  add constraint fk_pwsdetail_uptake foreign key(uptakeid) references uptake(id),
  add constraint pk_pwsdetail primary key(invoiceid,uptakeid);
