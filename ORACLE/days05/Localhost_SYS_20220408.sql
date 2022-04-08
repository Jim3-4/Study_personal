-- SYS 계정 접속 --

GRANT  SELECT ON dept TO HR; 
--
SELECT *
FROM all_synonyms  -- 자료 사저 : 뷰(view)
WHERE synonym_name LIKE '%airang%';
--
CREATE PUBLIC SYNONYM arirang FOR scott.dept;

--
SELECT *
FROM arirang;

-- PUBLIC 시노님  : dual 
