<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd" >
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="candidateNavbar.jsp" %>
</head>
<frameset cols="20%,80%" title="Documentation frame" onload="top.loadFrames()">

<frameset rows="30%,70%" title="Left frames" onload="top.loadFrames()">

<frame src="overview-frame.html" name="packageListFrame" title="All Packages">

<frame src="allclasses-frame.html" name="packageFrame" title="All classes and interfaces (except non-static nested types)">

</frameset>

<frame src="overview-summary.html" name="classFrame" title="Package, class and interface descriptions" scrolling="yes">

<noframes>

<noscript>

<div>JavaScript is disabled on your browser.</div>

</noscript>

<h2>Frame Alert</h2>

<p>This document is designed to be viewed using the frames feature. If you see this message, you are using a non-frame-capable web client. Link to <a href="overview-summary.html">Non-frame version</a>.</p>

</noframes>

</frameset>
<body>
<h1>Welcome user here</h1>

</body>
</html>