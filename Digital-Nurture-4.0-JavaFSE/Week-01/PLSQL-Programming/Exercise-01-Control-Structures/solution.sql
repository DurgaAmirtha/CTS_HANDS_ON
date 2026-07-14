-- ====================================================================
-- Scenario 1: Apply a 1% discount to loan interest rates for customers above 60 years old.
-- ====================================================================
DECLARE
    v_age NUMBER;
BEGIN
    FOR r_loan IN (SELECT l.LoanID, l.InterestRate, c.DOB, c.Name 
                   FROM Loans l 
                   JOIN Customers c ON l.CustomerID = c.CustomerID) 
    LOOP
        v_age := FLOOR(MONTHS_BETWEEN(SYSDATE, r_loan.DOB) / 12);
        
        IF v_age > 60 THEN
            UPDATE Loans 
            SET InterestRate = InterestRate - 1 
            WHERE LoanID = r_loan.LoanID;
            
            DBMS_OUTPUT.PUT_LINE('Applied 1% discount to Customer ' || r_loan.Name || ' (Age: ' || v_age || '). Old Rate: ' || r_loan.InterestRate || '%, New Rate: ' || (r_loan.InterestRate - 1) || '%');
        END IF;
    END LOOP;
    COMMIT;
END;
/

-- ====================================================================
-- Scenario 2: Iterate through all customers and set IsVIP to 'TRUE' for those with balance over $10,000.
-- ====================================================================
BEGIN
    FOR r_cust IN (SELECT CustomerID, Name, Balance FROM Customers) 
    LOOP
        IF r_cust.Balance > 10000 THEN
            UPDATE Customers 
            SET IsVIP = 'TRUE' 
            WHERE CustomerID = r_cust.CustomerID;
            
            DBMS_OUTPUT.PUT_LINE('Customer ' || r_cust.Name || ' promoted to VIP. Balance: $' || r_cust.Balance);
        ELSE
            UPDATE Customers 
            SET IsVIP = 'FALSE' 
            WHERE CustomerID = r_cust.CustomerID;
        END IF;
    END LOOP;
    COMMIT;
END;
/

-- ====================================================================
-- Scenario 3: Fetch all loans due in the next 30 days and print reminder messages.
-- ====================================================================
DECLARE
    v_days_left NUMBER;
BEGIN
    FOR r_due IN (SELECT l.LoanID, c.Name, l.EndDate 
                  FROM Loans l 
                  JOIN Customers c ON l.CustomerID = c.CustomerID) 
    LOOP
        v_days_left := FLOOR(r_due.EndDate - SYSDATE);
        
        IF v_days_left >= 0 AND v_days_left <= 30 THEN
            DBMS_OUTPUT.PUT_LINE('REMINDER: Loan ID ' || r_due.LoanID || ' for Customer ' || r_due.Name || ' is due in ' || v_days_left || ' days (Date: ' || TO_CHAR(r_due.EndDate, 'YYYY-MM-DD') || ').');
        END IF;
    END LOOP;
END;
/
