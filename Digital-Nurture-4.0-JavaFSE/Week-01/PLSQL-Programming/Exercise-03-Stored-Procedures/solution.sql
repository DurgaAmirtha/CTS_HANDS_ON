-- ====================================================================
-- Scenario 1: Process monthly interest for all savings accounts (apply 1% rate)
-- ====================================================================
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
    UPDATE Accounts
    SET Balance = Balance * 1.01,
        LastModified = SYSDATE
    WHERE AccountType = 'Savings';
    
    DBMS_OUTPUT.PUT_LINE('Monthly interest of 1% applied to all Savings accounts.');
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error processing monthly interest: ' || SQLERRM);
END;
/

-- ====================================================================
-- Scenario 2: Implement bonus scheme for employees based on department
-- ====================================================================
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_department IN VARCHAR2,
    p_bonus_pct IN NUMBER
) AS
BEGIN
    IF p_bonus_pct < 0 THEN
        DBMS_OUTPUT.PUT_LINE('Error: Bonus percentage cannot be negative.');
        RETURN;
    END IF;

    UPDATE Employees
    SET Salary = Salary * (1 + (p_bonus_pct / 100))
    WHERE Department = p_department;
    
    DBMS_OUTPUT.PUT_LINE('Updated salaries for employees in ' || p_department || ' department with a ' || p_bonus_pct || '% bonus.');
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error updating employee bonuses: ' || SQLERRM);
END;
/

-- ====================================================================
-- Scenario 3: Transfer funds between accounts with sufficient balance check
-- ====================================================================
CREATE OR REPLACE PROCEDURE TransferFunds (
    p_source_account IN NUMBER,
    p_dest_account IN NUMBER,
    p_amount IN NUMBER
) AS
    v_source_balance NUMBER;
BEGIN
    -- Input validation
    IF p_amount <= 0 THEN
        DBMS_OUTPUT.PUT_LINE('Error: Transfer amount must be positive.');
        RETURN;
    END IF;

    -- Fetch and lock source account balance
    SELECT Balance INTO v_source_balance
    FROM Accounts
    WHERE AccountID = p_source_account
    FOR UPDATE;

    -- Check balance sufficiency
    IF v_source_balance < p_amount THEN
        DBMS_OUTPUT.PUT_LINE('Error: Insufficient balance in source account ID ' || p_source_account || '. Available: $' || v_source_balance);
        ROLLBACK;
        RETURN;
    END IF;

    -- Perform transfer
    UPDATE Accounts
    SET Balance = Balance - p_amount,
        LastModified = SYSDATE
    WHERE AccountID = p_source_account;

    UPDATE Accounts
    SET Balance = Balance + p_amount,
        LastModified = SYSDATE
    WHERE AccountID = p_dest_account;

    DBMS_OUTPUT.PUT_LINE('Transferred $' || p_amount || ' from Account ID ' || p_source_account || ' to Account ID ' || p_dest_account || ' successfully.');
    COMMIT;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: Source or destination account not found.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error transferring funds: ' || SQLERRM);
END;
/
