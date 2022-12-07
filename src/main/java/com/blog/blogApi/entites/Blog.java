package com.blog.blogApi.entites;

public class Blog {
	
	private int id;
	private String heading;
	private String content;
	private int authorId;
	private String shortIntro;
	private int timeToRead;
	private boolean isPublic;
	private String autherName;

	public Blog(int id, String heading, String content, int authorId, String shortIntro, int timeToRead, boolean isPublic,
			String autherName) {
		this.id = id;
		this.heading = heading;
		this.content = content;
		this.authorId = authorId;
		this.shortIntro = shortIntro;
		this.timeToRead = timeToRead;
		this.isPublic=isPublic;
		this.autherName=autherName;
	}
	
	public Blog() {
		
	}

	public boolean getIsPublic() {
		return isPublic;
	}

	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHeading() {
		return heading;
	}

	public void setHeading(String heading) {
		this.heading = heading;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getShortIntro() {
		return shortIntro;
	}

	public void setShortIntro(String shortIntro) {
		this.shortIntro = shortIntro;
	}

	public int getTimeToRead() {
		return timeToRead;
	}

	public void setTimeToRead(int timeToRead) {
		this.timeToRead = timeToRead;
	}
	
	public String getAutherName() {
		return autherName;
	}

	public void setAutherName(String autherName) {
		this.autherName = autherName;
	}

	@Override
	public String toString() {
		return "Blog [id=" + id + ", heading=" + heading + ", content=" + content + ", authorId=" + authorId
				+ ", shortIntro=" + shortIntro + ", timeToRead=" + timeToRead + ", isPublic=" + isPublic + ", autherName=" + autherName + "]";
	}

}
