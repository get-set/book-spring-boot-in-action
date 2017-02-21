<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/thml4/loose.dtd">

<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>Servlet async test</title>
</head>
<body>

<div id="msgpush"></div>

<script type="application/javascript" src="assets/js/jquery.js"></script>
<script type="application/javascript">
    deferred();

    function deferred() {
        $.get('defer', function (data) {
            console.log(data);
            deferred();
        })
    }
</script>

</body>
</html>