-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('客户提问', '3', '1', 'query', 'app/query/index', 1, 0, 'C', '0', '0', 'app:query:list', '#', 'admin', sysdate(), '', null, '客户提问菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('客户提问查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'app:query:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('客户提问新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'app:query:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('客户提问修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'app:query:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('客户提问删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'app:query:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('客户提问导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'app:query:export',       '#', 'admin', sysdate(), '', null, '');