package com.example.apple.jialianmerchant.utils;

import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 使用正则表达式验证输入格式
 */
public class RegexValidateUtil {

    /**
     * 正则表达式:验证用户名(不包含中文和特殊字符)如果用户名使用手机号码或邮箱 则结合手机号验证和邮箱验证
     */
    public static final String REGEX_USERNAME = "^[a-zA-Z]\\w{5,17}$";

    /**
     * 正则表达式:验证密码(不包含特殊字符)
     */
    public static final String REGEX_PASSWORD = "^[a-zA-Z0-9]{6,16}$";

    /**
     * 正则表达式:验证手机号
     */
    public static final String REGEX_MOBILE = "^(0|86|17951)?(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$";

    /**
     * 正则表达式:验证邮箱
     */
    public static final String REGEX_EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";

    /**
     * 正则表达式:验证汉字(2-9个汉字)  {2,9} 自定义区间
     */
    public static final String REGEX_CHINESE = "^[\u4e00-\u9fa5]{2,9}$";

    /**
     * 正则表达式:验证汉字(4个汉字)  {4} 自定义区间
     */
    public static final String REGEX_CHINESE_COUNT = "^[\u4e00-\u9fa5]{4}$";

    /**
     * 正则表达式:验证汉字(4个汉字)  {4} 自定义区间
     */
    public static final String REGEX_CHINESE_BANK = "^[\u4e00-\u9fa5]{2,30}$";

    /**
     * 正则表达式:验证身份证
     */
    public static final String REGEX_ID_CARD = "(^\\d{15}$)|(^\\d{17}([0-9]|X)$)";


    /**
     * 正则表达式:验证URL
     */
//	public static final String REGEX_URL = "http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?";
    /**
     * 正则表达式:验证银行卡 13-19位
     */
    public static final String REGEX_BANK_CARD = "^\\d{13,19}$";


    /**
     * 正则表达式:验证IP地址
     */
    public static final String REGEX_IP_ADDR = "(2[5][0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})";


    /**
     * 正则表达式:验证地址：只含有汉字、数字、字母、-只能以汉字开头，范围2-30个
     */
    public static final String REGEX_ADDRESS = "^[\\u4e00-\\u9fa5][a-zA-Z0-9-\\u4e00-\\u9fa5]{1,30}";

    /**
     * 校验用户名
     *
     * @param username
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isUserName(String username) {
        return Pattern.matches(REGEX_USERNAME, username);
    }

    /**
     * 校验密码
     *
     * @param password
     * @return 校验通过返回true，否则返回false
     */
    public static boolean checkCharacter(String password) {
        return Pattern.matches(REGEX_PASSWORD, password);
    }

    /**
     * 校验手机号
     *
     * @param mobile
     * @return 校验通过返回true，否则返回false
     */
    public static boolean checkMobileNumber(String mobile) {
        return Pattern.matches(REGEX_MOBILE, mobile);
    }

    /**
     * 校验邮箱
     *
     * @param email
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isEmail(String email) {
        return Pattern.matches(REGEX_EMAIL, email);
    }

    /**
     * 校验汉字
     *
     * @param chinese
     * @return 校验通过返回true，否则返回false
     */
    public static boolean checkUserName(String chinese) {
        return Pattern.matches(REGEX_CHINESE, chinese);
    }

    /**
     * 校验4个汉字
     *
     * @param chinese
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isFourChinese(String chinese) {
        return Pattern.matches(REGEX_CHINESE_COUNT, chinese);
    }

    /**
     * 校验4个汉字
     *
     * @param chinese
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isChineseBank(String chinese) {
        return Pattern.matches(REGEX_CHINESE_BANK, chinese);
    }

    /**
     * 校验身份证
     *
     * @param idCard
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isIDCard(String idCard) {
        return Pattern.matches(REGEX_ID_CARD, idCard);
    }

    /**
     * 校验身份证
     *
     * @param idCard
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isBankCard(String idCard) {
        return Pattern.matches(REGEX_BANK_CARD, idCard);
    }


//	/**
//	 * 校验URL
//	 * @param url
//	 * @return 校验通过返回true，否则返回false
//	 */
//	public static boolean isUrl(String url) {
//		return Pattern.matches(REGEX_URL, url);
//	}

    /**
     * 校验IP地址
     *
     * @param ipAddress
     * @return
     */
    public static boolean isIPAddress(String ipAddress) {
        return Pattern.matches(REGEX_IP_ADDR, ipAddress);
    }

    /**
     * 校验地址
     *
     * @param ipAddress
     * @return
     */
    public static boolean checkHomeNum(String ipAddress) {
        return Pattern.matches(REGEX_ADDRESS, ipAddress);
    }

    /**
     * 银行卡后四位
     *
     * @param cardNo
     * @return
     */
    public static final String formatCardEndFour(String cardNo) {
        String card = "";
        card += cardNo.substring(cardNo.length() - 4);
        return card;
    }

    //银行卡隐藏*号，只留最后4位
    public static final String xinghaoBank(String cardNo) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < cardNo.length() - 4; i++) {
            if (i-3 % 4 == 1) {
                sb.append(" ");
            }
            sb.append("*");
        }
        sb.append(formatCardEndFour(cardNo));
        return sb.toString();
    }

    //身份证隐藏*号，只留最后4位
    public static final String idFour(String idCard) {
        StringBuffer sb = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();
        String first = idCard.substring(0, 4);
        String last = idCard.substring(idCard.length() - 4,idCard.length());
        for (int i = 3; i < idCard.length() - 4; i++) {

            if (i % 4 == 1) {
                sb.append(" ");
            }
            sb.append("*");
        }
        sb.append(formatCardEndFour(idCard));
        sb2.append(first).append(sb);
        return sb2.toString();
    }

    /**
     * String转换0.00
     *
     * @return
     */

    public static final String formatDouble(String money) {
        double d = Double.parseDouble(money);
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(d);
    }

    /**
     * String转换0.00
     *
     * @return
     */

    public static final String formatDouble(int money) {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(money);
    }

//		/**
//	 * 验证合法字符
//	 */
//	public static boolean checkCharacter(String character) {
//		boolean flag = false;
//		try {
//			String check = "[a-zA-Z0-9_]{6,16}";
//			Pattern regex = Pattern.compile(check);
//			Matcher matcher = regex.matcher(character);
//			flag = matcher.matches();
//		} catch (Exception e) {
//			flag = false;
//		}
//		return flag;
//	}

    /**
     * 验证邮箱
     */
    public static boolean checkEmail(String email) {
        boolean flag = false;
        try {
            String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
            Pattern regex = Pattern.compile(check);
            Matcher matcher = regex.matcher(email);
            flag = matcher.matches();
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }


    /**
     * 验证手机号码
     */
//	public static boolean checkMobileNumber(String mobileNumber) {
//		boolean flag = false;
//		try {
//			Pattern regex = Pattern
//					.compile("^(((13[0-9])|(15([0-3]|[5-9]))|(18([0-3]|[5-9]))|(18[0,5-9]))\\d{8})|(0\\d{2}-\\d{8})|(0\\d{3}-\\d{7})$");
//			Matcher matcher = regex.matcher(mobileNumber);
//			flag = matcher.matches();
//		} catch (Exception e) {
//			flag = false;
//		}
//		return flag;
//	}

//	/**
//	 * 验证用户名：只含有汉字2-4个
//	 */
//	public static boolean checkUserName(String userName) {
//		boolean flag = false;
//		try {
//			Pattern regex = Pattern
//					.compile("^[\\u4E00-\\u9FA5]{2,4}$");
////					.compile("^(?!_)(?!.*?_$)[a-zA-Z0-9_\\u4e00-\\u9fa5]+$");//只含有汉字、数字、字母、下划线不能以下划线开头和结尾
////					.compile("^[a-zA-Z0-9_\\u4e00-\\u9fa5]+$");只含有汉字、数字、字母、下划线，下划线位置不限
////					.compile("^[a-zA-Z0-9\\u4e00-\\u9fa5]+$");//只含有汉字、数字、字母
//			Matcher matcher = regex.matcher(userName);
//			flag = matcher.matches();
//		} catch (Exception e) {
//			flag = false;
//		}
//		return flag;
//	}

    /**
     * 验证地址：只含有汉字、数字、字母、-只能以汉字开头，范围3-30个
     */
//	public static boolean checkHomeNum(String homeNum) {
//		boolean flag = false;
//		try {
//			Pattern regex = Pattern
//					.compile("^[\\u4e00-\\u9fa5][a-zA-Z0-9-\\u4e00-\\u9fa5]{2,30}");
////					.compile("^[a-zA-Z0-9\\u4e00-\\u9fa5]+$");//只含有汉字、数字、字母
//			Matcher matcher = regex.matcher(homeNum);
//			flag = matcher.matches();
//		} catch (Exception e) {
//			flag = false;
//		}
//		return flag;
//	}


}