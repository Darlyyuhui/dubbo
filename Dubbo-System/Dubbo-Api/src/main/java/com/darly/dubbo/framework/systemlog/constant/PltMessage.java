package com.darly.dubbo.framework.systemlog.constant;

/**
 * @Author: Darly Fronch（张宇辉）
 * @Description： 常用信息常量
 */

public final class PltMessage
{
    //////////////////////////////////////////////////////////////////////////
    ////////////////////////系统配置信息////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////


    /** 获取Log4j的配置文件失败！采用系统默认的Log4j配置. */
    public static final String SYS_LOG4J_CFG_NOT_FOUND = "Failed to attain the Log4J config file and the default config was accepted. ";


    ////////////////////////////////////////////////////////////////////////////
    //////////////////////////全局公共错误信息//////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////

    /** 传入的参数为空值. */
    public static final String GLB_PARAMETER_VALUE_NULL = "The Parameter inputed is null or empty. ";


    //////////////////////////////////////////////////////////////////////////////
    ////////////////////////////数据访问层////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////

    /** 持久对象名称不能为空值. */
    public static final String DBCC_PONAME_NULL = "The name of persistent object can't be null or empty. ";

    /** 表名称不能为空值. */
    public static final String DBCC_TABLE_NAME_NULL = "The name of table can't be null or empty. ";


    /** 没有查询到符合条件的记录或者符合条件的记录数目大于一条. */
    public static final String DBCC_RESULT_ERROR = "Failed to attain the logs according to the query conditions or the count of matching logs more than one. ";

    /** 插入数据失败. */
    public static final String DBCC_CREATE_FAIL = "Failed to create a new data record. ";

    /** 更新数据失败. */
    public static final String DBCC_UPDATE_FAIL = "Failed to update the data record. ";

    /** 删除数据用失败. */
    public static final String DBCC_DELETE_FAIL = "Failed to remove the data record. ";
    /** 查询数据失败. */
    public static final String DBCC_QUERY_FAIL = "Faild to retrieve any data records. ";


    //////////////////////////////////////////////////////////////////////////////
    ////////////////////////////Resource配置类////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////
    /** 指定的配置文件不存在. */
    public static final String RES_CFGFILE_NOT_FOUND = "The config file \"{0}\" is not existed. ";
    /** 指定的配置文件不存在. */
    public static final String RES_CFGFILE_LOAD_FAIL = "Failed to load the config file \"{0}\". ";
    /** 配置文件格式错误. */
    public static final String RES_CFGFILE_FORMAT_ERROR = "The format of config is incorrectly. ";
    /** 开始加载sql配置文件. */
    public static final String RES_CFGFILE_TO_LOAD = "Begin to load the config file \"{0}\". ";
    /** 加载sql配置文件成功. */
    public static final String RES_CFGFILE_LOAD_SUCC = "Load the config file \"{0}\" successfully. ";
    /** 开始重新加载sql配置文件. */
    public static final String RES_CFGFILE_TO_RELOAD = "Begin to reload the config file \"{0}\". ";
    /** 重新加载sql配置文件成功. */
    public static final String RES_CFGFILE_RELOAD_SUCC = "Reload the config file \"{0}\" successfully. ";

    /** 传递参数错误，请确认配置标识和参数个数、类型. */
    public static final String BSN_TRANS_PARAM_ERROR = "The parameter is incorrectly and please to confirm the config identifier,the whole count and types of the parameters. ";
}
