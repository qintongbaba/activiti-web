package org.wuqinghua.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 请假单表
 *
 */

@Entity
@Table(name = "t_leave_bill")
public class LeaveBill implements Serializable {
	private static final long serialVersionUID = -1416594599216711175L;
	private Long id;
	private Integer days;// 请假天数
	private String content;// 请假内容
	private Date leaveDate = new Date();
	private String remark;
	private Employee user;
	private Integer state;// 请假状态 0开始录入 1开始审批 2审批完成

	public LeaveBill(Long id, Integer days, String content, Date leaveDate, String remark, Employee user,
			Integer state) {
		super();
		this.id = id;
		this.days = days;
		this.content = content;
		this.leaveDate = leaveDate;
		this.remark = remark;
		this.user = user;
		this.state = state;
	}

	public LeaveBill() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getDays() {
		return days;
	}

	public void setDays(Integer days) {
		this.days = days;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getLeaveDate() {
		return leaveDate;
	}

	public void setLeaveDate(Date leaveDate) {
		this.leaveDate = leaveDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@ManyToOne
	@JoinColumn(name = "user_id")
	public Employee getUser() {
		return user;
	}

	public void setUser(Employee user) {
		this.user = user;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

}
