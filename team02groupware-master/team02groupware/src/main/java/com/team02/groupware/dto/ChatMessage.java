package com.team02.groupware.dto;

public class ChatMessage {
	
	 	private MessageType type;
	    private String content;
	    private String userId;
	    private String chatRoomCode;
	    private String userNickName;

	    

		@Override
		public String toString() {
			return "ChatMessage [type=" + type + ", content=" + content + ", userId=" + userId + ", chatRoomCode="
					+ chatRoomCode + ", userNickName=" + userNickName + "]";
		}

		public String getUserId() {
			return userId;
		}

		public void setUserId(String userId) {
			this.userId = userId;
		}

		public String getUserNickName() {
			return userNickName;
		}

		public void setUserNickName(String userNickName) {
			this.userNickName = userNickName;
		}

		public String getChatRoomCode() {
			return chatRoomCode;
		}

		public void setChatRoomCode(String chatRoomCode) {
			this.chatRoomCode = chatRoomCode;
		}

		public MessageType getType() {
	        return type;
	    }

	    public void setType(MessageType type) {
	        this.type = type;
	    }

	    public String getContent() {
	        return content;
	    }

	    public void setContent(String content) {
	        this.content = content;
	    }

	  

}
