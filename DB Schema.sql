----------------------------------------게시판-----------------------------------------
CREATE TABLE BOARD
(
	IDX serial NOT NULL,
	PARENT_IDX NUMERIC,
	TITLE CHARACTER VARYING NOT NULL,
	CONTENTS CHARACTER VARYING NOT NULL,
	HIT_CNT NUMERIC NOT NULL,
	DEL_GB CHARACTER VARYING(1) DEFAULT 'N' NOT NULL,
	REG_DTM text DEFAULT to_char(now(), 'yyyy-mm-dd HH24:MI:SS') NOT NULL,
	REG_ID CHARACTER VARYING NOT NULL
);
COMMENT ON TABLE BOARD IS '게시판';
COMMENT ON COLUMN BOARD.IDX IS '인덱스';
COMMENT ON COLUMN BOARD.PARENT_IDX IS '부모글 인덱스';
COMMENT ON COLUMN BOARD.TITLE IS '제목';
COMMENT ON COLUMN BOARD.CONTENTS IS '내용';
COMMENT ON COLUMN BOARD.HIT_CNT IS '조회수';
COMMENT ON COLUMN BOARD.DEL_GB IS '삭제구분';
COMMENT ON COLUMN BOARD.REG_DTM IS '생성일자';
COMMENT ON COLUMN BOARD.REG_ID IS '생성자 ID';

--insert
INSERT INTO BOARD
(
    TITLE, 
    CONTENTS, 
    HIT_CNT, 
    DEL_GB, 
    REG_ID
)
VALUES
(
    '제목', 
    '내용', 
    0, 
    'N', 
    'Admin'
);

---------------------------------------------------------------------------------------
--------------------------------File 정보 테이블-------------------------------------------
CREATE TABLE TB_FILE
(
  IDX   serial,
  BOARD_IDX numeric NOT NULL,
  ORIGINAL_FILE_NAME character varying(260) NOT NULL,
  STORED_FILE_NAME character varying(36) NOT NULL,
  FILE_SIZE numeric,
  REG_DTM  text NOT NULL DEFAULT to_char(now(), 'yyyy-mm-dd HH24:MI:SS'::text), 
  REG_ID   character varying(30) NOT NULL,
  DEL_GB    character varying(1) DEFAULT 'N' NOT NULL
);
