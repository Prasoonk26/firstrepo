<!DOCTYPE html>
<html >
<head>
  <meta charset="UTF-8">
  <title>Responstable 2.0: a responsive table solution</title>
  
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">

  
      <link rel="stylesheet" href="css_table/style.css">
      <script src="http://code.jquery.com/jquery-1.10.2.js"
	type="text/javascript"></script>
<script src="js/ajax.js" type="text/javascript"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="http://code.jquery.com/jquery-latest.js"> </script>

  
  <script>



	
	 $(document).ready(function() {                        
		                $('#radio').click(function(event) {  
		                    var username=$('#radio').val();
	                 	alert("user Value is "+username);
		                 $.get('fakeController',{user:username},function(responseText) { 
		                            
		                    });
		                });
		            });
	


</script>
</head>

<body>
  

<table class="responstable">
  
  <tr>
    <th>Main driver</th>
    <th>XYZ</th>
    <th>Surname</th>
    <th>Date of birth</th>
    <th>Relationship</th>
  </tr>
  
  <tr>
    <td><input type="radio" id="radio" value="Three"/></td>
    <td>Steve</td>
    <td>Foo</td>
    <td>01/01/1978</td>
    <td>Policyholder</td>
  </tr>
  
  <tr>
    <td><input type="radio" id="radio" value="four"/></td>
    <td>Steffie</td>
    <td>Foo</td>
    <td>01/01/1978</td>
    <td>Spouse</td>
  </tr>
  
  <tr>
    <td><input type="radio" id="radio" value="five"/></td>
    <td>Stan</td>
    <td>Foo</td>
    <td>01/01/1994</td>
    <td>Son</td>
  </tr>
  
  <tr>
    <td><input type="radio" id="radio" value="one" /></td>
    <td>Stella</td>
    <td>Foo</td>
    <td>01/01/1992</td>
    <td>Daughter</td>
  </tr>
  
</table>
  <script src='http://cdnjs.cloudflare.com/ajax/libs/respond.js/1.4.2/respond.js'></script>

  
</body>
</html>
