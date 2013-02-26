package com.force.aus.erp.canvas.interceptors;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.force.aus.erp.canvas.AppProperties;
import com.force.aus.erp.canvas.CanvasRequest;
import com.force.aus.erp.canvas.SignedRequest;
import com.force.aus.erp.canvas.actions.BaseAction;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class SignedRequestInterceptor extends AbstractInterceptor {
	
	private Logger logger;
	private static String SESSION_KEY_CANVAS_REQUEST = "CanvasRequest";
	private static String REQUEST_KEY_SIGNED_REQUEST = "signed_request";


	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		logger = LoggerFactory.getLogger(this.getClass());
		logger.info("Are we checking for the Signed Request?");
		Map<String, Object> attributes = ActionContext.getContext().getSession();
		HttpServletRequest request = ServletActionContext.getRequest();
		
		String signedRequest = request.getParameter(REQUEST_KEY_SIGNED_REQUEST);
		CanvasRequest canvasRequest = null;
		
		if (signedRequest != null) {
			logger.info("We have a SignedRequest {}", signedRequest);
			// process signed request
			String canvasAppSecret = System.getenv(AppProperties.CANVAS_APP_SECRET);
			if(canvasAppSecret == null) 
				canvasAppSecret = AppProperties.getPropValue(AppProperties.CANVAS_APP_SECRET);
			canvasRequest = SignedRequest.verifyAndDecode(signedRequest, canvasAppSecret);
			logOutCanvasDetails(canvasRequest);
			attributes.put(SESSION_KEY_CANVAS_REQUEST, canvasRequest);

		} else {
	
			canvasRequest = (CanvasRequest)attributes.get(SESSION_KEY_CANVAS_REQUEST);
			if (canvasRequest == null) {
				
				logger.error("There is no Signed Request or Session stored Canvas Request. Maybe we should be refreshing parent window?");
				// return "noSignedRequest";
			} else {
				logger.info("We have a CanvasRequest in session. Not sure how to validate this is accurate?");
			}
		}
		BaseAction action = (BaseAction)invocation.getAction();
		action.setCanvasRequest(canvasRequest);
		return invocation.invoke();

	}
	
	private void logOutCanvasDetails(CanvasRequest canvasRequest) {
		
		logger.info("Algorithm {}", canvasRequest.getAlgorithm());
		logger.info("Client ID {}", canvasRequest.getClient().getClientId());
		logger.info("Instance ID {}", canvasRequest.getClient().getInstanceId());
		logger.info("Instance URL {}", canvasRequest.getClient().getInstanceUrl());
		logger.info("OAuth Token {}", canvasRequest.getClient().getOAuthToken());
		logger.info("Target Origin {}", canvasRequest.getClient().getTargetOrigin());
		logger.info("Dimension - Height {}", canvasRequest.getContext().getEnvironmentContext().getDimensions().getHeight());
		logger.info("Dimension - Width {}", canvasRequest.getContext().getEnvironmentContext().getDimensions().getWidth());
		logger.info("Location URL {}", canvasRequest.getContext().getEnvironmentContext().getLocationUrl());
		logger.info("API Version {}", canvasRequest.getContext().getEnvironmentContext().getSystemVersion().getApiVersion());
		logger.info("Season {}", canvasRequest.getContext().getEnvironmentContext().getSystemVersion().getSeason());
		logger.info("UI Theme {}", canvasRequest.getContext().getEnvironmentContext().getUiTheme());
		logger.info("URL - Chatter Feed Item {}", canvasRequest.getContext().getLinkContext().getChatterFeedItemsUrl());
		logger.info("URL - Chatter Feeds {}", canvasRequest.getContext().getLinkContext().getChatterFeedsUrl());
		logger.info("URL - Chatter Groups {}", canvasRequest.getContext().getLinkContext().getChatterGroupsUrl());
		logger.info("URL - Chatter Users {}", canvasRequest.getContext().getLinkContext().getChatterUsersUrl());
		logger.info("URL - Enterprise {}", canvasRequest.getContext().getLinkContext().getEnterpriseUrl());
		logger.info("URL - Metadata {}", canvasRequest.getContext().getLinkContext().getMetadataUrl());
		logger.info("URL - Partner {}", canvasRequest.getContext().getLinkContext().getPartnerUrl());
		logger.info("URL - Query {}", canvasRequest.getContext().getLinkContext().getQueryUrl());
		logger.info("URL - Recent Items {}", canvasRequest.getContext().getLinkContext().getRecentItemsUrl());
		logger.info("URL - Rest {}", canvasRequest.getContext().getLinkContext().getRestUrl());
		logger.info("URL - Search {}", canvasRequest.getContext().getLinkContext().getSearchUrl());
		logger.info("URL - SObject {}", canvasRequest.getContext().getLinkContext().getSobjectUrl());
		logger.info("URL - User {}", canvasRequest.getContext().getLinkContext().getUserUrl());
		logger.info("Currency ISO Code {}", canvasRequest.getContext().getOrganizationContext().getCurrencyISOCode());
		logger.info("Org Name {}", canvasRequest.getContext().getOrganizationContext().getName());
		logger.info("Org ID {}", canvasRequest.getContext().getOrganizationContext().getOrganizationId());
		logger.info("Currency ISO Code {}", canvasRequest.getContext().getUserContext().getCurrencyISOCode());
		logger.info("User - Email {}", canvasRequest.getContext().getUserContext().getEmail());
		logger.info("User - Firstname {}", canvasRequest.getContext().getUserContext().getFirstName());
		logger.info("User - Full Name {}", canvasRequest.getContext().getUserContext().getFullName());
		logger.info("User - Language {}", canvasRequest.getContext().getUserContext().getLanguage());
		logger.info("User - Lastname {}", canvasRequest.getContext().getUserContext().getLastName());
		logger.info("User - Locale {}", canvasRequest.getContext().getUserContext().getLocale().toString());
		logger.info("User - Profile ID {}", canvasRequest.getContext().getUserContext().getProfileId());
		logger.info("URL - Profile Photo {}", canvasRequest.getContext().getUserContext().getProfilePhotoUrl());
		logger.info("URL - Profile Thumbnail {}", canvasRequest.getContext().getUserContext().getProfileThumbnailUrl());
		logger.info("User - Role ID {}", canvasRequest.getContext().getUserContext().getRoleId());
		logger.info("User - Timezone {}", canvasRequest.getContext().getUserContext().getTimeZone());
		logger.info("User - username {}", canvasRequest.getContext().getUserContext().getUserName());
		logger.info("User - Type {}", canvasRequest.getContext().getUserContext().getUserType());
		logger.info("Issued At {}", canvasRequest.getIssuedAt());
		logger.info("User - ID {}", canvasRequest.getUserId());
	}
}
