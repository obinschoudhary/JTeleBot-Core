package com.roadtonerdvana.jtelebot.client;

import com.roadtonerdvana.jtelebot.response.json.Result;
import com.roadtonerdvana.jtelebot.response.json.Update;
import com.roadtonerdvana.jtelebot.response.json.User;

public enum RequestType {
	GET_ME("getMe",User.class),
	GET_UPDATES("getUpdates",Update.class);
	/**
	 * TODO:
	 * Finish this.. dont worry robert i will
	 */
	/*SEND_MESSAGE, 
	FORWARD_MESSAGE, 
	SEND_PHOTO, 
	SEND_AUDIO, 
	SEND_DOCUMENT, 
	SEND_STICKER, 
	SEND_VIDEO, 
	SEND_LOCATION, 
	SEND_CHAT_ACTION, 
	GET_USER_PROFILE_PHOTOS, 
	GET_UPDATES, 
	SET_WEBHOOK*/
	//, sendMessage, forwardMessage, sendPhoto, sendAudio, sendDocument, sendSticker, sendVideo, sendLocation, sendChatAction, getUserProfilePhotos, setWebhook

	private Class<? extends Result> resultClass;
	private String methodName;
	
	private RequestType(final String methodName, final Class<? extends Result> clazz){
		this.resultClass = clazz;
		this.methodName = methodName;
	}

	public Class<? extends Result> getResultClass() {
		return resultClass;
	}

	public String getMethodName() {
		return methodName;
	}
	
	
	
}
