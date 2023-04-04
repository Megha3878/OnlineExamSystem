<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="https://cdnjs.datatables/1.12.1/css/dataTables.bootstrap4.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.js"></script> 
<script src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.12.1/js/dataTables.bootstrap4.min.js"></script>
</head>
<body>
<div class="container">
				
					<form action="./saveCandidateDetails" method="post">

						<div class="container" style="margin-top: 25px; border: 1px solid black;">
							<p align="right">
								<span class="text-danger">*</span> indicates mandatory fields
							</p>
							<h3>Edit Candidate</h3>
							
								
								<div class="form-group col-md-6 offset-md-3">
									<input type="hidden"
										name="candid" id="candid" class="form-control" value="${cand.candid}">
									<span id="candidEr" class="text-danger font-weight-bold"></span>
								</div>
								
							
								<div class="form-group col-md-6 offset-md-3">
									<label>Candidate Name :<span
						class="text-danger">*</span></label> <input type="text"
										name="candname" id="candname" class="form-control" value="${cand.candname}">
									<span id="applicantNameEr" class="text-danger font-weight-bold"></span>
								</div>
								
								<div class="form-group col-md-6 offset-md-3">
									<label>User Name :<span
						class="text-danger">*</span></label> <input type="text"
										name="candusername" id="candusername" class="form-control" value="${cand.candusername}">
									<span id="applicantNameEr" class="text-danger font-weight-bold"></span>
								</div>
								
								<div class="form-group col-md-6 offset-md-3">
									<label>Email :<span
						class="text-danger">*</span></label> <input type="text" name="candidateemail"
										id="candidateemail" class="form-control"  value="${cand.candidateemail}"> <span id="emailEr"
										class="text-danger font-weight-bold"></span>
								</div>
								
								<div class="form-group col-md-6 offset-md-3">
									<label>Mobile No:<span
						class="text-danger">*</span></label> <input type="number" name="candMobile"
										id="candMobile" class="form-control"  value="${cand.candMobile}"> <span
										id="mobileNoEr" class="text-danger font-weight-bold"></span>
								</div>
						
								<div class="form-group col-md-6 offset-md-3">
									<label>Date of Birth:<span
						class="text-danger">*</span></label> <input type="Date" name="canddob"
										id="canddob" class="form-control"  value="<f:formatDate pattern="yyyy-MM-dd" type="date" value="${cand.canddob}"/>"> <span id="dobEr"
										class="text-danger font-weight-bold"></span>
								</div>
							
							<div class="form-group col-md-6 offset-md-3">
									<label>Date of Exam:<span
						class="text-danger">*</span></label> <input type="Date" name="dateexam"
										id="dateexam" class="form-control" value="<f:formatDate pattern="yyyy-MM-dd" type="date" value="${cand.dateexam}"/>"> <span id="dobEr"
										class="text-danger font-weight-bold"></span>
								</div>
								
								<div class="form-group col-md-6 offset-md-3">
									<label>Address :<span class="text-danger">*</span></label> <br> 
										<textarea name="address" id="address" value="${cand.address}" class="form-control"></textarea>
								</div>
								
								
							
							<div class="form-group col-md-6 offset-md-3" align="center">
								<input type="submit" id="tabOneSubmit" onclick="return confirm('Are you want to Save your Details');" value="Submit"  class="btn btn-success">&nbsp;&nbsp;
								<input type="reset" value="Reset" class="btn btn-danger">
									
							</div>
						</div>

					</form>
					</div>
		 	
</body>
</html>