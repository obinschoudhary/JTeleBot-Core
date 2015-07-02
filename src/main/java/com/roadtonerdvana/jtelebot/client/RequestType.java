package com.roadtonerdvana.jtelebot.client;

import com.roadtonerdvana.jtelebot.response.json.Message;
import com.roadtonerdvana.jtelebot.response.json.Update;
import com.roadtonerdvana.jtelebot.response.json.User;
import com.roadtonerdvana.jtelebot.response.json.UserProfilePhotos;

public enum RequestType {
	GET_ME("getMe",User.class),
	GET_UPDATES("getUpdates",Update.class),
	SEND_MESSAGE("sendMessage"), 
	FORWARD_MESSAGE("forwardMessage"), 
	SEND_PHOTO("sendPhoto"), 
	SEND_AUDIO("sendAudio"), 
	SEND_DOCUMENT("sendDocument"), 
	SEND_STICKER("sendSticker"), 
	SEND_VIDEO("sendVideo"), 
	SEND_LOCATION("sendLocation"), 
	SEND_CHAT_ACTION("sendChatAction",Boolean.class), 
	GET_USER_PROFILE_PHOTOS("getUserProfilePhotos",UserProfilePhotos.class), 
	SET_WEBHOOK("setWebhook");

	private Class<?> resultClass;
	private String methodName;
	/**
	 * A lot of methods return Message
	 * @param methodName
	 */
	private RequestType(final String methodName){
		this(methodName,Message.class);
	}
	

	private RequestType(final String methodName, final Class<?> clazz){
		this.resultClass = clazz;
		this.methodName = methodName;
	}

	public Class<?> getResultClass() {
		return resultClass;
	}

	public String getMethodName() {
		return methodName;
	}





	
	
	
}
