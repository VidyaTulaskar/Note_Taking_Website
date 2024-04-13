package Bean;

import java.io.Serializable;

@SuppressWarnings("serial")
public class NoteBean implements Serializable
{
	private int Id;
	private String uname, datetime, title, note;
	
	public NoteBean() {}
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
}
