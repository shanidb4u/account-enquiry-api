DROP TABLE IF EXISTS account_info;
DROP TABLE IF EXISTS transaction_details;

CREATE TABLE account_info (
  account_id INT AUTO_INCREMENT  PRIMARY KEY,
  user_id VARCHAR(50) NOT NULL,
  account_name VARCHAR(250) NOT NULL,
  account_number VARCHAR(250) NOT NULL,
  account_type VARCHAR(250) NOT NULL,
  balance_date DATE NOT NULL,
  opening_balance DECIMAL(10,3) NOT NULL,
  currency VARCHAR(250) NOT NULL
);

CREATE TABLE transaction_details (
  transaction_id INT AUTO_INCREMENT  PRIMARY KEY,
  account_id INT NOT NULL,
  value_date DATE NOT NULL,
  currency VARCHAR(250) NOT NULL,
  amount DECIMAL(10,3) NOT NULL,
  transaction_type VARCHAR(250) NOT NULL,
  transaction_narrative VARCHAR(250) NOT NULL,
  foreign key (account_id) references account_info(account_id)
);

INSERT INTO account_info (account_id, user_id, account_name, account_number, account_type,
 balance_date, opening_balance, currency) VALUES
  (1001, 'anzuser', 'ausavings123', '123123345', 'Savings', to_date('01/01/2019','DD/MM/YYYY'), 1234.75, 'AUD'),
  (1002, 'sguser', 'sgcurrent123', '435456789', 'Current', to_date('01/02/2019','DD/MM/YYYY'), 2345.00, 'AUD'),
  (1003, 'anzuser', 'nzsavings456', '567654345', 'Savings', to_date('01/03/2019','DD/MM/YYYY'), 4564.50, 'AUD');


INSERT INTO transaction_details (transaction_id, account_id, value_date, currency,
 amount, transaction_type, transaction_narrative) VALUES
  (5001, 1001, to_date('01/01/2019','DD/MM/YYYY'), 'AUD', 1000, 'Debit', 'Transfer 1'),
  (5002, 1002, to_date('01/01/2019','DD/MM/YYYY'), 'SQD', 2000, 'Debit', 'transfer 2'),
  (5003, 1001, to_date('01/01/2019','DD/MM/YYYY'), 'AUD', 35000, 'Credit', 'transfer 3');