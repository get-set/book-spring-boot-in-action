<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/thml4/loose.dtd">

<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>SSE test</title>
</head>
<body>

<div id="msgpush"></div>

<script type="application/javascript" src="assets/js/jquery.js"></script>
<script type="application/javascript">
    if (!!window.EventSource) {
        var source = new EventSource('push');
        s='';
        source.addEventListener('message', function (e) {
            console.log("message:" + e.data);
            s += e.data + "<br/>";
            $("#msgpush").html(s);
        });

        source.addEventListener('open', function (e) {
            console.log("连接打开");
        }, false);
        source.addEventListener('error', function (e) {
            if (e.readyState == EventSource.CLOSED) {
                console.log("连接关闭");
            } else {
                console.log(e.readyState);
            }
        }, false);
    } else {
        console.log("浏览器不支持SSE");
    }
</script>

</body>
</html>