package br.com.cliente.security;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/bootstrap/**", "/dist/**", "plugins/**").permitAll().anyRequest()
				.authenticated().and().formLogin().failureUrl("/login?error").loginPage("/login").defaultSuccessUrl("/")
				.permitAll().and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/login").permitAll();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		/** Vamos usar o detailManager do spring boot **/
		JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager();

		/** Prover um datasource para o user Detail Manager **/
		userDetailsManager.setDataSource(dataSource);

		/** criar um encoder de senhas **/
		PasswordEncoder encoder = new BCryptPasswordEncoder();

		/** adiciona componentes ao autentication manager builder **/
		auth.userDetailsService(userDetailsManager).passwordEncoder(encoder);
		auth.jdbcAuthentication().dataSource(dataSource);

		/** testa se o usuario existe, se nao, cria o usuario **/
		if (!userDetailsManager.userExists("admin")) {
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			/** adiciona usuario **/
			authorities.add(new SimpleGrantedAuthority("ADMIN"));
			User user = new User("admin", encoder.encode("admin"), authorities);
			userDetailsManager.createUser(user);
		}
		
		if (!userDetailsManager.userExists("narutinho")) {
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			/** adiciona usuario **/
			authorities.add(new SimpleGrantedAuthority("ADMIN"));
			User user = new User("narutinho", encoder.encode("narutinho"), authorities);
			userDetailsManager.createUser(user);
		}
		
		if (!userDetailsManager.userExists("sakura")) {
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			/** adiciona usuario **/
			authorities.add(new SimpleGrantedAuthority("ADMIN"));
			User user = new User("sakura", encoder.encode("sakura"), authorities);
			userDetailsManager.createUser(user);
		}
	}
}
