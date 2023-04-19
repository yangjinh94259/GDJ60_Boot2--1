<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
 <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Modern Business - Start Bootstrap Template</title>
        <!-- favicon 적용 -->
        <c:import url="../temp/style.jsp"></c:import>
        <!-- favicon 끝 -->
    </head>
</head>
 	<body class="d-flex flex-column h-100">
        <main class="flex-shrink-0">
        <!-- Navigation-->
            <c:import url="../temp/header.jsp"></c:import>
        		 <section class="py-5">
                <div class="container px-5">
                    <!-- Contact form-->
                    <div class="bg-light rounded-3 py-5 px-4 px-md-5 mb-5">
                        <div class="text-center mb-5">
                            <div class="feature bg-primary bg-gradient text-white rounded-3 mb-3"><i class="bi bi-envelope"></i></div>
                            <h1 class="fw-bolder">Get in touch</h1>
                            <p class="lead fw-normal text-muted mb-0">We'd love to hear from you</p>
                        </div>
                        <div class="row gx-5 justify-content-center">
                            <div class="col-lg-8 col-xl-6">
                               
                                <form id="contactForm" action="./add" method="post" data-sb-form-api-token="API_TOKEN" enctype="multipart/form-data">
                                    <!-- Name input-->
                                    <div class="form-floating mb-3">
                                        <input class="form-control" id="title" name="title" type="text" placeholder="Enter Title..." data-sb-validations="required" />
                                        <label for="title">Title</label>
                                        <div class="invalid-feedback" data-sb-feedback="title:required">A name is required.</div>
                                    </div>
                                    <!-- Writer address input-->
                                    <div class="form-floating mb-3">
                                        <input class="form-control" id="name" name="name" type="text" data-sb-validations="required,email" />
                                        <label for="name">Writer</label>
                                        <div class="invalid-feedback" data-sb-feedback="email:required">An email is required.</div>
                                        <div class="invalid-feedback" data-sb-feedback="email:email">Email is not valid.</div>
                                    </div>
                                    <!-- info input-->
                                    <div class="form-floating mb-3">
                                        <textarea class="form-control" id="info" name="info" placeholder="Enter info here..." style="height: 10rem" data-sb-validations="required"></textarea>
                                        <label for="info">Contents</label>
                                        <div class="invalid-feedback" data-sb-feedback="info:required">A message is required.</div>
                                    </div>
                                  
                                  	<!-- 첨부파일 -->
                                  	<div class="form-floating mb-3">
                                  		<input type="file" name="boardFiles">
                                  	</div>
                                  	
                                    <!-- Submit Button-->
                                    <div class="d-grid"><button class="btn btn-primary btn-lg" id="submitButton" type="button">Submit</button></div>
                                </form>
                            </div>
                        </div>
                    </div>
                    <!-- Contact cards-->
                    <div class="row gx-5 row-cols-2 row-cols-lg-4 py-5">
                        <div class="col">
                            <div class="feature bg-primary bg-gradient text-white rounded-3 mb-3"><i class="bi bi-chat-dots"></i></div>
                            <div class="h5 mb-2">Chat with us</div>
                            <p class="text-muted mb-0">Chat live with one of our support specialists.</p>
                        </div>
                        <div class="col">
                            <div class="feature bg-primary bg-gradient text-white rounded-3 mb-3"><i class="bi bi-people"></i></div>
                            <div class="h5">Ask the community</div>
                            <p class="text-muted mb-0">Explore our community forums and communicate with other users.</p>
                        </div>
                        <div class="col">
                            <div class="feature bg-primary bg-gradient text-white rounded-3 mb-3"><i class="bi bi-question-circle"></i></div>
                            <div class="h5">Support center</div>
                            <p class="text-muted mb-0">Browse FAQ's and support articles to find solutions.</p>
                        </div>
                        <div class="col">
                            <div class="feature bg-primary bg-gradient text-white rounded-3 mb-3"><i class="bi bi-telephone"></i></div>
                            <div class="h5">Call us</div>
                            <p class="text-muted mb-0">Call us during normal business hours at (555) 892-9403.</p>
                        </div>
                    </div>
                </div>
            </section>
        
        </main>
       	 <!-- Footer 적용 -->
       		<c:import url="../temp/footer.jsp"></c:import>
      	 <!-- Footer 끝 -->
      	 
      	 <script type="text/javascript" src="../js/boardform.js"></script>
</body>
</html>