-- Insert sample customers (John Doe is over 60, Jane Smith has a balance > 10,000)
INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified, IsVIP)
VALUES (1, 'John Doe', TO_DATE('1955-05-15', 'YYYY-MM-DD'), 5000, SYSDATE, 'FALSE');

INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified, IsVIP)
VALUES (2, 'Jane Smith', TO_DATE('1990-07-20', 'YYYY-MM-DD'), 15000, SYSDATE, 'FALSE');

INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified, IsVIP)
VALUES (3, 'Alice Johnson', TO_DATE('1985-06-12', 'YYYY-MM-DD'), 8000, SYSDATE, 'FALSE');

-- Insert loans (John Doe has a loan; and Alice's loan is due within 30 days)
INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES (1, 1, 10000, 7.5, SYSDATE - 365, SYSDATE + 730);

INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES (2, 3, 5000, 6.0, SYSDATE - 100, SYSDATE + 15); -- due in 15 days

COMMIT;
