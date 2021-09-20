-- users
INSERT INTO users (username, code, password, enabled, name, last_name, email, created_user, created_at, update_user, updated_at) VALUES ('aospino', '1140900962', '$2a$10$qZdErhoeE7/0QTHuQEidGOYz8JXV2z6/8bYwiN3c2TbIZUrauWJP6',true,'miguel andres','ospino','andres@midominio.local', '1140900962', NOW(), '1140900962', NOW());
INSERT INTO users (username, code, password, enabled, name, last_name, email, created_user, created_at, update_user, updated_at) VALUES ('admin', '99012518524','$2a$10$t5Bg0mqioFGDZxqg1ttPKetifVQYE8JbQ/rt7u7EJiHCpIXkONcvu',true,'administrador','company','root@root.local', '1140900962', NOW(), '1140900962', NOW());

-- roles
INSERT INTO roles (name, guard_name, created_user, updated_user, created_at, updated_at) VALUES ('gerente', 'api', '1140900962','1140900962', NOW(),  NOW());
INSERT INTO roles (name, guard_name, created_user, updated_user, created_at, updated_at) VALUES ('asesor', 'api', '1140900962','1140900962', NOW(),  NOW());
INSERT INTO roles (name, guard_name, created_user, updated_user, created_at, updated_at) VALUES ('refaccionaria', 'api', '1140900962','1140900962', NOW(),  NOW());
INSERT INTO roles (name, guard_name, created_user, updated_user, created_at, updated_at) VALUES ('mecánico', 'api', '1140900962','1140900962', NOW(),  NOW());
INSERT INTO roles (name, guard_name, created_user, updated_user, created_at, updated_at) VALUES ('hostess', 'api', '1140900962','1140900962', NOW(),  NOW());
INSERT INTO roles (name, guard_name, created_user, updated_user, created_at, updated_at) VALUES ('call center', 'api', '1140900962','1140900962', NOW(),  NOW());
INSERT INTO roles (name, guard_name, created_user, updated_user, created_at, updated_at) VALUES ('cliente', 'api', '1140900962','1140900962', NOW(),  NOW());
INSERT INTO roles (name, guard_name, created_user, updated_user, created_at, updated_at) VALUES ('administrador', 'api', '1140900962','1140900962', NOW(),  NOW());
INSERT INTO roles (name, guard_name, created_user, updated_user, created_at, updated_at) VALUES ('superadministrador', 'api', '1140900962','1140900962', NOW(),  NOW());


--usuarios roles
INSERT INTO users_rols (user_id, role_id) VALUES (1, 1);
INSERT INTO users_rols (user_id, role_id) VALUES (1, 9);
INSERT INTO users_rols (user_id, role_id) VALUES (2, 1);

























