INSERT INTO "public"."users" ("id", "password", "username", "role") VALUES (1, 'pass123', 'rus', 'USER');
SELECT setval('users_id_seq', (SELECT MAX(id) FROM users));

INSERT INTO "public"."accounts" ("id", "balance", "iban", "user_id") VALUES (1, 3000, 'NL3000', 1);
INSERT INTO "public"."accounts" ("id", "balance", "iban", "user_id") VALUES (2, 6000, 'NL6000', 1);
SELECT setval('accounts_id_seq', (SELECT MAX(id) FROM accounts));

INSERT INTO "public"."categories" ("id", "name", "flow_type") VALUES (1, 'Income', 'inflow');
INSERT INTO "public"."categories" ("id", "name", "flow_type") VALUES (2, 'Gift', 'inflow');
INSERT INTO "public"."categories" ("id", "name", "flow_type") VALUES (3, 'Refund', 'inflow');
INSERT INTO "public"."categories" ("id", "name", "flow_type") VALUES (4, 'Grocery', 'outflow');
INSERT INTO "public"."categories" ("id", "name", "flow_type") VALUES (5, 'Energy', 'outflow');
INSERT INTO "public"."categories" ("id", "name", "flow_type") VALUES (6, 'Restaurant', 'outflow');
INSERT INTO "public"."categories" ("id", "name", "flow_type") VALUES (7, 'Cafe', 'outflow');
INSERT INTO "public"."categories" ("id", "name", "flow_type") VALUES (8, 'Clothes', 'outflow');
INSERT INTO "public"."categories" ("id", "name", "flow_type") VALUES (9, 'Pharmacy', 'outflow');
INSERT INTO "public"."categories" ("id", "name", "flow_type") VALUES (10, 'Public transport', 'outflow');

INSERT INTO "public"."transactions" ("id", "amount", "flow_type", "footprint", "local_date", "receiver", "sender", "account_id", "category_id") VALUES (1, 300.00, 'outflow', 181200.00, '2023-01-02', 'NL1234', 'NL3000', 1, 5);
INSERT INTO "public"."transactions" ("id", "amount", "flow_type", "footprint", "local_date", "receiver", "sender", "account_id", "category_id") VALUES (2, 20.00, 'outflow', 16040.00, '2023-01-22', 'NL4321', 'NL3000', 1, 4);
INSERT INTO "public"."transactions" ("id", "amount", "flow_type", "footprint", "local_date", "receiver", "sender", "account_id", "category_id") VALUES (3, 5.00, 'outflow', 4010.00, '2023-01-25', 'NL8966', 'NL3000', 1, 7);
INSERT INTO "public"."transactions" ("id", "amount", "flow_type", "footprint", "local_date", "receiver", "sender", "account_id", "category_id") VALUES (4, 5.00, 'outflow', 4010.00, '2023-02-01', 'NL4321', 'NL3000', 1, 4);
INSERT INTO "public"."transactions" ("id", "amount", "flow_type", "footprint", "local_date", "receiver", "sender", "account_id", "category_id") VALUES (5, 100.00, 'inflow', 0.00, '2023-02-21', 'NL3000', 'NL9999', 1, 3);
INSERT INTO "public"."transactions" ("id", "amount", "flow_type", "footprint", "local_date", "receiver", "sender", "account_id", "category_id") VALUES (6, 20.00, 'outflow', 16040.00, '2023-03-10', 'NL1111', 'NL3000', 1, 6);
INSERT INTO "public"."transactions" ("id", "amount", "flow_type", "footprint", "local_date", "receiver", "sender", "account_id", "category_id") VALUES (7, 20.00, 'outflow', 16040.00, '2023-03-12', 'NL1111', 'NL3000', 1, 6);
INSERT INTO "public"."transactions" ("id", "amount", "flow_type", "footprint", "local_date", "receiver", "sender", "account_id", "category_id") VALUES (8, 200.00, 'inflow', 0.00, '2023-03-20', 'NL3000', 'NL8888', 1, 2);
INSERT INTO "public"."transactions" ("id", "amount", "flow_type", "footprint", "local_date", "receiver", "sender", "account_id", "category_id") VALUES (9, 110.00, 'outflow', 125730.00, '2023-03-24', 'NL1231', 'NL3000', 1, 8);
INSERT INTO "public"."transactions" ("id", "amount", "flow_type", "footprint", "local_date", "receiver", "sender", "account_id", "category_id") VALUES (10, 10.00, 'outflow', 1050.00, '2023-04-10', 'NL2492', 'NL3000', 1, 9);
INSERT INTO "public"."transactions" ("id", "amount", "flow_type", "footprint", "local_date", "receiver", "sender", "account_id", "category_id") VALUES (11, 10.00, 'outflow', 1050.00, '2023-04-24', 'NL2131', 'NL3000', 1, 10);
SELECT setval('transactions_id_seq', (SELECT MAX(id) FROM transactions));

INSERT INTO "public"."footprint" ("id", "amount", "date", "category_id", "user_id") VALUES (1, 181200.00, '2023-01-02', 5, 1);
INSERT INTO "public"."footprint" ("id", "amount", "date", "category_id", "user_id") VALUES (2, 16040.00, '2023-01-22', 4, 1);
INSERT INTO "public"."footprint" ("id", "amount", "date", "category_id", "user_id") VALUES (3, 4010.00, '2023-01-25', 7, 1);
INSERT INTO "public"."footprint" ("id", "amount", "date", "category_id", "user_id") VALUES (4, 4010.00, '2023-02-01', 4, 1);
INSERT INTO "public"."footprint" ("id", "amount", "date", "category_id", "user_id") VALUES (5, 0.00, '2023-02-21', 3, 1);
INSERT INTO "public"."footprint" ("id", "amount", "date", "category_id", "user_id") VALUES (6, 16040.00, '2023-03-10', 6, 1);
INSERT INTO "public"."footprint" ("id", "amount", "date", "category_id", "user_id") VALUES (7, 16040.00, '2023-03-12', 6, 1);
INSERT INTO "public"."footprint" ("id", "amount", "date", "category_id", "user_id") VALUES (8, 0.00, '2023-03-20', 2, 1);
INSERT INTO "public"."footprint" ("id", "amount", "date", "category_id", "user_id") VALUES (9, 125730.00, '2023-03-24', 8, 1);
INSERT INTO "public"."footprint" ("id", "amount", "date", "category_id", "user_id") VALUES (10, 1050.00, '2023-04-10', 9, 1);
INSERT INTO "public"."footprint" ("id", "amount", "date", "category_id", "user_id") VALUES (11, 1050.00, '2023-04-24', 10, 1);
SELECT setval('footprint_id_seq', (SELECT MAX(id) FROM footprint));
