package br.com.cliente.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

/**
 * @author vinny em 07/08/2020
 * @project cliente
 **/

@Entity
public class Users extends AbstractModel<Long> {

	@Column(name = "username", length = 20, nullable = false)
	private String userName;

	@Column(name = "password", length = 100, nullable = false)
	private String password;

	@Column(name = "enabled")
	private Boolean enabled;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

}
