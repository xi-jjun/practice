1.
List each country name where the population is larger than that of 'Russia'.

answer)
select name
from world
where population > (
        select population
        from world
        where name = 'Russia'
    )


2.
Show the countries in Europe with a per capita GDP greater than 'United Kingdom'.

Per Capita GDP
The per capita GDP is the gdp/population

answer)
select name
from world
where continent = 'Europe' AND
    gdp/population > (
        select gdp/population
        from world
        where name = 'United Kingdom'
    )


3.
List the name and continent of countries in the continents containing either Argentina or Australia. Order by name of the country.

answer)
select name, continent
from world
where continent in (
        select continent
        from world
        where name in ('Australia', 'Argentina')
    )
order by name;


4.
Which country has a population that is more than United Kingom but less than Germany? Show the name and the population.

answer)
select name, population
from world
where population > ( select population from world where name = 'United Kingdom' ) AND
population < ( select population from world where name = 'Germany' );


5.
Germany (population 80 million) has the largest population of the countries in Europe. Austria (population 8.5 million) has 11% of the population of Germany.

Show the name and the population of each country in Europe. Show the population as a percentage of the population of Germany.

The format should be Name, Percentage for example:

name	percentage
Albania	3%
Andorra	0%
Austria	11%
...	...
Decimal places
You can use the function ROUND to remove the decimal places.
Percent symbol %
You can use the function CONCAT to add the percentage symbol.

answer)
select name, CONCAT(
  ROUND(
    (population/(select population
                 from world
                 where name = 'Germany'
                )
    ) * 100, 0),
'%') as percentage
from world
where continent = 'Europe';


6.
Which countries have a GDP greater than every country in Europe? [Give the name only.] (Some countries may have NULL gdp values)

answer)
select name
from world
where gdp > ALL(select gdp
                from world
                WHERE gdp > 0 AND continent ='Europe')
;


7.
Find the largest country (by area) in each continent, show the continent, the name and the area:

answer)
SELECT continent, name, area
FROM world x
WHERE area >= ALL(SELECT area
                        FROM world y
                        WHERE y.continent=x.continent
                        AND area > 0);


8.

