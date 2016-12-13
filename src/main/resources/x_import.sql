/* Demo */
insert into adm_domain(domain_key, domain_name, full_domain, date_created) values ('281c4e23-5bc3-47d0-9da3-a928dc45c5a0', 'opentalkdemo', 'opentalkdemo.live.com', now())

insert into adm_user(user_key, user_id, user_name, user_email, date_created) values ('10d70ef4-e720-4503-90ca-fb1d40a0b0fb', 'ivanchan', 'Ivan Chan', '29january@gmail.com', now())
insert into adm_user(user_key, user_id, user_name, user_email, date_created) values ('d620459e-2998-4a3d-8cc3-77b42d778a38', 'gloria', 'Gloria Wong', 'gloria@gmail.com', now())
insert into adm_user(user_key, user_id, user_name, user_email, date_created) values ('67b21ca7-338c-4ffe-9dba-cc6c8e5fa597', 'macro', 'Macro Lee', 'macro@gmail.com', now())
insert into adm_user(user_key, user_id, user_name, user_email, date_created) values ('804aa522-27e6-407a-a616-887ba4c1e0bb', 'leo', 'Leo Chung', 'leo@gmail.com', now())
insert into adm_user(user_key, user_id, user_name, user_email, date_created) values ('fac6e737-a227-4e74-a642-5cca17d551b1', 'sam', 'Sam Kwan', 'sam@gmail.com', now())

insert into team_channel(channel_key, channel_name, channel_desc, date_created, is_public_channel, status) values ('c7931733-371d-4fdf-aef6-82f7d46ceb78', 'general', 'talk everything', now(), true, 1)
insert into team_channel(channel_key, channel_name, channel_desc, date_created, is_public_channel, status) values ('a4d6d107-09c3-4ca4-ac82-d3f39d31798a', 'dev', 'development talk', now(), true, 1)
insert into team_channel(channel_key, channel_name, channel_desc, date_created, is_public_channel, status) values ('2413887e-ecc2-41ed-b5f1-b51dc2dfd022', 'secret', 'no let boss know', now(), false, 1)