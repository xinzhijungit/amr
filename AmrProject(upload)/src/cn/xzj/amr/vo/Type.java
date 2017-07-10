package cn.xzj.amr.vo;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class Type implements Serializable {
	private Integer tid ;
	public List<Subtype> getSubtypes() {
		return subtypes;
	}
	public void setSubtypes(List<Subtype> subtypes) {
		this.subtypes = subtypes;
	}
	private String title ;
	private List<Subtype> subtypes ;
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
