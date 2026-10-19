# Write your MySQL query statement below
select t.name as Employee from Employee e
join (select * from Employee) t
on t.managerId = e.id
where e.salary<t.salary;