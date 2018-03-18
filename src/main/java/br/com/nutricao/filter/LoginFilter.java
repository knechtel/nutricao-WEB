package br.com.nutricao.filter;
import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.nutricao.bean.Usuario;
import br.com.nutricao.controller.UsuarioBean;

/**
 * Servlet Filter implementation class LoginFilter
 */
public class LoginFilter implements Filter {
@Inject
UsuarioBean usuarioBean;
    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, 
	            ServletResponse response,
	            FilterChain chain) throws IOException, ServletException {
	   
	                     //Captura o ManagedBean chamado “usuarioMB”
//	                     UsuarioBackBean usuario = (UsuarioBackBean) 
//	                    		  ((HttpServletRequest) request)
//	                       .getSession().getAttribute("usuarioBean");

		
	                   
	                     //Verifica se nosso ManagedBean ainda não 
	                     //foi instanciado ou caso a
	                     //variável loggedIn seja false, assim saberemos que  
	                     // o usuário não está logado
	                     if (usuarioBean == null|| ! usuarioBean.isLoggedIn() ) {
	                       String contextPath = ((HttpServletRequest) request)
	                        .getContextPath();
	                         //Redirecionamos o usuário imediatamente 
	                         //para a página de login.xhtml
	                       ((HttpServletResponse) response).sendRedirect
	                        (contextPath +"/index.xhtml");
	                       
	                       
	                       
	                     } else {
	                            //Caso ele esteja logado, apenas deixamos 
	                            //que o fluxo continue
	                          chain.doFilter(request, response);
	                     }
	           }
	

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
