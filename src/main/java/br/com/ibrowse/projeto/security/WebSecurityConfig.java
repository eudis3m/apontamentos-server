package br.com.ibrowse.projeto.security;



import java.util.Collections;



import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.cors.*;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
@CrossOrigin
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	UsernamePasswordAuthenticationFilter  username = new UsernamePasswordAuthenticationFilter();
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable();
        httpSecurity.cors().configurationSource( corsConfigurationSource());
		httpSecurity.authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/apontamentos").permitAll()
                .antMatchers("/apontamentos/**").permitAll()
                .antMatchers("/empresa").permitAll()
                .antMatchers("/empresa/**").permitAll()
                .antMatchers("/centro-custo").permitAll()
                .antMatchers("/centro-custo/**").permitAll()
                .antMatchers("/projeto").permitAll()
                .antMatchers("/projeto/**").permitAll()
                .antMatchers("/tipo-atividade").permitAll()
                .antMatchers("/tipo-atividade/**").permitAll()
                .antMatchers("/atividades").permitAll()
                .antMatchers("/atividades/**").permitAll()
                .antMatchers("/usuarios/").permitAll()
                .antMatchers("/usuarios/**").permitAll()
                .antMatchers("/update-usuario").permitAll()
                .antMatchers("/recursos").permitAll()
                .antMatchers("/recursos/**").permitAll()
                .antMatchers("/update-empresa").permitAll()
                .antMatchers("/**/**").permitAll()
                .anyRequest().authenticated()
                .and().addFilterBefore( new JWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    public CorsConfigurationSource corsConfigurationSource() {
        final CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedHeaders(Collections.singletonList("*"));
        configuration.setAllowedMethods(Collections.singletonList("*"));
        configuration.addAllowedOrigin("*");
        configuration.setAllowCredentials(true);

        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

}
