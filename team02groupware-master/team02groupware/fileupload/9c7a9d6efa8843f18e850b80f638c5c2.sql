-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        5.5.32 - MySQL Community Server (GPL)
-- 서버 OS:                        Win32
-- HeidiSQL 버전:                  10.1.0.5464
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 테이블 dev34mvc.board 구조 내보내기
CREATE TABLE IF NOT EXISTS `board` (
  `board_category` varchar(20) NOT NULL,
  `board_title` varchar(100) NOT NULL,
  `board_content_text` mediumtext NOT NULL,
  `board_writer` varchar(15) NOT NULL DEFAULT '관리자',
  `board_write_date` datetime NOT NULL,
  `board_view_count` int(10) NOT NULL DEFAULT '0',
  `board_num` int(11) NOT NULL AUTO_INCREMENT,
  `board_comment_count` int(10) NOT NULL DEFAULT '0',
  `board_file_check` enum('Y','N') NOT NULL DEFAULT 'N',
  PRIMARY KEY (`board_num`)
) ENGINE=InnoDB AUTO_INCREMENT=150 DEFAULT CHARSET=utf8;

-- 테이블 데이터 dev34mvc.board:~88 rows (대략적) 내보내기
/*!40000 ALTER TABLE `board` DISABLE KEYS */;
INSERT INTO `board` (`board_category`, `board_title`, `board_content_text`, `board_writer`, `board_write_date`, `board_view_count`, `board_num`, `board_comment_count`, `board_file_check`) VALUES
	('고객지원팀', '고객 응대 태도 관련하여', 'ㄴㅁㅇㅁㄴㅁㄴㅇㄴㅁㅇ', '관리자', '2020-01-22 00:00:00', 0, 1, 0, 'N'),
	('고객지원팀', '고객지원팀은 필독해주시길 바랍니다.', '반갑습니다', '관리자', '2020-01-22 00:00:00', 0, 2, 0, 'N'),
	('고객지원팀', '안녕하십니까', '반갑습니다2', '관리자', '2020-01-22 00:00:00', 5, 3, 0, 'N'),
	('고객지원팀', '저번에도 그랬고 앞으로도', '반가워영', '관리자', '2020-01-22 00:00:00', 0, 4, 0, 'N'),
	('마케팅팀', '안녕하십니까_수정', '<p>아자차카타파하123</p><p>수정</p>', '관리자', '2020-01-22 00:00:00', 3, 5, 0, 'N'),
	('마케팅팀', '회의록 입니다.', '안녕하세요. 34기', '홍길동', '2020-01-21 00:00:00', 1, 6, 0, 'N'),
	('마케팅팀', '시장 동향 보고서 입니다', '반갑습니다2', '관리자', '2020-01-22 00:00:00', 0, 7, 0, 'N'),
	('마케팅팀', '금년 들어서는 더더욱', '아자차카타파하', '관리자', '2020-01-22 00:00:00', 1, 8, 0, 'N'),
	('마케팅팀', '마케팅팀', 'dsfsadfsdf', '관리자', '2020-01-23 00:00:00', 0, 9, 0, 'N'),
	('개발팀', '통계치를 보면', 'ㄴㅁㅇㅁㄴ', '관리자', '2020-01-22 00:00:00', 0, 10, 0, 'N'),
	('개발팀', '저번주에도 그렇고', '반갑습니다', '관리자', '2020-01-22 00:00:00', 0, 11, 0, 'N'),
	('개발팀', '저희 회사는', '아자차카타파하', '관리자', '2020-01-22 00:00:00', 0, 12, 0, 'N'),
	('개발팀', '가만보면', 'dsfsadfsdf', '관리자', '2020-01-23 00:00:00', 0, 13, 0, 'N'),
	('개발팀', '이렇게도 생각해 볼 수 있는', 'sadsadas0508', '관리자', '2020-01-23 00:00:00', 0, 14, 0, 'N'),
	('개발팀', 'nodeJs 관련 질문입니다', 'sdasd', '관리자', '2020-01-23 00:00:00', 0, 15, 0, 'N'),
	('디자인팀', '이번 컨셉', 'ㄴㅁㅇㅁㄴ', '관리자', '2020-01-22 00:00:00', 0, 16, 0, 'N'),
	('개발팀', '자바의 정석', 'ㄴㅁㅇㅁㄴㅁㄴㅇㄴㅁㅇ', '관리자', '2020-01-22 00:00:00', 0, 17, 0, 'N'),
	('디자인팀', '요구사항 관련', '반갑습니다2', '관리자', '2020-01-22 00:00:00', 0, 18, 0, 'N'),
	('개발팀', '프로그래머란', '아자차카타파하', '관리자', '2020-01-22 00:00:00', 0, 19, 0, 'N'),
	('디자인팀', '디자인 시안입니다.', '아자차카타파하123', '관리자', '2020-01-22 00:00:00', 0, 20, 0, 'N'),
	('개발팀', '파이썬을 한다는건', 'fsdfsdf', '관리자', '2020-01-23 00:00:00', 0, 21, 0, 'N'),
	('디자인팀', '저번에 진행했었던', 'sadsadas0508', '관리자', '2020-01-23 00:00:00', 0, 22, 0, 'N'),
	('개발팀', '비쥬얼 스튜디오코드는', 'sdasd', '관리자', '2020-01-23 00:00:00', 1, 23, 0, 'N'),
	('개발팀', '저번 프로젝트에서도 그렇고', '안녕하세요. 34기', '홍길동', '2020-01-21 00:00:00', 0, 24, 0, 'N'),
	('개발팀', '걱정이네요', '반가워영', '관리자', '2020-01-22 00:00:00', 0, 25, 0, 'N'),
	('개발팀', '이방법은', '아자차카타파하123', '관리자', '2020-01-22 00:00:00', 0, 26, 0, 'N'),
	('경영지원팀', '안녕하십니까 저는', '반가워영', '관리자', '2020-01-22 00:00:00', 7, 27, 0, 'N'),
	('경영지원팀', '경영론', '아자차카타파하123', '관리자', '2020-01-22 00:00:00', 2, 28, 0, 'N'),
	('경영지원팀', '창의적인 생각', 'fsdfsdf', '관리자', '2020-01-23 00:00:00', 0, 29, 0, 'N'),
	('경영지원팀', '금년 목표 매출액 관련', 'sdasd', '관리자', '2020-01-23 00:00:00', 3, 30, 0, 'N'),
	('경영지원팀', '저번주에 진행했던', 'ㄴㅁㅇㅁㄴㅁㄴㅇㄴㅁㅇ', '관리자', '2020-01-22 00:00:00', 2, 31, 0, 'N'),
	('디자인팀', '디자인의 정석', 'ㄴㅇㄹㄴㅇㄹㅇㄴㄹㅇㅁ ㄴ', '관리자', '2020-01-28 00:00:00', 7, 32, 0, 'N'),
	('마케팅팀', '마케터', 'ㅓ호ㅓ', '관리자', '2020-01-28 00:00:00', 1, 33, 0, 'N'),
	('개발팀', '이번 프로젝트', '김\r\n연\r\n지\r\n메\r\n롱\r\n', '관리자', '2020-01-28 00:00:00', 6, 34, 0, 'N'),
	('고객지원팀', '배송문의', '안녕', '관리자', '2020-02-06 00:00:00', 0, 35, 0, 'N'),
	('마케팅팀', '이번주는', '???', '관리자', '2020-02-10 15:00:24', 7, 36, 0, 'N'),
	('개발팀', '스프링에 관하여', '??\r\n', '관리자', '2020-02-10 15:19:57', 4, 37, 0, 'N'),
	('디자인팀', '기간 문의', 'ㅇㅇ', '관리자', '2020-02-10 16:04:41', 3, 38, 0, 'N'),
	('개발팀', '개발 환경 관련', 'ㄴㅇㄹㄴㅇㄹ', '관리자', '2020-02-10 16:15:17', 0, 39, 0, 'N'),
	('마케팅팀', '앞으로', 'ㄴㅇㄹㄴㅇㅁㄹ', '관리자', '2020-02-10 16:19:54', 0, 40, 0, 'N'),
	('경영지원팀', '여러분들', 'ㄹㅇㄴㄹㅁㄴㅇㄹ', '관리자', '2020-02-10 16:20:08', 15, 41, 0, 'N'),
	('경영지원팀', '업계 통상치', 'asdfadsf', '관리자', '2020-02-11 09:25:29', 0, 42, 0, 'N'),
	('개발팀', '고객 요구사항', 'ffff', '관리자', '2020-02-11 09:25:33', 0, 43, 0, 'N'),
	('경영지원팀', '업무 관련해서', '배송배송', '관리자', '2020-02-11 09:25:40', 2, 44, 0, 'N'),
	('디자인팀', '문의사항', 'ㅁㄴㅇㄹㅇㅁㄴㄹ', '관리자', '2020-02-11 09:25:49', 0, 45, 0, 'N'),
	('개발팀', '자바 스프링', 'ㅁㅇㄴㄹ', '관리자', '2020-02-11 09:25:53', 1, 46, 0, 'N'),
	('디자인팀', '올 하반기 컨셉은', 'ㄻㅇㄴㄹ', '관리자', '2020-02-11 09:26:10', 3, 47, 0, 'N'),
	('경영지원팀', '재무상황 보고서 입니다', 'ㅁㄴㅇㅊ', '관리자', '2020-02-11 09:26:15', 5, 48, 0, 'N'),
	('디자인팀', '디자인 시안 입니다', 'ㅎㅎ', '관리자', '2020-02-14 09:23:12', 0, 49, 0, 'N'),
	('경영지원팀', '상반기 계획', 'ㅁㄴㅇ', '관리자', '2020-02-14 09:47:42', 2, 50, 0, 'N'),
	('고객지원팀', '효과적인', 'sdafasdf', '관리자', '2020-02-18 11:23:28', 0, 51, 0, 'N'),
	('마케팅팀', '매출 증대 방안', 'asdasd', '관리자', '2020-02-18 11:31:23', 3, 52, 0, 'N'),
	('고객지원팀', '신규 고객 유치', 'artasdfsadfadsf', '관리자', '2020-02-18 11:31:30', 1, 53, 1, 'N'),
	('개발팀', '올해 목표치', 'asdfadsf', '관리자', '2020-03-03 09:05:38', 1, 54, 0, 'N'),
	('마케팅팀', '저번주에는', '안녕', '관리자', '2020-03-03 09:09:57', 2, 55, 2, 'N'),
	('마케팅팀', '이번 프로젝트 관련', '배송', '관리자', '2020-03-03 09:11:48', 1, 57, 0, 'N'),
	('마케팅팀', '마케팅 건의안 입니다.', 'sdf', '관리자', '2020-03-03 09:15:01', 2, 58, 2, 'N'),
	('공지', '금년 우리 회사의 목표는', 'ㅇㅇ', '관리자', '2020-03-04 09:12:55', 1, 59, 2, 'N'),
	('공지', '임직원 여러분들', 'ㅇㅇ', '관리자', '2020-03-04 09:29:11', 0, 60, 1, 'N'),
	('공지', '상반기 회사 성과에 관하여', 'ㅇㅇ', '관리자', '2020-03-04 09:29:43', 0, 61, 1, 'N'),
	('공지', '최근들어', 'ㅇㅇ', '관리자', '2020-03-04 11:40:43', 1, 63, 6, 'N'),
	('개발팀', '자바의 정석', '<p>ㅇㅇ</p>', '관리자', '2020-03-11 10:30:11', 14, 65, 4, 'N'),
	('개발팀', '필터와 인터셉트', '<p>ㅇ</p><p>ㅇ</p><p>ㅇ</p><p>ㅇ</p><p><br></p>', '관리자', '2020-03-16 09:16:16', 4, 66, 1, 'N');
/*!40000 ALTER TABLE `board` ENABLE KEYS */;

-- 테이블 dev34mvc.board_comment 구조 내보내기
CREATE TABLE IF NOT EXISTS `board_comment` (
  `comment_num` int(5) NOT NULL AUTO_INCREMENT COMMENT '댓글번호',
  `board_num` int(11) NOT NULL COMMENT '게시판 번호',
  `employee_code` varchar(15) NOT NULL DEFAULT 'EE004' COMMENT '사원번호',
  `comment_date` datetime NOT NULL COMMENT '작성일',
  `comment_content` text NOT NULL COMMENT '내용',
  `comment_writer` varchar(50) NOT NULL COMMENT '작성자닉네임',
  PRIMARY KEY (`comment_num`),
  KEY `게시물번호` (`board_num`),
  KEY `FK_employee_TO_board_comment` (`employee_code`),
  CONSTRAINT `FK_board_TO_board_comment` FOREIGN KEY (`board_num`) REFERENCES `board` (`board_num`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_employee_TO_board_comment` FOREIGN KEY (`employee_code`) REFERENCES `employee` (`employee_code`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8 COMMENT='게시판 댓글 테이블';

-- 테이블 데이터 dev34mvc.board_comment:~20 rows (대략적) 내보내기
/*!40000 ALTER TABLE `board_comment` DISABLE KEYS */;
INSERT INTO `board_comment` (`comment_num`, `board_num`, `employee_code`, `comment_date`, `comment_content`, `comment_writer`) VALUES
	(1, 59, 'EE004', '2020-03-13 13:55:27', '넵', '관리자'),
	(2, 59, 'EE004', '2020-03-13 13:55:33', '옙', '관리자'),
	(3, 60, 'EE004', '2020-03-13 13:55:50', '예?', '관리자'),
	(4, 61, 'EE004', '2020-03-13 13:56:00', '하하', '관리자'),
	(5, 63, 'EE004', '2020-03-13 13:56:08', 'ㅇㅇ', '관리자'),
	(6, 63, 'EE004', '2020-03-13 13:56:09', 'ㅇㅇ', '관리자'),
	(7, 63, 'EE004', '2020-03-13 13:56:10', 'ㅇㅇ', '관리자'),
	(8, 63, 'EE004', '2020-03-13 13:56:13', 'ㅇㅇ\nㅇㅇ\nㅇㅇ\nㅇㅇ', '관리자'),
	(9, 63, 'EE004', '2020-03-13 13:56:16', 'ㅎㅇㅎㅇ', '관리자'),
	(10, 63, 'EE004', '2020-03-13 13:56:17', 'ㅎㅇㅎㅇ', '관리자'),
	(12, 58, 'EE004', '2020-03-13 13:56:31', 'ㅇㅇ', '관리자'),
	(13, 58, 'EE004', '2020-03-13 13:56:32', 'ㅇㅇ', '관리자'),
	(14, 55, 'EE004', '2020-03-13 13:56:37', 'ㅇㅇ', '관리자'),
	(15, 55, 'EE004', '2020-03-13 13:56:38', 'ㅇㅇ', '관리자'),
	(16, 53, 'EE004', '2020-03-13 13:56:45', 'ㅎㅇㅎㅇ', '관리자'),
	(17, 65, 'EE004', '2020-03-13 14:48:23', 'ㅁㄴㅇㄹㅇㅁㄴㄹ', '관리자'),
	(18, 65, 'EE004', '2020-03-13 14:48:29', '아하\n아하', '관리자'),
	(19, 65, 'EE004', '2020-03-13 14:48:43', 'ㅇㅎ', '관리자'),
	(20, 65, 'EE004', '2020-03-16 09:14:58', 'ㅎㅇㅎㅇ\nㅎㅇㅎㅇ', '관리자'),
	(21, 66, 'EE004', '2020-03-16 09:16:36', 'test\ntest\ntest', '관리자');
/*!40000 ALTER TABLE `board_comment` ENABLE KEYS */;

-- 테이블 dev34mvc.board_file 구조 내보내기
CREATE TABLE IF NOT EXISTS `board_file` (
  `board_file_num` int(11) NOT NULL AUTO_INCREMENT COMMENT '파일번호',
  `board_num` int(11) NOT NULL COMMENT '게시판 번호',
  `board_file_original_name` varchar(256) NOT NULL COMMENT '파일명(original)',
  `board_file_stored_name` varchar(36) NOT NULL COMMENT '파일명(저장용)',
  `board_file_size` int(255) NOT NULL COMMENT '파일용량',
  PRIMARY KEY (`board_file_num`),
  KEY `FK_board_TO_board_file` (`board_num`),
  CONSTRAINT `FK_board_TO_board_file` FOREIGN KEY (`board_num`) REFERENCES `board` (`board_num`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8 COMMENT='게시판 파일 테이블';

-- 테이블 데이터 dev34mvc.board_file:~17 rows (대략적) 내보내기
/*!40000 ALTER TABLE `board_file` DISABLE KEYS */;
/*!40000 ALTER TABLE `board_file` ENABLE KEYS */;

-- 테이블 dev34mvc.employee_group 구조 내보내기
CREATE TABLE IF NOT EXISTS `employee_group` (
  `group_code` varchar(15) NOT NULL COMMENT '조직코드',
  `group_name` varchar(15) NOT NULL COMMENT '조직명',
  `group_level` int(11) NOT NULL COMMENT '레벨',
  `group_parent` varchar(15) DEFAULT NULL COMMENT '상위조직명',
  PRIMARY KEY (`group_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='조직 테이블';

-- 테이블 데이터 dev34mvc.employee_group:~6 rows (대략적) 내보내기
/*!40000 ALTER TABLE `employee_group` DISABLE KEYS */;
INSERT INTO `employee_group` (`group_code`, `group_name`, `group_level`, `group_parent`) VALUES
	('EG001', '대표이사', 1, NULL),
	('EG002', '경영지원팀', 2, '대표이사'),
	('EG003', '마케팅팀', 3, '경영지원부'),
	('EG004', '개발팀', 2, NULL),
	('EG005', '고객지원팀', 2, NULL),
	('EG006', '디자인팀', 2, NULL);
/*!40000 ALTER TABLE `employee_group` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
