package com.darly.dubbo.common;

/**
 * @package: com.xiangxun.util
 * @ClassName: ConstantStatus.java
 * @Description: 结果码

 * @author: HanGJ
 * @date: 2015-7-24 上午10:47:02
 */
public class ConstantStatus {
	// 列表请求的状态 刷新 加载更多
	public static final int listStateRefresh = 1;
	public static final int listStateLoadMore = 2;
	public static final int listStateFirst = 3;

	// 登录
	public static final int loadSuccess = 4;
	public static final int loadFailed = 5;
	// 从本地加载图片状态

	public static final int GetLocalSuccess = 13;
	public static final int GetLocalFalse = 14;

	public static final int FAILED = 15;
	public static final int FAILED_NO_NET = 16;
	public static final int FAILED_NO_USER = 17;
	public static final int VIEWOLDPIC = 18;
	public static final int NOPIC = 19;
	public static final int NOLAWKEY = 20;
	public static final int LAWKEY = 21;
	public static final int DISMISS_POPUPMENU = 22;

	public static final int CASE_SEARCH_SUCCESS = 27;
	public static final int CASE_SEARCH_FALSE = 28;

	public static final int VEHICLE_SEARCH_SUCCESS = 29;
	public static final int VEHICLE_SEARCH_FALSE = 30;
	// SD卡无空间
	public static final int SD_NOSPACE = 31;
	public static final int FAILED_ERROR_PSSWORD = 33;
	public static final int ACCOUNT_NO_BOUND = 34;
	public static final int ACCOUNT_NO_AUTHORITY = 35;

	public static final int SREACHCONTATSSUCCESS = 36;
	public static final int SREACHCONTATSFALSE = 37;

	public static final int SREACH_SYSTEM_MESSAGE_SUCCESS = 38;
	public static final int SREACH_SYSTEM_MESSAGE_FALSE = 39;

	public static final int SREACH_SYSTEM_NITICE_SUCCESS = 40;
	public static final int SREACH_SYSTEM_NITICE_FALSE = 41;

	public static final int SREACH_VIODATA_SUCCESS = 42;
	public static final int SREACH_VIODATA_FALSE = 43;

	public static final int SREACH_DETAIL_SUCCESS = 44;
	public static final int SREACH_DETAIL_FALSE = 45;

	public static final int UPLOAD_GPSDATA = 46;
	public static final int UPLOAD_VIODATA = 47;
	public static final int UPLOAD_FIELDPUNISHDATA = 48;
	public static final int UPLOAD_ENFORCEMENTDATA = 49;
	public static final int UPLOAD_DUTYDATA = 50;
	public static final int UPLOAD_ACCIDENTDATA = 51;
	public static final int UPLOAD_LAWCHECKDATA = 52;
	public static final int UPLOAD_ALLDATA = 53;
	public static final int UPLOAD_WARNACKDATA = 57;
	public static final int UPLOAD_CHANGE_INFO = 58;
	// 上传本地照片状态码
	public static final int UpLoadSuccess = 61;
	public static final int UpLoadFalse = 62;

	public static final int getVioDicData = 66;
	public static final int getArticleInfo = 67;

	public static final int OTHER_PLATENUM = 68;

	public static final int getEmergencyOrgListSuccess = 69;
	public static final int getEmergencyOrgListFalse = 70;
	public static final int getEmergencyMaterialListSuccess = 71;
	public static final int getEmergencyMaterialListFalse = 72;
	public static final int getCompanyInfoSuccess = 73;
	public static final int getCompanyInfoFalse = 74;

	public static final int START_YEAR = 1990, END_YEAR = 2100;

	// 成功返回码

	public static final int SUCCESS = 200;
	// 网络错误返回码

	public static final int NetWorkError = 400;
	// 检查更新
	public static final int updateSuccess = 131;
	public static final int updateFalse = 132;
	public static final String FILESELECTORACTIONXML = "com.xiangxun.xml";
	public static final String FILESELECTORACTIONEXCEL = "com.xiangxun.excel";


	public static final int UpStatusFail = 0; //失败
	public static final int UpStatusSuccess = 1; //
	public static final int UpStatusException = 2; //
	public static final int UpStatusNoAuthority = 3; //无权
	public static final int UpStatusSigned = 4; //已签收

	public static final int UpStatusAcked = 5; //已反馈

	public static final int UpStatusNoinfo = 6; //无反馈信息

}
