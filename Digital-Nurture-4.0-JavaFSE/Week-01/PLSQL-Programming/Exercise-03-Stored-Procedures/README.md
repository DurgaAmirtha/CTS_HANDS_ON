# PL/SQL Stored Procedures

## Objective
This exercise showcases PL/SQL stored procedures. It wraps banking transactions and monthly interest application blocks.

## Files
*   `sample_data.sql` – Database seed script statements
*   `schema.sql` – Database schema definitions
*   `solution.sql` – PL/SQL procedural statements solution script

## Approach
Created stored procedures with transactional statements like COMMIT and ROLLBACK to transfer balances safely.

## How to Run
```bash
@solution.sql
```

## Result
Executing the scripts registers the procedures and performs sample bank balance transfers.

## What I Learned
I understood why wrapping transactions inside stored procedures helps maintain database integrity.
