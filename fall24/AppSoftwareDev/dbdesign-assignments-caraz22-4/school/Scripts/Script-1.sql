Select t.technician_code as code,t.technician_first_name as firstName,t.technician_last_name as lastName,
wos.work_order_status_desc as workOrderStatus, t.technician_type as type, GROUP_CONCAT(twp.state_code SEPARATOR ',') 
as states  from work_order_pro.technician t left join work_order_pro.technician_work_permit twp
on twp.technician_code =t.technician_code left join work_order_pro.work_order wo on wo.work_order_number =
(Select max(wo1.work_order_number) from work_order_pro.work_order wo1 where wo1.technician_code = t.technician_code)
left join work_order_pro.work_order_status wos on wos.work_order_status_code = wo.work_order_status_code
where t.technician_code = 'T10481' group by t.technician_code;