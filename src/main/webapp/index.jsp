<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script>
	$(document).ready(function(){
		//alert("Success");
		
		
		$.deletePerson = function(e){
			if(confirm("Silmek istediğinize emin misiniz?")){
				$.ajax({type:'GET',
						url:'/MobilDev/rest/userservice/delete?userId='+e,
						success: function(data) { 
							$("#"+e).remove();
							alert(data);
						}
				});
			}
			
		}
		
		$.getJSON('/MobilDev/rest/userservice/users',function(data){
			$.each( data, function( index,item ) {
				console.log(item);
				$("#userList").append('<div id="'+item.uuid+'">' + item.ad +" " + item.soyad +"  "+ item.email + '<a style="float:right" href="" onClick=$.deletePerson("'+item.uuid+'")>Sil</a></div>');
			    
			  });
		});
		
		$("#saveSubmit").on("click",function(e){

			let isFormValid = document.getElementById('userForm').checkValidity();
		    if(!isFormValid) {
		        $('#userForm').reportValidity();
		    } else {
		        
			    const ad = $("#ad").val();
				const soyad = $("#soyad").val();
				const email = $("#email").val();
				const password = $("#password").val();
				$.ajax({
				    type: 'POST',
				    contentType: "application/json",
				    dataType: 'json',
				    url: '/MobilDev/rest/userservice/create',
				    success: function() { 
						
						alert('Kayıt başarılı');
				    },
				    data: JSON.stringify({"ad":ad,"soyad":soyad,"email":email,"password":password}),				    
				});
				event.preventDefault();
		    }

			
		});
	});
</script>
</head>
<body>
<div class="container">
<p>
  <a class="btn btn-primary" data-bs-target="#save"  data-bs-toggle="collapse" href="#save" role="button" aria-expanded="false" aria-controls="save">
    Kullanıcı Kayıt
  </a>


  <a class="btn btn-primary" data-bs-target="#list" data-bs-toggle="collapse" href="#list" role="button" aria-expanded="false" aria-controls="list">
    Kullanıcı Listesi
  </a>

</p>

<div class="collapse" id="save">
  <div class="card card-body">
      <div class="mb-3 row">
      
	      <form id="userForm">
	      	<label for="ad" class="col-sm-2 m-2 col-form-label">Ad</label>
		    <div class="col-sm-10 m-2">
		      <input type="text" class="form-control" id="ad" required>
		    </div>
		    
		    <label for="soyad" class="col-sm-2 col-form-label" >Soyad</label>
		    <div class="col-sm-10  m-2">
		      <input type="text" class="form-control" id="soyad" required>
		    </div>
	      
		    <label for="email" class="col-sm-2 col-form-label">Email</label>
		    <div class="col-sm-10  m-2">
		      <input type="text" class="form-control" id="email" required>
		    </div>
		    
		  	<label for="password" class="col-sm-2 col-form-label">Password</label>
		    <div class="col-sm-10  m-2">
		      <input type="password" class="form-control" id="password" required="required">
		    </div>
		    
		    <button type="submit" class="btn btn-primary mb-3" id="saveSubmit">Kaydet</button>
		   </form>
	  </div>

    
    
    
    
  </div>
</div>
<div class="collapse" id="list">
  <div id="userList" class="card card-body">
    
  </div>
</div>
</div>


</body>
</html>