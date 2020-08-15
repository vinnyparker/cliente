package br.com.cliente.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

/**
 * @author vinny em 07/08/2020
 * @project cliente
 **/

@Entity
public class Authorities extends AbstractModel<Long> {

	@Column(name = "username", length = 20, nullable = false)
	private String userName;

	@Column(name = "authority", length = 20, nullable = false)
	private String authority;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}



}
