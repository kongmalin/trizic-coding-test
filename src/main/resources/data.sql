insert into advisor (advisor_id, guid) values ('e0fe83a1-7512-432f-ba66-d2ae677272c1', '43f173ae-a17c-456e-8ccb-c69e1d61c437');
insert into advisor (advisor_id, guid) values ('e0fe83a1-7512-432f-ba66-d2ae677272c2', '43f173ae-a17c-456e-8ccb-c69e1d61c438');
insert into advisor (advisor_id, guid) values ('e0fe83a1-7512-432f-ba66-d2ae677272c3', '43f173ae-a17c-456e-8ccb-c69e1d61c439');

insert into portfolio (name, description, cash_holding_percentage, drift_percentage, created_on, model_type, rebalance_frequency, advisor_id) values ('Portfolio01', 'example model with tech stocks 01', 10, 20, '2017-03-01', 'TAXABLE', 'QUARTERLY', 'e0fe83a1-7512-432f-ba66-d2ae677272c1');
insert into portfolio (name, description, cash_holding_percentage, drift_percentage, created_on, model_type, rebalance_frequency, advisor_id) values ('Portfolio02', 'example model with tech stocks 02', 5, 20, '2017-05-05', 'QUALIFIED', 'SEMI_ANNUAL', 'e0fe83a1-7512-432f-ba66-d2ae677272c1');
insert into portfolio (name, description, cash_holding_percentage, drift_percentage, created_on, model_type, rebalance_frequency, advisor_id) values ('Portfolio03', 'example model with tech stocks 03', 5, 15, '2017-10-02', 'TAXABLE', 'ANNUAL', 'e0fe83a1-7512-432f-ba66-d2ae677272c2');
insert into portfolio (name, description, cash_holding_percentage, drift_percentage, created_on, model_type, rebalance_frequency, advisor_id) values ('Portfolio04', 'example model with tech stocks 04', 9, 10, '2017-03-01', 'TAXABLE', 'QUARTERLY', 'e0fe83a1-7512-432f-ba66-d2ae677272c2');
insert into portfolio (name, description, cash_holding_percentage, drift_percentage, created_on, model_type, rebalance_frequency, advisor_id) values ('Portfolio05', 'example model with tech stocks 05', 8, 20, '2017-05-05', 'QUALIFIED', 'MONTHLY', 'e0fe83a1-7512-432f-ba66-d2ae677272c3');

insert into asset_allocation (symbol, percentage, name) values ('AAPL', 10, 'Portfolio01');
insert into asset_allocation (symbol, percentage, name) values ('GOOG', 20, 'Portfolio01');
insert into asset_allocation (symbol, percentage, name) values ('IBM', 30, 'Portfolio01');
insert into asset_allocation (symbol, percentage, name) values ('FB', 20, 'Portfolio01');
insert into asset_allocation (symbol, percentage, name) values ('COKE', 30, 'Portfolio02');
insert into asset_allocation (symbol, percentage, name) values ('PEP', 30, 'Portfolio02');
insert into asset_allocation (symbol, percentage, name) values ('CMG', 20, 'Portfolio02');
insert into asset_allocation (symbol, percentage, name) values ('TEST01', 20, 'Portfolio03');
insert into asset_allocation (symbol, percentage, name) values ('TEST02', 25, 'Portfolio03');
insert into asset_allocation (symbol, percentage, name) values ('TEST03', 5, 'Portfolio03');
insert into asset_allocation (symbol, percentage, name) values ('TEST04', 5, 'Portfolio03');
insert into asset_allocation (symbol, percentage, name) values ('TEST05', 30, 'Portfolio03');
insert into asset_allocation (symbol, percentage, name) values ('TEST06', 60, 'Portfolio04');
insert into asset_allocation (symbol, percentage, name) values ('TEST07', 30, 'Portfolio04');
insert into asset_allocation (symbol, percentage, name) values ('TEST08', 30, 'Portfolio05');
insert into asset_allocation (symbol, percentage, name) values ('TEST09', 40, 'Portfolio05');
insert into asset_allocation (symbol, percentage, name) values ('TEST10', 20, 'Portfolio05');