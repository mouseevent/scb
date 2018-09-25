<html>

<head>  
	<title>SCB Dashboard</title>
    <link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">  
    <link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">  
    <script type="text/javascript" src="/easyui/jquery.min.js"></script>  
    <script type="text/javascript" src="/easyui/jquery.easyui.min.js"></script>  
  </head>  
<body>
<#--<div style="margin:0px auto;text-align: center;">-->
 <h2>Login</h2>
 	<form action="/login" method="post" >
    	<div >    
      		<input required="required" name="username" class="easyui-textbox" placeholder="User Name" type="text">
    	</div>
    	<div >
      		<input required="required" placeholder="Password" name="password" class="easyui-textbox" type="password">
    	</div>
    	<div >
    	<input type="submit" name="Submit"/>
		</div>
	    <#if error??>
    	    <div style="text-align:left;padding: 10px;">${error}</div>
    	</#if>

  	</form>

</body>
</html>