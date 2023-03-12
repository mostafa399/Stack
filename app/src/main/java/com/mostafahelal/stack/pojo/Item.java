package com.mostafahelal.stack.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Item {

    @SerializedName("tags")
    @Expose
    private List<String> tags;
    @SerializedName("owner")
    @Expose
    private Owner owner;
    @SerializedName("is_answered")
    @Expose
    private Boolean isAnswered;
    @SerializedName("view_count")
    @Expose
    private Integer viewCount;
    @SerializedName("answer_count")
    @Expose
    private Integer answerCount;
    @SerializedName("score")
    @Expose
    private Integer score;
    @SerializedName("last_activity_date")
    @Expose
    private Integer lastActivityDate;
    @SerializedName("creation_date")
    @Expose
    private Integer creationDate;
    @SerializedName("question_id")
    @Expose
    private String questionId;
    @SerializedName("content_license")
    @Expose
    private String contentLicense;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("bounty_amount")
    @Expose
    private Integer bountyAmount;
    @SerializedName("bounty_closes_date")
    @Expose
    private Integer bountyClosesDate;
    @SerializedName("last_edit_date")
    @Expose
    private Integer lastEditDate;
    @SerializedName("closed_date")
    @Expose
    private Integer closedDate;
    @SerializedName("closed_reason")
    @Expose
    private String closedReason;
    @SerializedName("accepted_answer_id")
    @Expose
    private Integer acceptedAnswerId;
    @SerializedName("protected_date")
    @Expose
    private Integer protectedDate;

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Boolean getIsAnswered() {
        return isAnswered;
    }

    public void setIsAnswered(Boolean isAnswered) {
        this.isAnswered = isAnswered;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public Integer getAnswerCount() {
        return answerCount;
    }

    public void setAnswerCount(Integer answerCount) {
        this.answerCount = answerCount;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getLastActivityDate() {
        return lastActivityDate;
    }

    public void setLastActivityDate(Integer lastActivityDate) {
        this.lastActivityDate = lastActivityDate;
    }

    public Integer getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Integer creationDate) {
        this.creationDate = creationDate;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getContentLicense() {
        return contentLicense;
    }

    public void setContentLicense(String contentLicense) {
        this.contentLicense = contentLicense;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getBountyAmount() {
        return bountyAmount;
    }

    public void setBountyAmount(Integer bountyAmount) {
        this.bountyAmount = bountyAmount;
    }

    public Integer getBountyClosesDate() {
        return bountyClosesDate;
    }

    public void setBountyClosesDate(Integer bountyClosesDate) {
        this.bountyClosesDate = bountyClosesDate;
    }

    public Integer getLastEditDate() {
        return lastEditDate;
    }

    public void setLastEditDate(Integer lastEditDate) {
        this.lastEditDate = lastEditDate;
    }

    public Integer getClosedDate() {
        return closedDate;
    }

    public void setClosedDate(Integer closedDate) {
        this.closedDate = closedDate;
    }

    public String getClosedReason() {
        return closedReason;
    }

    public void setClosedReason(String closedReason) {
        this.closedReason = closedReason;
    }

    public Integer getAcceptedAnswerId() {
        return acceptedAnswerId;
    }

    public void setAcceptedAnswerId(Integer acceptedAnswerId) {
        this.acceptedAnswerId = acceptedAnswerId;
    }

    public Integer getProtectedDate() {
        return protectedDate;
    }

    public void setProtectedDate(Integer protectedDate) {
        this.protectedDate = protectedDate;
    }
    public class Owner {

        @SerializedName("reputation")
        @Expose
        private Integer reputation;
        @SerializedName("user_id")
        @Expose
        private Integer userId;
        @SerializedName("user_type")
        @Expose
        private String userType;
        @SerializedName("accept_rate")
        @Expose
        private Integer acceptRate;
        @SerializedName("profile_image")
        @Expose
        private String profileImage;
        @SerializedName("display_name")
        @Expose
        private String displayName;
        @SerializedName("link")
        @Expose
        private String link;

        public Integer getReputation() {
            return reputation;
        }

        public void setReputation(Integer reputation) {
            this.reputation = reputation;
        }

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }

        public String getUserType() {
            return userType;
        }

        public void setUserType(String userType) {
            this.userType = userType;
        }

        public Integer getAcceptRate() {
            return acceptRate;
        }

        public void setAcceptRate(Integer acceptRate) {
            this.acceptRate = acceptRate;
        }

        public String getProfileImage() {
            return profileImage;
        }

        public void setProfileImage(String profileImage) {
            this.profileImage = profileImage;
        }

        public String getDisplayName() {
            return displayName;
        }

        public void setDisplayName(String displayName) {
            this.displayName = displayName;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

    }

}