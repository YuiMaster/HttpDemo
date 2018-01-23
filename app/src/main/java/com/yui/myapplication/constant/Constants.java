package com.yui.myapplication.constant;

/**
 * 常量
 *
 * @author liaoyuhuan
 * @date on  2018/1/23
 * @email
 * @org
 * @describe 添加描述
 */


public class Constants {
    //分页每页数量
    public static final int PAGE_SIZE = 20;
    public static final String DIALOG_OK = "ok";
    public static final String DIALOG_CANCLE = "cancle";
    public static final String PARAMETER1 = "parameter1";
    public static final String PARAMETER2 = "parameter2";
    public static final String TYPE = "type";
    public static final String TOKEN = "tokenKey";
    public static final String ID = "id";
    public static final String DATA = "data";
    //选择图片请求码
    public static final int PIC_PICKER_REQUEST_CODE = 0x00;
    public static final String DOCTOR_ = "doctor_";
    public static final String IM_STR_SP = "&&&";
    public static final String IM_CONTENT_GROUP = "content##";
    public static final String IM_ACTIVITY_GROUP = "active_video##";
    public static final String IM_GARBAGE_GROUP = "garbage";
    //问诊模块群组
    public static final String IM_INQUIRY_GROUP = "counsel##";
    public static final String DETELE_TYPE_PROBLEM = "problem";
    public static final String DETELE_TYPE_ANSWER = "answer";
    //回答问题页面点头像请求码
    public static final int ANSWER_HEAD_REQUEST_CODE = 0x08;
    public static int ERROE_FLAG_USERNAME = 1;
    public static int ERROE_FLAG_IMG_CODE = 2;
    public static int ERROE_FLAG_SMS_CODE = 3;
    public static int ERROE_FLAG_PASSWORD_CODE = 4;

    public enum SysData {
        status,
        isFilterUser,
        normal,
        delete
    }

    //多媒体类型
    public enum MediaTypeEnum {
        text,
        image,
        audio,
        video,
        pdf,
    }


    public enum TupleTypeEnum {
        author,
        doctor,
        tag,
        title,
        richText,
        media,
        mediaBig,
        // 以下为活动特有的元组类别
        enroll,
        startTime,
        countDown,
        otherData,
    }


    //分享渠道类型
    public enum ShareTypeEnum {
        wx,
        wx_quan,
        wb,
        qq,
    }

    //分享内容类型
    public enum ShareContentTypeEnum {
        tourist,
        user,
        doctor,
        student,
        nurse,
        studioDoctor,
        content,
    }

    // 跳转的类型
    public enum JumpLoginFragmentFlagEnum {
        // 注册
        register,
        // 登录
        login,
        // 忘记密码
        forgot_password,
        // 修改密码
        change_password,
        // 更改手机号
        change_mobile,
    }

    // 跳转的类型
    public enum ContentTypeEnum {
        // 普通内容
        common,
        // 活动
        activity,
        h5,
        feedback,
        problem,
        answer,
        review,
    }

    public enum H5Operation {
        //他的关注
        AttentionsList,
        //他的粉丝
        FollowersList,
        //他的收藏
        CollectionsList
    }


    //活动类型
    public enum ActivityTypeEnum {
        //其他专栏
        NOTCOLUN,
        //医大帮子专栏
        ISCOLUMN
    }

    //取消关注用户的类型
    public enum CancelUserTypeEnum {
        //普通用户
        NORMAL,
        //粉丝
        FANS
    }


    //用户权限限制
    public enum UserPermissionLimiteEnum {
        //活动详情
        activityDetail,
        //标签关注
        tagAttention,
        //申请加入工作室
        joinStudio,
        //发布
        postContent,
        //内容详情
        contentDetail,
        //视频播放
        playVideo,
        //内容提问
        askQuestion,
        //用户关注
        userAttention,
        //收藏
        collection,
        //内容评论
        comment,
        //对回答评论
        commentOfAnswer,
        //对评论的回复
        replyOfComment,
        //播放音频
        playVoice,
        //积分
        integral,
        //签到
        signin
    }

    //患者提醒
    public enum PatientReminderEnum {
        care,   //关心提醒
        medication,     //用药提醒
        referral    //复诊提醒
    }

    public static class MODULE_SETTING {
        //request code
        public static final int ME_DETAIL_INFO_AVATAR_REQUEST = 10;
        public static final int ME_DETAIL_INFO_PHONE_REQUEST = 11;
        public static final int ME_DETAIL_INFO_NAME_REQUEST = 12;
        public static final int ME_DETAIL_INFO_EMAIL_REQUEST = 13;
        public static final int ME_DETAIL_INFO_SEX_REQUEST = 14;
        public static final int ME_DETAIL_INFO_HOSPITAL_REQUEST = 15;
        public static final int ME_DETAIL_INFO_SECTION_REQUEST = 16;
        public static final int ME_DETAIL_INFO_TITLE_REQUEST = 18;
        public static final int ME_DETAIL_INFO_CERT_REQUEST = 19;
        public static final int ME_DETAIL_INFO_INTRO_REQUEST = 20;
        public static final int ME_DETAIL_INFO_SCHOOL_REQUEST = 21;
        public static final int ME_DETAIL_INFO_LICENCE_REQUEST = 22;
        public static final int ME_DETAIL_INFO_DESC_REQUEST = 23;

        public static final int ME_DETAIL_ADD_SCHOOL_REQUEST = 121;     //添加学校
        public static final int ME_DETAIL_ADD_HOSPITAL_REQUEST = 122;   //添加医院


        public static final String SETTING_EVENT_SELECTED_TITLE_DOCTOR = "setting_title_doctor";
        public static final String SETTING_EVENT_SELECTED_TITLE_NURSE = "setting_title_nurse";
        public static final String SETTING_EVENT_SELECTED_TITLE_STUDENT = "setting_title_student";
        public static final String SETTING_EVENT_SELECTED_TITLE_PHARMACIST = "setting_title_pharmacist";

        //认证类型为医生的值
        public static final int DOCTOR_TYPE_AUTH_VALUE = 18007;
        //认证类型为护士的值
        public static final int NURSE_TYPE_AUTH_VALUE = 18008;
        //认证类型为医学生的值
        public static final int STUDENT_TYPE_AUTH_VALUE = 18009;
        //认证类型为药剂师的值
        public static final int PHARMACIST_TYPE_AUTH_VALUE = 18010;
        //没有认证的类型
        public static final int USER_TYPE_AUTH_VALUE = 0;

        public static final String SETTING_PRE_NAME = "setting_system_switch";
        public static final String SETTING_PRE_VOICE = "setting_pre_voice";
        public static final String SETTING_PRE_VIBRATE = "setting_pre_vibrate";
        public static final String SETTING_PRE_HEADPHONE = "setting_pre_headphone";

        /*腾讯IM APPID*/
        public static final String SETTING_PRE_IM_APPID_KEY = "im.appid";
        /*华为推送*/
        public static final String SETTING_PRE_HW_PUSH_KEY = "im.huawei.cerid";
        /*小米推送*/
        public static final String SETTING_PRE_XM_PUSH_KEY = "im.xiaomi.cerid";
        /*强更时间*/
        public static final String SETTING_PRE_FORCE_UPDATE_KEY = "im.266.refrush.expire";
        //razor
        public static final String SETTING_PRE_RAZOR_KEY = "razor.appkey";


        /*基础数据更新时间*/
        public static final String SETTING_NORMAL_IMAGE = "normal_image";
        public static final String SETTING_NORMAL_VIDEO = "normal_video";
        public static final String SETTING_NORMAL_AUDIO = "normal_audio";
        public static final String SETTING_BIG_VIDEO = "big_video";
        public static final String SETTING_BIG_AUDIO = "big_audio";
        public static final String SETTING_BIG_PDF = "big_pdf";
        public static final String SETTING_NULL_URL_BIG_PDF = "null_url_big_pdf";


    }


    public static class Home {

        //默认item 类型 参考/yidabang_online_docs/2.6.8/server/首页风格描述/首页分格.MD

        //左边文字，右边媒体（媒体不能为空)
        public static final String HOME_ITEM_TYPE_01 = "style_1";
        //活动
        public static final String HOME_ITEM_TYPE_02 = "style_2";
        //只有媒体没有文字
        public static final String HOME_ITEM_TYPE_03 = "style_3";
        //只有文字
        public static final String HOME_ITEM_TYPE_04 = "style_4";
        //活动反馈
        public static final String HOME_ITEM_TYPE_05 = "style_5";


        //默认item 类型 参考/yidabang_online_docs/2.6.8/server/首页风格描述/首页分格.MD
        //正文只有文字时
        public static final String HOME_ITEM_TYPE_TEXT_CONTENT_STYLE = "textContentStyle";

        //正文只有视频时
        public static final String HOME_ITEM_TYPE_VIDEO_CONTENT_STYLE = "videoContentStyle";
        //多个媒体
        public static final String HOME_ITEM_TYPE_TREBLING_MEDIA_STYLE = "treblingMediaStyle";

        //正文只有图片时
        public static final String HOME_ITEM_TYPE_ONLY_IMG_CONTENT_STYLE = "oneImgContentStyle";

        //正文只有pdf文件时
        public static final String HOME_ITEM_TYPE_PDF_CONTENT_STYLE = "pdfContentStyle";


        //正文有文字和视频时
        public static final String HOME_ITEM_TYPE_TEXT_VIDEO_CONTENT_STYLE = "textVideoContentStyle";
        //正文有文字和图片时
        public static final String HOME_ITEM_TYPE_TEXT_IMG_CONTENT_STYLE = "textImgContentStyle";
        //正文只有语音时，显示一个语音img加标题，语音img样式见UI
        public static final String HOME_ITEM_TYPE_VOICE_CONTENT_STYLE = "voiceContentStyle";
        //正文有文字和语音时
        public static final String HOME_ITEM_TYPE_TEXT_VOICE_CONTENT_STYLE = "textVoiceContentStyle";
        //正文有文字和pdf时，
        public static final String HOME_ITEM_TYPE_TEXT_PDF_CONTENT_STYLE = "textPdfContentStyle";


        //历史活动
        public static final String HOME_ITEM_TYPE_HISTORY_ACTIVITY_STYLE = "historyActivityStyle";
        //未開始的活動
        public static final String HOME_ITEM_TYPE_APPLIABLE_ACTIVITY_STYLE = "appliableActivityStyle";
        //直播中的活动
        public static final String HOME_ITEM_TYPE_LIVING_ACTIVITY_STYLE = "livingActivityStyle";

        //活动未开始
        public static final int ACTIVITY_UN_BEGUN = 1;
        //活动进行中
        public static final int ACTIVITY_IN_PROGRESS = 2;
        //活动结束
        public static final int ACTIVITY_END = 3;
    }

    //搜索
    public static class Search {
        public static final String SEARCH_TYPE_NORMAL = "normal";
        public static final String SEARCH_TYPE_PUBLISH = "publish";
        public static final String SEARCH_TYPE_EVENT = "event";
        public static final String SEARCH_TYPE_TAG_LIST = "tag_list";
        public static final String SEARCH_TYPE_TAG_STUDIO = "studio";
        //历史记录显示的个数
        public static final int SEARCH_HISTORY_NUM = 10;
        //热门关键字个数
        public static final int SEARCH_HOT_KEY_NUM = 10;
        //最近多少天的
        public static final int SEARCH_HOT_KEY_DAY = 30;

    }

    public static class Event {
        public static final int EVENT_REFRESH = 10000;

    }


    //会话
    public static class Conversation {
        public static final String ADMINENAME = "notice_445";
        public static final int MAXMESSAGENUM = 100000;
    }

    //发布
    public static class Publish {
        public static final String PLUS = "＋";
        //标签请求码
        public static final int PUBLISH_CHOOSE_TAG_REQUEST = 0x01;
        //标签搜索请求码
        public static final int PUBLISH_TAG_SEARCH_REQUEST = 0x02;
        public static final String PUBLISH_CHOOSE_TAGS_KEY = "tags";
        public static final String PUBLISH_CHOOSE_TAG_KEY = "tag";
        public static final String PUBLISH_EDIT_PIC_FOCUS = "pic";
        public static final String PUBLISH_EDIT_EDIT_FOCUS = "edit";
    }


    //我
    public static class Me {
        //以我的身份访问工作室列表
        public static final String ME_STUDIO_ACCESS_ME = "me";

        public static final String ME_PATH = "me";
        //我的活动
        public static final int ME_ACTIVITY_ARGUMENT = 0X00;
        //我的关注
        public static final int ME_ATTENTION_ARGUMENT = 0X01;
        //我的粉丝
        public static final int ME_FANS_ARGUMENT = 0X02;
        //我的工作室
        public static final int ME_STUDIOS_ARGUMENT = 0X03;
        //我的收藏
        public static final int ME_FAV_ARGUMENT = 0X04;
        //我的回答
        public static final int ME_ANSWER_ARGUMENT = 0X05;
        //我的提问
        public static final int ME_QUESTION_ARGUMENT = 0X06;
        //我的发布
        public static final int ME_PUBLISH_ARGUMENT = 0X07;
    }

    //转诊
    public static class Referral {
        //创建转诊试以普通人的身份访问工作室列表
        public static final String REFERRAL_STUDIO_ACCESS_NORMAL_USER = "normal_user";
        public static final int REFERRAL_MAX_PIC_SIZE = 9;
        public static final String REFERRAL_STATUS_TYPE = "type";
        //转诊中
        public static final int REFERRAL_STATUS_PROCESSING = 0x01;
        //待转诊
        public static final int REFERRAL_STATUS_PENDING = 0x02;
        //已处理
        public static final int REFERRAL_STATUS_PROCESSED = 0x03;
        public static final String REFERRAL_STUDIO_BEAN = "studioBean";
        public static final String REFERRAL_BEAN = "referralBean";

    }


    //查看大图
    public static class PhotoView {
        public static final String PHOTOVIEW_URL = "url";
        public static final String PHOTOVIEW_BIG_IMG = "bigImg";
    }

    //IM
    public static class IM {
        public static final String DATA_FLAG = "data";
        public static final String CONVERSATION_TYPE = "type";
        public static final int LOAD_FRAGMENT_TYPE_PRIVATE = 1;
        public static final int LOAD_FRAGMENT_TYPE_STUDIO = 2;
        public static final int LOAD_FRAGMENT_TYPE_TRANSFER = 3;

        public static final String CONVERSATION_ID = "identify";
        public static final String CONVERSATION_TEAMID = "teamID";
        public static final String CONVERSATION_LOAD_FRAGMENT_TYPE = "load_fragment_type";
        public static final String CONVERSATION_TRANSFER_ID = "transfer_id";


        public static final String IM_PACKAGE_MORETHAN_9K = "package_more_than8k----" +
                "package_more_than8k----package_more_than8k----package_more_than8k----package_more_than8k" +
                "----package_more_than8k----package_more_than8k----package_more_than8k----package_more_than8k" +
                "----package_more_than8k----package_more_than8k----package_more_than8k----package_more_than8k" +
                "----package_more_than8k----package_more_than8k----package_more_than8k----package_more_than8k" +
                "----package_more_than8k----package_more_than8k----package_more_than8k----package_more_than8k" +
                "----package_more_than8k----package_more_than8k----package_more_than8k----package_more_than8k" +
                "----package_more_than8k----package_more_than8k----package_more_than8k----package_more_than8k" +
                "----package_more_than8k----package_more_than8k----package_more_than8k----package_more_than8k" +
                "----package_more_than8k----package_more_than8k----package_more_than8k----package_more_than8k" +
                "----package_more_than8k----package_more_than8k----package_more_than8k----package_more_than8k" +
                "----package_more_than8k----package_more_than8k----package_more_than8k----package_more_than8k" +
                "----package_more_than8k----package_more_than8k----package_more_than8k----package_more_than8k" +
                "----package_more_than8k----package_more_than8k----package_more_than8k----package_more_than8k" +
                "----package_more_than8k----package_more_than8k----package_more_than8k----package_more_than8k" +
                "----package_more_than8k----package_more_than8k----package_more_than8k----package_more_than8k" +
                "----package_more_than8k----package_more_than8k----package_more_than8k----package_more_than8k" +
                "----package_more_than8k----package_more_than8k----package_more_than8k----package_more_than8k" +
                "----package_more_than8k----package_more_than8k----package_more_than8k----package_more_than8k" +
                "----package_more_than8k----package_more_than8k----package_more_than8k----package_more_than8k" +
                "----package_more_than8k----package_more_than8k----package_more_than8k----package_more_than8k" +
                "----package_more_than8k----package_more_than8k----package_more_than8k----package_more_than8k" +
                "----package_more_than8k----package_more_than8k----package_more_than8k----package_more_than8k" +
                "----package_more_than8k----package_more_than8k----package_more_than8k----package_more_than8k" +
                "----package_more_than8k----package_more_than8k----package_more_than8k----package_more_than8k" +
                "----package_more_than8k----package_more_than8k----package_more_than8k----package_more_than8k" +
                "----package_more_than8k----package_more_than8k----package_more_than8k----package_more_than8k" +
                "----package_more_than8k----package_more_than8k----package_more_than8k----package_more_than8k" +
                "----package_more_than8k----package_more_than8k----package_more_than8k----package_more_than8k" +
                "----package_more_than8k----package_more_than8k----package_more_than8k----package_more_than8k" +
                "----package_more_than8k----package_more_than8k----package_more_than8k----package_more_than8k" +
                "----package_more_than8k----package_more_than8k----package_more_than8k----package_more_than8k" +
                "----package_more_than8k----package_more_than8k----package_more_than8k----package_more_than8k" +
                "----package_more_than8k----package_more_than8k----package_more_than8k----package_more_than8k" +
                "----package_more_than8k----package_more_than8k----package_more_than8k----package_more_than8k" +
                "----package_more_than8k----package_more_than8k----package_more_than8k----package_more_than8k" +
                "----package_more_than8k----package_more_than8k----package_more_than8k----package_more_than8k" +
                "----package_more_than8k----package_more_than8k----package_more_than8k----package_more_than8k" +
                "----package_more_than8k----package_more_than8k----package_more_than8k----package_more_than8k" +
                "----package_more_than8k----package_more_than8k----package_more_than8k----package_more_than8k" +
                "----package_more_than8k----package_more_than8k----package_more_than8k----package_more_than8k" +
                "----package_more_than8k----package_more_than8k----package_more_than8k----package_more_than8k" +
                "----package_more_than8k----package_more_than8k----package_more_than8k----package_more_than8k" +
                "----package_more_than8k----package_more_than8k----package_more_than8k----package_more_than8k" +
                "----package_more_than8k----package_more_than8k----package_more_than8k----package_more_than8k" +
                "----package_more_than8k----package_more_than8k----package_more_than8k----package_more_than8k" +
                "----package_more_than8k----package_more_than8k----package_more_than8k----package_more_than8k" +
                "----package_more_than8k----package_more_than8k----package_more_than8k----package_more_than8k" +
                "----package_more_than8k----package_more_than8k----package_more_than8k----package_more_than8k" +
                "----package_more_than8k----package_more_than8k----package_more_than8k----package_more_than8k" +
                "----package_more_than8k----package_more_than8k----package_more_than8k----package_more_than8k" +
                "----package_more_than8k----package_more_than8k----package_more_than8k----package_more_than8k" +
                "----package_more_than8k----package_more_than8k----package_more_than8k----package_more_than8k" +
                "----package_more_than8k----package_more_than8k----package_more_than8k----package_more_than8k" +
                "----package_more_than8k----package_more_than8k----package_more_than8k----package_more_than8k" +
                "----package_more_than8k----package_more_than8k----package_more_than8k----package_more_than8k" +
                "----package_more_than8k----package_more_than8k----package_more_than8k----package_more_than8k" +
                "----package_more_than8k----package_more_than8k----package_more_than8k----package_more_than8k" +
                "----package_more_than8k----package_more_than8k----package_more_than8k----package_more_than8k" +
                "----package_more_than8k----package_more_than8k----package_more_than8k----package_more_than8k" +
                "----package_more_than8k----package_more_than8k----package_more_than8k----package_more_than8k" +
                "----package_more_than8k----package_more_than8k----package_more_than8k----package_more_than8k" +
                "----package_more_than8k----package_more_than8k----package_more_than8k----package_more_than8k" +
                "----package_more_than8k----package_more_than8k----package_more_than8k----package_more_than8k" +
                "----package_more_than8k----package_more_than8k----package_more_than8k----package_more_than8k" +
                "----package_more_than8k----package_more_than8k----package_more_than8k----package_more_than8k" +
                "----package_more_than8k----package_more_than8k----package_more_than8k----package_more_than8k" +
                "----package_more_than8k----package_more_than8k----package_more_than8k----package_more_than8k" +
                "----package_more_than8k----package_more_than8k----package_more_than8k----package_more_than8k" +
                "----package_more_than8k----package_more_than8k----package_more_than8k----package_more_than8k" +
                "----package_more_than8k----package_more_than8k----package_more_than8k----package_more_than8k" +
                "----package_more_than8k----package_more_than8k----package_more_than8k----package_more_than8k" +
                "----package_more_than8k----package_more_than8k----package_more_than8k----package_more_than8k" +
                "----package_more_than8k----package_more_than8k----package_more_than8k----package_more_than8k" +
                "----package_more_than8k----package_more_than8k----package_more_than8k----package_more_than8k" +
                "----package_more_than8k----package_more_than8k----package_more_than8k----package_more_than8k" +
                "----package_more_than8k----package_more_than8k----package_more_than8k----package_more_than8k" +
                "----package_more_than8k----package_more_than8k----package_more_than8k----package_more_than8k" +
                "----package_more_than8k----package_more_than8k----package_more_than8k----package_more_than8k" +
                "----package_more_than8k----package_more_than8k----package_more_than8k----package_more_than8k" +
                "----package_more_than8k----package_more_than8k----package_more_than8k----package_more_than8k";
    }

    public static class WebView {
        /*静态页面host*/
        public static final String WEB_VIEW_STATIC_HOST = "https://common.1dabang.cn/";
        //个人主页，工作室主页地址
        public static final String HOMEPAGE_PATH = WEB_VIEW_STATIC_HOST + "HomeWorkshop";
        //积分地址
        public static final String SCORE_PATH = WEB_VIEW_STATIC_HOST + "MyPoints";
        //反馈地址
        public static final String FEEDBACK_PATH = WEB_VIEW_STATIC_HOST + "Feedback";
        //联系我们地址
        public static final String CONTACT_US_PATH = WEB_VIEW_STATIC_HOST + "ContactUs";
        //博客地址
        public static final String BLOG_PATH = WEB_VIEW_STATIC_HOST + "ProductBlog";
        //隐私服务条款
        public static final String PRIVACY_PATH = WEB_VIEW_STATIC_HOST + "UserAgreement";

        //请求web 页面实体的bundle key
        public static final String WEB_SERIALIZABLE_KEY = "web";
        //PDF 解析头部
        public static final String PDF_ANALYSIS_HEADER = "https://cdn-files.1dabang.cn/mobile/pdf_view/web/viewer.html?pdf=";

    }


    //所有的ReadmDB parent ID
    public static class DB_ParentID {
        public static final int DEPARTMENT = 1532;  //编辑用户信息时的一级科室
        public static final int SECOND_DEPARTMENT = 8231;   //编辑用户信息时级联二级科室

        public static final int ALL_TITLE = 1675;   //所有职称
        public static final int ALL_CERT_TYPE = 1675;   //所有认证类型
        public static final int SELECT_CERT_TYPE = 18008;   //某个认证类型下的职称 parent_id 表示认证类型

        public static final int HOSPITAL_PROVINCE = 9500;   //筛选医院的省份
        //筛选医院的城市 parent id= province id
        //某个城市的医院 parent id= province id  医院与城市数据为同一个

        public static final int SCHOOL_PROVINCE = 17483;   //筛选学校的省份
        //某个省份的学校 parent id= province id
        public static final int SCHOOL_ALL = 17483;   //筛选所有学校
    }

    //数据库相关
    public static class DB {
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_PARENT_ID = "parent_id";
        public static final String COLUMN_LEVEL = "level";
        public static final String COLUMN_STATUS = "status";
        public static final String COLUMN_ORDER_NO = "order_no";
        public static final String COLUMN_IS_REGISTER = "is_register";
        public static final String COLUMN_IS_FILTER_USER = "is_filter_user";
        public static final String COLUMN_UPDATE_TIME = "update_time";
        public static final String COLUMN_TAG_NAME = "tag_name";
        public static final String COLUMN_CITY = "city";
        public static final String COLUMN_CITY_ID = "city_id";
        public static final String COLUMN_PROVINCE = "province";
        public static final String COLUMN_PROVINCE_ID = "province_id";
        public static final String COLUMN_LEADER_ID = "leader_id";
        public static final String COLUMN_LEADER_NAME = "leader_name";
        public static final String COLUMN_LEADER_HEAD_IMG = "leader_head_img";
        public static final String COLUMN_LEADER_TITLE = "leader_title";
        public static final String COLUMN_LEADER_DEPARTMENT = "leader_department";
        public static final String COLUMN_HOSPITAL_NAME = "hospital_name";


        public static final String SQL_SELECT_SYS_DATA = "select * from sys_data_client";
        public static final String SQL_SELECT_HOSPITAL = "select * from hospitals_client";
        public static final String SQL_SELECT_TAG = "select * from tag_client";
        public static final String SQL_SELECT_DOCTOR_TEAM = "select * from doctor_team_client";
    }


    public static class Inquiry {
        public static final String INQUIRY_PATIENT_BEAN = "patientBean";
        public static final String INQUIRY_DRUG_RECOMMEND_DETAIL_BEAN = "drugRecommendDetailBean";
        public static final String INQUIRY_CONSULT_ID = "consult_id";
        public static final String INQUIRY_IS_PULL = "is_pull";
        public static final String INQUIRY_IS_UPDATE = "is_update";
        public static final String INQUIRY_LIST_DRUG_RECOMMEND_DETAIL_BEAN = "list_drug_recommend_detail_bean";
        public static final String INQUIRY_DRUG_RECOMMEND_ID = "drug_recommend_id";
        public static final String INQUIRY_FAMILY_NAME = "family_name";
        public static final String INQUIRY_PATIENT_MOBILE = "patient_mobile";
        public static final int INQUIRY_REQUEST_ADD_PRESCRIBE_CODE = 0X00;


        /**
         * 1：已申请未操作 2：患者病情 3：已申请已操作 通过 4: 已申请已操作 拒绝 ,
         **/
        public static final int INQUIRY_MSG_CODE_NOT_APPLIED = 0X01;
        public static final int INQUIRY_MSG_CODE_PATIENT_INFO = 0X02;
        public static final int INQUIRY_MSG_CODE_ACCEPTED = 0X03;
        public static final int INQUIRY_MSG_CODE_REJECTEDD = 0X04;

        /**
         * 普通的聊天消息
         */
        public static final int INQUIRY_CONSULT_MSG_NORMAL = 0;
        /**
         * 用药建议消息
         */
        public static final int INQUIRY_CONSULT_MSG_MEDICINE_SUGGEST = 2;
        /**
         * 健康档案消息
         */
        public static final int INQUIRY_CONSULT_MSG_HEALTH_RECODER = 3;
        /**
         * 电话提醒
         */
        public static final int INQUIRY_CONSULT_MSG_CALL_START = 4;
        /**
         * 随访提醒
         */
        public static final int INQUIRY_CONSULT_MSG_REMIND = 5;

        /**
         * 普通的文本聊天消息
         */
        public static final int INQUIRY_CONSULT_MSG_NORMAL_TXT = 0;
        /**
         * 普通的图片聊天消息
         */
        public static final int INQUIRY_CONSULT_MSG_NORMAL_PIC = 1;
        /**
         * 普通的语言聊天消息
         */
        public static final int INQUIRY_CONSULT_MSG_NORMAL_VOICE = 2;


        /**
         * 普通的文本分类中的文本聊天消息
         */
        public static final String INQUIRY_CONSULT_MSG_NORMAL_TXT_TYPE = "text";
        /**
         * 普通的文本分类中的图片聊天消息
         */
        public static final String INQUIRY_CONSULT_MSG_NORMAL_IMG_TYPE = "image";
        /**
         * 普通的文本分类中的通话结束聊天消息
         */
        public static final String INQUIRY_CONSULT_MSG_NORMAL_PHONE_COMPLETED_TYPE = "phone_completed";
        /**
         * 普通的文本分类中的咨询结束聊天消息
         */
        public static final String INQUIRY_CONSULT_MSG_NORMAL_CONSULT_END_TYPE = "consult_ended";
        /**
         * 普通的文本分类中的电话开始聊天消息
         */
        public static final String INQUIRY_CONSULT_MSG_NORMAL_PHONE_BEGIN_TYPE = "phone_begin";


        /**
         * 添加新群组
         */
        public static final int CODE_ADD_NEW_GROUP = 100;
        /**
         * 群组编辑
         */
        public static final int CODE_EDIT_GROUP = 101;
        /**
         * 群组提醒
         */
        public static final int CODE_PATIENT_REMINDER = 102;
        /**
         * 选择患者
         */
        public static final int CODE_CHOOSE_PATIENT = 103;
    }

    //网络请求
    public static class Http {
        //Api 地址
        //public static final String BASE_URL = "https://api2.1dabang.cn";
        public static final String BASE_URL = "https://apis.1dabang.cn";
        public static final int HTTP_OK_STATUS = 100;
        //业务相关
        public static final int HTTP_GET_LICENC_OK = 4207;
    }
}
