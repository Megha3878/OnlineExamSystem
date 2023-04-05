<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="hrNavbar.jsp"%>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.min.css">
<link
	rel="https://cdnjs.datatables/1.12.1/css/dataTables.bootstrap4.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script
	src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
<script
	src="https://cdn.datatables.net/1.12.1/js/dataTables.bootstrap4.min.js"></script>
</head>
<body>

	<div class="container">
<<<<<<< Upstream, based on origin/master
            <div id="login-row" class="row justify-content-center align-items-center">
                <div id="login-column" class="col-md-6">
                    <div id="login-box" style="height: 240px;" class="col-md-12">
                      
                      <h3 class="text-center mt-4">Enter new password</h3>
                      
                      <form action="/change-password" method="post">
                      		<div class="form-group">
								<input name="newpassword" required="required" type="password" placeholder="Enter New Password Here" class="form-control">
                      		</div>
                      		<div class="form-group">
								<input name="cpassword" required="required" type="password" placeholder="Enter New Password Here" class="form-control">
                      		</div>
                      		<div class="container text-center">
                      			<button class="btn btn-success">Change password</button>
                      		</div>
                      </form>
                    </div>
                </div>
            </div>
        </div>
=======
		<div id="login-row"
			class="row justify-content-center align-items-center">
			<div id="login-column" class="col-md-6">
				<div id="login-box" style="height: 240px;" class="col-md-12">

					<h3 class="text-center mt-4">Enter new password</h3>

					<form action="/change-password" method="post">
						<div class="form-group">
							<input name="newpassword" required="required" type="password"
								placeholder="Enter New Password Here" class="form-control">
						</div>
						<div class="form-group">
							<input name="password" required="required" type="password"
								placeholder="Enter New Password Here" class="form-control">
						</div>
						<div class="container text-center">
							<button class="btn btn-success">Change password</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
>>>>>>> c8e5a72 initial commit

</body>
</html>