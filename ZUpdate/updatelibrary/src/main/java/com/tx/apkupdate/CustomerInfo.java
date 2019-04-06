package com.tx.apkupdate;

/**
 * 客服联系信息
 */
public class CustomerInfo {
    /**
     * type: 1 = 在线客服,2 = QQ ,3 = 微信,4 = 邮箱,5 = 钉钉，6=手机号,7=qq公众号
     * value:具体的值
     * pre:前缀
     * 约定：1.列表是按照顺序的。2.";pre":里面的值如果前缀需要添加“:“,就添加。
     * isJump: 0 不跳转，1跳转
     */
    private String value;
    private String type;
    private String pre;
    private String isJump="0";

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPre() {
        return pre;
    }

    public void setPre(String pre) {
        this.pre = pre;
    }

    public String getIsJump() {
        return isJump;
    }

    public void setIsJump(String isJump) {
        this.isJump = isJump;
    }
}
