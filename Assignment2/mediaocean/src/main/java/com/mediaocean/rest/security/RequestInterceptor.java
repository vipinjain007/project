package com.mediaocean.rest.security;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.mediaocean.rest.constant.Messages;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Iterator;
import java.util.List;

/**
 * Intercept all REST request headers Verify if security-token is present and is valid
 *
 */
public class RequestInterceptor implements HandlerInterceptor {

    Logger log = LoggerFactory.getLogger(RequestInterceptor.class);
    private List<String> specialUrls;
  

    // TODO: bill add logic here to apply username and intercept ALL REST calls


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        boolean result = false;
        String url = request.getRequestURI();

        int authenticationId=0;
        log.info("Intercept request to REST Service URI: " + url);

        if (this.isSpecialUrl(url)) {
            log.info("Request uri : " + url + " is a special URL!");

            result = this.validateSpecialRequest(request);
        } else {
           
        	try{
             authenticationId = Integer.parseInt(request.getHeader("AUTHENTICATION_ID"));
            
        	} catch(Exception e){
            	result = false;
            }
            log.info("RequestInterceptor.preHandle():  Username: " + authenticationId);

            // check for a valid authorization token and username
            if ((authenticationId !=99)) {

                log.error(Messages.NO_AUTHTOKEN_EXCEPTION);
                result = false;

            } else {

            	result = true;
            }
        }

        if (result == true) {
            log.info("RequestInterceptor.preHandle(): " + Messages.API_REQUEST_WAS_PERMITTED);
        } else {
            log.info(Messages.API_REQUEST_WAS_REJECTED);

            response.sendError(401, Messages.API_REQUEST_WAS_REJECTED);
        }

        return result;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        log.debug("Successfully validated request header");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        log.debug("Completed Intercepting REST service request header");
    }

    /**
     *  Analyze the URL, see if it is one of the registered special URLs.
     *  e.g. The Login URL
     *
     * @param url
     * @return
     */
    private boolean isSpecialUrl(String url) {

        boolean isSpecial = false;
       
        if (specialUrls != null && !specialUrls.isEmpty()) {
            Iterator<String> strItr = specialUrls.iterator();

            String specialUrl;

            while (strItr.hasNext()) {

                specialUrl = strItr.next();

                if (url.indexOf(specialUrl) != -1) {
                    log.info("Special Url: validating request credentials :");
                    isSpecial = true;
                    break;
                }
            }
        }

        return isSpecial;
    }

    /**
     *  This is the pass-thru method for the login service, currently THIS IS THE ONLY UNAUTHENTICATED API CALL PERMITTED
     *
     *  @param      request The original HTTP Request
     *  @return             true
     */
    private boolean validateSpecialRequest(HttpServletRequest request) {

//        String url = request.getRequestURI();
//        String uid =  request.getParameter("user");
//        String pwd =  request.getParameter("password");
//
//
//        log.debug("Validate specialRequest : " + url);
//        log.debug("Post parameters user: " + uid);
//        log.debug("post parameter password: " + pwd);

        //

        return true;
    }

    public List<String> getSpecialUrls() {

        return specialUrls;
    }

    public void setSpecialUrls(List<String> specialUrls) {

        this.specialUrls = specialUrls;
    }
}
