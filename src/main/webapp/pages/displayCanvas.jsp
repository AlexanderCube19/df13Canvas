<%@taglib prefix="s" uri="/struts-tags" %>

<ul class="request">
	<li>User ID : <s:property value="canvasRequest.userId"/> </li>
	<li>Signing Algoritm : <s:property value="canvasRequest.algorithm"/></li>
	<li>Issued At : <s:property value="canvasRequest.issuedAt"/></li>
	<li>
		<ul>
			<li>Canvas Context</li>
			<li>
				<ul>
					<li>User Context</li>
					<li>User Id : <s:property value="canvasRequest.context.userContext.userId"/></li>
    				<li>User Name : <s:property value="canvasRequest.context.userContext.userName"/></li>
    				<li>First Name : <s:property value="canvasRequest.context.userContext.firstName"/></li>
    				<li>Last Name: <s:property value="canvasRequest.context.userContext.lastName"/></li>
   					<li>Email : <s:property value="canvasRequest.context.userContext.email"/></li>
    				<li>Full Name : <s:property value="canvasRequest.context.userContext.fullName"/></li>
    				<li>User Locale : <s:property value="canvasRequest.context.userContext.locale"/></li>
    				<li>Language : <s:property value="canvasRequest.context.userContext.language"/></li>
    				<li>Time Zone : <s:property value="canvasRequest.context.userContext.timeZone"/></li>
    				<li>Profile ID : <s:property value="canvasRequest.context.userContext.profileId"/></li>
    				<li>Role ID : <s:property value="canvasRequest.context.userContext.roleId"/></li>
    				<li>User Type : <s:property value="canvasRequest.context.userContext.userType"/></li>
    				<li>Currency ISO Code : <s:property value="canvasRequest.context.userContext.currencyISOCode"/></li>
    				<li>Accessiblity Mode : <s:property value="canvasRequest.context.userContext.accessibilityMode"/></li>
    				<li>Profile Photo URL : <s:property value="canvasRequest.context.userContext.profilePhotoUrl"/></li>
    				<li>Profile Thumbnail URL : <s:property value="canvasRequest.context.userContext.profileThumbnailUrl"/></li>
				</ul>
			</li>
			<li>
				<ul>
					<li>Organisation Context</li>
					<li>Org ID : <s:property value="canvasRequest.context.organizationContext.organizationId"/></li>
					<li>Org Name : <s:property value="canvasRequest.context.organizationContext.name"/></li>
    				<li>Multi Currency : <s:property value="canvasRequest.context.organizationContext.multicurrencyEnabled"/></li>
    				<li>Currency ISO Code : <s:property value="canvasRequest.context.organizationContext.currencyISOCode"/></li>
				</ul>
			</li>
			<li>
				<ul>
					<li>Link Context</li>
					<li>Enterprise URL : <s:property value="canvasRequest.context.linkContext.enterpriseUrl"/></li>
    				<li>Metadata URL : <s:property value="canvasRequest.context.linkContext.metadataUrl"/></li>
    				<li>Partner URL : <s:property value="canvasRequest.context.linkContext.partnerUrl"/></li>
    				<li>Rest URL : <s:property value="canvasRequest.context.linkContext.restUrl"/></li>
    				<li>SObject URL : <s:property value="canvasRequest.context.linkContext.sobjectUrl"/></li>
    				<li>Search URL : <s:property value="canvasRequest.context.linkContext.searchUrl"/></li>
    				<li>Query URL : <s:property value="canvasRequest.context.linkContext.queryUrl"/></li>
    				<li>Recent Items URL : <s:property value="canvasRequest.context.linkContext.recentItemsUrl"/></li>
    				<li>User Profile URL : <s:property value="canvasRequest.context.linkContext.userProfileUrl"/></li>
    				<li>Chatter Feeds URL : <s:property value="canvasRequest.context.linkContext.chatterFeedsUrl"/></li>
    				<li>Chatter Groups URL : <s:property value="canvasRequest.context.linkContext.chatterGroupsUrl"/></li>
    				<li>Chatter Users URL : <s:property value="canvasRequest.context.linkContext.chatterUsersUrl"/></li>
    				<li>Chatter Feed Items URL : <s:property value="canvasRequest.context.linkContext.chatterFeedItemsUrl"/></li>
				</ul>
			</li>
			<li>
				<ul>
					<li>Environment Context</li>
					<li>Location URL : <s:property value="canvasRequest.context.environmentContext.locationUrl"/></li>
    				<li>UI Theme : <s:property value="canvasRequest.context.environmentContext.uiTheme"/></li>
    				<li>
    					<ul>
    						<li>Dimensions</li>
    						<li>Width : <s:property value="canvasRequest.context.environmentContext.dimensions.width"/></li>
    						<li>Height : <s:property value="canvasRequest.context.environmentContext.dimensions.height"/></li>
    					</ul>
    				</li>
    				<li>
    					<ul>
    						<li>System Version</li>
    						<li>API : <s:property value="canvasRequest.context.environmentContext.systemVersion.api"/></li>
    						<li>Season : <s:property value="canvasRequest.context.environmentContext.systemVersion.season"/></li>
    					</ul>
    				</li>
				</ul>
			</li>
		</ul>
	</li>
	<li>
		<ul>
			<li>Canvas Client</li>
			<li>OAuth Token : <s:property value="canvasRequest.client.OAuthToken"/></li>
    		<li>Client ID : <s:property value="canvasRequest.client.clientId"/></li>
    		<li>Instance ID : <s:property value="canvasRequest.client.instanceId"/></li>
    		<li>Target Origin : <s:property value="canvasRequest.client.targetOrigin"/></li>
    		<li>Instance URL : <s:property value="canvasRequest.client.instanceUrl"/></li>
		</ul>
	</li>
</ul>
