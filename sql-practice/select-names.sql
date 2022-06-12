1.
You can use WHERE name LIKE 'B%' to find the countries that start with "B".

The % is a wild-card it can match any characters
Find the country that start with Y

answer)
select name from world
where name like 'Y%';


2.
Find the countries that end with y

answer)
select name from world
where name like '%y';


3.
Luxembourg has an x - so does one other country. List them both.

Find the countries that contain the letter x

answer)
SELECT name FROM world
where name like '%x%';


4.
Iceland, Switzerland end with land - but are there others?

Find the countries that end with land

answer)
select name from world
where name like '%land';


5.
Columbia starts with a C and ends with ia - there are two more like this.

Find the countries that start with C and end with ia

answer)
select name from world
where name like 'C%' and (name like '%ia');


6.
Greece has a double e - who has a double o?

Find the country that has oo in the name

answer)
select name from world
where name like '%oo%';


7.
Bahamas has three a - who else?

Find the countries that have three or more a in the name

answer)
SELECT name FROM world
  WHERE len(name) - len(replace(name, 'a', '')) >= 3;


8.
Find the countries that have "t" as the second character.

answer)
select name from world
where name like '_t%';


9.
Lesotho and Moldova both have two o characters separated by two other characters.

Find the countries that have two "o" characters separated by two others.

answer)
SELECT name FROM world
 WHERE name LIKE '%o__o%'


10.
Cuba and Togo have four characters names.

Find the countries that have exactly four characters.

answer)
select name from world
where name like '____';


11.
The capital of Luxembourg is Luxembourg. Show all the countries where the capital is the same as the name of the country

Find the country where the name is the capital city.

answer)
select name from world
where name like capital;


12.
The capital of Mexico is Mexico City. Show all the countries where the capital has the country together with the word "City".

Find the country where the capital is the country plus "City".

answer)
select name from world
where capital like '%City';


13.
Find the capital and the name where the capital includes the name of the country.

answer)
select capital, name from world
where capital like name + '%';


14.
Find the capital and the name where the capital is an extension of name of the country.

You should include Mexico City as it is longer than Mexico. You should not include Luxembourg as the capital is the same as the country.

answer)
select capital, name from world
where capital like name + '_%';


15.
For Monaco-Ville the name is Monaco and the extension is -Ville.

Show the name and the extension where the capital is an extension of name of the country.

You can use the SQL function REPLACE.

answer)
select name, trim(replace(capital, name, '')) as extension
from world
where capital like concat('%', name, '%') and len(capital) > len(name);

=> 이 문제 정답처리가 이상.




