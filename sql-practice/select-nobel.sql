


12
Find all details of the prize won by EUGENE O'NEILL

Escaping single quotes
You can't put a single quote in a quote string directly. You can use two single quotes within a quoted string.

answer)
select *
from nobel
where winner = 'EUGENE O''NEILL';

'를 2번연속으로 써줘야 escape문자를 쓸 수 있다.


13
List the winners, year and subject where the winner starts with Sir. Show the the most recent first, then by name order.

answer)
select winner, yr, subject
from nobel
where winner like 'Sir%'
order by yr desc, winner;

order by를 쓰는 방법, 원래 default sorting은 asc라는 것을 알려준 문제


14번 문제는 또 오류난 듯.
The expression subject IN ('chemistry','physics') can be used as a value - it will be 0 or 1.

Show the 1984 winners and subject ordered by subject and winner name; but list chemistry and physics last.

answer)
select winner, subject
  from nobel
  where yr=1984
  order by subject in ('physics','chemistry'), subject, winner

in 이 syntax error 뜸

