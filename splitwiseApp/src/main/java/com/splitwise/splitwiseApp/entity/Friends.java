package com.splitwise.splitwiseApp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="friends")
public class Friends {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long no;
	private String name;
	private Long spend;
	private Long remain;
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getSpend() {
		return spend;
	}
	public void setSpend(Long spend) {
		this.spend = spend;
	}
	public Long getRemain() {
		return remain;
	}
	public void setRemain(Long remain) {
		this.remain = remain;
	}
	
}
