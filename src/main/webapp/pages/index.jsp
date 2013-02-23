<%--
  Copyright (c) 2013, salesforce.com, inc.
  All rights reserved.
 
  Redistribution and use in source and binary forms, with or without modification, are permitted provided
  that the following conditions are met:
 
     Redistributions of source code must retain the above copyright notice, this list of conditions and the
     following disclaimer.
 
     Redistributions in binary form must reproduce the above copyright notice, this list of conditions and
     the following disclaimer in the documentation and/or other materials provided with the distribution.
 
     Neither the name of salesforce.com, inc. nor the names of its contributors may be used to endorse or
     promote products derived from this software without specific prior written permission.
 
  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED
  WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A
  PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
  ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED
  TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
  HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
  POSSIBILITY OF SUCH DAMAGE.
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" session="false" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<meta charset="utf-8" />
		<title>Jetty Template</title>
		<link href="/css/template.css" rel="stylesheet" type="text/css" />
		<link href="/images/favicon.ico" rel="icon" type="image/x-icon">
		<script src="/js/jquery-1.7.1.min.js"></script>
		<script src="/js/jquery.noty.js"></script>
		<script src="/js/layouts/top.js"></script>
		<script src="/js/layouts/topCenter.js"></script>
		<script src="/js/themes/default.js"></script>
		<script src="/js/template.js"></script>
	</head>
<body>

<div id="header">
	<h1><s:property value="pageName"/></h1>
	<div id="breadcrumb">
		
		<ul>
			<s:iterator value="breadcrumb" var="crumb" status="stat">
				<s:if test="#stat.index !=  breadcrumb.size()-1">
					<li class="middle">
				</s:if>
				<s:else>
					<li>
				</s:else>
					<s:url var="url" action="%{#crumb.toLowerCase()}" namespace="/struts" />
					<s:a href="%{#url}"><s:property value="#crumb"/></s:a>
				</li>
			</s:iterator>
		</ul>
	</div>
</div>
<div id="mainContainer">
	<h2>Here should be the stuff.</h2>
	<ul>
		<s:iterator value="accounts" var="account" status="index">
			<li>
				<s:property value="#account.name"/> [Ex_ID <s:property value="#account.externalID"/>]
			</li>
		</s:iterator>
	</ul>
</div>
<div id="footer">
Powered by <a href="http://www.heroku.com"><img src="/images/heroku.png" alt="Heroku" height="20px" align="top"/></a>
</div>
</body>
</html>