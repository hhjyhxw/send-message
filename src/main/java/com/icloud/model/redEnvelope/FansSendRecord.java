package com.icloud.model.redEnvelope;
/**
 * 红包活动模板消息发送记录
 * @author z
 *
 */
public class FansSendRecord extends FansSendRecordKey {
    private String nickName;

    private String sendStatus = "0";

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getSendStatus() {
        return sendStatus;
    }

    public void setSendStatus(String sendStatus) {
        this.sendStatus = sendStatus == null ? null : sendStatus.trim();
    }
}