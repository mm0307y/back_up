SELECT * FROM zipcode_t

SELECT zipcode, address
 FROM zipcode_t
WHERE dong = '������';

SELECT zipcode, address
 FROM zipcode_t
WHERE dong like '����'||'%';

SELECT '��ü' zdo FROM dual
UNION ALL
SELECT zdo
  FROM (
        SELECT
               distinct(zdo) zdo
          FROM zipcode_t
        ORDER BY zdo asc
       );

SELECT
       distinct(zdo) zdo
  FROM zipcode_t
ORDER BY zdo desc;