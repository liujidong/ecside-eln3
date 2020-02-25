package com.fjt;

/** 常量 */
public interface AspConstants {
	
	/** AJAX返回类型 html */
	String CONTENT_TYPE_HTML = "text/html; charset=UTF-8";
	/** AJAX返回类型 xml */
	String CONTENT_TYPE_XML = "text/xml; charset=UTF-8";
	
	/** 考试信息添加成功 */
	String EXAM_SAVE_SUCCEED = "examSaveSeccess";
	/** 考试信息添加失败 */
	String EXAM_SAVE_FAILED = "examSaveFailed";
	
	/** 考试信息修改成功 */
	String EXAM_MODIFY_SUCCEED = "examModifySeccess";
	/** 考试信息修改失败 */
	String EXAM_MODIFY_FAILED = "examModifyFailed";
	
	/** 查询信息成功*/
	String SELECT_SUCCEED = "selectSeccess";
	/** 查询信息失败*/
	String SELECT_FAILED = "selectFailed";
	
	/** 网络联接失败 */
	String CONNECTION_FAILED = "connectionFailed";
	
	/** 固定试卷 : 1 */
	String EXAM_PAPER_TYPE_FIXED = "1";
	/** 随机试卷 : 2 */
	String EXAM_PAPER_TYPE_RANDOM = "2";
	
	/** 课程试卷 ：3 */
	String EXAM_PAPER_TYPE_COURSE = "3";
	
	/** 固定出题 : 0 */
	int EXAM_PAPER_ITEM_STRATEGY_FIXED = 0;
	/** 乱序出题 : 1 */
	int EXAM_PAPER_ITEM_STRATEGY_RANDOM = 1;
	
	/** 日期格式 */
	String SIMPLE_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	
	/** 单选题 :1*/
	int ITEM_TYPE_RADIO = 1;
	/** 多选题: 2*/
	int ITEM_TYPE_MORE = 2;
	/** 判断题: 3*/
	int ITEM_TYPE_DYN = 3;
	/** 填空题: 4*/
	int ITEM_TYPE_FILL = 4;
	/** 计算题: 5*/
	int ITEM_TYPE_COMPUTE = 5;
	/** 问答题：6 */
	int ITEM_TYPE_QUESTION = 6;
	/** 语音题：7 */
	int ITEM_TYPE_WAVE = 7;
	/** 操作题：8*/
	int ITEM_TYPE_OPERATOR = 8;
	
	/** 试题难度:无 */
	int ITEM_DIFFICULTY_ALL = 0;
	/** 试题难度:1 */
	int ITEM_DIFFICULTY_ONE = 1;
	/** 试题难度:2 */
	int ITEM_DIFFICULTY_TWO = 2;
	/** 试题难度:3 */
	int ITEM_DIFFICULTY_THREE = 3;
	/** 试题难度:4 */
	int ITEM_DIFFICULTY_FOUR = 4;
	/** 试题难度:5 */
	int ITEM_DIFFICULTY_FIVE = 5 ;
	
	
	/** 统一考试 */
	int EXAM_TYPE_UNITIVE = 0;
	/** 课程考试 */
	int EXAM_TYPE_COURSE = 1;
	/** 练习*/
	int EXAM_TYPE_TRAINING = 2;
	/** 竞赛 */
	int EXAM_TYPE_CONTEST = 3;
	
	/** 考试试题集合 */
	String EXAM_ITEM_LIST = "examItemList";
	
	/** 考试试题MAP */
	String EXAM_ITEM_MAP = "examItemMap";
	
	/** 考试名称 */
	String EXAM_INFO = "examInfo";
	
	/** 0、 考试未结束 */
	int EXAM_NOT_FINISH = 0;
	
	/** 1、 考试结束*/
	int EXAM_FINISHED =1;
	
	/** 0、考试未发布 */
	int EXAM_NOT_PUBLICED = 0;
	
	/** 1、考试发布 */
	int EXAM_PUBLICED = 1;
	
	/** 0 未删除*/
	int NOT_DELETE = 0;
	
	/** 1 删除*/
	int DELETED = 1;
	
	/** 状态 
	 * 公告状态（1-未发布，2-已发布，3-已撤销）	 * 
	 * */
	int BULLETIN_STATE_RELEASE_NOT = 1;
	int BULLETIN_STATE_RELEASE = 2;
	int BULLETIN_STATE_CANCEL = 3;
	
	/**
	 * 系统公告的两种（11是系统管理员可见，22是全部学员可见）
	 */
	int SYSTEM_BULLETIN_TYPE_ADMIN=11;
	int SYSTEM_BULLETIN_TYPE_USERS=12;
	
	/**
	 *  发送方式：1－站内，2－邮件，12－站内＋邮件 4－手机短信 14－手机短信＋站内，24－手机短信＋邮件,124－站内＋邮件＋手机短信
	 */
	public static final int MESSAGE_MODE_INNER = 1;
	public static final int MESSAGE_MODE_EMAIL = 2;
	public static final int MESSAGE_MODE_INNER_EMAIL = 12;
	public static final int MESSAGE_MODE_NOTE = 4;
	public static final int MESSAGE_MODE_INNER_NOTE = 14;
	public static final int MESSAGE_MODE_EMAIL_NOTE = 24;
	public static final int MESSAGE_MODE_INNER_EMAIL_NOTE = 124;
		
	/**
	 * 信息状态：1＝已发送，2＝未发送，3＝已删除
	 */
	public static final int MESSAGE_STATE_SEND = 1;
	public static final int MESSAGE_STATE_SEND_NOT = 2;
	public static final int MESSAGE_STATE_DELETE = 3;
	
	/**
	 * 1=已读，2=未读
	 */
	public static final int MESSAGE_STATE_READ = 1;
	public static final int MESSAGE_STATE_READ_NOT = 2;

	/** 课程设置范围-部门 */
	public static final int COURSE_CONFINE_OBJECT_TYPE_ORG=0;
	/** 课程设置范围-岗位 */
	public static final int COURSE_CONFINE_OBJECT_TYPE_POS=1;
	/** 课程设置范围-班级 */
	public static final int COURSE_CONFINE_OBJECT_TYPE_CLA=2;
	/** 课程设置范围-标签 */
	public static final int COURSE_CONFINE_OBJECT_TYPE_TAG=3;
	/** 课程设置范围-个人 */
	public static final int COURSE_CONFINE_OBJECT_TYPE_PER=4;
	
	/**
	 * 必修课
	 */
	public static final int COURSE_CONFINE_COURSE_NEED_MUST = 1;
	
	/**
	 * 选修课
	 */
	public static final int COURSE_CONFINE_COURSE_NEED = 2;
	
	
	
	/** 课程设置范围-部门 */
	public static final int STUDENT_PLAN_OBJECT_TYPE_ORG=1;
	/** 课程设置范围-岗位 */
	public static final int STUDENT_PLAN_OBJECT_TYPE_POS=2;
	/** 课程设置范围-标签 */
	public static final int STUDENT_PLAN_OBJECT_TYPE_TAG=3;
	/** 课程设置范围-班级 */
	public static final int STUDENT_PLAN_OBJECT_TYPE_CLA=4;
	
	
	/** 报表范围-全公司 */
	public static final int REPORT_OBJECT_TYPE_COOP=0;
	/** 报表范围-部门 */
	public static final int REPORT_OBJECT_TYPE_ORG=1;
	/** 报表范围-岗位 */
	public static final int REPORT_OBJECT_TYPE_POS=2;
	/** 报表范围-班级 */
	public static final int REPORT_OBJECT_TYPE_CLA=3;
	/** 报表范围-标签 */
	public static final int REPORT_OBJECT_TYPE_TAG=4;
	/** 报表范围-个人 */
	public static final int REPORT_OBJECT_TYPE_PER=5;
	/** 报表计划时间 */
	public static final int REPORT_PLAN_DATE = 0;
	/** 报表学习时间 */
	public static final int REPORT_STUDY_DATE = 1;
	/** 报表考试时间 */
	public static final int REPORT_COURSE_EXAM_DATE = 2;
	/** 改进计划时间 */
	public static final int REPORT_IMPROVE_PLAN_DATE = 3;
	
	/** 课程考试试题数 */
	public static final int COURSE_EXAM_COUNT = 15;
	/** 课程考试已提交*/
	public static final int COURSE_EXAM_SUBMITED = 1;
	/** 课程考试未提交*/
	public static final int COURSE_EXAM_NO_SUBMIT = 0;
	/** 课程考试通过 */
	public static final int COURSE_EXAM_PASSED = 1;
	/** 课程考试未通过 */
	public static final int COURSE_EXAM_NO_PASS = 0;
	
	/** 新生成随机试卷*/
	public static final String NEW_RANDOM_PAPER_FLAG = "1";
	
	/** 开放部分课程 */
	public static final int NOT_OPEN_ALL_COURSE = 0;
	
	/** 开放所有课程 */
	public static final int OPEN_ALL_COURSE = 1;
	
	/**
	 * 1=班长，2=学员
	 */
	public static final int CLASS_ROLE_MONITOR = 1;
	public static final int CLASS_ROLE_STUDENT = 2;

	
	// --- 页面导向常量开始 --- /

	public static final String FORWARD_EXAM_ITEM_LIST = "forwardExamItemList";
	public static final String FORWARD_EXAM_ITEM_ONE = "forwardExamItemOne";
	
	public static final String CACHED_PAPER_ITEM_LIST = "cachedPaper";
	public static final String CACHED_PAPER_ITEM_ONE = "cachedPaperItemOne";
	
	public static final int EXAM_MODE_FULL = 0;
	public static final int EXAM_MODE_ONE = 1;
	
	// --- 页面导向常量结束 --- /
	
	public static final String LESSON_STATE_NO_ATTEMPTED = "not attempted";
	
	public static final String LESSON_STATE_COMPLETED = "completed";
	
	//---学习页面 default logo---/
	public static final String STUDY_LOGO_PATH = "templates\\login\\logo.png";
	
}
