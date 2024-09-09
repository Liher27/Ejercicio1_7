package main.pojo;

import java.util.Objects;

public class Message {

	private String fromText = null;
	private String toText = null;
	private String hourText = null;
	private String dateText = null;
	private String themeText = null;
	private String contentText = null;

	public Message(String fromText, String toText, String hourText, String dateText,String themeText, String contentText) {
		this.fromText = fromText;
		this.toText = toText;
		this.hourText = hourText;
		this.dateText = dateText;
		this.themeText = themeText;
		this.contentText = contentText;
	}

	public String getFromText() {
		return fromText;
	}

	public void setFromText(String fromText) {
		this.fromText = fromText;
	}

	public String getToText() {
		return toText;
	}

	public void setToText(String toText) {
		this.toText = toText;
	}

	public String getHourText() {
		return hourText;
	}

	public void setHourText(String hourText) {
		this.hourText = hourText;
	}

	public String getDateText() {
		return dateText;
	}

	public void setDateText(String dateText) {
		this.dateText = dateText;
	}

	public String getThemeText() {
		return themeText;
	}

	public void setThemeText(String themeText) {
		this.themeText = themeText;
	}

	public String getContentText() {
		return contentText;
	}

	public void setContentText(String contentText) {
		this.contentText = contentText;
	}

	@Override
	public int hashCode() {
		return Objects.hash(contentText, dateText, fromText, hourText, themeText, toText);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Message other = (Message) obj;
		return Objects.equals(contentText, other.contentText) && Objects.equals(dateText, other.dateText)
				&& Objects.equals(fromText, other.fromText) && Objects.equals(hourText, other.hourText)
				&& Objects.equals(themeText, other.themeText) && Objects.equals(toText, other.toText);
	}

	@Override
	public String toString() {
		return "Message [fromText=" + fromText + ", toText=" + toText + ", hourText=" + hourText + ", dateText="
				+ dateText + ", themeText=" + themeText + ", contentText=" + contentText + "]";
	}

}
