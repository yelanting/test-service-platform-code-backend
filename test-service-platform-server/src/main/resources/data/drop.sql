use test_service_platform;
SELECT
   concat

   (
      'DROP TABLE IF EXISTS ',
      table_name,
      ';'
   )
FROM
   information_schema.tables
WHERE
   table_schema = 'test_service_platform';
SET FOREIGN_KEY_CHECKS= 0;