package com.messenger.models;

public class Media {
    private String mediaId;
    private String mediaType; // e.g., image, video, audio
    private String filePath;

    public Media(String mediaId, String mediaType, String filePath) {
        this.mediaId = mediaId;
        this.mediaType = mediaType;
        this.filePath = filePath;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}