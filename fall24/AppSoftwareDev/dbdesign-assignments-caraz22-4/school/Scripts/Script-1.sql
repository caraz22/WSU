SELECT * from work_order_pro.technician t;

UPDATE work_order_pro.technician set technician_type='Plumber' where technician_code <= 'T10490';
UPDATE work_order_pro.technician set technician_type='Electrician' where technician_code > 'T10490';

#ALTER table work_order_pro.technician add column technician_type varchar(15)

SELECT * from work_order_pro.state s;